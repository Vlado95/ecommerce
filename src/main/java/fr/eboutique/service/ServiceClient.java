package fr.eboutique.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eboutique.dao.IDaoClient;
import fr.eboutique.metier.Client;

@Service
public class ServiceClient implements IServiceClient{

	@Autowired
	private IDaoClient daoClient;

	@Override
	public Client rechercherParId(int id) {
		return daoClient.selectById(id);
	}
	
	@Override
	public Client rechercherEmailMdp(String email, String mdp) {
		return daoClient.findByEmailPdw(email, mdp);
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
