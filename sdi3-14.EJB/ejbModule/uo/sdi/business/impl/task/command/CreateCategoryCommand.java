package uo.sdi.business.impl.task.command;

import uo.sdi.business.exception.BusinessException;
import uo.sdi.business.impl.util.CategoryCheck;
import uo.sdi.dto.Category;
import uo.sdi.infrastructure.Factories;

public class CreateCategoryCommand{

	private Category category;

	public CreateCategoryCommand(Category category) {
		this.category = category;
	}

	public Category execute() throws BusinessException {
		CategoryCheck.nameIsNotNull(category);
		CategoryCheck.nameIsNotEmpty(category);
		CategoryCheck.userIsNotNull(category);
		CategoryCheck.isValidUser(category);
		CategoryCheck.isUniqueName(category);
		CategoryCheck.isNotForAdminUser(category);

		return Factories.persistence.getCategoryDao().save(category);
	}

}
