package uo.sdi.rest.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.ForbiddenException;
import javax.ws.rs.InternalServerErrorException;
import javax.xml.bind.DatatypeConverter;

import uo.sdi.business.TaskService;
import uo.sdi.business.UserService;
import uo.sdi.business.exception.BusinessException;
import uo.sdi.business.impl.ModelDtoConverter;
import uo.sdi.dto.rest.RestClientCategory;
import uo.sdi.dto.rest.RestClientTask;
import uo.sdi.infrastructure.Factories;
import uo.sdi.model.Category;
import uo.sdi.model.Task;
import uo.sdi.model.User;
import uo.sdi.rest.services.TaskServiceRest;
import alb.util.date.DateUtil;

public class TaskServiceRestImpl implements TaskServiceRest {

	private TaskService taskService = Factories.services.getTaskService();

	@Override
	public Long login(String authorization) {
		return getUser(authorization).getId();
	}

	@Override
	public RestClientTask createTask(Long userId, Long catId,
			String authorization, RestClientTask task) {
		Task newTask = new Task();
		User u = getUser(authorization);
		if (userId.equals(u.getId())) {
			try {
				newTask.setId(null);
				newTask.setUser(u);

				newTask.setCreated(DateUtil.now());
				newTask.setPlanned(task.getPlanned());
				newTask.setComments(task.getComments());
				newTask.setTitle(task.getTitle());

				Category c;

				try {
					c = taskService.findCategoryById(catId);
				} catch (BusinessException e) {
					c = null;
				}

				if (c == null || !c.getUser().getId().equals(u.getId())) {
					throw new ForbiddenException(
							"La categoria no existe o no pertenece al usuario");
				} else {
					newTask.setCategory(c);
				}
				return ModelDtoConverter.convertTask(taskService
						.createTask(newTask));
			} catch (BusinessException e) {
				throw new InternalServerErrorException(e.getMessage());
			}
		} else {
			throw new ForbiddenException("Id de usuario y login no coinciden");
		}
	}

	@Override
	public List<RestClientCategory> findCategoriesByUserId(Long userId,
			String authorization) {
		User u = getUser(authorization);
		if (userId.equals(u.getId()))
			try {
				List<Category> categories = taskService
						.findCategoriesByUserId(u.getId());
				List<RestClientCategory> dtoCategories = new ArrayList<RestClientCategory>();

				for (Category c : categories)
					dtoCategories.add(ModelDtoConverter.convertCategory(c));

				return dtoCategories;
			} catch (BusinessException e) {
				throw new InternalServerErrorException(e.getMessage());
			}
		else
			throw new ForbiddenException("Id de usuario y login no coinciden");
	}

	@Override
	public void markTaskAsFinished(Long userId, Long taskId,
			String authorization) {
		User u = getUser(authorization);

		if (userId.equals(u.getId())) {
			Task t;
			try {
				t = taskService.findTaskById(taskId);
			} catch (BusinessException e) {
				throw new InternalServerErrorException(e.getMessage());
			}

			if (t.getUser().getId().equals(userId))
				try {
					taskService.markTaskAsFinished(taskId);
				} catch (BusinessException e) {
					throw new InternalServerErrorException(e.getMessage());
				}
			else
				throw new ForbiddenException("El usuario " + userId
						+ " no tiene acceso a la tarea " + taskId);

		} else
			throw new ForbiddenException("Id de usuario y login no coinciden");

	}

	@Override
	public List<RestClientTask> findTasksByCategoryId(Long userId, Long catId,
			String authorization) {
		User u = getUser(authorization);
		if (userId.equals(u.getId())) {

			Category category;
			try {
				category = taskService.findCategoryById(catId);
			} catch (BusinessException b) {
				throw new InternalServerErrorException(b.getMessage());
			}
			if (category.getUser().getId().equals(userId)) {
				try {
					List<Task> tareas = taskService
							.findTasksByCategoryId(category.getId());

					List<RestClientTask> dtoTareas = new ArrayList<RestClientTask>();

					for (Task t : tareas)
						dtoTareas.add(ModelDtoConverter.convertTask(t));

					return dtoTareas;

				} catch (BusinessException e) {
					throw new InternalServerErrorException(e.getMessage());
				}
			} else {
				throw new ForbiddenException("El usuario " + userId
						+ " no tiene acceso a la categoria " + catId);
			}

		} else
			throw new ForbiddenException("Id de usuario y login no coinciden");
	}

	private User getUser(String authorization) {
		UserService us = Factories.services.getUserService();
		String decoded = authorization.replace("Basic ", "");

		decoded = new String(DatatypeConverter.parseBase64Binary(decoded));

		String login = decoded.split(":")[0];
		String password = decoded.split(":")[1];

		User u;
		try {
			u = us.findLoggableUser(login, password);
			return u;
		} catch (BusinessException e) {
			e.printStackTrace();
		}

		return null;
	}

}
