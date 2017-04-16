package uo.sdi.business.impl.user.command;

import uo.sdi.business.exception.BusinessException;
import uo.sdi.business.impl.command.Command;
import uo.sdi.dto.User;
import uo.sdi.infrastructure.Factories;

public class FindUserByLoginCommand<T> implements Command<User> {

	private String login;

	public FindUserByLoginCommand(String login) {
		this.login = login;
	}

	@Override
	public User execute() throws BusinessException {
		User user = Factories.persistence.getUserDao().findByLogin(login);

		return user;
	}
}
