package uo.sdi.clients.rest.menu;

import java.util.List;

import alb.util.console.Console;

public class MenuItemExecutor {

	private List<MenuItem> items;

	public MenuItemExecutor(List<MenuItem> items) {
		this.items = items;
	}

	public void execute() {
		while (true) {
			// print the options
			Console.println("\nSeleccione una: \n");

			Console.println("0 - Salir");
			Console.println();
			for (int i = 0; i < items.size(); i++) {
				Console.println(i + 1 + " - " + items.get(i).getMenuName());
			}
			// get the user option
			Integer userOption = Console.readInt("Opcion");
			if (userOption == null) {
				userOption = -1;
			}

			if (userOption > items.size() || userOption < 0) {
				Console.println("Opcion marcada incorrecta");
			} else if (userOption == 0) {
				Console.println("Saliendo");
				break;
			} else {
				this.items = items.get(userOption - 1).execute();
			}
		}
	}
}
