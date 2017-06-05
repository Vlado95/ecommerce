package fr.eboutique.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import fr.eboutique.metier.Acteur;

@Component
@Transactional
public class DaoActeur implements IDao<Acteur> {

	@PersistenceContext(unitName = "myPersistenceUnit")
	private EntityManager entityManager;
	
	@Override
	public Acteur selectById(int id) {
		return entityManager.find(Acteur.class, id);
	}

	@Override
	public List<Acteur> selectAll() {
		/*
		 * return entityManager.createQuery("SELECT a FROM Acteur a",
		 * Acteur.class).getResultList();
		 */
		return entityManager.createNamedQuery("acteur.all", Acteur.class).getResultList();
	}

	@Override
	public List<Acteur> searchLike(String str) {
		return entityManager.createNamedQuery("acteur.search", Acteur.class).setParameter(1, "%" + str + "%")
				.getResultList();
	}

	@Override
	public Acteur insert(Acteur a) {
		entityManager.persist(a);
		// la clef primaire auto incr?ment? par mysql
		// remonte dans l'objet java lors du .persist()
		// grace ? @GeneratedValue() sur l'id de l'Acteur
		return a;
	}

	@Override
	public void update(Acteur a) {
		// entityManager.getTransaction().begin() effectu? via @Transactional
		entityManager.merge(a);
		// entityManager.getTransaction().commit() effectu? via @Transactional
	}

	@Override
	public void delete(int id) {
		Acteur a = entityManager.find(Acteur.class, id);
		entityManager.remove(a);

	}

}
