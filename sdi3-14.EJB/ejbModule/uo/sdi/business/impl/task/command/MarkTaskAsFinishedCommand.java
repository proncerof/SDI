package uo.sdi.business.impl.task.command;

import uo.sdi.business.exception.BusinessCheck;
import uo.sdi.business.exception.BusinessException;
import uo.sdi.dto.Task;
import uo.sdi.infrastructure.Factories;
import uo.sdi.persistence.TaskDao;
import alb.util.date.DateUtil;

public class MarkTaskAsFinishedCommand{

	private Long id;

	public MarkTaskAsFinishedCommand(Long id) {
		this.id = id;
	}

	public Void execute() throws BusinessException {
		TaskDao tDao = Factories.persistence.getTaskDao();

		Task t = tDao.findById(id);
		BusinessCheck.isNotNull(t, "The task does not exist");

		t.setFinished(DateUtil.today());
		tDao.update(t);
		return null;
	}

}
