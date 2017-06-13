package fr.eboutique.dao;

import fr.eboutique.metier.Client;

public interface IDaoClient extends IDao<Client>{
	
	public Client findByEmailPdw(String email, String pdw);
	

}
