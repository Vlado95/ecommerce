package fr.eboutique.rest;

import java.util.List;

import fr.eboutique.metier.Client;
import fr.eboutique.metier.Commande;
import fr.eboutique.metier.LigneCommande;
import javax.ws.rs.core.Response;

public interface IServiceCommandeRest extends IServiceRest<Commande> {
	
	public List<Commande> rechercheCommandeClient(Integer idClient);

}
