/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package fr.eboutique.metier;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

// Start of user code (user defined imports)

// End of user code

/**
 * Description of LigneCommande.
 * 
 * @author Fitec
 */
@Entity
@Table(name="ligne_commande")
@NamedQueries({ @NamedQuery(name = "ligneCommande.all", query = "SELECT f FROM LigneCommande f")})

public class LigneCommande implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Description of the property id.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_lcmd")
	private Integer id;
	/**
	 * Description of the property quantite.
	 */
	private Integer quantite = 0;

	/**
	 * Description of the property prix.
	 */
	private Double prix = Double.valueOf(0D);


	/**
	 * Description of the property films.
	 */
	@ManyToOne
	@JoinColumn(name="id_film")
	private Film film;

	// Start of user code (user defined attributes for LigneCommande)

	// End of user code

	/**
	 * The constructor.
	 */
	public LigneCommande() {
		// Start of user code constructor for LigneCommande)
		super();
		// End of user code
	}

	// Start of user code (user defined methods for LigneCommande)

	// End of user code
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
	public void setQuantite(Integer newQuantite) {
		this.quantite = newQuantite;
	}

	/**
	 * Returns prix.
	 * @return prix 
	 */
	public Double getPrix() {
		return this.prix;
	}

	/**
	 * Sets a value to attribute prix. 
	 * @param newPrix 
	 */
	public void setPrix(Double newPrix) {
		this.prix = newPrix;
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
	public void setId(Integer newId) {
		this.id = newId;
	}

	/**
	 * Returns films.
	 * @return films 
	 */
	public Film getFilm() {
		return this.film;
	}

	/**
	 * Sets a value to attribute films. 
	 * @param newFilms 
	 */
	public void setFilm(Film newFilm) {
		this.film = newFilm;
	}

	@Override
	public String toString() {
		return "LigneCommande [id=" + id + ", quantite=" + quantite + ", prix=" + prix + ", film=" + film + "]";
	}
	
	

}
