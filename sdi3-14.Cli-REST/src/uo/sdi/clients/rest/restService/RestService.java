package uo.sdi.clients.rest.restService;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import uo.sdi.clients.rest.dto.Category;
import uo.sdi.clients.rest.dto.Task;
import uo.sdi.clients.rest.dto.User;

public class RestService {

	private static final String URL_BASE = "http://localhost:8280/sdi3-14.Web/rest/";

	private static final String URL_CREATE_CATEGORY = URL_BASE
			+ "TaskServiceRs/createCategory";
	private static final String URL_FIND_CATEGORIES_BY_USER = URL_BASE
			+ "TaskServiceRs/findCategoriesByUserId";
	private static final String URL_MARK_AS_FINISHED = URL_BASE
			+ "TaskServiceRs/markTaskAsFinished";
	private static final String URL_FIND_TASKS_BY_CATEGORY = URL_BASE
			+ "TaskServiceRs/findTasksByCategoryId";
	private static final String URL_LOGIN = URL_BASE + "TaskServiceRs/login";

	private Client client;

	private String user;
	private String password;

	public RestService(String user, String password) {
		this.client = ClientBuilder.newClient().register(
				new Authenticator(user, password));
		this.user = user;
		this.password = password;
	}

	public User login() {
		User u;
		try {
			u = client.target(URL_LOGIN).path(user).path(password).request()
					.accept(MediaType.APPLICATION_XML).get()
					.readEntity(User.class);
		} catch (javax.ws.rs.ProcessingException p) {
			u = null;
		}
		return u;
	}

	public Task createTask(Task tarea) {

		return client.target(URL_CREATE_CATEGORY).request()
				.accept(MediaType.APPLICATION_XML)
				.post(Entity.entity(tarea, MediaType.APPLICATION_XML))
				.readEntity(Task.class);

	}

	public List<Category> findCategoriesByUserID(Long id) {
		GenericType<List<Category>> listm = new GenericType<List<Category>>() {
		};

		List<Category> res = client.target(URL_FIND_CATEGORIES_BY_USER)
				.path(id.toString()).request()
				.accept(MediaType.APPLICATION_XML).get().readEntity(listm);

		return res;
	}

	public void markTaskAsFinished(Long id) {
		// PREGUNTAR A ALBERTO
		client.target(URL_MARK_AS_FINISHED).path(id.toString()).request()
				.put(null);
	}

	public List<Task> getTasksFromCategoryId(Long id) {

		GenericType<List<Task>> listm = new GenericType<List<Task>>() {
		};

		List<Task> res = client.target(URL_FIND_TASKS_BY_CATEGORY)
				.path(id.toString()).request()
				.accept(MediaType.APPLICATION_XML).get().readEntity(listm);

		return res;
	}

}
