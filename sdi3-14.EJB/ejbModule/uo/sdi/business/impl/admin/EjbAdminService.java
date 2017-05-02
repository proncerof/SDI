package uo.sdi.business.impl.admin;

import java.util.List;

import javax.ejb.Stateless;
import javax.jws.WebService;

import uo.sdi.business.exception.BusinessException;
import uo.sdi.business.impl.admin.command.DeepDeleteUserCommand;
import uo.sdi.business.impl.admin.command.DisableUserCommand;
import uo.sdi.business.impl.admin.command.EnableUserCommand;
import uo.sdi.business.impl.admin.command.ResetDBCommand;
import uo.sdi.dto.User;
import uo.sdi.infrastructure.Factories;

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
		// TODO Auto-generated constructor stub
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
}
