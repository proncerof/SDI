package uo.sdi.services;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import uo.sdi.business.AdminService;

public class ServiceLocator {

	private static final String ADMIN_SERVICE_JNDI_KEY = 
			"sdi3-14/sdi3-14.EJB/EjbAdminService!"
			+ "uo.sdi.business.impl.admin.EjbAdminServiceRemote";

	public static AdminService getAdminService() {
		try {
			Context ctx = new InitialContext();
			return (AdminService) ctx.lookup(ADMIN_SERVICE_JNDI_KEY);
		} catch (NamingException e) {
			throw new RuntimeException("JNDI problem", e);
		}
	}

}
