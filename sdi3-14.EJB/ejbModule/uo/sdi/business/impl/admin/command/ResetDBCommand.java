package uo.sdi.business.impl.admin.command;

import uo.sdi.business.exception.BusinessException;
import uo.sdi.business.impl.command.Command;
import uo.sdi.dto.Category;
import uo.sdi.dto.Task;
import uo.sdi.dto.User;
import uo.sdi.dto.types.UserStatus;
import uo.sdi.persistence.CategoryDao;
import uo.sdi.persistence.Persistence;
import uo.sdi.persistence.TaskDao;
import uo.sdi.persistence.UserDao;
import alb.util.date.DateUtil;

public class ResetDBCommand implements Command<Void> {

	@Override
	public Void execute() throws BusinessException {
		UserDao uDao = Persistence.getUserDao();
		CategoryDao cDao = Persistence.getCategoryDao();
		TaskDao tDao = Persistence.getTaskDao();
		
		tDao.deleteAll();
		cDao.deleteAll();
		uDao.deleteAll();

		for (int i = 1; i < 4; i++) {
			User u = generateUser(i);
			long userID = uDao.save(u);

			for (int j = 1; j < 4; j++) {
				Category c = new Category();
				c.setName(String.format("categoria%d user%d", j, i));
				c.setUserId(userID);
				
				long categoryID = cDao.save(c);

				// 10 tareas para el día que se ejecuta la tarea - (sin
				// categorizar) y otras 10 retrasadas respecto al día que
				// ejecute la prueba y pertenecientes a
				// las categorías 1 (3 tareas), 2 (3 tareas) y 3 (4 tareas).
				int numberOfTasks = j == 3 ? 4 : 3;
				for (int k = 1; k <= numberOfTasks; k++) {
					Task t = new Task();
					t.setTitle(String.format("cat%d tarea%02d", j, k));
					t.setCategoryId(categoryID);
					t.setCreated(DateUtil.today());
					t.setUserId(userID);
					t.setPlanned(DateUtil.addDays(DateUtil.today(), -5));
					tDao.save(t);
				}
			}

			// 10 tareas previstas para los siguientes 6 días a hoy (sin
			// categorizar)
			for (int k = 1; k < 11; k++) {
				Task t = new Task();
				t.setTitle(String.format("user%d tarea%02d futuras", i, k));
				t.setCreated(DateUtil.today());
				t.setUserId(userID);
				t.setPlanned(DateUtil.addDays(DateUtil.tomorrow(), k % 6));
				tDao.save(t);
			}

			// 10 tareas para el día que se ejecuta la tarea - (sin
			// categorizar)
			for (int k = 1; k < 11; k++) {
				Task t = new Task();
				t.setTitle(String.format("user%d tarea%02d hoy", i, k));
				t.setCreated(DateUtil.today());
				t.setUserId(userID);
				t.setPlanned(DateUtil.today());
				tDao.save(t);
			}

		}
		
		User admin1 = new User();
		
		admin1.setIsAdmin(true);
		
		admin1.setLogin("admin1");
		admin1.setPassword("admin1");
		admin1.setEmail("admin1@uniovi.es");
		admin1.setStatus(UserStatus.ENABLED);
		uDao.save(admin1);
		
		return null;
	}

	private User generateUser(int userNumber) {
		User u = new User();
		u.setLogin(String.format("user%d", userNumber));
		u.setPassword(String.format("user%d", userNumber));
		u.setEmail(String.format("user%d@uniovi.es", userNumber));
		u.setIsAdmin(false);
		u.setStatus(UserStatus.ENABLED);
		return u;
	}

}
