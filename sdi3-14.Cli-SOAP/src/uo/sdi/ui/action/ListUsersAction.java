package uo.sdi.ui.action;

import java.util.List;

import uo.sdi.services.ServiceLocator;
import uo.sdi.ws.admin.AdminService;
import uo.sdi.ws.admin.User;
import alb.util.console.Console;
import alb.util.menu.Action;

public class ListUsersAction implements Action{

	@Override
	public void execute() throws Exception {
		 
		//Procesar
		AdminService as = ServiceLocator.getAdminService();
		List<User> users = as.findAllUsers();
		for(User u : users)
			Console.println(u);

	}
	

}
