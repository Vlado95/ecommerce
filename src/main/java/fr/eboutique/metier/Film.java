/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package fr.eboutique.metier;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

// Start of user code (user defined imports)

// End of user code

/**
 * Description of Film.
 * 
 * @author Fitec
 */

@Entity
@Table(name="films")
@NamedQueries({ @NamedQuery(name = "film.all", query = "SELECT f FROM Film f"),
	@NamedQuery(name = "film.searchByTitre", query = "SELECT f FROM Film f WHERE f.titre like ?1") })
public class Film implements Serializable {
	
	private static final long serialVersionUID = 1L; 

	@Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_film")
	private Integer id; 
	
	private String titre ;

	/**
	 * Description of the property public.
	 */
	private String publics ;

	/**
	 * Description of the property prix.
	 */
	private double prix ;

	/**
	 * Description of the property origine.
	 */
	private String origine ;

	/**
	 * Description of the property duree.
	 */
	private String duree ;

	/**
	 * Description of the property type.
	 */
	private String format ;

	/**
	 * Description of the property langue.
	 */
	private String langue ;

	/**
	 * Description of the property quantite.
	 */
	private int quantite;

	/**
	 * Description of the property Resume.
	 */
	private String resume;

	private String affiche;

	/**
	 * Description of the property realisateurs.
	 */
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="id_realisateur")
	private Realisateur realisateur;

	/**
	 * Description of the property genre.
	 */
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="id_genre")
	private Genre genre ;
	

	//add relatioship between Film and Acteur
	//@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "film_acteur", 
	joinColumns = @JoinColumn(name = "id_film",referencedColumnName="id_film"), 
	inverseJoinColumns =@JoinColumn(name = "id_acteur",referencedColumnName="id_acteur"))
	private List<Acteur> listActeurs = new ArrayList<>();
	
//	@JsonIgnore
	@OneToMany(mappedBy = "film",cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private List<LigneCommande> listLignesCommande =new ArrayList<>();

	
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
	 * Returns prix.
	 * @return prix 
	 */
//	public double getPrix() {
//		return this.prix;
//	}

	/**
	 * Sets a value to attribute prix. 
	 * @param newPrix 
	 */
//	public void setPrix(double newPrix) {
//		this.prix = newPrix;
//	}
	

	/**
	 * Returns origine.
	 * @return origine 
	 */
	public String getOrigine() {
		return this.origine;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

//	public List<LigneCommande> getListLignesCommande() {
//		return listLignesCommande;
//	}
//
//	public void setListLignesCommande(List<LigneCommande> listLignesCommande) {
//		this.listLignesCommande = listLignesCommande;
//	}

	public Integer getId() {
		return id;
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
	public String getFormat() {
		return this.format;
	}

	/**
	 * Sets a value to attribute type. 
	 * @param newType 
	 */
	public void setFormat(String newFormat) {
		this.format = newFormat;
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
		return this.resume;
	}

	/**
	 * Sets a value to attribute Resume. 
	 * @param newResume 
	 */
	public void setResume(String newResume) {
		this.resume = newResume;
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
	
	

	public String getPublics() {
		return publics;
	}

	public void setPublics(String publics) {
		this.publics = publics;
	}

	public String getAffiche() {
		return affiche;
	}

	public void setAffiche(String affiche) {
		this.affiche = affiche;
	}

	public Realisateur getRealisateur() {
		return realisateur;
	}

	public void setRealisateur(Realisateur realisateur) {
		this.realisateur = realisateur;
	}

	public List<Acteur> getListActeurs() {
		return listActeurs;
	}

	public void setListActeurs(List<Acteur> listActeurs) {
		this.listActeurs = listActeurs;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Film [id=" + id + ", titre=" + titre + ", publics=" + publics + ", prix=" + prix + ", origine="
				+ origine + ", duree=" + duree + ", format=" + format + ", langue=" + langue + ", quantite=" + quantite
				+ ", resume=" + resume + ", affiche=" + affiche + ", realisateur=" + realisateur
				+ ", genre=" + genre + ", listActeurs=" + listActeurs + "]";

	}

	

	

}
