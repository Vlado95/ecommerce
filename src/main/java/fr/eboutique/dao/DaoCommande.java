package fr.eboutique.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import fr.eboutique.metier.Commande;



@Component
@Transactional
public class DaoCommande implements IDao<Commande> {

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
	public Commande insert(Commande a) {
		entityManager.persist(a);
		return a;
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

}