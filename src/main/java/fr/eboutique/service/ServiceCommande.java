package fr.eboutique.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eboutique.dao.IDao;
import fr.eboutique.dao.IDaoCommande;
import fr.eboutique.metier.Client;
import fr.eboutique.metier.Commande;
import fr.eboutique.metier.LigneCommande;

@Service
public class ServiceCommande implements IServiceCommande{


	@Autowired
	private IDaoCommande daoCommande;

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

	@Override
	public List<Commande> rechercheCommandaClient(Integer idClient) {
		
		return daoCommande.rechercheCommandaClient(idClient);
	}

	

}
