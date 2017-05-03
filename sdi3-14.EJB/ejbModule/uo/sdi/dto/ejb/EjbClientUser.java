package uo.sdi.dto.ejb;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

import uo.sdi.dto.Task;
import uo.sdi.dto.User;
import uo.sdi.dto.types.UserStatus;

public class EjbClientUser implements Serializable {

	private static final long serialVersionUID = 5461745400344675866L;

	private Long id;

	private String login;
	private String email;
	private Boolean isAdmin = false;

	private UserStatus status = UserStatus.ENABLED;

	private int tareasCompletadas, tareasCompletadasRetrasadas,
			tareasPlanificadas, tareasSinPlanificar;

	public EjbClientUser(User user) {
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

	@XmlElement
	public String getEmail() {
		return email;
	}

	public EjbClientUser setEmail(String email) {
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
