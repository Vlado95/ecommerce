package fr.eboutique.back.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.eboutique.metier.Realisateur;
import fr.eboutique.service.IService;

@Controller
public class RealisateurController  {
	
	@Autowired
	private IService<Realisateur> serviceRealisateur;
	
	@RequestMapping(value = "/realisateurs**", method = RequestMethod.GET)
	public String realisateurPage( Model model) {
		List<Realisateur> realisateurList= serviceRealisateur.findAll();
		model.addAttribute("title", "List de tous les realisateurs");
		model.addAttribute("realisateurList", realisateurList);
		System.out.println("realisateurs"+realisateurList);
		return "pages/realisateurs";

	}
}
