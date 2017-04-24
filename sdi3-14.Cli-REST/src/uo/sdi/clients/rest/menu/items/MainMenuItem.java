package uo.sdi.clients.rest.menu.items;

import java.util.ArrayList;
import java.util.List;

import uo.sdi.clients.rest.dto.User;
import uo.sdi.clients.rest.menu.MenuItem;
import uo.sdi.clients.rest.restService.RestService;

public abstract class MainMenuItem implements MenuItem {

	protected RestService restService;
	protected User user;

	public MainMenuItem(RestService restService, User user) {
		this.restService = restService;
		this.user = user;
	}
	
	@Override
	public List<MenuItem> execute() {
		
		executeInternal();

		List<MenuItem> items = new ArrayList<MenuItem>();
		
		items.add(new ListCategoriesMenuItem(restService, user));
		items.add(new ListTaskFromCategoryMenuItem(restService, user));
		items.add(new CreateTaskMenuItem(restService, user));
		items.add(new MarkTaskAsFinishedMenuItem(restService, user));
		
		return items;
	}

	protected abstract void executeInternal();
}
