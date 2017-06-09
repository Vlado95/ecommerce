package fr.eboutique.back.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.eboutique.metier.Acteur;
import fr.eboutique.metier.Film;
import fr.eboutique.metier.Genre;
import fr.eboutique.metier.Realisateur;
import fr.eboutique.metier.Film;
import fr.eboutique.service.IService;

@Controller
public class FilmController  {
	
	@Autowired
	private IService<Film> serviceFilm;
	
	@Autowired
	private IService<Genre> serviceGenre;
	
	@Autowired
	private IService<Acteur> serviceActeur;
	
	@Autowired
	private IService<Realisateur> serviceRealisateur;
	
	//list films
	@RequestMapping(value = "/films", method = RequestMethod.GET)
	public String filmPage( Model model) {
		List<Film> filmList= serviceFilm.findAll();
		model.addAttribute("filmList", filmList); 
		model.addAttribute("action","addFilm");
		model.addAttribute("film", new Film());
		return "pages/films";
	}

	//add film
		@RequestMapping(value= "/films", method = RequestMethod.POST)
		public String ajoutFilm(@ModelAttribute("film") Film film,Model model){
			System.out.println("ajouter un film");
			 Film fil = serviceFilm.ajouter(film);
			System.out.println("film ajouter: "+fil.getTitre());
			model.addAttribute("action","addFilm");
			return "redirect:/films";	

			
		}
		
			
		@RequestMapping(value="/removeFilm/{id}", method = RequestMethod.GET)
	    public String supprimerFilm(@PathVariable("id") int id){
	        this.serviceFilm.supprimer(id);
	        return "redirect:/films";
	    }
		
		
		@RequestMapping(value= "/editFilm/{id}",  method = RequestMethod.GET)
		    public String editFilm(@PathVariable("id") int id, Model model){
				model.addAttribute("action","editFilm");
		        model.addAttribute("film", this.serviceFilm.rechercherParId(id));
		        model.addAttribute("filmList", this.serviceFilm.findAll());
		        return "/pages/films";
		 }
		
		@RequestMapping(value= "/editFilm/{id}",  method = RequestMethod.POST)
	    public String editFilm(@ModelAttribute("film") Film f, Model model){
			//Film act = new Film();
			model.addAttribute("action","editFilm");
	         this.serviceFilm.maj(f);
	      //  model.addAttribute("FilmList", this.serviceFilm.findAll());
	        return "redirect:/films";
		}
		
		 @ModelAttribute("genres")
		    public List<Genre> GetGenre() throws SQLException {
		        List<Genre> genres = serviceGenre.findAll();
		        return genres;
		 }
		 
		 @ModelAttribute("acteurs")
		    public List<Acteur> GetActeur() throws SQLException {
		        List<Acteur> acteurs = serviceActeur.findAll();
		        return acteurs;
		 }
		 
		 
		 @ModelAttribute("realisateurs")
		    public List<Realisateur> GetRealisateur() throws SQLException {
		        List<Realisateur> realisateurs = serviceRealisateur.findAll();
		        return realisateurs;
		 }
		 
		 
	
	

}
