package fr.eboutique.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import fr.eboutique.metier.Realisateur;

@Component
@Transactional
public class DaoRealisateur implements IDao<Realisateur> {

	@PersistenceContext(unitName = "myPersistenceUnit")
	private EntityManager entityManager;
	
	@Override
	public Realisateur selectById(int id) {
		return entityManager.find(Realisateur.class, id);
	}

	@Override
	public List<Realisateur> selectAll() {
		/*
		 * return entityManager.createQuery("SELECT a FROM Realisateur a",
		 * Realisateur.class).getResultList();
		 */
		return entityManager.createNamedQuery("realisateur.all", Realisateur.class).getResultList();
	}

	@Override
	public List<Realisateur> searchLike(String str) {
		return entityManager.createNamedQuery("realisateur.search", Realisateur.class).setParameter(1, "%" + str + "%")
				.getResultList();
	}

	@Override
	public Realisateur insert(Realisateur r) {
		entityManager.persist(r);
		// la clef primaire auto incr?ment? par mysql
		// remonte dans l'objet java lors du .persist()
		// grace ? @GeneratedValue() sur l'id de l'Realisateur
		return r;
	}

	@Override
	public void update(Realisateur r) {
		// entityManager.getTransaction().begin() effectu? via @Transactional
		entityManager.merge(r);
		// entityManager.getTransaction().commit() effectu? via @Transactional
	}

	@Override
	public void delete(int id) {
		Realisateur r = entityManager.find(Realisateur.class, id);
		entityManager.remove(r);

	}


}
