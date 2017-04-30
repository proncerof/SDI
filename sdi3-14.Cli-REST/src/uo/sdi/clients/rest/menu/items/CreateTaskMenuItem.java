package uo.sdi.clients.rest.menu.items;

import java.util.Date;

import uo.sdi.clients.rest.dto.Task;
import uo.sdi.clients.rest.restService.RestService;
import alb.util.console.Console;
import alb.util.date.DateUtil;

public class CreateTaskMenuItem extends MainMenuItem {

	public CreateTaskMenuItem(RestService restService) {
		super(restService);
	}

	@Override
	public String getMenuName() {
		return "Crear tarea";
	}

	@Override
	protected void executeInternal() {
		Task tarea = new Task();

		this.setTitle(tarea);
		this.setComments(tarea);
		this.setPlanned(tarea);

		tarea.setCreated(DateUtil.now());

		Long catId = Console.readLong("Introduzca el Id de la categoria");

		if (catId == null) {
			Console.println("Id de categoria incorrecto");
			return;
		}

		Task t = restService.createTask(tarea, catId);

		if (t == null)
			Console.println("No se ha podido crear la tarea correctamente");
		else
			Console.println("Tarea creada: " + t);
		// if (t == null)
		// Console.println("No se ha podido enviar la tarea correctamente");
		// else {
		// Console.println("La tarea se ha enviado correctamente:");
		// Console.println(t);
		// }

	}

	private void setTitle(Task tarea) {
		tarea.setTitle(Console.readString("Introduzca el titulo:"));
	}

	private void setComments(Task tarea) {
		tarea.setComments(Console.readString("Introduzca un comentario:"));
	}

	private void setPlanned(Task tarea) {
		Date fecha = null;
		boolean formatoIncorrecto = true;
		while (formatoIncorrecto) {
			int day = Console.readInt("Introduzca el dia");
			int month = Console.readInt("Introduzca el mes");
			int year = Console.readInt("Introduzca el anio");
			try {
				fecha = DateUtil.fromDdMmYyyy(day, month, year);
				formatoIncorrecto = false;
			} catch (IndexOutOfBoundsException i) {
				Console.println("El formato de la fecha no es correcto");
			}
		}
		tarea.setPlanned(fecha);
	}
}
