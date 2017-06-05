package fr.eboutique.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eboutique.dao.IDao;
import fr.eboutique.metier.Genre;


@Service
public class ServiceGenre implements IService<Genre> {

	@Autowired
	private IDao<Genre> daoGenre;

	@Override
	public Genre rechercherParId(int id) {
		return daoGenre.selectById(id);
	}

	@Override
	public List<Genre> findAll() {
		return daoGenre.selectAll();
	}

	@Override
	public List<Genre> chercherParString(String str) {
		return daoGenre.searchLike(str);
	}

	@Override
	public Genre ajouter(Genre genre) {
		return daoGenre.insert(genre);
	}

	@Override
	public void maj(Genre genre) {
		daoGenre.update(genre);
	}

	@Override
	public void supprimer(int id) {
		daoGenre.delete(id);
	}

}
