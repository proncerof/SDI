package uo.sdi.dto.util;

import uo.sdi.dto.Category;
import uo.sdi.dto.Task;
import uo.sdi.dto.User;

public class Cloner {

	public static User clone(User u) {
		return new User().setId(u.getId()).setEmail(u.getEmail())
				.setIsAdmin(u.getIsAdmin()).setLogin(u.getLogin())
				.setPassword(u.getPassword()).setStatus(u.getStatus());
	}

	public static Task clone(Task t) {
		Task n = new Task();
		n.setCategoryId(t.getCategoryId());
		n.setComments(t.getComments());
		n.setCreated(t.getCreated());
		n.setFinished(t.getFinished());
		n.setId(t.getId());
		n.setPlanned(t.getPlanned());
		n.setTitle(t.getTitle());
		n.setUserId(t.getUserId());

		return n;
	}

	public static Category clone(Category c) {
		return new Category().setName(c.getName()).setUserId(c.getUserId());
	}

}
