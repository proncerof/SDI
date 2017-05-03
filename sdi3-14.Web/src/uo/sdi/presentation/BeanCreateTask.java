package uo.sdi.presentation;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import uo.sdi.business.exception.BusinessException;
import uo.sdi.infrastructure.Factories;
import uo.sdi.model.Task;
import alb.util.date.DateUtil;
import alb.util.log.Log;

public class BeanCreateTask {

	@ManagedProperty(value = "userBean")
	private UserBean userBean;

	private String categoryNameToChange;
	private String title;// Titulo de la nueva tarea
	private Date planned;// Fecha planeada de la nueva tarea
	private String comment;// Comentario de la nueva tarea;

	@PostConstruct
	public void init() {
		userBean = (UserBean) FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap()
				.get(new String("userBean"));
	}

	public String getCategoryNameToChange() {
		return categoryNameToChange;
	}

	public void setCategoryNameToChange(String categoryNameToChange) {
		this.categoryNameToChange = categoryNameToChange;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getPlanned() {
		return planned;
	}

	public void setPlanned(Date planned) {
		this.planned = planned;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * Crea una nueva tarea con los datos editTitle, editComments, editPlanned
	 * and editFinished.
	 * 
	 * @return exito, si la tarea se guarda correctamente. fracaso si hay algun
	 *         error al guardar la tarea
	 */
	public String createTask() {
		String resultado = "exito";
		try {
			Task nuevaTarea = new Task();
			nuevaTarea.setUser(userBean.getUser());
			nuevaTarea.setTitle(title);
			nuevaTarea.setComments(comment);
			nuevaTarea.setCreated(DateUtil.today());
			if (planned != null)
				nuevaTarea.setPlanned(planned);
			else
				nuevaTarea.setPlanned(DateUtil.today());

			if (this.categoryNameToChange != null)
				nuevaTarea.setCategory(userBean
						.getCategoryFromName(this.categoryNameToChange));

			Factories.services.getTaskService().createTask(nuevaTarea);

			Log.debug("Se ha creado una nueva tarea [%s] correctamente", title);

			if (nuevaTarea.getCategory() == null) {
				userBean.listarInbox();
				resultado = "inbox";
			} else {
				if (nuevaTarea.getPlanned().equals(DateUtil.today())) {
					userBean.listarHoy();
					resultado = "hoy";
				} else {
					userBean.listarSemana();
					resultado = "semana";
				}
			}

		} catch (BusinessException e) {
			resultado = "fracaso";
			Log.debug("Ha ocurrido un error creando la tarea [%s]: %s", title,
					e.getMessage());

		}
		return resultado;
	}

}
