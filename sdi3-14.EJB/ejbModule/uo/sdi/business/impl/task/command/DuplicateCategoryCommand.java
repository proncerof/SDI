package uo.sdi.business.impl.task.command;

import java.util.List;

import uo.sdi.business.exception.BusinessCheck;
import uo.sdi.business.exception.BusinessException;
import uo.sdi.infrastructure.Factories;
import uo.sdi.model.Category;
import uo.sdi.model.Task;
import uo.sdi.model.util.Cloner;
import uo.sdi.persistence.CategoryDao;
import uo.sdi.persistence.TaskDao;

public class DuplicateCategoryCommand{

	private Long origId;

	public DuplicateCategoryCommand(Long id) {
		this.origId = id;
	}

	public Category execute() throws BusinessException {
		Category copyId = duplicateCategory( origId );
		duplicateTasks( origId, copyId );
		
		return copyId;
	}

	private Category duplicateCategory(Long id) throws BusinessException {
		CategoryDao cDao = Factories.persistence.getCategoryDao();
		
		Category original = cDao.findById(id);
		BusinessCheck.isNotNull( original, "The category does not exist");
		checkUserNotDisabled( original );
		
		Category copy = Cloner.clone(original);
		copy.setName( copy.getName() + " - copy");
		return cDao.save( copy );
	}

	private void checkUserNotDisabled(Category c) throws BusinessException {
		//User u = Factories.persistence.getUserDao().findById( c.getUserId() );
		//BusinessCheck.isTrue( u.getStatus().equals( UserStatus.ENABLED ),
		//		"User disables, category cannot be duplicated.");
	}

	private void duplicateTasks(Long catId, Category copyCat) {
		TaskDao tDao = Factories.persistence.getTaskDao();

		List<Task> tasks = tDao.findTasksByCategoryId( catId );
		for(Task t: tasks) {
			Task copy = Cloner.clone(t);
			copy.setCategory( copyCat );
			tDao.save( copy );
		}
	}

}
