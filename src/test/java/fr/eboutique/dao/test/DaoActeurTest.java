package fr.eboutique.dao.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.eboutique.dao.IDao;
import fr.eboutique.metier.Acteur;
import fr.eboutique.metier.Film;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "/applicationContext.xml" })
@ContextConfiguration(locations = { "/jpaSpringConf.xml" })
public class DaoActeurTest {

	@Autowired
	IDao<Acteur> daoActeur;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSelectById() {
		Acteur acteur = daoActeur.selectById(1);
//		Assert.assertTrue(user.getId() == 1);
		System.out.println(acteur.toString());
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
