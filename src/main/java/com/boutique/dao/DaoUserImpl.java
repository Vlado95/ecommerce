package com.boutique.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.boutique.admin.entity.User;

@Component // ou bien @repository
@Transactional // version spring
public class DaoUserImpl implements IDaoUser {

	@PersistenceContext(unitName = "myPersistenceUnit")

	private EntityManager entityManager;

	@Override
	public User selectById(int id) {
		return entityManager.find(User.class, id);
	}

	@Override
	public User findByEmailPdw(String email, String pdw) {
		return entityManager.createNamedQuery("user.byEmailPwd", User.class).setParameter(1, email).setParameter(2, pdw)
				.getSingleResult();
	}

	@Override
	public List<User> selectAll() {
		/*
		 * return entityManager.createQuery("SELECT a FROM User a",
		 * User.class).getResultList();
		 */
		return entityManager.createNamedQuery("user.all", User.class).getResultList();
	}

	@Override
	public List<User> searchLike(String str) {
		return entityManager.createNamedQuery("user.search", User.class).setParameter(1, "%" + str + "%")
				.getResultList();
	}

	@Override
	public User insert(User a) {
		entityManager.persist(a);
		// la clef primaire auto incr?ment? par mysql
		// remonte dans l'objet java lors du .persist()
		// grace ? @GeneratedValue() sur l'id de l'User
		return a;
	}

	@Override
	public void update(User a) {
		// entityManager.getTransaction().begin() effectu? via @Transactional
		entityManager.merge(a);
		// entityManager.getTransaction().commit() effectu? via @Transactional
	}

	@Override
	public void delete(int id) {
		User a = entityManager.find(User.class, id);
		entityManager.remove(a);

	}

}
