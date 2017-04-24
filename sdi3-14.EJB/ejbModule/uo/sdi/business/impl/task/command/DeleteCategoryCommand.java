package uo.sdi.business.impl.task.command;

import uo.sdi.business.exception.BusinessException;
import uo.sdi.infrastructure.Factories;

public class DeleteCategoryCommand{

	private Long catId;

	public DeleteCategoryCommand(Long catId) {
		this.catId = catId;
	}

	public Void execute() throws BusinessException {
		Factories.persistence.getTaskDao().deleteAllFromCategory( catId );
		Factories.persistence.getCategoryDao().delete( catId );
		return null;
	}

}
