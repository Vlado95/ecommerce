package fr.eboutique.back.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.eboutique.metier.Genre;
import fr.eboutique.service.IService;

@Controller
public class GenreController {


	@Autowired
	private IService<Genre> serviceGenre;
	
	@RequestMapping(value = "/genres**", method = RequestMethod.GET)
	public String filmPage( Model model) {
		List<Genre> genreList= serviceGenre.findAll();
		model.addAttribute("title", "List de tous les genres");
		model.addAttribute("genreList", genreList);
		System.out.println("genres"+genreList);
		return "pages/genres";

	}
	

}
