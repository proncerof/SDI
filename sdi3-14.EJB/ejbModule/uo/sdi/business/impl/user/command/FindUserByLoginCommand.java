package uo.sdi.business.impl.user.command;

import uo.sdi.business.exception.BusinessException;
import uo.sdi.infrastructure.Factories;
import uo.sdi.model.User;

public class FindUserByLoginCommand<T>{

	private String login;

	public FindUserByLoginCommand(String login) {
		this.login = login;
	}

	public User execute() throws BusinessException {
		User user = Factories.persistence.getUserDao().findByLogin(login);

		return user;
	}
}
