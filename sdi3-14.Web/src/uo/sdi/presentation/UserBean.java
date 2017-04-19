package uo.sdi.presentation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;

import uo.sdi.business.TaskService;
import uo.sdi.business.exception.BusinessException;
import uo.sdi.dto.Category;
import uo.sdi.dto.Task;
import uo.sdi.dto.User;
import uo.sdi.infrastructure.Factories;
import alb.util.date.DateUtil;
import alb.util.log.Log;

public class UserBean {

	private final static int LISTA_INBOX = 0;
	private final static int LISTA_HOY = 2;
	private final static int LISTA_SEMANA = 1;

	private boolean mostrarTodasEnInbox = false;

	private User user; // El usuario logeado

	private TaskList tasks; // Lista de tareas del usuario atenticado
	private List<Task> selectedTasks;// Lista de tareas seleccionadas de la
										// lista anterior
	private List<Task> filteredTasks;

	private List<Category> categories;// Lista de categorias del usuario

	private String title;// Titulo de la tarea a nodificar
	private Date planned;// Fecha planeada de la tarea a modificar
	private String categoryNameToChange;// Categoria de la tarea a modificar

	private int listaActual = LISTA_INBOX;

	/**
	 * Busca el objeto user en sesion.
	 */
	@PostConstruct
	public void init() {
		// Obtenemos el usuario de la sesion
		FacesContext facesContext = FacesContext.getCurrentInstance();
		Map<String, Object> sessionMap = facesContext.getExternalContext()
				.getSessionMap();
		this.user = (User) sessionMap.get("user");
		// Inicializamos la lista categorias y tareas del usuario
		inicializarCategorias();

		if (this.mostrarTodasEnInbox)
			this.listarTodas();
		else
			this.listarNoTerminadas();
	}

	public TaskList getTasks() {
		return tasks;
	}

	public void setTasks(TaskList tasks) {
		this.tasks = tasks;
	}

	public List<Task> getSelectedTasks() {
		return selectedTasks;
	}

	public void setSelectedTasks(List<Task> selectedTasks) {
		this.selectedTasks = selectedTasks;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public String getCategoryNameToChange() {
		return categoryNameToChange;
	}

	public void setCategoryNameToChange(String categoryNameToChange) {
		this.categoryNameToChange = categoryNameToChange;
	}

	private void inicializarCategorias() {
		try {
			setCategories(Factories.services.getTaskService()
					.findCategoriesByUserId(user.getId()));
		} catch (BusinessException e) {
			e.printStackTrace();
			Log.debug("Ha ocurrido un error al inicializar las categorias: %s",
					e.getMessage());
		}
	}

	/**
	 * Actualiza la lista de tareas inbox del usuario
	 * 
	 * @return exito, si se han actualizado correctamente, fracaso si ha habido
	 *         algun problema con la base de datos.
	 */
	public String listarInbox() {
		String resultado = "exito";

		TaskService service = Factories.services.getTaskService();
		try {
			this.setFilteredTasks(null);
			List<Task> newTasksNotFinished = service
					.findInboxTasksByUserId(user.getId());
			Collections.sort(newTasksNotFinished);

			if (mostrarTodasEnInbox) {
				List<Task> newTasksFinished = service
						.findFinishedInboxTasksByUserId(user.getId());
				Collections.sort(newTasksFinished);
				newTasksNotFinished.addAll(newTasksFinished);
			}

			this.setTasks(new TaskList(newTasksNotFinished));

			this.listaActual = LISTA_INBOX;
			Log.debug(
					"Se han listado correctamente las tareas inbox del usuario [%s]",
					user.getLogin());
		} catch (BusinessException e) {
			resultado = "error";
			e.printStackTrace();
			Log.debug(
					"Ha ocurrido un problema al listar las tareas inbox del usuario [%s]: %s",
					user.getLogin(), e.getMessage());
		}

		return resultado;
	}

	/**
	 * Actualiza la lista de tareas de hoy del usuario
	 * 
	 * @return exito, si se han actualizado correctamente, fracaso si ha habido
	 *         algun problema con la base de datos.
	 */
	public String listarHoy() {
		String resultado = "exito";

		TaskService service = Factories.services.getTaskService();
		try {
			this.setFilteredTasks(null);
			List<Task> newTasks = service.findTodayTasksByUserId(user.getId());
			Collections.sort(newTasks);
			setTasks(new TaskList(newTasks));

			this.listaActual = LISTA_HOY;
			Log.debug(
					"Se han listado correctamente las tareas de hoy del usuario [%s]",
					user.getLogin());
		} catch (BusinessException e) {
			resultado = "error";
			e.printStackTrace();
			Log.debug(
					"Ha ocurrido un herror al listar las tareas de hoy del usuario [%s]: ",
					user.getLogin(), e.getMessage());
		}

		return resultado;
	}

	/**
	 * Actualiza la lista de tareas de hoy del usuario
	 * 
	 * @return exito, si se han actualizado correctamente, fracaso si ha habido
	 *         algun problema con la base de datos.
	 */
	public String listarSemana() {
		String resultado = "exito";

		TaskService service = Factories.services.getTaskService();
		try {
			this.setFilteredTasks(null);
			List<Task> newTasks = service.findWeekTasksByUserId(user.getId());
			Collections.sort(newTasks);
			setTasks(new TaskList(newTasks));
			this.listaActual = LISTA_SEMANA;
			Log.debug(
					"Se han listado correctamente las tareas de la semana del usuario [%s]",
					user.getLogin());
		} catch (BusinessException e) {
			resultado = "error";
			e.printStackTrace();
			Log.debug(
					"Ha ocurrido un error al listar las tareas de la semana del usuario [%s]: %s",
					user.getLogin(), e.getMessage());
		}

		return resultado;
	}

	/**
	 * Finaliza las tareas de la lista de tareas seleccionadas.
	 */
	public void finalizarTarea() {
		TaskService service = Factories.services.getTaskService();
		try {

			// Eliminamos todos los filtros
			@SuppressWarnings("unchecked")
			List<Task> tareas = ((List<Task>) this.tasks.getWrappedData());

			if (this.getFilteredTasks() != null) {
				this.getFilteredTasks().clear();
				this.getFilteredTasks().addAll(tareas);
			}

			for (Task task : selectedTasks)
				service.markTaskAsFinished(task.getId());

			actualizarListaActual();

			Log.debug("Se han finalizado correctamente las tareas seleccionadas");
		} catch (BusinessException e) {
			e.printStackTrace();
			Log.debug("Ha ocurrido un problema al finalizar la terea: %s",
					e.getMessage());
		}
	}

	private void actualizarListaActual() {
		if (this.listaActual == LISTA_SEMANA)
			this.listarSemana();
		else if (this.listaActual == LISTA_HOY)
			this.listarHoy();
		else {
			if (this.mostrarTodasEnInbox)
				this.listarTodas();
			else
				this.listarNoTerminadas();
		}
	}

	/**
	 * Metodo para averiguar el nombre de la categoria
	 * 
	 * @param tarea
	 * @return
	 */
	public String getCategoryName(Task tarea) {
		if(tarea.getCategory()==null)
			return "";
		return tarea.getCategory().getName();
	}

	/**
	 * Metodo para averiguar el nombre de la categoria
	 * 
	 * @param tarea
	 * @return
	 */
	public String getCategoryNameFromId(Long id) {
		for (Category c : this.getCategories())
			if (id.equals(c.getId()))
				return c.getName();
		return "";
	}

	public List<String> getListOfCategoryNames() {
		List<String> names = new ArrayList<String>();
		for (Category c : this.getCategories())
			names.add(c.getName());
		return names;
	}

	/**
	 * Actualiza la tarea modificada en la base de datos
	 * 
	 * @param tarea
	 *            que se ha modificado para ser actualizada
	 */
	public void updateTask(Task tarea) {
		TaskService service = Factories.services.getTaskService();

		try {
			service.updateTask(tarea);
			Log.debug("La tarea [%d] se ha actualizado correctamente",
					tarea.getId());
			actualizarListaActual();
		} catch (BusinessException e) {
			e.printStackTrace();
			Log.debug("Ha ocurrido un error al actualizar la tarea [%d]: %s",
					tarea.getId(), e.getMessage());
		}
	}

	public String formatDate(Date date) {
		if (date == null)
			return "";
		return DateUtil.toString(date);
	}

	public Category getCategoryFromName(String name) {
		for (Category c : this.categories)
			if (c.getName().equals(name))
				return c;
		return null;
	}

	public List<Task> getFilteredTasks() {
		return filteredTasks;
	}

	public void setFilteredTasks(List<Task> filteredTasks) {
		this.filteredTasks = filteredTasks;
	}

	/**
	 * Metodo que lista todas las categorias incluyendo las terminadas en inbox
	 */
	public void listarTodas() {
		this.mostrarTodasEnInbox = true;
		TaskService service = Factories.services.getTaskService();
		try {
			this.setFilteredTasks(null);
			List<Task> newTasksNotFinished = service
					.findInboxTasksByUserId(user.getId());
			Collections.sort(newTasksNotFinished);

			List<Task> newTasksFinished = service
					.findFinishedInboxTasksByUserId(user.getId());
			Collections.sort(newTasksFinished);

			newTasksNotFinished.addAll(newTasksFinished);

			this.setTasks(new TaskList(newTasksNotFinished));

			this.listaActual = LISTA_INBOX;
			Log.debug(
					"Se han listado correctamente las tareas inbox del usuario [%s]",
					user.getLogin());
		} catch (BusinessException e) {
			e.printStackTrace();
			Log.debug(
					"Ha ocurrido un problema al listar las tareas inbox del usuario [%s]: %s",
					user.getLogin(), e.getMessage());
		}
	}

	/**
	 * Metodo que lista todas las tareas excepto las terminadas en inbox
	 */
	public void listarNoTerminadas() {
		this.mostrarTodasEnInbox = false;
		this.listarInbox();
	}
	


}
