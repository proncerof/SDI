package uo.sdi.clients.rest.menu.items;

import java.util.List;

import alb.util.console.Console;
import uo.sdi.clients.rest.dto.Category;
import uo.sdi.clients.rest.dto.User;
import uo.sdi.clients.rest.restService.RestService;

public class ListCategoriesMenuItem extends MainMenuItem {


	public ListCategoriesMenuItem(RestService restService, User user) {
		super(restService, user);
	}

	@Override
	public String getMenuName() {
		return "Ver categorias";
	}

	@Override
	protected void executeInternal() {

		List<Category> categories = restService.findCategoriesByUserID(user
				.getId());

		for (Category c : categories) {
			Console.println(c);
		}

	}

}
