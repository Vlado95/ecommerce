package fr.eboutique.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eboutique.dao.IDao;
import fr.eboutique.metier.Film;



@Service
public class ServiceFilm implements IService<Film> {

	@Autowired
	private IDao<Film> daoFilm;

	@Override
	public Film rechercherParId(int id) {
		return daoFilm.selectById(id);
	}

	@Override
	public List<Film> findAll() {
		return daoFilm.selectAll();
	}

	@Override
	public List<Film> chercherParString(String str) {
		return daoFilm.searchLike(str);
	}

	@Override
	public Film ajouter(Film film) {
		return daoFilm.insert(film);
	}

	@Override
	public void maj(Film film) {
		daoFilm.update(film);

	}

	@Override
	public void supprimer(int id) {
		daoFilm.delete(id);

	}

}
