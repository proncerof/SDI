package uo.sdi.clients.rest;

import java.util.ArrayList;
import java.util.List;

import alb.util.console.Console;
import uo.sdi.clients.rest.menu.MenuItem;
import uo.sdi.clients.rest.menu.MenuItemExecutor;
import uo.sdi.clients.rest.menu.items.LoginMenuItem;


public class Main {

	
	public static void main(String[] args) {
		Console.println("REST Cli");
		List<MenuItem> menuItems = new ArrayList<MenuItem>();
		
		menuItems.add(new LoginMenuItem());
		
		new MenuItemExecutor(menuItems).execute();
		
	}
}
