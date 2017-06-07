package fr.eboutique.back.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.eboutique.metier.Acteur;
import fr.eboutique.service.IServiceActeur;

@Controller
public class ActeurController  {
	
	@Autowired
	private IServiceActeur serviceActeur;
	
	
	@RequestMapping(value = "/acteurs", method = RequestMethod.GET)
	public String acteurPage( Model model) {
		List<Acteur> acteurList= serviceActeur.findAll();
		model.addAttribute("acteurList", acteurList);
		model.addAttribute("acteur", new Acteur());
		System.out.println("acteurs"+acteurList);
		return "/acteurs";
	
	}


	//For add and update acteur both
		@RequestMapping(value= "acteurs/add", method = RequestMethod.POST)
		public String ajoutActeur(@ModelAttribute("acteur") Acteur a){
			System.out.println(a.getNom() +","+a.getPrenom());
			this.serviceActeur.ajouter(a);
			return "redirect:/acteurs";		
			
		}
		
		@RequestMapping("/remove/{id}")
	    public String supprimerActeur(@PathVariable("id") int id){
			
	        this.serviceActeur.supprimer(id);
	        return "redirect:/acteurs";
	    }
}

