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

import fr.eboutique.metier.Client;
import fr.eboutique.service.IService;

@Path("/clients")
@Produces("application/json")
@Consumes("application/json")
@CrossOriginResourceSharing(allowAllOrigins=true)
@Component
public class ServiceClientRest implements IServiceRest<Client>{



	@Autowired
	private IService<Client> serviceClient;

	@Override
	@GET
	@Path("/{id}")
	public Client rechercher(@PathParam("id") int id) {
		return serviceClient.rechercherParId(id);
	}

	@Override
	@GET
	@Path("/all")
	public List<Client> getAll() {
		return serviceClient.findAll();
	}

	@Override
	@GET
	@Path("/litlelike/{str}")
	public List<Client> getAll(@PathParam("str") String str) {
		return serviceClient.chercherParString(str);
	}
	@Override
	@POST
	@Path("/")
	public Response ajouter(Client client) {
		try {
			serviceClient.ajouter(client);
			return Response.status(Status.OK).entity(client)
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
			serviceClient.supprimer(id);
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
	public Response maj(@PathParam("id") int id, Client client) {
		try {
			serviceClient.maj(client);;
			return Response.status(Status.OK).entity(client).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.status(Status.NOT_FOUND).build();
		}
	}
}
