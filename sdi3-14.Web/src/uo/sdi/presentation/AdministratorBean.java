package uo.sdi.presentation;

import java.util.List;

import uo.sdi.business.AdminService;
import uo.sdi.business.exception.BusinessException;
import uo.sdi.infrastructure.Factories;
import uo.sdi.model.User;
import alb.util.log.Log;

public class AdministratorBean {

	private List<User> users;// Lista de usuarios que tiene el administrador
	private List<User> selectedUsers;// Usuarios seleccionados de la lista

	public AdministratorBean() {
		listarUsuarios();
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<User> getSelectedUsers() {
		return selectedUsers;
	}

	public void setSelectedUsers(List<User> selectedUsers) {
		this.selectedUsers = selectedUsers;
	}

	/**
	 * Metodo que elimina los usuarios que estan en la lista de usuarios
	 * seleccionados.
	 * 
	 * @return Error si algo falla. Exito si los usuarios son eliminados
	 *         correctemente.
	 */
	public String eliminarUsuarios() {
		String resultado = "exito";
		AdminService service = Factories.services.getAdminService();
		try {
			System.out.println(selectedUsers.size());
			for (User user : selectedUsers)
				service.deepDeleteUser(user.getId());

			users = service.findAllUsers();
			Log.debug("Se han eliminado los usuarios seleccionados correctamente");
		} catch (BusinessException e) {
			resultado = "fracaso";
			e.printStackTrace();
			Log.debug(
					"Ha ocurrido algun error al intentar borrar los usuarios seleccionados: %e",
					e.getMessage());
		}

		return resultado;
	}

	/**
	 * Actualiza la lista de usuarios del administrador.
	 * 
	 * @return
	 */
	public String listarUsuarios() {

		String resultado = "exito";

		try {
			users = Factories.services.getAdminService().findAllUsers();
			Log.debug("Se ha actualizado la lista de usuarios correctamente");
		} catch (BusinessException e) {
			resultado = "error";
			e.printStackTrace();
			Log.debug(
					"Ha ocurrido un error al actualizar la lista de usuarios: %s",
					e.getMessage());
		}

		return resultado;
	}

	/**
	 * Esta clase resetea la base de datos desde el menu de administrador, por
	 * eso se hace la comprobacion de si estamos como admin.
	 * 
	 * @return resultado de la operacion para el faces-config.xml
	 */
	public String resetearBD() {
		String resultado;
		// if (user == null || !user.getIsAdmin())
		// resultado = "error";
		// else
		try {
			Factories.services.getAdminService().reseteaDB();
			resultado = "exito";
			listarUsuarios();
			Log.debug("Se ha reseteado la base de datos correctamente");
		} catch (BusinessException b) {
			resultado = "error";
			Log.debug("Ha ocurrido un error reseteando la base de datos: %s",
					b.getMessage());
		}

		return resultado;
	}

	/**
	 * Metodo que habilita/deshabilita los usuarios que estan en la lista de
	 * usuarios seleccionados.
	 * 
	 * @return Error si algo falla. Exito si los usuarios son
	 *         habilitados/deshabilitados correctemente.
	 */
	public String habilitarUsuarios(boolean status) {
		String resultado = "exito";
		AdminService service = Factories.services.getAdminService();
		try {
			System.out.println(selectedUsers.size());
			for (User user : selectedUsers) {
				if (status) {
					service.enableUser(user.getId());
					Log.debug("Habilitado el usuario %s ", user.getLogin());
				} else {
					service.disableUser(user.getId());
					Log.debug("Deshabilitado el usuario %s ", user.getLogin());
				}
			}

			listarUsuarios();

		} catch (BusinessException e) {
			resultado = "fracaso";
			e.printStackTrace();
		}

		return resultado;
	}

}
