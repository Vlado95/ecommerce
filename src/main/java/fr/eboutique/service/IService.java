package fr.eboutique.service;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;


public interface IService<T> {

	public T rechercherParId(int id);

	public List<T> findAll();

	public List<T> chercherParString(String str);

	public T ajouter(T objet);

	public void maj(T objet);

	public void supprimer(int id);

}
