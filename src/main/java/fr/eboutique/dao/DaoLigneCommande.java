package fr.eboutique.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import fr.eboutique.metier.Client;
import fr.eboutique.metier.Commande;
import fr.eboutique.metier.Film;
import fr.eboutique.metier.LigneCommande;

@Component
@Transactional
public class DaoLigneCommande implements IDao<LigneCommande> {

	@PersistenceContext(unitName = "myPersistenceUnit")
	private EntityManager entityManager;
	
	@Override
	public LigneCommande selectById(int id) {
		return entityManager.find(LigneCommande.class,id);
	}

	@Override
	public List<LigneCommande> selectAll() {
		return entityManager.createNamedQuery("ligneCommande.all", LigneCommande.class).getResultList();
	}

	@Override
	public List<LigneCommande> searchLike(String str) {
		return null;
	}

	@Override
	public LigneCommande insert(LigneCommande lc) {
		
		  Commande cmd = lc.getCommande();
		   entityManager.merge(cmd );
		   
		   lc.setCommande(cmd);
		   entityManager.persist(lc);
		  
		return lc;
	}

	@Override
	public void update(LigneCommande lc) {
		entityManager.merge(lc);
		
	}

	@Override
	public void delete(int id) {
		LigneCommande lc = entityManager.find(LigneCommande.class, id);
		entityManager.remove(lc);
		
	}

	
}
