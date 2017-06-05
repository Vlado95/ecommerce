package com.boutique.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boutique.dao.IDao;
import com.boutique.entity.Livre;

import fr.eboutique.service.IService;

@Service
public class ServiceLivreImpl implements IService<Livre> {

	@Autowired
	private IDao<Livre> daoLivre;

	@Override
	public Livre rechercherParId(int id) {
		return daoLivre.selectById(id);
	}

	@Override
	public List<Livre> findAll() {
		return daoLivre.selectAll();
	}

	@Override
	public List<Livre> chercherParString(String str) {
		return daoLivre.searchLike(str);
	}

	@Override
	public Livre ajouter(Livre livre) {
		return daoLivre.insert(livre);
	}

	@Override
	public void maj(Livre livre) {
		daoLivre.update(livre);

	}

	@Override
	public void supprimer(int id) {
		daoLivre.delete(id);

	}

}
