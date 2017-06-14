package fr.eboutique.service;

import java.util.List;

import fr.eboutique.metier.Client;
import fr.eboutique.metier.Commande;
import fr.eboutique.metier.LigneCommande;

public interface IServiceCommande extends IService<Commande> {
	
	public List<Commande> rechercheCommandaClient(Integer idt);

}
