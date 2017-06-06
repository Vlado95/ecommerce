package fr.eboutique.rest;

import java.util.List;

import javax.ws.rs.core.Response;

public interface IServiceRest<T> {
	
	public T rechercher(int id);
	
	public List<T> getAll();

	public List<T> getAll(String str);

	public Response ajouter(T objet);

	public Response supprimer(int id);
	
	public Response maj(int id, T objet);
}
