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

import fr.eboutique.metier.Film;
import fr.eboutique.service.IService;



@Path("/films")
@Produces("application/json")
@Consumes("application/json")
@CrossOriginResourceSharing(allowAllOrigins=true)
@Component // ou @Service (info :herite de component) : pour prise en charge
			// Spring
public class ServiceFilmRest implements IServiceRest<Film> {

	@Autowired
	private IService<Film> serviceFilm;
	// service interne ou private IDaoteur daoFilm; // dao interne

	@Override
	@GET
	@Path("/{id}")
	public Film rechercher(@PathParam("id") int id) {
		return serviceFilm.rechercherParId(id);
	}

	@Override
	@GET
	@Path("/all")
	public List<Film> getAll() {
		return serviceFilm.findAll();
	}

	@Override
	@GET
	@Path("/litlelike/{str}")
	public List<Film> getAll(@PathParam("str") String str) {
		return serviceFilm.chercherParString(str);
	}
	@Override
	@POST
	@Path("/")
	public Response ajouter(Film film) {
		try {
			serviceFilm.ajouter(film);
			return Response.status(Status.OK).entity(film)
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
			serviceFilm.supprimer(id);
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
	public Response maj(@PathParam("id") int id, Film film) {
		try {
			serviceFilm.maj(film);;
			return Response.status(Status.OK).entity(film).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.status(Status.NOT_FOUND).build();
		}
	}

}
