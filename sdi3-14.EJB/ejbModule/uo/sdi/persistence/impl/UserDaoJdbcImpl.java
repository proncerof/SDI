package uo.sdi.persistence.impl;

import java.util.List;

import javax.persistence.EntityManager;

import uo.sdi.dto.User;
import uo.sdi.persistence.UserDao;
import uo.sdi.persistence.util.Jpa;

public class UserDaoJdbcImpl implements UserDao {

	@Override
	public User save(User dto) {
		Jpa.getManager().persist(dto);
		return dto;
	}

	@Override
	public User update(User dto) {
		Jpa.getManager().persist(dto);
		return dto;
	}

	@Override
	public User delete(Long id) {
		EntityManager em = Jpa.getManager();
		User user = em.find(User.class, id);
		if (user != null)
			em.remove(user);
		return user;
	}

	@Override
	public void deleteAll() {
		Jpa.getManager().createQuery(Jpa.getSqlQuery("USER_DELETE_ALL"))
				.executeUpdate();
	}

	@Override
	public User findById(Long id) {
		return Jpa.getManager().find(User.class, id);
	}

	@Override
	public List<User> findAll() {
		return Jpa.getManager()
				.createQuery(Jpa.getSqlQuery("USER_FIND_ALL"), User.class)
				.getResultList();
	}

	@Override
	public User findByLogin(String login) {
		List<User> res = Jpa
				.getManager()
				.createQuery(Jpa.getSqlQuery("USER_FIND_BY_LOGIN"), User.class)
				.setParameter(1, login)
				.getResultList();
		
		return res.size() == 0
                ? null
                : res.get(0);
	}

	@Override
	public User findByLoginAndPassword(String login, String password) {
		List<User> res = Jpa
				.getManager()
				.createQuery(
						Jpa.getSqlQuery("USER_FIND_BY_LOGIN_AND_PASSWORD"),
						User.class)
				.setParameter(1, login)
				.setParameter(2, password)
				.getResultList();
		
		return res.size() == 0
                ? null
                : res.get(0);
	}

}
