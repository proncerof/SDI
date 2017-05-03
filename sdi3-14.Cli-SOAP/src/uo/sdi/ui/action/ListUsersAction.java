package uo.sdi.ui.action;

import java.util.List;

import uo.sdi.services.ServiceLocator;
import uo.sdi.ws.AdminService;
import uo.sdi.ws.EjbClientUser;
import alb.util.console.Console;
import alb.util.menu.Action;

public class ListUsersAction implements Action {

	@Override
	public void execute() throws Exception {

		// Processor
		AdminService as = ServiceLocator.getAdminService();
		List<EjbClientUser> users = as.findAllUsersEjbClient();

		// Mostrar resultado
		Console.println("--LISTA DE USUARIOS--");
		for (EjbClientUser u : users) {
			Console.println(printUser(u));
		}

	}

	private String printUser(EjbClientUser u) {
		return "EjbClientUser [id=" + u.getId() + ", login=" + u.getLogin()
				+ ", email=" + u.getEmail() + ", isAdmin=" + u.isIsAdmin()
				+ ", status=" + u.getStatus() + ", tareasCompletadas="
				+ u.getTareasCompletadas() + ", tareasCompletadasRetrasadas="
				+ u.getTareasCompletadasRetrasadas() + ", tareasPlanificadas="
				+ u.getTareasPlanificadas() + ", tareasSinPlanificar="
				+ u.getTareasSinPlanificar() + "]";
	}

}
