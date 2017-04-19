package uo.sdi.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import alb.util.date.DateUtil;

@Entity
@Table(name="TTasks")
public class Task implements Serializable, Comparable<Task> {

	private static final long serialVersionUID = -5194439578090536982L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;
	private String comments;
	private Date created = DateUtil.today();
	private Date planned;
	private Date finished;

	@ManyToOne(optional = true)
	private Category category;

	@ManyToOne
	private User user;

	public Long getId() {
		return id;
	}

	public Task setId(Long id) {
		this.id = id;
		return this;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Date getCreated() {
		return created;
	}

	public Task setCreated(Date created) {
		this.created = created;
		return this;
	}

	public Date getPlanned() {
		return planned;
	}

	public void setPlanned(Date planned) {
		this.planned = planned;
	}

	public Date getFinished() {
		return finished;
	}

	public Task setFinished(Date finished) {
		this.finished = finished;
		return this;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public User getUser() {
		return user;
	}

	public boolean isRetarded() {
		return !hasBeenFinished() && this.getPlanned() != null
				&& this.getPlanned().before(DateUtil.today());
	}

	public boolean hasBeenFinished() {
		return this.getFinished() != null;
	}

	public Task setUser(User user) {
		this.user = user;
		return this;
	}

	@Override
	public String toString() {
		return "TaskDto [id=" + id + ", title=" + title + ", comments="
				+ comments + ", created=" + created + ", planned=" + planned
				+ ", finished=" + finished + ", category=" + category
				+ ", userId=" + user + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((category == null) ? 0 : category.hashCode());
		result = prime * result
				+ ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result
				+ ((finished == null) ? 0 : finished.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((planned == null) ? 0 : planned.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Task other = (Task) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (created == null) {
			if (other.created != null)
				return false;
		} else if (!created.equals(other.created))
			return false;
		if (finished == null) {
			if (other.finished != null)
				return false;
		} else if (!finished.equals(other.finished))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (planned == null) {
			if (other.planned != null)
				return false;
		} else if (!planned.equals(other.planned))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
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

}
