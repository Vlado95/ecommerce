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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Genre> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Genre> searchLike(String str) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Genre insert(Genre objet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Genre objet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	
}
