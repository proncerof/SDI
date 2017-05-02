package uo.sdi.business.impl.user;

import javax.ejb.Stateless;

import uo.sdi.business.exception.BusinessException;
import uo.sdi.business.impl.user.command.FindLoggableUSerCommand;
import uo.sdi.business.impl.user.command.FindUserByLoginCommand;
import uo.sdi.business.impl.user.command.RegisterUserCommand;
import uo.sdi.business.impl.user.command.UpdateUserDetailsCommand;
import uo.sdi.dto.User;

/**
 * Session Bean implementation class EjbUserService
 */
@Stateless
public class EjbUserService implements EjbUserServiceRemote,
		EjbUserServiceLocal {

	/**
	 * Default constructor.
	 */
	public EjbUserService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public User registerUser(User user) throws BusinessException {
		return new RegisterUserCommand(user).execute();
	}

	@Override
	public void updateUserDetails(User user) throws BusinessException {
		new UpdateUserDetailsCommand(user).execute();
	}

	@Override
	public User findLoggableUser(final String login, final String password)
			throws BusinessException {

		return new FindLoggableUSerCommand<User>(login, password).execute();
	}

	@Override
	public User findUserByLogin(String login) throws BusinessException {

		return new FindUserByLoginCommand<User>(login).execute();
	}

}
