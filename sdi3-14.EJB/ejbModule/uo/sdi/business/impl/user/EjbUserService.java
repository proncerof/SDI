package uo.sdi.business.impl.user;

import javax.ejb.Stateless;
import javax.jws.WebService;

import uo.sdi.business.exception.BusinessException;
import uo.sdi.business.impl.command.CommandExecutor;
import uo.sdi.business.impl.user.command.FindLoggableUSerCommand;
import uo.sdi.business.impl.user.command.FindUserByLoginCommand;
import uo.sdi.business.impl.user.command.RegisterUserCommand;
import uo.sdi.business.impl.user.command.UpdateUserDetailsCommand;
import uo.sdi.dto.User;

/**
 * Session Bean implementation class EjbUserService
 */
@Stateless
@WebService(name = "UserService")
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
		return new CommandExecutor<User>()
				.execute(new RegisterUserCommand(user));
	}

	@Override
	public void updateUserDetails(User user) throws BusinessException {
		new CommandExecutor<Void>().execute(new UpdateUserDetailsCommand(user));
	}

	@Override
	public User findLoggableUser(final String login, final String password)
			throws BusinessException {

		return new CommandExecutor<User>()
				.execute(new FindLoggableUSerCommand<User>(login, password));
	}

	@Override
	public User findUserByLogin(String login) throws BusinessException {
		return new CommandExecutor<User>()
				.execute(new FindUserByLoginCommand<User>(login));
	}

}
