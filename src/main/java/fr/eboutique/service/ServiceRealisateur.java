package fr.eboutique.service;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eboutique.dao.IDao;
import fr.eboutique.metier.Realisateur;

@Service
public class ServiceRealisateur implements IService<Realisateur> {

	@Autowired
	private IDao<Realisateur> daoRealisateur;

	@Override
	public Realisateur rechercherParId(int id) {
		return daoRealisateur.selectById(id);
	}

	@Override
	public List<Realisateur> findAll() {
		return daoRealisateur.selectAll();
	}

	@Override
	public List<Realisateur> chercherParString(String str) {
		return daoRealisateur.searchLike(str);
	}

	@Override
	public Realisateur ajouter(Realisateur realisateur) {
		return daoRealisateur.insert(realisateur);
	}

	@Override
	public void maj(Realisateur realisateur) {
		daoRealisateur.update(realisateur);

	}

	@Override
	public void supprimer(int idRealisateur) {
		daoRealisateur.delete(idRealisateur);

	}

}
