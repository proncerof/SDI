package uo.sdi.business.impl.util;

import uo.sdi.business.exception.BusinessCheck;
import uo.sdi.business.exception.BusinessException;
import uo.sdi.infrastructure.Factories;
import uo.sdi.model.Category;
import uo.sdi.model.User;
import uo.sdi.model.types.UserStatus;

public class CategoryCheck {

	public static void nameIsNotNull(Category category)
			throws BusinessException {
		BusinessCheck.isNotNull(category.getName(),
				"Category name cannot be null");
	}

	public static void nameIsNotEmpty(Category category)
			throws BusinessException {
		BusinessCheck.isFalse(category.getName().length() == 0,
				"Category name cannot be empty");
	}

	public static void userIsNotNull(Category category)
			throws BusinessException {
		BusinessCheck.isNotNull(category.getUser(),
				"A category must be assigned to a user");
	}

	public static void isValidUser(Category c) throws BusinessException {
		User u = Factories.persistence.getUserDao().findById(
				c.getUser().getId());

		BusinessCheck.isNotNull(u,
				"A category must be assigned to an existing user");

		BusinessCheck.isTrue(u.getStatus().equals(UserStatus.ENABLED),
				"A category must be assigned to an enabled user");
	}

	public static void isUniqueName(Category category) throws BusinessException {
		Category other = Factories.persistence.getCategoryDao()
				.findByUserIdAndName(category.getUser().getId(),
						category.getName());

		BusinessCheck.isNull(other,
				"The category name cannot be repeated for this user");
	}

	public static void isNotForAdminUser(Category category)
			throws BusinessException {
		User u = Factories.persistence.getUserDao().findById(
				category.getUser().getId());
		BusinessCheck
				.isFalse(u.getIsAdmin(), "An admin cannot have categories");
	}

}
