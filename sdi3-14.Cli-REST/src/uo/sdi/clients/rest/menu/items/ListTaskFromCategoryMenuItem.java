package uo.sdi.clients.rest.menu.items;

import java.util.Collections;
import java.util.List;

import uo.sdi.clients.rest.dto.Task;
import uo.sdi.clients.rest.dto.User;
import uo.sdi.clients.rest.restService.RestService;
import alb.util.console.Console;

public class ListTaskFromCategoryMenuItem extends MainMenuItem {

	public ListTaskFromCategoryMenuItem(RestService restService, User user) {
		super(restService, user);
	}

	@Override
	public String getMenuName() {
		return "Listar tareas de categoria";
	}

	@Override
	protected void executeInternal() {
		Long id = Console.readLong("Introduzca el id de la categoria:");
		List<Task> tasks = restService.getTasksFromCategoryId(id);
		Collections.sort(tasks);
		for (Task t : tasks)
			if (t.getUser().getId().equals(user.getId()))
				System.out.println(t);
	}

}
