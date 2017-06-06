package fr.eboutique.dao.test;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.eboutique.dao.IDao;
import fr.eboutique.metier.Client;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "/applicationContext.xml" })
@ContextConfiguration(locations = { "/jpaSpringConf.xml" })
public class DaoClientTest {

	@Autowired
	IDao<Client> daoClient;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSelectById() {
		Client client = daoClient.selectById(1);
		System.out.println(client.toString());
	}

	@Test
	public void testSelectAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testSearchLike() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsert() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

}
