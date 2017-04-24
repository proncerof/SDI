package uo.sdi.rest.services.impl;

import javax.ws.rs.core.Response;

import uo.sdi.business.TaskService;
import uo.sdi.business.exception.BusinessException;
import uo.sdi.dto.Task;
import uo.sdi.infrastructure.Factories;
import uo.sdi.rest.services.TaskServiceRest;

public class TaskServiceRestImpl implements TaskServiceRest {

	private TaskService taskService = Factories.services.getTaskService();
	
	
	@Override
	public void createTask(Task task) throws BusinessException {
		taskService.createTask(task);
	}

	@Override
	public Response findCategoriesByUserId(final Long id)
			throws BusinessException {
		return addHeaders(taskService.findCategoriesByUserId(id));
	}

	@Override
	public void markTaskAsFinished(Long id) throws BusinessException {
		taskService.markTaskAsFinished(id);
	}

	@Override
	public Response findTasksByCategoryId(final Long id)
			throws BusinessException {
		return addHeaders(taskService.findTasksByCategoryId(id));
	}

	private Response addHeaders(Object o) {
		return Response
				.status(200) 
				.header("Access-Control-Allow-Origin", "http://localhost:4200")
				.header("Access-Control-Allow-Methods", "GET,POST,PUT")
				.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Headers", "Authorization")
				.entity(o).build();
	}
}