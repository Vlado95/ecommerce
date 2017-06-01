package com.boutique.service;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.boutique.entity.Produit;


public interface IService<T extends Produit> {
	
	
	public T rechercherParId(int id);
	
	public List<T> findAll();
	
	public List<T> chercherParString(String str);
	
	
    public T ajouter(T objet);
    
    public void maj(T objet);
    
    public  void  supprimer(int id);
	
	

}
