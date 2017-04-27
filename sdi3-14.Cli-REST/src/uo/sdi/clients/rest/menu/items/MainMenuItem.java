package uo.sdi.clients.rest.menu.items;

import java.util.ArrayList;
import java.util.List;

import uo.sdi.clients.rest.menu.MenuItem;
import uo.sdi.clients.rest.restService.RestService;

public abstract class MainMenuItem implements MenuItem {

	protected RestService restService;

	public MainMenuItem(RestService restService) {
		this.restService = restService;
	}
	
	@Override
	public List<MenuItem> execute() {
		
		executeInternal();

		List<MenuItem> items = new ArrayList<MenuItem>();
		
		items.add(new ListCategoriesMenuItem(restService));
		items.add(new ListTaskFromCategoryMenuItem(restService));
		items.add(new CreateTaskMenuItem(restService));
		items.add(new MarkTaskAsFinishedMenuItem(restService));
		items.add(new LogoutMenuItem());
		
		return items;
	}

	protected abstract void executeInternal();
}
