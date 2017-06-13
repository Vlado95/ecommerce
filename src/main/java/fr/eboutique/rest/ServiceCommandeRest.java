package fr.eboutique.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.eboutique.metier.Commande;
import fr.eboutique.metier.LigneCommande;
import fr.eboutique.service.IServiceCommande;

@Path("/commandes")
@Produces("application/json")
@Consumes("application/json")
@CrossOriginResourceSharing(allowAllOrigins=true)
@Component
public class ServiceCommandeRest implements IServiceCommandeRest{


	@Autowired
	private IServiceCommande serviceCommande;

	@Override
	@GET
	@Path("/{id}")
	public Commande rechercher(@PathParam("id") int id) {
		return serviceCommande.rechercherParId(id);
	}

	@Override
	@GET
	@Path("/all")
	public List<Commande> getAll() {
		return serviceCommande.findAll();
	}

	@Override
	@GET
	@Path("/litlelike/{str}")
	public List<Commande> getAll(@PathParam("str") String str) {
		return serviceCommande.chercherParString(str);
	}
	@Override
	@POST
	@Path("/")
	public Response ajouter(Commande commande) {
		try {
			for(LigneCommande lc : commande.getLigneCommandes()){
				System.out.println("commade"+lc );	
			}
			
			serviceCommande.ajouter(commande);
			return Response.status(Status.OK).entity(commande)
					.build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.status(Status.NOT_FOUND).build();
			// return Response.status(Status.BAD_REQUEST).build();
		}
	}

	@Override
	@DELETE
	@Path("/{id}")
	public Response supprimer(@PathParam("id") int id) {
		try {
			serviceCommande.supprimer(id);
			return Response.status(Status.OK).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.status(Status.NOT_FOUND).build();
		}
	}
	
	@Override
	@PUT
	@Path("/{id}")
	public Response maj(@PathParam("id") int id, Commande commande) {
		try {
			serviceCommande.maj(commande);;
			return Response.status(Status.OK).entity(commande).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.status(Status.NOT_FOUND).build();
		}
	}


	@Override
	@POST
	@Path("client/")
	public Response enregistrerCommande(Commande commande, List<LigneCommande> lcmds) {
		try {
			   for(LigneCommande lcmd : lcmds){
				   System.out.println("ligne commande à ajouter: "+lcmd);
			   }
			serviceCommande.enregistrerCommande(commande, lcmds);
			return Response.status(Status.OK).entity(commande)
					.build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.status(Status.NOT_FOUND).build();
			// return Response.status(Status.BAD_REQUEST).build();
		}
	}
}
