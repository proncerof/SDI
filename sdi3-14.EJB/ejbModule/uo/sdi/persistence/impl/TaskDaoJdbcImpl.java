package uo.sdi.persistence.impl;

import java.util.List;

import javax.persistence.EntityManager;

import uo.sdi.model.Task;
import uo.sdi.persistence.TaskDao;
import uo.sdi.persistence.util.Jpa;

public class TaskDaoJdbcImpl implements TaskDao {

	@Override
	public Task save(Task dto) {
		Jpa.getManager().persist(dto);
		return dto;
	}

	@Override
	public Task update(Task dto) {
		Jpa.getManager().merge(dto);
		return dto;
	}

	@Override
	public Task delete(Long id){
		EntityManager em = Jpa.getManager();
		Task task = em.find(Task.class, id);
		if(task != null)
			Jpa.getManager().remove(task);
		return task;
	}

	@Override
	public Task findById(Long id) {
		return Jpa.getManager().find(Task.class, id);
	}

	@Override
	public List<Task> findAll() {
		return Jpa.getManager()
				.createNamedQuery("TaskFindAll", Task.class)
				.getResultList();
	}

	@Override
	public int deleteAllFromUserId(Long userId) {
		return Jpa
				.getManager()
				.createNamedQuery("Task.deleteByUserId")
				.setParameter(1, userId)
				.executeUpdate();
	}

	@Override
	public int deleteAllFromCategory(Long catId) {
		return Jpa
				.getManager()
				.createNamedQuery("Task.deleteById")
				.setParameter(1, catId)
				.executeUpdate();
	}

	@Override
	public List<Task> findByUserId(Long userId) {
		return Jpa
				.getManager()
				.createNamedQuery("Task.findUserById",
						Task.class)
				.setParameter(1, userId)
				.getResultList();
	}

	@Override
	public List<Task> findInboxTasksByUserId(Long userId) {
		return Jpa
				.getManager()
				.createNamedQuery("Task.findInboxByUserId",
						Task.class)
				.setParameter(1, userId)
				.getResultList();
	}

	@Override
	public List<Task> findTodayTasksByUserId(Long userId) {
		return Jpa
				.getManager()
				.createNamedQuery("Task.findTodayByUserId",
						Task.class)
				.setParameter(1, userId)
				.getResultList();
	}

	@Override
	public List<Task> findWeekTasksByUserId(Long userId) {
		return Jpa
				.getManager()
				.createNamedQuery("Task.findWeekByUserId",
						Task.class)
				.setParameter(1, userId)
				.getResultList();
	}

	@Override
	public List<Task> findTasksByCategoryId(Long catId) {
		return Jpa
				.getManager()
				.createNamedQuery(
						"Task.findUnfinishedByCategoryId",
						Task.class)
				.setParameter(1, catId)
				.getResultList();
	}

	@Override
	public List<Task> findFinishedTasksByCategoryId(Long catId) {
		return Jpa
				.getManager()
				.createNamedQuery(
						"Task.findByCategoryId",
						Task.class)
				.setParameter(1, catId)
				.getResultList();
	}

	@Override
	public List<Task> findFinishedTasksInboxByUserId(Long userId) {
		return Jpa
				.getManager()
				.createNamedQuery(
						"Task.findFinishedInboxByUserId",
						Task.class)
				.setParameter(1, userId)
				.getResultList();

	}

	@Override
	public void deleteAll() {
		Jpa.getManager()
				.createNamedQuery("Task.deleteAll")
				.executeUpdate();
	}


}
