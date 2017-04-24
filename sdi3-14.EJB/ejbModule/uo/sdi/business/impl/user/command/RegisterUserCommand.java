package uo.sdi.business.impl.user.command;

import uo.sdi.business.exception.BusinessException;
import uo.sdi.business.impl.util.UserCheck;
import uo.sdi.dto.User;
import uo.sdi.infrastructure.Factories;

public class RegisterUserCommand{

	private User user;

	public RegisterUserCommand(User user) {
		this.user = user;
	}

	public User execute() throws BusinessException {
		UserCheck.isNotAdmin( user );
		UserCheck.isValidEmailSyntax( user ); 
		UserCheck.minLoginLength( user );
		UserCheck.minPasswordLength( user );
		UserCheck.notRepeatedLogin( user );
		
		return Factories.persistence.getUserDao().save( user );
	}

}
