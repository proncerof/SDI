package uo.sdi.rest.services.impl;

import java.util.List;

import uo.sdi.business.TaskService;
import uo.sdi.business.UserService;
import uo.sdi.business.exception.BusinessException;
import uo.sdi.dto.Category;
import uo.sdi.dto.Task;
import uo.sdi.dto.User;
import uo.sdi.infrastructure.Factories;
import uo.sdi.rest.services.TaskServiceRest;

public class TaskServiceRestImpl implements TaskServiceRest {

	private TaskService taskService = Factories.services.getTaskService();
	private UserService userService = Factories.services.getUserService();
	
	@Override
	public User createTask(String login, String password)
			throws BusinessException {
		return userService.findLoggableUser(login, password);
	}
	
	@Override
	public Task createTask(Task task) throws BusinessException {
		return taskService.createTask(task);
	}

	@Override
	public List<Category> findCategoriesByUserId(final Long id)
			throws BusinessException {
		return taskService.findCategoriesByUserId(id);
	}

	@Override
	public void markTaskAsFinished(Long id) throws BusinessException {
		taskService.markTaskAsFinished(id);
	}

	@Override
	public List<Task> findTasksByCategoryId(final Long id)
			throws BusinessException {
		return taskService.findTasksByCategoryId(id);
	}
}
