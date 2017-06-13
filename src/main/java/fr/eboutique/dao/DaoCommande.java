package fr.eboutique.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;


import fr.eboutique.metier.Commande;
import fr.eboutique.metier.LigneCommande;



@Component
@Transactional
public class DaoCommande implements IDaoCommande {

	@PersistenceContext(unitName = "myPersistenceUnit")
	private EntityManager entityManager;
	
	@Override
	public Commande selectById(int id) {
		return entityManager.find(Commande.class,id);
	}

	@Override
	public List<Commande> selectAll() {
		return entityManager.createNamedQuery("Commande.all", Commande.class).getResultList();
	}

	@Override
	public List<Commande> searchLike(String str) {
		return entityManager.createNamedQuery("Commande.search", Commande.class).setParameter(1, "%" + str + "%")
				.getResultList();
	}

	@Override
	public Commande insert(Commande commande) {
		System.out.println("persistance commande par ws");
		List<LigneCommande> lcmd2 =  commande.getLigneCommandes();
		   for(LigneCommande lcmd :  lcmd2){
			   System.out.println("ligne commande à ajouter: "+lcmd);
		   }
//		
//		List<LigneCommande> lcmd2 = new ArrayList<LigneCommande>();
//		   for(LigneCommande lcmd : commande.getLigneCommandes()){
//			   entityManager.merge(lcmd);
//			   lcmd2.add(lcmd);
//			   System.out.println();
//		   }
//		   for(LigneCommande lcmd : lcmd2){
//			   System.out.println("ligne commande à ajouter: "+lcmd);
//		   }
			
		   entityManager.persist(commande);
		   
		   for(LigneCommande lcmd : lcmd2){
			   lcmd.setCommande(commande);
			   entityManager.persist(lcmd);
			   //lcmd2.add(lcmd);
		   }
		   
	
			return commande;
	}

	

	

	@Override
	public void update(Commande a) {
		entityManager.merge(a);
		
	}

	@Override
	public void delete(int id) {
		Commande a = entityManager.find(Commande.class, id);
		entityManager.remove(a);
		
	}
	
	@Override
	public Commande enregistrerCommande(Commande commande, List<LigneCommande> lcmds) {
		List<LigneCommande> lcmd2 = new ArrayList<LigneCommande>();
		   for(LigneCommande lcmd : lcmds){
			   entityManager.merge(lcmd);
			   lcmd2.add(lcmd);
			   System.out.println();
		   }
		   for(LigneCommande lcmd : lcmd2){
			   System.out.println("ligne commande à ajouter: "+lcmd);
		   }
			
		   commande.setLigneCommandes(lcmd2);
		   entityManager.merge(commande);
			return commande;
	}

}