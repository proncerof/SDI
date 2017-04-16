package uo.sdi.ui.action;

import java.util.List;

import uo.sdi.business.AdminService;
import uo.sdi.dto.User;
import uo.sdi.services.ServiceLocator;
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
