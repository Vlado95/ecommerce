package fr.eboutique.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eboutique.dao.IDao;
import fr.eboutique.metier.LigneCommande;
	
@Service
public class ServiceLigneCommande implements IService<LigneCommande>{

	@Autowired
	private IDao<LigneCommande> daoLigneCommande;

	@Override
	public LigneCommande rechercherParId(int id) {
		return daoLigneCommande.selectById(id);
	}

	@Override
	public List<LigneCommande> findAll() {
		return daoLigneCommande.selectAll();
	}

	@Override
	public List<LigneCommande> chercherParString(String str) {
		return daoLigneCommande.searchLike(str);
	}

	@Override
	public LigneCommande ajouter(LigneCommande lignecommande) {
		return daoLigneCommande.insert(lignecommande);
	}

	@Override
	public void maj(LigneCommande lignecommande) {
		daoLigneCommande.update(lignecommande);

	}

	@Override
	public void supprimer(int idLigneCommande) {
		daoLigneCommande.delete(idLigneCommande);

	}


}
