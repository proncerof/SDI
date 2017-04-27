package uo.sdi.clients.rest.menu.items;

import java.util.ArrayList;
import java.util.List;

import uo.sdi.clients.rest.menu.MenuItem;
import uo.sdi.clients.rest.restService.RestService;
import alb.util.console.Console;

public class LoginMenuItem implements MenuItem {

	private RestService restService;

	public LoginMenuItem() {
	}

	@Override
	public String getMenuName() {
		return "Iniciar sesion";
	}

	@Override
	public List<MenuItem> execute() {
		List<MenuItem> items = new ArrayList<MenuItem>();

		String login = Console.readString("Introduce tu login:");
		String password = Console.readString("Introduce tu contrasenia");

		restService = new RestService(login, password);
		
		Long user = restService.login();

		if (user != null) {
			items.add(new ListCategoriesMenuItem(restService));
			items.add(new ListTaskFromCategoryMenuItem(restService));
			items.add(new CreateTaskMenuItem(restService));
			items.add(new MarkTaskAsFinishedMenuItem(restService));
			items.add(new LogoutMenuItem());
			
			System.out.println("Login correcto");
			
		} else {
			items.add(this);
			System.out.println("Login incorrecto o servidor no accesible");
		}

		return items;
	}

}
