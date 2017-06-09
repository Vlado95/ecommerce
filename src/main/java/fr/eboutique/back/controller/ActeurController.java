package fr.eboutique.back.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
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
		model.addAttribute("action","addActeur");
		model.addAttribute("acteur", new Acteur());
		return "/pages/acteurs";
	
	}


	//For add and update acteur both
		@RequestMapping(value= "/acteurs", method = RequestMethod.POST)
		public String ajoutActeur(@ModelAttribute("acteur") Acteur a,Model model){
			this.serviceActeur.ajouter(a);
			model.addAttribute("action","addActeur");
			return "redirect:/acteurs";	

			
		}
		
			
		@RequestMapping(value="/remove/{id}", method = RequestMethod.GET)
	    public String supprimerActeur(@PathVariable("id") int id){
	        this.serviceActeur.supprimer(id);
	        return "redirect:/acteurs";
	    }
		
		
		@RequestMapping(value= "/edit/{id}",  method = RequestMethod.GET)
		    public String editActeur(@PathVariable("id") int id, Model model){
				model.addAttribute("action","edit");
		        model.addAttribute("acteur", this.serviceActeur.rechercherParId(id));
		        model.addAttribute("acteurList", this.serviceActeur.findAll());
		        return "/pages/acteurs";
		 }
		
		@RequestMapping(value= "/edit/{id}",  method = RequestMethod.POST)
	    public String editActeur(@ModelAttribute("acteur") Acteur a, Model model){
			//Acteur act = new Acteur();
			model.addAttribute("action","edit");
	         this.serviceActeur.maj(a);
	      //  model.addAttribute("acteurList", this.serviceActeur.findAll());
	        return "redirect:/acteurs";
	 }
	
}

