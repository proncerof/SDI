package uo.sdi.ui.action;

import uo.sdi.services.ServiceLocator;
import alb.util.console.Console;
import alb.util.menu.Action;

public class DeleteUserAction implements Action{

	@Override
	public void execute() throws Exception {
		//Pedir datos
		Long id = Console.readLong("Id del usuario:");
		
		//Procesar
		ServiceLocator.getAdminService().deepDeleteUser(id);
		
		//Mostrar resultado
		Console.println("El usuario ha sido eliminado");
	}

}
