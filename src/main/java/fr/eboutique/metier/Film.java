/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package fr.eboutique.metier;

import java.util.ArrayList;
import java.util.List;

// Start of user code (user defined imports)

// End of user code

/**
 * Description of Film.
 * 
 * @author Fitec
 */
public class Film {

	private Integer id; 
	
	private String titre = "";

	/**
	 * Description of the property public.
	 */
	private String publics="";

	/**
	 * Description of the property prix.
	 */
	private double prix = 0D;

	/**
	 * Description of the property origine.
	 */
	private String origine = "";

	/**
	 * Description of the property duree.
	 */
	private String duree = "";

	/**
	 * Description of the property type.
	 */
	private String type = "";

	/**
	 * Description of the property langue.
	 */
	private String langue = "";

	/**
	 * Description of the property quantite.
	 */
	private int quantite = 0;

	/**
	 * Description of the property Resume.
	 */
	private String Resume ;


	/**
	 * Description of the property realisateurs.
	 */
	private Realisateur realisateur;

	/**
	 * Description of the property genre.
	 */
	private Genre genre ;

	/**
	 * Description of the property acteurs.
	 */
	public List<Acteur> acteurs = new ArrayList<>();

	// Start of user code (user defined attributes for Film)

	// End of user code

	/**
	 * The constructor.
	 */
	public Film() {
		// Start of user code constructor for Film)
		super();
		// End of user code
	}

	// Start of user code (user defined methods for Film)

	// End of user code
	/**
	 * Returns titre.
	 * @return titre 
	 */
	public String getTitre() {
		return this.titre;
	}

	/**
	 * Sets a value to attribute titre. 
	 * @param newTitre 
	 */
	public void setTitre(String newTitre) {
		this.titre = newTitre;
	}

	/**
	 * Returns public.
	 * @return public 
	 */
	public String getPublic() {
		return this.publics;
	}

	/**
	 * Sets a value to attribute public. 
	 * @param newPublic 
	 */
	public void setPublic(String newPublic) {
	    this.publics = newPublic;
	}

	/**
	 * Returns id.
	 * @return id 
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * Sets a value to attribute id. 
	 * @param newId 
	 */
	public void setId(int newId) {
		this.id = newId;
	}

	/**
	 * Returns prix.
	 * @return prix 
	 */
	public double getPrix() {
		return this.prix;
	}

	/**
	 * Sets a value to attribute prix. 
	 * @param newPrix 
	 */
	public void setPrix(double newPrix) {
		this.prix = newPrix;
	}

	/**
	 * Returns origine.
	 * @return origine 
	 */
	public String getOrigine() {
		return this.origine;
	}

	/**
	 * Sets a value to attribute origine. 
	 * @param newOrigine 
	 */
	public void setOrigine(String newOrigine) {
		this.origine = newOrigine;
	}

	/**
	 * Returns duree.
	 * @return duree 
	 */
	public String getDuree() {
		return this.duree;
	}

	/**
	 * Sets a value to attribute duree. 
	 * @param newDuree 
	 */
	public void setDuree(String newDuree) {
		this.duree = newDuree;
	}

	/**
	 * Returns type.
	 * @return type 
	 */
	public String getType() {
		return this.type;
	}

	/**
	 * Sets a value to attribute type. 
	 * @param newType 
	 */
	public void setType(String newType) {
		this.type = newType;
	}

	/**
	 * Returns langue.
	 * @return langue 
	 */
	public String getLangue() {
		return this.langue;
	}

	/**
	 * Sets a value to attribute langue. 
	 * @param newLangue 
	 */
	public void setLangue(String newLangue) {
		this.langue = newLangue;
	}

	/**
	 * Returns quantite.
	 * @return quantite 
	 */
	public Integer getQuantite() {
		return this.quantite;
	}

	/**
	 * Sets a value to attribute quantite. 
	 * @param newQuantite 
	 */
	public void setQuantite(int newQuantite) {
		this.quantite = newQuantite;
	}

	/**
	 * Returns Resume.
	 * @return Resume 
	 */
	public String getResume() {
		return this.Resume;
	}

	/**
	 * Sets a value to attribute Resume. 
	 * @param newResume 
	 */
	public void setResume(String newResume) {
		this.Resume = newResume;
	}




	/**
	 * Returns realisateurs.
	 * @return realisateurs 
	 */
	public Realisateur getRealisateurs() {
		return this.realisateur;
	}

	/**
	 * Sets a value to attribute realisateurs. 
	 * @param newRealisateurs 
	 */
	public void setRealisateurs(Realisateur newRealisateurs) {
		this.realisateur = newRealisateurs;
	}

	/**
	 * Returns genre.
	 * @return genre 
	 */
	public Genre getGenre() {
		return this.genre;
	}

	/**
	 * Sets a value to attribute genre. 
	 * @param newGenre 
	 */
	public void setGenre(Genre newGenre) {
		this.genre = newGenre;
	}

	/**
	 * Returns acteurs.
	 * @return acteurs 
	 */
	public List<Acteur> getActeurs() {
		return this.acteurs;
	}

}
