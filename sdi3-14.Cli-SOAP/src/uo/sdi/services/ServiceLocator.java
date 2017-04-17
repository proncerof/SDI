package uo.sdi.services;

import uo.sdi.ws.admin.AdminService;
import uo.sdi.ws.admin.EjbAdminServiceService;
import uo.sdi.ws.task.EjbTaskServiceService;
import uo.sdi.ws.task.TaskService;
import uo.sdi.ws.user.EjbUserServiceService;
import uo.sdi.ws.user.UserService;

public class ServiceLocator {

	public static AdminService getAdminService() {
		return new EjbAdminServiceService().getAdminServicePort();
	}

	public static UserService getUserService() {
		return new EjbUserServiceService().getUserServicePort();
	}

	public static TaskService getTaskService() {
		return new EjbTaskServiceService().getTaskServicePort();
	}
}
