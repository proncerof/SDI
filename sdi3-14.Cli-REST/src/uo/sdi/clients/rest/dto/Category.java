package uo.sdi.clients.rest.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "category")
public class Category implements Serializable {

	private static final long serialVersionUID = 5568866959974234572L;

	private Long id;
	private String name;

	private Long userId;

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@XmlElement
	public String getName() {
		return name;
	}

	@XmlElement
	public Long getId() {
		return id;
	}
	
	@XmlElement
	public Long getUserId() {
		return this.userId;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Category setName(String name) {
		this.name = name;
		return this;
	}

	@Override
	public String toString() {
		return "CategoryDto [id=" + id + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Category other = (Category) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}

}
