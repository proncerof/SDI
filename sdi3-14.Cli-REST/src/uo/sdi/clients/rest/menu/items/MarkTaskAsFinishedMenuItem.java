package uo.sdi.clients.rest.menu.items;

import uo.sdi.clients.rest.restService.RestService;
import alb.util.console.Console;

public class MarkTaskAsFinishedMenuItem extends MainMenuItem {


	public MarkTaskAsFinishedMenuItem(RestService restService) {
		super(restService);
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
