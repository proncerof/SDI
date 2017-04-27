package uo.sdi.clients.rest.menu.items;

import java.util.Collections;
import java.util.List;

import uo.sdi.clients.rest.dto.Task;
import uo.sdi.clients.rest.restService.RestService;
import alb.util.console.Console;

public class ListTaskFromCategoryMenuItem extends MainMenuItem {

	public ListTaskFromCategoryMenuItem(RestService restService) {
		super(restService);
	}

	@Override
	public String getMenuName() {
		return "Listar tareas de categoria";
	}

	@Override
	protected void executeInternal() {
		Long id = Console.readLong("Introduzca el id de la categoria");
		if (id == null) {
			Console.println("Formato de id incorrecto");
		} else {
			List<Task> tasks = restService.getTasksFromCategoryId(id);
			Collections.sort(tasks);
			for (Task t : tasks)
				System.out.println(t);
		}
	}

}
