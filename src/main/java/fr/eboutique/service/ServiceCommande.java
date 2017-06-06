package fr.eboutique.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eboutique.dao.IDao;
import fr.eboutique.metier.Commande;

@Service
public class ServiceCommande implements IService<Commande>{

	@Autowired
	private IDao<Commande> daoCommande;

	@Override
	public Commande rechercherParId(int id) {
		return daoCommande.selectById(id);
	}

	@Override
	public List<Commande> findAll() {
		return daoCommande.selectAll();
	}

	@Override
	public List<Commande> chercherParString(String str) {
		return daoCommande.searchLike(str);
	}

	@Override
	public Commande ajouter(Commande commande) {
		return daoCommande.insert(commande);
	}

	@Override
	public void maj(Commande commande) {
		daoCommande.update(commande);

	}

	@Override
	public void supprimer(int idCommande) {
		daoCommande.delete(idCommande);

	}

	

}
