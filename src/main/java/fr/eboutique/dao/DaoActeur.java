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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Acteur> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Acteur> searchLike(String str) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Acteur insert(Acteur objet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Acteur objet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
