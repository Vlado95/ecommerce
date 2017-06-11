package fr.eboutique.service;

import fr.eboutique.dao.IDao;
import fr.eboutique.metier.Client;

public interface IDaoClient extends IDao<Client>{
	
	public Client findByEmailPdw(String email, String pdw);
	

}
