package fr.eboutique.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.eboutique.dao.IDao;
import fr.eboutique.metier.Client;

public class ServiceClient implements IService<Client>{

	@Autowired
	private IDao<Client> daoClient;

	@Override
	public Client rechercherParId(int id) {
		return daoClient.selectById(id);
	}

	@Override
	public List<Client> findAll() {
		return daoClient.selectAll();
	}

	@Override
	public List<Client> chercherParString(String str) {
		return daoClient.searchLike(str);
	}

	@Override
	public Client ajouter(Client client) {
		return daoClient.insert(client);
	}

	@Override
	public void maj(Client client) {
		daoClient.update(client);

	}

	@Override
	public void supprimer(int idClient) {
		daoClient.delete(idClient);

	}

	

}
