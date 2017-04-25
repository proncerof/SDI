package uo.sdi.rest.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import uo.sdi.business.exception.BusinessException;
import uo.sdi.dto.Category;
import uo.sdi.dto.Task;

@Path("/TaskServiceRs")
public interface TaskServiceRest {
	
	@GET
	public void getUserID(@HeaderParam("Authentication") String authenticacion);

	@POST
	@Path("users/{id}/categories/{id}/tasks")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void createTask(Task task) throws BusinessException;

	@GET
	@Path("users/{id}/categories")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Category> findCategoriesByUserId(@PathParam("id") Long id)
			throws BusinessException;

	@PUT
	@Path("users/{id}/categories/{id}/tasks/{id}")
	public void markTaskAsFinished(@PathParam("id") Long id)
			throws BusinessException;

	@GET
	@Path("users/{id}/categories/{id}/tasks")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response findTasksByCategoryId(@PathParam("catId") Long catId)
			throws BusinessException;
}
