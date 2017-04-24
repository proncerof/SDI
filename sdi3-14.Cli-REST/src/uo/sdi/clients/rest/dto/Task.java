package uo.sdi.clients.rest.dto;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import alb.util.date.DateUtil;

@XmlRootElement(name="task")
public class Task implements Serializable, Comparable<Task> {

	private static final long serialVersionUID = -5194439578090536982L;

	private Long id;

	private String title;
	private String comments;
	private Date created = DateUtil.today();
	private Date planned;
	private Date finished;

	private User user;
	
	@XmlElement
	public Long getId() {
		return id;
	}

	public Task setId(Long id) {
		this.id = id;
		return this;
	}

	@XmlElement
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@XmlElement
	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@XmlElement
	public Date getCreated() {
		return created;
	}

	public Task setCreated(Date created) {
		this.created = created;
		return this;
	}

	@XmlElement
	public Date getPlanned() {
		return planned;
	}

	public void setPlanned(Date planned) {
		this.planned = planned;
	}

	@XmlElement
	public Date getFinished() {
		return finished;
	}

	public Task setFinished(Date finished) {
		this.finished = finished;
		return this;
	}

	public boolean isRetarded() {
		return !hasBeenFinished() && this.getPlanned() != null
				&& this.getPlanned().before(DateUtil.today());
	}

	public boolean hasBeenFinished() {
		return this.getFinished() != null;
	}

	@Override
	public String toString() {
		return "TaskDto [id=" + id + ", title=" + title + ", comments="
				+ comments + ", created=" + created + ", planned=" + planned
				+ ", finished=" + finished + "]";
	}

	@Override
	public int compareTo(Task o) {
		if (o.getPlanned() != null && getPlanned() != null)
			return getPlanned().compareTo(o.getPlanned());
		else if (o.getPlanned() == null)
			return -1;
		else
			return 1;
	}

	@XmlElement
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
