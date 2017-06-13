package fr.eboutique.rest;

import java.util.List;

import fr.eboutique.metier.Commande;
import fr.eboutique.metier.LigneCommande;
import javax.ws.rs.core.Response;

public interface IServiceCommandeRest extends IServiceRest<Commande> {
	
	public Response enregistrerCommande(Commande commande, List<LigneCommande> lcmds);

}
