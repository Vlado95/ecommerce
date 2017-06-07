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

import fr.eboutique.metier.Genre;
import fr.eboutique.service.IService;

@Path("/Genres")
@Produces("application/json")
@Consumes("application/json")
@CrossOriginResourceSharing(allowAllOrigins=true)
@Component
public class ServiceGenreRest implements IServiceRest<Genre> {

	
	@Autowired
	private IService<Genre> serviceGenre;
	// service interne ou private IDaoteur daoGenre; // dao interne

	@Override
	@GET
	@Path("/{id}")
	public Genre rechercher(@PathParam("id") int id) {
		return serviceGenre.rechercherParId(id);
	}

	@Override
	@GET
	@Path("/all")
	public List<Genre> getAll() {
		return serviceGenre.findAll();
	}

	@Override
	@GET
	@Path("/litlelike/{str}")
	public List<Genre> getAll(@PathParam("str") String str) {
		return serviceGenre.chercherParString(str);
	}
	@Override
	@POST
	@Path("/")
	public Response ajouter(Genre Genre) {
		try {
			serviceGenre.ajouter(Genre);
			return Response.status(Status.OK).entity(Genre)
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
			serviceGenre.supprimer(id);
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
	public Response maj(@PathParam("id") int id, Genre Genre) {
		try {
			serviceGenre.maj(Genre);;
			return Response.status(Status.OK).entity(Genre).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.status(Status.NOT_FOUND).build();
		}
	}
}
