package uo.sdi.clients.rest.menu.items;

import java.util.List;

import uo.sdi.clients.rest.dto.Category;
import uo.sdi.clients.rest.restService.RestService;
import alb.util.console.Console;

public class ListCategoriesMenuItem extends MainMenuItem {

	public ListCategoriesMenuItem(RestService restService) {
		super(restService);
	}

	@Override
	public String getMenuName() {
		return "Ver categorias";
	}

	@Override
	protected void executeInternal() {

		List<Category> categories = restService.findCategoriesByUserID();

		for (Category c : categories) {
			Console.println(c);
		}

	}

}
