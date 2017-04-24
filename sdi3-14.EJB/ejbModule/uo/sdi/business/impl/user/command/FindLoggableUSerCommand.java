package uo.sdi.business.impl.user.command;

import uo.sdi.business.exception.BusinessException;
import uo.sdi.dto.User;
import uo.sdi.dto.types.UserStatus;
import uo.sdi.infrastructure.Factories;

public class FindLoggableUSerCommand<T>{

	private String login;
	private String password;

	public FindLoggableUSerCommand(String login, String password) {
		this.login = login;
		this.password = password;
	}

	public User execute() throws BusinessException {
		User user = Factories.persistence.getUserDao()
						.findByLoginAndPassword(login, password);
		
		return (user != null && user.getStatus().equals( UserStatus.ENABLED ))
				? user
				: null;
	}

}
