package uo.sdi.services;

import uo.sdi.ws.AdminService;
import uo.sdi.ws.EjbAdminServiceService;

public class ServiceLocator {

	public static AdminService getAdminService() {
		return new EjbAdminServiceService().getAdminServicePort();
	}
	
}
