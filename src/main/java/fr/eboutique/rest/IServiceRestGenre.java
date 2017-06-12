package fr.eboutique.rest;

import java.util.List;

import fr.eboutique.metier.Film;
import fr.eboutique.metier.Genre;

public interface IServiceRestGenre extends IServiceRest<Genre> {
	
	public List<Film> rechercheFilmParCat(Integer  idGenre);
	

}
