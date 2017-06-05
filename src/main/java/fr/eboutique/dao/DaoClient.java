package fr.eboutique.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import fr.eboutique.metier.Client;

@Component
@Transactional
public class DaoClient implements IDao<Client> {

	@PersistenceContext(unitName = "myPersistenceUnit")
	private EntityManager entityManager;
	
	@Override
	public Client selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Client> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Client> searchLike(String str) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client insert(Client objet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Client objet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
