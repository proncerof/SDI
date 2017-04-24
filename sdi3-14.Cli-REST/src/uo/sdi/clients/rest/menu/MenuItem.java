package uo.sdi.clients.rest.menu;

import java.util.List;

public interface MenuItem {

	String getMenuName();
	
	List<MenuItem> execute();
	
}
