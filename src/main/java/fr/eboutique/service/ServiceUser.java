package fr.eboutique.service;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eboutique.dao.IDao;
import fr.eboutique.metier.User;



@Service
public class ServiceUser implements IService<User> {

	@Autowired
	private IDao<User> daoUser;

	@Override
	public User rechercherParId(int id) {
		return daoUser.selectById(id);
	}

	@Override
	public List<User> findAll() {
		return daoUser.selectAll();
	}

	@Override
	public List<User> chercherParString(String str) {
		return daoUser.searchLike(str);
	}

	@Override
	public User ajouter(User user) {
		return daoUser.insert(user);
	}

	@Override
	public void maj(User user) {
		daoUser.update(user);

	}

	@Override
	public void supprimer(int idUser) {
		daoUser.delete(idUser);

	}

}
