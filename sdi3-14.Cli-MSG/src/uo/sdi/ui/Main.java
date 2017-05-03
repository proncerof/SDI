package uo.sdi.ui;

import uo.sdi.ui.actions.CreateTaskAction;
import uo.sdi.ui.actions.FindTodayTasksAction;
import uo.sdi.ui.actions.LoginAction;
import uo.sdi.ui.actions.MarkTaskAsFinishedAction;
import alb.util.menu.BaseMenu;

public class Main extends BaseMenu{

	
	public Main() {
		menuOptions = new Object[][] {
			{ "MSG Cli", null },
			{ "Iniciar sesion", 	LoginAction.class },
			{ "Listar tareas de hoy y retrasadas", 	FindTodayTasksAction.class },
			{ "Finalizar tarea", MarkTaskAsFinishedAction.class } ,
			{ "Crear tarea", CreateTaskAction.class},	
		};
	}

	public static void main(String[] args) {
		new Main().execute();
	}
	
}
