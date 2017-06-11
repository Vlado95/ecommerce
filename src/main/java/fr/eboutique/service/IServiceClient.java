package fr.eboutique.service;

import fr.eboutique.metier.Client;

public interface IServiceClient extends IService<Client> {

	public Client rechercherEmailMdp(String email, String mdp);
}
