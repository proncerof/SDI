package uo.sdi.presentation;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import uo.sdi.business.UserService;
import uo.sdi.business.exception.BusinessException;
import uo.sdi.infrastructure.Factories;
import uo.sdi.model.User;

public class RegistroBean {

	private String email, login, password, passwordRepeated;

	public String getLogin() {
		return login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordRepeated() {
		return passwordRepeated;
	}

	public void setPasswordRepeated(String passwordRepeated) {
		this.passwordRepeated = passwordRepeated;
	}

	public String signin() {
		String result = "exito";

		try {
			UserService service = Factories.services.getUserService();
			User user = new User().setEmail(email).setLogin(login)
					.setPassword(password);
			service.registerUser(user);
		} catch (BusinessException e) {
			result = "error";
			e.printStackTrace();

			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(e.getMessage()));
		}

		return result;

	}
}