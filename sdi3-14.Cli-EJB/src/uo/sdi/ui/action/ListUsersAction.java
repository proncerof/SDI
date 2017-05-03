package uo.sdi.ui.action;

import java.util.List;

import uo.sdi.business.AdminService;
import uo.sdi.dto.ejb.EjbClientUser;
import uo.sdi.services.ServiceLocator;
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
			Console.println(u);
		}
	}
}
