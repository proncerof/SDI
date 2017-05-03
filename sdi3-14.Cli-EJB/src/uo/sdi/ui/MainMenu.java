package uo.sdi.ui;

import uo.sdi.ui.action.DeleteUserAction;
import uo.sdi.ui.action.DisableUserAction;
import uo.sdi.ui.action.EnableUserAction;
import uo.sdi.ui.action.ListUsersAction;
import alb.util.menu.BaseMenu;

public class MainMenu extends BaseMenu{

	public MainMenu() {
		menuOptions = new Object[][] { 
			{ "EJB Cli", null },
			{ "Listar usuarios", 			ListUsersAction.class }, 
			{ "Habiliar usuario", 			EnableUserAction.class },
			{ "Deshabilitar usuario", 		DisableUserAction.class },
			{ "Eliminar Usuario", 			DeleteUserAction.class },
		};
	}

	public static void main(String[] args) {
		new MainMenu().execute();
	}
}
