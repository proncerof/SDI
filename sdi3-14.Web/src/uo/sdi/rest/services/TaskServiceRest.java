package uo.sdi.rest.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import uo.sdi.business.exception.BusinessException;
import uo.sdi.dto.Category;
import uo.sdi.dto.Task;
import uo.sdi.dto.User;

@Path("/TaskServiceRs")
public interface TaskServiceRest {

	@GET
	@Path("login/{login}/{password}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public User createTask(@PathParam("login") String login,
			@PathParam("password") String password) throws BusinessException;

	@POST
	@Path("users/{id}/tasks")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Task createTask(Task task) throws BusinessException;

	@GET
	@Path("findCategoriesByUserId/{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Category> findCategoriesByUserId(@PathParam("id") Long id)
			throws BusinessException;

	@PUT
	@Path("markTaskAsFinished/{id}")
	public void markTaskAsFinished(@PathParam("id") Long id)
			throws BusinessException;

	@GET
	@Path("findTasksByCategoryId/{catId}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Task> findTasksByCategoryId(@PathParam("catId") Long catId)
			throws BusinessException;
}
