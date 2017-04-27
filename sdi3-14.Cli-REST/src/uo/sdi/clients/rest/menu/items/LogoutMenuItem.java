package uo.sdi.clients.rest.menu.items;

import java.util.ArrayList;
import java.util.List;

import uo.sdi.clients.rest.menu.MenuItem;

public class LogoutMenuItem implements MenuItem {

	@Override
	public String getMenuName() {
		return "Cerrar sesion";
	}

	@Override
	public List<MenuItem> execute() {
		List<MenuItem> items = new ArrayList<MenuItem>();

		items.add(new LoginMenuItem());
		return items;
	}

}
