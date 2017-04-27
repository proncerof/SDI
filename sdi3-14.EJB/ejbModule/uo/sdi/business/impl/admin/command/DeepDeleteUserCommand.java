package uo.sdi.business.impl.admin.command;

import uo.sdi.business.exception.BusinessException;
import uo.sdi.infrastructure.Factories;
import uo.sdi.persistence.CategoryDao;
import uo.sdi.persistence.TaskDao;
import uo.sdi.persistence.UserDao;

public class DeepDeleteUserCommand{

	private Long userId;

	public DeepDeleteUserCommand(Long id) {
		this.userId = id;
	}

	public Void execute() throws BusinessException {
		TaskDao tDao = Factories.persistence.getTaskDao();
		CategoryDao cDao = Factories.persistence.getCategoryDao();
		UserDao uDao = Factories.persistence.getUserDao();

		tDao.deleteAllFromUserId(userId);
		cDao.deleteAllFromUserId(userId);
		uDao.delete(userId);

		return null;
	}

}
