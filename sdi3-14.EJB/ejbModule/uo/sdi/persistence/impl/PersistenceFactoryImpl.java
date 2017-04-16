package uo.sdi.persistence.impl;

import uo.sdi.persistence.CategoryDao;
import uo.sdi.persistence.PersistenceFactory;
import uo.sdi.persistence.TaskDao;
import uo.sdi.persistence.UserDao;

public class PersistenceFactoryImpl implements PersistenceFactory {

	@Override
	public UserDao getUserDao() {
		return new UserDaoJdbcImpl();
	}

	@Override
	public TaskDao getTaskDao() {
		return new TaskDaoJdbcImpl();
	}

	@Override
	public CategoryDao getCategoryDao() {
		return new CategoryDaoJdbcImpl();
	}

}
