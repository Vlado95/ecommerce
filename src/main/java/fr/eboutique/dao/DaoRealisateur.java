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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Realisateur> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Realisateur> searchLike(String str) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Realisateur insert(Realisateur objet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Realisateur objet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
