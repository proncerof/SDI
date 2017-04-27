package uo.sdi.ui;

import uo.sdi.ui.actions.FindTodayTasks;
import alb.util.menu.BaseMenu;

public class MainMenu extends BaseMenu{
	public MainMenu() {
		menuOptions = new Object[][] { 
		{"Listar tareas de hoy y retrasadas", FindTodayTasks.class},
		};
	}

	public static void main(String[] args) {
		new MainMenu().execute();
	}
}
