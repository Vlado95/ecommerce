package fr.eboutique.service.test;

import org.junit.Test;
import fr.eboutique.metier.Acteur;
import fr.eboutique.service.IServiceActeur;

import java.util.List;

import org.junit.Assert;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class) 
//@ContextConfiguration(locations={"/applicationContext.xml"}) 
@ContextConfiguration(locations={"/jpaSpringConf.xml"}) 
public class ServiceActeurTest {
	
	@Autowired
	private IServiceActeur serviceActeur; //Ã  tester
	
	/*
	@Before ou @BeforeClass
	public void init(){
	   SpringContext ctx= new ClassPathXmlApplicationContext("/applicationContext.xml");
	   serviceAuteur = ctx.getBean(IServiceAueur.class);	
	}*/
	
	@Test
	public void testRechercherActeur(){
		Acteur a = serviceActeur.rechercherParId(1);
		Assert.assertTrue(a.getId()==1);
		System.out.println(a.toString());
	}
	
	@Test
	public void testTousLesActeurs(){
		List<Acteur> listeActeurs = serviceActeur.findAll();
		Assert.assertTrue(listeActeurs.size()>0);
		System.out.println("nombre acteurs:" +listeActeurs.size());
	}
	
	@Test
	public void testAjoutActeur(){
		 Acteur newActeur = new Acteur();
		    newActeur.setNom("adt");
		    newActeur.setPrenom("jzrj");
		 Acteur a = serviceActeur.ajouter(newActeur);
			Assert.assertTrue(a.getId()>2);
			System.out.println(a.toString());
			
		
	}
	

}




