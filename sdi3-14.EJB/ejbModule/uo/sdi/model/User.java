package uo.sdi.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import uo.sdi.model.types.UserStatus;

/**
 * An implementation of the DTO pattern
 * 
 * @author alb
 */
@Entity
@Table(name = "TUsers")
@XmlRootElement(name="user")
public class User implements Serializable {

	private static final long serialVersionUID = 5461745400344675866L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String login;
	private String email;
	private String password;
	private Boolean isAdmin = false;

	@Enumerated(EnumType.STRING)
	private UserStatus status = UserStatus.ENABLED;

	@OneToMany(mappedBy = "user")	
	public List<Category> categories = new ArrayList<>();

	@OneToMany(mappedBy = "user")
	public List<Task> tasks = new ArrayList<>();

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	@XmlElement
	public Long getId() {
		return id;
	}

	public User setId(Long id) {
		this.id = id;
		return this;
	}

	@XmlElement
	public String getLogin() {
		return login;
	}

	public User setLogin(String login) {
		this.login = login;
		return this;
	}

	@XmlElement
	public String getEmail() {
		return email;
	}

	public User setEmail(String email) {
		this.email = email;
		return this;
	}

	@XmlElement
	public String getPassword() {
		return password;
	}

	public User setPassword(String password) {
		this.password = password;
		return this;
	}

	@XmlElement
	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public List<Category> getCategories() {
		return new ArrayList<>(categories);
	}

	public List<Task> getTasks() {
		return new ArrayList<>(tasks);
	}
	
	public List<Task> _getTasks() {
		return tasks;
	}

	@Override
	public String toString() {
		return "UserDto [id=" + id + ", login=" + login + ", email=" + email
				+ ", password=" + password + ", isAdmin=" + isAdmin + "]";
	}

	@XmlElement
	public UserStatus getStatus() {
		return status;
	}

	public User setStatus(UserStatus status) {
		this.status = status;
		return this;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((isAdmin == null) ? 0 : isAdmin.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isAdmin == null) {
			if (other.isAdmin != null)
				return false;
		} else if (!isAdmin.equals(other.isAdmin))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (status != other.status)
			return false;
		return true;
	}

}
