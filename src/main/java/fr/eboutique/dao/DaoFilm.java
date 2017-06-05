package fr.eboutique.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import fr.eboutique.metier.Film;
import fr.eboutique.metier.User;

@Component
@Transactional
public class DaoFilm implements IDao<Film> {

	@PersistenceContext(unitName = "myPersistenceUnit")
	private EntityManager entityManager;
	
	@Override
	public Film selectById(int id) {
		return entityManager.find(Film.class,id);
	}

	@Override
	public List<Film> selectAll() {
		return entityManager.createNamedQuery("film.all", Film.class).getResultList();
	}

	@Override
	public List<Film> searchLike(String str) {
		return entityManager.createNamedQuery("film.searchByTitre", Film.class).setParameter(1, "%" + str + "%")
				.getResultList();
	}

	@Override
	public Film insert(Film film) {
		entityManager.persist(film);
		return film;
	}

	@Override
	public void update(Film film) {
		entityManager.merge(film);
		
	}

	@Override
	public void delete(int id) {
		Film film =entityManager.find(Film.class, id);
		entityManager.remove(film);
		
	}

}
