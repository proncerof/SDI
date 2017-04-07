package uo.sdi.business;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class LocalEjbServiceLocator implements ServicesFactory {

	private static final String ADMIN_SERVICE_JNDI_KEY = "java:global/"
			+ "sdi3-14/sdi3-14.EJB/EjbAdminService!"
			+ "uo.sdi.business.impl.admin.EjbAdminServiceLocal";

	private static final String TASK_SERVICE_JNDI_KEY = "java:global/"
			+ "sdi3-14/sdi3-14.EJB/EjbTaskService!"
			+ "uo.sdi.business.impl.task.EjbTaskServiceLocal";

	private static final String USER_SERVICE_JNDI_KEY = "java:global/"
			+ "sdi3-14/sdi3-14.EJB/EjbUserService!"
			+ "uo.sdi.business.impl.user.EjbUserServiceLocal";

	@Override
	public AdminService getAdminService() {
		try {
			Context ctx = new InitialContext();
			return (AdminService) ctx.lookup(ADMIN_SERVICE_JNDI_KEY);
		} catch (NamingException e) {
			throw new RuntimeException("JNDI problem", e);
		}
	}

	@Override
	public UserService getUserService() {
		try {
			Context ctx = new InitialContext();
			return (UserService) ctx.lookup(USER_SERVICE_JNDI_KEY);
		} catch (NamingException e) {
			throw new RuntimeException("JNDI problem", e);
		}
	}

	@Override
	public TaskService getTaskService() {
		try {
			Context ctx = new InitialContext();
			return (TaskService) ctx.lookup(TASK_SERVICE_JNDI_KEY);
		} catch (NamingException e) {
			throw new RuntimeException("JNDI problem", e);
		}
	}

}
