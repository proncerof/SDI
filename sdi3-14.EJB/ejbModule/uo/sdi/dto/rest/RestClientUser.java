package uo.sdi.dto.rest;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

import uo.sdi.model.Task;
import uo.sdi.model.User;
import uo.sdi.model.types.UserStatus;

public class RestClientUser implements Serializable {

	private static final long serialVersionUID = 5461745400344675866L;

	private Long id;

	private String login;
	private String email;
	private Boolean isAdmin = false;

	private UserStatus status = UserStatus.ENABLED;

	private int tareasCompletadas, tareasCompletadasRetrasadas,
			tareasPlanificadas, tareasSinPlanificar;

	public RestClientUser(User user) {
		this.id = user.getId();
		this.email = user.getEmail();
		this.isAdmin = user.getIsAdmin();
		this.status = user.getStatus();

		for (Task t : user.getTasks()) {
			if (t.getFinished() != null) {
				this.tareasCompletadas++;

				if (t.getFinished().compareTo(t.getPlanned()) > 0) {
					this.tareasCompletadasRetrasadas++;
				}

			} else if (t.getPlanned() != null) {
				this.tareasPlanificadas++;
			} else {
				tareasSinPlanificar++;
			}
		}
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	@XmlElement
	public Long getId() {
		return id;
	}

	public RestClientUser setId(Long id) {
		this.id = id;
		return this;
	}

	@XmlElement
	public String getLogin() {
		return login;
	}

	public RestClientUser setLogin(String login) {
		this.login = login;
		return this;
	}

	@XmlElement
	public String getEmail() {
		return email;
	}

	public RestClientUser setEmail(String email) {
		this.email = email;
		return this;
	}

	@XmlElement
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

	@XmlElement
	public UserStatus getStatus() {
		return status;
	}

	public RestClientUser setStatus(UserStatus status) {
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
