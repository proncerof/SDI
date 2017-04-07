package uo.sdi.infrastructure;

import uo.sdi.business.LocalEjbServiceLocator;
import uo.sdi.business.ServicesFactory;

public class Factories {
	
	public static ServicesFactory services = new LocalEjbServiceLocator();
	

}
