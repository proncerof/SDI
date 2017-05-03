package uo.sdi.business.impl.admin;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.jws.WebService;

import uo.sdi.business.exception.BusinessException;
import uo.sdi.business.impl.admin.command.DeepDeleteUserCommand;
import uo.sdi.business.impl.admin.command.DisableUserCommand;
import uo.sdi.business.impl.admin.command.EnableUserCommand;
import uo.sdi.business.impl.admin.command.ResetDBCommand;
import uo.sdi.dto.ejb.EjbClientUser;
import uo.sdi.infrastructure.Factories;
import uo.sdi.model.User;

/**
 * Session Bean implementation class EjbAdminService
 */
@Stateless
@WebService(name = "AdminService")
public class EjbAdminService implements EjbAdminServiceRemote,
		EjbAdminServiceLocal {

	/**
	 * Default constructor.
	 */
	public EjbAdminService() {
	}

	@Override
	public void deepDeleteUser(Long id) throws BusinessException {
		new DeepDeleteUserCommand(id).execute();
	}

	@Override
	public void disableUser(Long id) throws BusinessException {
		new DisableUserCommand(id).execute();
	}

	@Override
	public void enableUser(Long id) throws BusinessException {
		new EnableUserCommand(id).execute();
	}

	@Override
	public List<User> findAllUsers() throws BusinessException {
		return Factories.persistence.getUserDao().findAll();
	}

	@Override
	public User findUserById(final Long id) throws BusinessException {
		return Factories.persistence.getUserDao().findById(id);
	}

	@Override
	public void reseteaDB() throws BusinessException {
		new ResetDBCommand().execute();
	}

	@Override
	public List<EjbClientUser> findAllUsersEjbClient() throws BusinessException {
		List<User> users = Factories.persistence.getUserDao().findAll();

		List<EjbClientUser> newUsers = new ArrayList<EjbClientUser>();

		for (User u : users)
			newUsers.add(new EjbClientUser(u));
		
		return newUsers;
	}
}
