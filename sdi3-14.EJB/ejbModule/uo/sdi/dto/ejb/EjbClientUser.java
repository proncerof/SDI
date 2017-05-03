package uo.sdi.dto.ejb;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

import uo.sdi.model.types.UserStatus;

public class EjbClientUser implements Serializable {

	private static final long serialVersionUID = 7521139039516091035L;

	private Long id;

	private String login;
	private String email;
	private Boolean isAdmin = false;

	private UserStatus status = UserStatus.ENABLED;

	private int tareasCompletadas, tareasCompletadasRetrasadas,
			tareasPlanificadas, tareasSinPlanificar;

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public Long getId() {
		return id;
	}

	public EjbClientUser setId(Long id) {
		this.id = id;
		return this;
	}

	@XmlElement
	public String getLogin() {
		return login;
	}

	public EjbClientUser setLogin(String login) {
		this.login = login;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public EjbClientUser setEmail(String email) {
		this.email = email;
		return this;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	@Override
	public String toString() {
		return "EjbClientUser [id=" + id + ", login=" + login + ", email="
				+ email + ", isAdmin=" + isAdmin + ", status=" + status
				+ ", tareasCompletadas=" + tareasCompletadas
				+ ", tareasCompletadasRetrasadas="
				+ tareasCompletadasRetrasadas + ", tareasPlanificadas="
				+ tareasPlanificadas + ", tareasSinPlanificar="
				+ tareasSinPlanificar + "]";
	}

	public UserStatus getStatus() {
		return status;
	}

	public EjbClientUser setStatus(UserStatus status) {
		this.status = status;
		return this;
	}

	public int getTareasCompletadas() {
		return tareasCompletadas;
	}

	public void setTareasCompletadas(int tareasCompletadas) {
		this.tareasCompletadas = tareasCompletadas;
	}

	public int getTareasCompletadasRetrasadas() {
		return tareasCompletadasRetrasadas;
	}

	public void setTareasCompletadasRetrasadas(int tareasCompletadasRetrasadas) {
		this.tareasCompletadasRetrasadas = tareasCompletadasRetrasadas;
	}

	public int getTareasPlanificadas() {
		return tareasPlanificadas;
	}

	public void setTareasPlanificadas(int tareasPlanificadas) {
		this.tareasPlanificadas = tareasPlanificadas;
	}

	public int getTareasSinPlanificar() {
		return tareasSinPlanificar;
	}

	public void setTareasSinPlanificar(int tareasSinPlanificar) {
		this.tareasSinPlanificar = tareasSinPlanificar;
	}

}
