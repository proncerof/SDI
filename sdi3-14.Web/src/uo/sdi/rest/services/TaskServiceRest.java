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

import uo.sdi.dto.Category;
import uo.sdi.dto.Task;

@Path("/TaskServiceRs")
public interface TaskServiceRest {

	@GET
	@Path("/login")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Long login(@HeaderParam("Authorization") String authentication);

	@POST
	@Path("/users/{userId}/tasks")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void createTask(@PathParam("userId") Long userId,
			@HeaderParam("Authorization") String authorization, Task task);

	@GET
	@Path("/users/{userId}/categories")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Category> findCategoriesByUserId(@PathParam("userId") Long userId,
			@HeaderParam("Authorization") String authentication);

	@PUT
	@Path("/users/{userId}/tasks/{taskId}")
	public void markTaskAsFinished(@PathParam("userId") Long userId,
			@PathParam("taskId") Long taskId,
			@HeaderParam("Authorization") String authentication);

	@GET
	@Path("/users/{userId}/categories/{catId}/tasks")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Task> findTasksByCategoryId(@PathParam("userId") Long userId,
			@PathParam("catId") Long catId,
			@HeaderParam("Authorization") String authentication);
}
