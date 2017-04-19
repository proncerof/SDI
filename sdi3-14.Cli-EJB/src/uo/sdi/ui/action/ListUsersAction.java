package uo.sdi.ui.action;

import java.util.List;

import org.hibernate.Hibernate;

import uo.sdi.business.AdminService;
import uo.sdi.dto.Task;
import uo.sdi.dto.User;
import uo.sdi.services.ServiceLocator;
import alb.util.console.Console;
import alb.util.menu.Action;

public class ListUsersAction implements Action {

	@Override
	public void execute() throws Exception {

		// Procesar
		AdminService as = ServiceLocator.getAdminService();
		List<User> users = as.findAllUsers();

		// Mostrar resultado
		Console.println("--LISTA DE USUARIOS--");
		for (User u : users){
			Hibernate.initialize(u.getTasks());
			printUser(u);
		}

	}

	private void printUser(User u) {
		int tareasCompletadas = getTareasCompletadas(u);
		int tareasCompletadasRetrasadas = getTareasCompletadasRetrasadas(u);
		int tareasPlanificadas = getTareasPlanificadas(u);
		int tareasNoPlanificadas = getTareasNoPlanificadas(u);

		Console.println(String.format(
				"Id: %d - Login: %s - Email: %s - Administrador: %s - "
						+ "Status: %s - Tareas Completadas: %d - "
						+ "Tareas Completadas Retrasadas: %d - "
						+ "Tareas Planificadas: %d - "
						+ "Tareas no Planificadas: %d",
						u.getId(), u.getLogin(), u.getEmail(), u.getIsAdmin(), 
						u.getStatus(), tareasCompletadas, 
						tareasCompletadasRetrasadas, tareasPlanificadas, 
						tareasNoPlanificadas));
	}

	private int getTareasCompletadas(User u) {
		int tareasCompletadas = 0;

		for (Task t : u.getTasks())
			if (t.hasBeenFinished())
				tareasCompletadas++;

		return tareasCompletadas;
	}

	private int getTareasCompletadasRetrasadas(User u) {
		int tareasCompletadasRetrasadas = 0;

		for (Task t : u.getTasks())
			if (t.hasBeenFinished() && t.getPlanned().before(t.getFinished()))
				tareasCompletadasRetrasadas++;

		return tareasCompletadasRetrasadas;
	}

	private int getTareasPlanificadas(User u) {
		int tareasPlanificadas = 0;

		for (Task t : u.getTasks())
			if (t.getPlanned() != null)
				tareasPlanificadas++;

		return tareasPlanificadas;
	}

	private int getTareasNoPlanificadas(User u) {
		int tareasNoPlanificadas = 0;

		for (Task t : u.getTasks())
			if (t.getPlanned() == null)
				tareasNoPlanificadas++;

		return tareasNoPlanificadas;
	}

}
