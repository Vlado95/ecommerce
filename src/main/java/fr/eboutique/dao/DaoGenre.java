package fr.eboutique.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import fr.eboutique.metier.Genre;

@Component
@Transactional
public class DaoGenre implements IDao<Genre> {

	@PersistenceContext(unitName = "myPersistenceUnit")
	private EntityManager entityManager;

	@Override
	public Genre selectById(int id) {
		return entityManager.find(Genre.class, id);
	}

	@Override
	public List<Genre> selectAll() {
		/*
		 * return entityManager.createQuery("SELECT a FROM Genre a",
		 * Genre.class).getResultList();
		 */
		return entityManager.createNamedQuery("genre.all", Genre.class).getResultList();
	}

	@Override
	public List<Genre> searchLike(String str) {
		return entityManager.createNamedQuery("genre.search", Genre.class).setParameter(1, "%" + str + "%")
				.getResultList();
	}

	@Override
	public Genre insert(Genre g) {
		entityManager.persist(g);
		// la clef primaire auto incr?ment? par mysql
		// remonte dans l'objet java lors du .persist()
		// grace ? @GeneratedValue() sur l'id de l'Genre
		return g;
	}

	@Override
	public void update(Genre g) {
		// entityManager.getTransaction().begin() effectu? via @Transactional
		entityManager.merge(g);
		// entityManager.getTransaction().commit() effectu? via @Transactional
	}

	@Override
	public void delete(int id) {
		Genre g = entityManager.find(Genre.class, id);
		entityManager.remove(g);

	}

}
