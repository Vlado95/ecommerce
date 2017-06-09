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

import fr.eboutique.metier.LigneCommande;
import fr.eboutique.service.IService;

@Path("/ligneCommandes")
@Produces("application/json")
@Consumes("application/json")
@CrossOriginResourceSharing(allowAllOrigins=true)
@Component
public class ServiceLigneCommandeRest implements IServiceRest<LigneCommande>{


	@Autowired
	private IService<LigneCommande> serviceLigneCommande;

	@Override
	@GET
	@Path("/{id}")
	public LigneCommande rechercher(@PathParam("id") int id) {
		return serviceLigneCommande.rechercherParId(id);
	}

	@Override
	@GET
	@Path("/all")
	public List<LigneCommande> getAll() {
		return serviceLigneCommande.findAll();
	}

	@Override
	@GET
	@Path("/litlelike/{str}")
	public List<LigneCommande> getAll(@PathParam("str") String str) {
		return serviceLigneCommande.chercherParString(str);
	}
	@Override
	@POST
	@Path("/")
	public Response ajouter(LigneCommande ligneCommande) {
		try {
			serviceLigneCommande.ajouter(ligneCommande);
			return Response.status(Status.OK).entity(ligneCommande)
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
			serviceLigneCommande.supprimer(id);
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
	public Response maj(@PathParam("id") int id, LigneCommande ligneCommande) {
		try {
			serviceLigneCommande.maj(ligneCommande);;
			return Response.status(Status.OK).entity(ligneCommande).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.status(Status.NOT_FOUND).build();
		}
	}
}
