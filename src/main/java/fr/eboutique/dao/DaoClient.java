package fr.eboutique.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import fr.eboutique.metier.Acteur;
import fr.eboutique.metier.Client;
import fr.eboutique.service.IDaoClient;

@Component
@Transactional
public class DaoClient implements IDaoClient {

	@PersistenceContext(unitName = "myPersistenceUnit")
	private EntityManager entityManager;
	
	@Override
	public Client selectById(int id) {
		return entityManager.find(Client.class, id);
	}

	@Override
	public Client findByEmailPdw(String email, String pdw) {
		return entityManager.createNamedQuery("client.byEmailPwd", Client.class).setParameter(1, email).setParameter(2, pdw)
				.getSingleResult();
	}
	
	@Override
	public List<Client> selectAll() {
		return entityManager.createNamedQuery("client.all", Client.class).getResultList();
	}

	@Override
	public List<Client> searchLike(String str) {
		return entityManager.createNamedQuery("client.search", Client.class).setParameter(1, "%" + str + "%")
				.getResultList();
	}

	@Override
	public Client insert(Client a) {
		entityManager.merge(a);
		return a;
	}

	@Override
	public void update(Client a) {
		entityManager.merge(a);
		
	}

	@Override
	public void delete(int id) {
		Client a = entityManager.find(Client.class, id);
		entityManager.remove(a);

		
	}


}
