package fr.eboutique.back.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.eboutique.metier.LigneCommande;
import fr.eboutique.service.IService;

public class LigneCommandeController {
	@Autowired
	private IService<LigneCommande> serviceLigneCommande;
	
	@RequestMapping(value = "/ligneCommandes**", method = RequestMethod.GET)
	public String filmPage( Model model) {
		List<LigneCommande> ligneCdeList= serviceLigneCommande.findAll();
		model.addAttribute("title", "List de tous les films");
		model.addAttribute("LigneCommandeList", ligneCdeList);
		System.out.println("lignes"+ligneCdeList);
		return "pages/lignesCde";

	}

}
