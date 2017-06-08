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

import fr.eboutique.metier.Acteur;
import fr.eboutique.service.IService;

@Path("/acteurs")
@Produces("application/json")
@Consumes("application/json")
@CrossOriginResourceSharing(allowAllOrigins=true)
@Component
public class ServiceActeurRest implements IServiceRest<Acteur> {


	@Autowired
	private IService<Acteur> serviceActeur;

	@Override
	@GET
	@Path("/{id}")
	public Acteur rechercher(@PathParam("id") int id) {
		return serviceActeur.rechercherParId(id);
	}

	@Override
	@GET
	@Path("/all")
	public List<Acteur> getAll() {
		return serviceActeur.findAll();
	}

	@Override
	@GET
	@Path("/litlelike/{str}")
	public List<Acteur> getAll(@PathParam("str") String str) {
		return serviceActeur.chercherParString(str);
	}
	@Override
	@POST
	@Path("/")
	public Response ajouter(Acteur acteur) {
		try {
			serviceActeur.ajouter(acteur);
			return Response.status(Status.OK).entity(acteur)
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
			serviceActeur.supprimer(id);
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
	public Response maj(@PathParam("id") int id, Acteur acteur) {
		try {
			serviceActeur.maj(acteur);;
			return Response.status(Status.OK).entity(acteur).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.status(Status.NOT_FOUND).build();
		}
	}
}
