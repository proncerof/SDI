package uo.sdi.model.util;

import uo.sdi.model.Category;
import uo.sdi.model.Task;
import uo.sdi.model.User;

public class Cloner {

	public static User clone(User u) {
		User n = new User();
		n.setId(u.getId());
		n.setEmail(u.getEmail());
		n.setIsAdmin(u.getIsAdmin());
		n.setLogin(u.getLogin());
		n.setPassword(u.getPassword());
		n.setStatus(u.getStatus());
		return n;
	}

	public static Task clone(Task t) {
		Task n = new Task();
		n.setCategory(t.getCategory());
		n.setComments(t.getComments());
		n.setCreated(t.getCreated());
		n.setFinished(t.getFinished());
		n.setId(t.getId());
		n.setPlanned(t.getPlanned());
		n.setTitle(t.getTitle());
		n.setUser(t.getUser());

		return n;
	}

	public static Category clone(Category c) {
		return new Category().setName(c.getName()).setUser(c.getUser());
	}

}
