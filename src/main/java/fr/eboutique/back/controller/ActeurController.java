package fr.eboutique.back.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.eboutique.metier.Acteur;
import fr.eboutique.service.IService;

@Controller
public class ActeurController  {
	
	@Autowired
	private IService<Acteur> serviceActeur;
	
	@RequestMapping(value = "/acteurs**", method = RequestMethod.GET)
	public String acteurPage( Model model) {
		List<Acteur> acteurList= serviceActeur.findAll();
		model.addAttribute("title", "List de tous les acteurs");
		model.addAttribute("acteurList", acteurList);
		System.out.println("acteurs"+acteurList);
		return "/acteurs";

	}
}

