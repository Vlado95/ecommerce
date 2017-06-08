package fr.eboutique.back.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.eboutique.metier.Film;
import fr.eboutique.service.IService;

@Controller
public class FilmController  {
	
	@Autowired
	private IService<Film> serviceFilm;
	
	@RequestMapping(value = "/films**", method = RequestMethod.GET)
	public String filmPage( Model model) {
		List<Film> filmList= serviceFilm.findAll();
		model.addAttribute("title", "List de tous les films");
		model.addAttribute("filmList", filmList);
		System.out.println("films"+filmList);
		return "pages/films";

	}
	
	

}
