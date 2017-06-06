package fr.eboutique.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import fr.eboutique.metier.Film;
import fr.eboutique.metier.Genre;
import fr.eboutique.metier.Panier;
import fr.eboutique.service.IService;

@Controller
@SessionAttributes("panier")
public class EBoutiqueController {
	
	@Autowired
	private IService<Film> serviceFilm;
	
	@Autowired
	private IService<Genre> serviceGenre;
	
	
	@RequestMapping("/view")
	public String index(Model model){
	if(model.asMap().get("panier")==null){
	model.addAttribute("panier", new Panier());
	}
	model.addAttribute("genres", serviceGenre.findAll());
	model.addAttribute("films", serviceFilm.findAll());
	return "/viewFil";
	}
	
	
	
	@RequestMapping("/ajouterAuPanier")
	public String ajouterPanier(@RequestParam Integer
	idFilm,@RequestParam Integer quantite,Model model){
					Panier panier=null;
	if(model.asMap().get("panier")==null){
	panier=new Panier();
	model.addAttribute("panier", panier);
	}
	else
	panier=(Panier) model.asMap().get("panier");
	panier.addItem(serviceFilm.rechercherParId(idFilm), quantite);
	model.addAttribute("categories", serviceGenre.findAll());
	model.addAttribute("films", serviceFilm.findAll());
	return "/viewFil";
	}
	
	
	@RequestMapping("/supprimerAuPanier")
	public String supprimerPan(@RequestParam Integer
	idFilm/*,@RequestParam Integer quantite*/,Model model){
					Panier panier=null;
	if(model.asMap().get("panier")!=null){
		panier=(Panier) model.asMap().get("panier");
		panier.deleteItem(idFilm);
	//panier=new Panier();
	//model.addAttribute("panier", panier);
	}
	//else
	panier=(Panier) model.asMap().get("panier");
	//panier.addItem(serviceFilm.rechercherParId(idFilm), quantite);
	model.addAttribute("categories", serviceGenre.findAll());
	model.addAttribute("films", serviceFilm.findAll());
	return "/viewFil";
	}
//
//	@RequestMapping("/produitsParCat")
//	public String produitsParCat(@RequestParam Long idCat,Model
//	model){
//	model.addAttribute("categories", serviceGenre.findAll());
//	model.addAttribute("films",serviceFilm.findAll() /* serviceFilm.produitsParCategorie(idCat)*/);
//	return "index";
//	} @
//	RequestMapping("/chercherProduits")
//	public String chercherProduits(@RequestParam String mc,Model
//	model){
//	model.addAttribute("mc",mc);
//	model.addAttribute("categories", serviceGenre.findAll());
//	model.addAttribute("films",serviceFilm.chercherParString(mc));
//	return "index";
//	}

}
