package uo.sdi.clients.rest.restService;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import uo.sdi.clients.rest.dto.Category;
import uo.sdi.clients.rest.dto.Task;

public class RestService {

	private static final String URL_BASE = "http://localhost:8280/sdi3-14.Web/rest/TaskServiceRs";

	private Client client;

	private Long userId;

	public RestService(String user, String password) {
		this.client = ClientBuilder.newClient().register(
				new Authenticator(user, password));

		this.userId = login();
	}

	public Long login() {
		Long u;
		try {
			u = client.target(URL_BASE).path("login").request()
					.accept(MediaType.APPLICATION_JSON).get()
					.readEntity(Long.class);
		} catch (javax.ws.rs.ProcessingException p) {
			u = null;
		}
		return u;
	}

	public void createTask(Task tarea) {
		client.target(URL_BASE).path("users").path(userId.toString())
				.path("tasks").request().accept(MediaType.APPLICATION_XML)
				.post(Entity.entity(tarea, MediaType.APPLICATION_XML));

	}

	public List<Category> findCategoriesByUserID() {
		GenericType<List<Category>> listm = new GenericType<List<Category>>() {
		};

		List<Category> res;

		try {
			res = client.target(URL_BASE).path("users").path(userId.toString())
					.path("categories").request()
					.accept(MediaType.APPLICATION_XML).get().readEntity(listm);

		} catch (ProcessingException p) {
			res = new ArrayList<Category>();
		}

		return res;
	}

	public void markTaskAsFinished(Long id) {
		// PREGUNTAR A ALBERTO
		client.target(URL_BASE).path("users").path(userId.toString())
				.path("tasks").path(id.toString()).request().put(null);
	}

	public List<Task> getTasksFromCategoryId(Long id) {

		GenericType<List<Task>> listm = new GenericType<List<Task>>() {
		};

		List<Task> res;

		try {
			res = client.target(URL_BASE).path("users").path(userId.toString())
					.path("categories").path(id.toString()).path("tasks")
					.request().accept(MediaType.APPLICATION_XML).get()
					.readEntity(listm);
		} catch (ProcessingException p) {
			res = new ArrayList<Task>();
		}

		return res;
	}

}
