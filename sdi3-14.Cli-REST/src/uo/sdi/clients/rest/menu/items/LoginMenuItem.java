package uo.sdi.clients.rest.menu.items;

import java.util.ArrayList;
import java.util.List;

import uo.sdi.clients.rest.dto.User;
import uo.sdi.clients.rest.menu.MenuItem;
import uo.sdi.clients.rest.restService.RestService;
import alb.util.console.Console;

public class LoginMenuItem implements MenuItem {

	private RestService restService;

	public LoginMenuItem(RestService restService) {
		this.restService = restService;
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

		User user = restService.login(login, password);

		if (user != null) {
			items.add(new ListCategoriesMenuItem(restService, user));
			items.add(new ListTaskFromCategoryMenuItem(restService, user));
			items.add(new CreateTaskMenuItem(restService, user));
			items.add(new MarkTaskAsFinishedMenuItem(restService, user));
			
			System.out.println("Login correcto");
			
		} else {
			items.add(this);
			System.out.println("Login incorrecto o servidor no accesible");
		}

		return items;
	}

}
