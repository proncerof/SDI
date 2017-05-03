package uo.sdi.dto.rest;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "category")
public class RestClientCategory implements Serializable {

	private static final long serialVersionUID = 5568866959974234572L;

	private Long id;
	private String name;

	@XmlElement
	public String getName() {
		return name;
	}

	@XmlElement
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RestClientCategory setName(String name) {
		this.name = name;
		return this;
	}

	@Override
	public String toString() {
		return "CategoryDto [id=" + id + ", name=" + name + "]";
	}
}
