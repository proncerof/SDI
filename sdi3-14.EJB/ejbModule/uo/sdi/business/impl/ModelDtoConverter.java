package uo.sdi.business.impl;

import uo.sdi.dto.ejb.EjbClientUser;
import uo.sdi.dto.rest.RestClientCategory;
import uo.sdi.dto.rest.RestClientTask;
import uo.sdi.model.Category;
import uo.sdi.model.Task;
import uo.sdi.model.User;

public class ModelDtoConverter {

	public static EjbClientUser convertUser(User u) {

		EjbClientUser eu = new EjbClientUser();

		eu.setId(u.getId());
		eu.setEmail(u.getEmail());
		eu.setIsAdmin(u.getIsAdmin());
		eu.setStatus(u.getStatus());

		for (Task t : u.getTasks()) {
			if (t.getFinished() != null) {
				eu.setTareasCompletadas(eu.getTareasCompletadas() + 1);

				if (t.getFinished().compareTo(t.getPlanned()) > 0) {
					eu.setTareasCompletadasRetrasadas(eu
							.getTareasCompletadasRetrasadas() + 1);
				}

			} else if (t.getPlanned() != null) {
				eu.setTareasPlanificadas(eu.getTareasPlanificadas() + 1);
			} else {
				eu.setTareasSinPlanificar(eu.getTareasSinPlanificar() + 1);
			}
		}

		return eu;
	}

	public static RestClientCategory convertCategory(Category category) {
		RestClientCategory rc = new RestClientCategory();

		rc.setId(category.getId());
		rc.setName(category.getName());

		return rc;
	}

	public static RestClientTask convertTask(Task task) {
		RestClientTask rt = new RestClientTask();

		rt.setId(task.getId());
		rt.setComments(task.getComments());
		rt.setTitle(task.getTitle());

		rt.setCreated(task.getCreated());
		rt.setFinished(task.getFinished());
		rt.setPlanned(task.getPlanned());

		return rt;
	}
}
