package uo.sdi.rest.services.impl;

import java.util.List;

import javax.ws.rs.ForbiddenException;
import javax.ws.rs.InternalServerErrorException;
import javax.xml.bind.DatatypeConverter;

import uo.sdi.business.TaskService;
import uo.sdi.business.UserService;
import uo.sdi.business.exception.BusinessException;
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
	public Task createTask(Long userId, Long catId, String authorization,
			Task task) {
		User u = getUser(authorization);
		if (userId.equals(u.getId())) {
			try {
				task.setId(null);
				task.setUser(u);
				u._getTasks().add(task);
				task.setCreated(DateUtil.now());
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
					task.setCategory(c);
					c._getTasks().add(task);
				}
				return taskService.createTask(task);
			} catch (BusinessException e) {
				throw new InternalServerErrorException(e.getMessage());
			}
		} else {
			throw new ForbiddenException("Id de usuario y login no coinciden");
		}
	}

	@Override
	public List<Category> findCategoriesByUserId(Long userId,
			String authorization) {
		User u = getUser(authorization);
		if (userId.equals(u.getId()))
			return u.getCategories();
		else
			throw new ForbiddenException("Id de usuario y login no coinciden");
	}

	@Override
	public void markTaskAsFinished(Long userId, Long taskId,
			String authorization) {
		User u = getUser(authorization);
		if (userId.equals(u.getId())) {
			for (Task t : u.getTasks())
				if (t.getId().equals(taskId))
					try {
						taskService.markTaskAsFinished(taskId);
						return;
					} catch (BusinessException e) {
						throw new InternalServerErrorException(e.getMessage());
					}

			throw new ForbiddenException("El usuario " + userId
					+ " no tiene acceso a la tarea " + taskId);

		} else
			throw new ForbiddenException("Id de usuario y login no coinciden");

	}

	@Override
	public List<Task> findTasksByCategoryId(Long userId, Long catId,
			String authorization) {
		User u = getUser(authorization);
		if (userId.equals(u.getId())) {
			for (Category c : u.getCategories())
				if (c.getId().equals(catId))
					try {
						return taskService.findTasksByCategoryId(catId);
					} catch (BusinessException e) {
						throw new InternalServerErrorException(e.getMessage());
					}

			throw new ForbiddenException("El usuario " + userId
					+ " no tiene acceso a la categoria " + catId);

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
