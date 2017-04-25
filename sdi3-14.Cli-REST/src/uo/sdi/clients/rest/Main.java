package uo.sdi.clients.rest;

import java.util.ArrayList;
import java.util.List;

import uo.sdi.clients.rest.menu.MenuItem;
import uo.sdi.clients.rest.menu.MenuItemExecutor;
import uo.sdi.clients.rest.menu.items.LoginMenuItem;
import uo.sdi.clients.rest.restService.RestService;


public class Main {

	
	public static void main(String[] args) {
		List<MenuItem> menuItems = new ArrayList<MenuItem>();
		
		RestService restService = new RestService("sdi", "password");
		
		menuItems.add(new LoginMenuItem(restService));
		
		new MenuItemExecutor(menuItems).execute();;
		
	}
}