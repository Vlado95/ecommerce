package fr.eboutique.dao.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.eboutique.dao.IDao;
import fr.eboutique.metier.Acteur;
import fr.eboutique.metier.Film;
import fr.eboutique.metier.Genre;
import fr.eboutique.metier.Realisateur;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "/applicationContext.xml" })
@ContextConfiguration(locations = { "/jpaSpringConf.xml" })
public class DaoFilmTest {

	@Autowired
	IDao<Film> daoFilm;
	 
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSelectById() {
		Film film = daoFilm.selectById(1);
//		Assert.assertTrue(user.getId() == 1);
		System.out.println(film.toString());
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
//		Film film = new Film();
//		film.setDuree("1h53");
//		film.setFormat("blueRay");
//		Genre genre = new Genre();
//		genre.setId(1);
//		film.setGenre(genre);
//		film.setLangue("francais");
//		film.setTitre("Film3");
//		film.setOrigine("francaise");
//		film.setPrix(30.0);
//		film.setQuantite(20);
//		film.setPublics("adulte");
//		Realisateur realisateur = new Realisateur();
//		realisateur.setId(2);
//		List<Acteur> acteurs = new ArrayList<>();
//		Acteur a = new Acteur();
//		a.setId(3);
//		acteurs.add(a);
//		film.setRealisateur(realisateur);
//		film.setListActeurs(acteurs);
//		film.setResume("blalba");
//		daoFilm.insert(film);
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
