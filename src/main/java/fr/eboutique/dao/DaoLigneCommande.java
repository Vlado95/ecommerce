package fr.eboutique.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import fr.eboutique.metier.LigneCommande;

@Component
@Transactional
public class DaoLigneCommande implements IDao<LigneCommande> {

	@PersistenceContext(unitName = "myPersistenceUnit")
	private EntityManager entityManager;
	
	@Override
	public LigneCommande selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LigneCommande> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LigneCommande> searchLike(String str) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LigneCommande insert(LigneCommande objet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(LigneCommande objet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	
}
