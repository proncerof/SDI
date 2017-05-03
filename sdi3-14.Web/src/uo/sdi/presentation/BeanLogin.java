package uo.sdi.presentation;

import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import uo.sdi.business.exception.BusinessException;
import uo.sdi.infrastructure.Factories;
import uo.sdi.model.User;
import alb.util.log.Log;

public class BeanLogin {

	private String login, password;

	public String getLogin() {
		return login;
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

	/**
	 * Metodo que recibe las credenciales de usuario y las valida mirando en la
	 * base de datos, despues rellena el atributo usuario
	 * 
	 * @return Error, si algo falla. Admin, si el usuario autenticado es
	 *         administrador. Usuario, si el usuario autenticado no es
	 *         administrador.
	 */
	public String validateUser() {

		String resultado;
		try {
			User user = Factories.services.getUserService().findLoggableUser(
					login, password);
			FacesContext facesContext = FacesContext.getCurrentInstance();
			Map<String, Object> sessionMap = facesContext.getExternalContext()
					.getSessionMap();

			if (user != null) {
				sessionMap.put("user", user);
				if (user.getIsAdmin()) {
					resultado = "admin";
					Log.debug(
							"El usuario [%s] ha iniciado sesion como administrador",
							login);
				} else {
					resultado = "user";
					Log.debug("El usuario [%s] ha iniciado sesion", login);
				}
			} else {
				resultado = "error";
				Locale locale = facesContext.getViewRoot().getLocale();
				ResourceBundle bundle = ResourceBundle.getBundle("messages",
						locale);
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(bundle.getString("errorLogin")));
				Log.debug("El usuario [%s] no esta registrado", login);

			}

		} catch (BusinessException e) {
			e.printStackTrace();
			resultado = "error";
			Log.debug(
					"Ha ocurrido algun problema al obtener el usuario [%s] de la base de datos: %s",
					login, e.getMessage());
		}

		return resultado;
	}

	/**
	 * Invalida la sesion.
	 */
	public void cerrarSesion() {
		FacesContext.getCurrentInstance().getExternalContext()
				.invalidateSession();
	}
}
