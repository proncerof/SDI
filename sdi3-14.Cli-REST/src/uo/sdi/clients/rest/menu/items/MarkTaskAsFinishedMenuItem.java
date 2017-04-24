package uo.sdi.clients.rest.menu.items;

import alb.util.console.Console;
import uo.sdi.clients.rest.dto.User;
import uo.sdi.clients.rest.restService.RestService;

public class MarkTaskAsFinishedMenuItem extends MainMenuItem {


	public MarkTaskAsFinishedMenuItem(RestService restService, User user) {
		super(restService, user);
	}

	@Override
	public String getMenuName() {
		return "Finalizar una tarea";
	}

	@Override
	protected void executeInternal() {
		Long id = Console.readLong("Introduzca el id de la tarea");
		restService.markTaskAsFinished(id);
		
	}

}
