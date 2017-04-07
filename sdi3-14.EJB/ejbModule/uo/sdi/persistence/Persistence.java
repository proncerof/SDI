package uo.sdi.persistence;

import uo.sdi.persistence.impl.CategoryDaoJdbcImpl;
import uo.sdi.persistence.impl.TaskDaoJdbcImpl;
import uo.sdi.persistence.impl.UserDaoJdbcImpl;

public class Persistence {

	public static UserDao getUserDao() {
		return new UserDaoJdbcImpl();
	}

	public static TaskDao getTaskDao() {
		return new TaskDaoJdbcImpl();
	}

	public static CategoryDao getCategoryDao() {
		return new CategoryDaoJdbcImpl();
	}

}
