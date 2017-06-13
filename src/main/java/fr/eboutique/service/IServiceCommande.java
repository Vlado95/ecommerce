package fr.eboutique.service;

import java.util.List;

import fr.eboutique.metier.Commande;
import fr.eboutique.metier.LigneCommande;

public interface IServiceCommande extends IService<Commande> {
	
	public Commande enregistrerCommande(Commande commande,List<LigneCommande> lcmds);

}
