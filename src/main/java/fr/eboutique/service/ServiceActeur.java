package fr.eboutique.service;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eboutique.dao.IDao;
import fr.eboutique.metier.Acteur;



@Service
public class ServiceActeur implements IService<Acteur> {

	@Autowired
	private IDao<Acteur> daoActeur;

	@Override
	public Acteur rechercherParId(int id) {
		return daoActeur.selectById(id);
	}

	@Override
	public List<Acteur> findAll() {
		return daoActeur.selectAll();
	}

	@Override
	public List<Acteur> chercherParString(String str) {
		return daoActeur.searchLike(str);
	}

	@Override
	public Acteur ajouter(Acteur acteur) {
		return daoActeur.insert(acteur);
	}

	@Override
	public void maj(Acteur acteur) {
		daoActeur.update(acteur);

	}

	@Override
	public void supprimer(int idActeur) {
		daoActeur.delete(idActeur);

	}

}
