package fr.eboutique.back.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.eboutique.metier.Commande;
import fr.eboutique.service.IService;

@Controller
public class CommandeController {
	

	@Autowired
	private IService<Commande> serviceCommande;
	
	@RequestMapping(value = "/commandes**", method = RequestMethod.GET)
	public String commandePage( Model model) {
		List<Commande> commandeList= serviceCommande.findAll();
		model.addAttribute("title", "List de toutes les commandes");
		model.addAttribute("commandeList", commandeList);
		System.out.println("commandes"+commandeList);
		return "/commandes";

	}

}
