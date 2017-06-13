package fr.eboutique.dao;

import java.util.List;

import fr.eboutique.metier.Client;
import fr.eboutique.metier.Commande;
import fr.eboutique.metier.LigneCommande;

public interface IDaoCommande extends IDao<Commande> {
	
	
	public Commande enregistrerCommande(Commande commande,List<LigneCommande> lcmds);

}
