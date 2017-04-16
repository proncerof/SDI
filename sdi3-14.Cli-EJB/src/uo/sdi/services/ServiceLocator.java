package uo.sdi.services;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import uo.sdi.business.AdminService;
import uo.sdi.business.TaskService;
import uo.sdi.business.UserService;

public class ServiceLocator {

	private static final String ADMIN_SERVICE_JNDI_KEY = 
			"sdi3-14/sdi3-14.EJB/EjbAdminService!"
			+ "uo.sdi.business.impl.admin.EjbAdminServiceRemote";

	private static final String TASK_SERVICE_JNDI_KEY =
			"sdi3-14/sdi3-14.EJB/EjbTaskService!"
			+ "uo.sdi.business.impl.task.EjbTaskServiceRemote";

	private static final String USER_SERVICE_JNDI_KEY =
			"sdi3-14/sdi3-14.EJB/EjbUserService!"
			+ "uo.sdi.business.impl.user.EjbUserServiceRemote";

	public static AdminService getAdminService() {
		try {
			Context ctx = new InitialContext();
			return (AdminService) ctx.lookup(ADMIN_SERVICE_JNDI_KEY);
		} catch (NamingException e) {
			throw new RuntimeException("JNDI problem", e);
		}
	}

	public static UserService getUserService() {
		try {
			Context ctx = new InitialContext();
			return (UserService) ctx.lookup(USER_SERVICE_JNDI_KEY);
		} catch (NamingException e) {
			throw new RuntimeException("JNDI problem", e);
		}
	}

	public static TaskService getTaskService() {
		try {
			Context ctx = new InitialContext();
			return (TaskService) ctx.lookup(TASK_SERVICE_JNDI_KEY);
		} catch (NamingException e) {
			throw new RuntimeException("JNDI problem", e);
		}
	}
}
