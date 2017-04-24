package uo.sdi.clients.rest.dto.util;

import uo.sdi.clients.rest.dto.Category;
import uo.sdi.clients.rest.dto.Task;
import uo.sdi.clients.rest.dto.User;

public class Cloner {

	public static User clone(User u) {
		return new User().setId(u.getId()).setEmail(u.getEmail())
				.setIsAdmin(u.getIsAdmin()).setLogin(u.getLogin())
				.setPassword(u.getPassword()).setStatus(u.getStatus());
	}

	public static Task clone(Task t) {
		Task n = new Task();
		n.setComments(t.getComments());
		n.setCreated(t.getCreated());
		n.setFinished(t.getFinished());
		n.setId(t.getId());
		n.setPlanned(t.getPlanned());
		n.setTitle(t.getTitle());

		return n;
	}

	public static Category clone(Category c) {
		return new Category().setName(c.getName());
	}

}
