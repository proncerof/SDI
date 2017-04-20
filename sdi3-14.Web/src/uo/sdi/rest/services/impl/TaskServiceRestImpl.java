package uo.sdi.rest.services.impl;

import java.util.List;

import uo.sdi.business.TaskService;
import uo.sdi.business.exception.BusinessException;
import uo.sdi.dto.Category;
import uo.sdi.dto.Task;
import uo.sdi.infrastructure.Factories;
import uo.sdi.rest.services.TaskServiceRest;

public class TaskServiceRestImpl implements TaskServiceRest {

	private TaskService service = Factories.services.getTaskService();

	@Override
	public Task createTask(Task task) throws BusinessException {
		return service.createTask(task);
	}

	@Override
	public List<Category> findCategoriesByUserId(final Long id)
			throws BusinessException {
		return service.findCategoriesByUserId(id);
	}

	@Override
	public void markTaskAsFinished(Long id) throws BusinessException {
		service.markTaskAsFinished(id);
	}

	@Override
	public List<Task> findTasksByCategoryId(final Long id)
			throws BusinessException {
		return service.findTasksByCategoryId(id);
	}
}
