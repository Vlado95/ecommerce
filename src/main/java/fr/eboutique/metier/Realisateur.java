/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package fr.eboutique.metier;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

// Start of user code (user defined imports)

// End of user code

/**
 * Description of Realisateur.
 * 
 * @author Fitec
 */

@Entity
public class Realisateur implements Serializable {
	
	private static final long serialVersionUID = 1L; 
	/**
	 * Description of the property id.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_realisateur")
	private Integer id;

	/**
	 * Description of the property nom.
	 */
	private String nom;

	/**
	 * Description of the property prenom.
	 */
	private String prenom;

	// Start of user code (user defined attributes for Realisateur)

	// End of user code

	//declarer la liste de film par realisateur
	@OneToMany(mappedBy = "realisateur" ,fetch = FetchType.LAZY)
	private List<Film> films;
	/**
	 * The constructor.
	 */
	public Realisateur() {
		// Start of user code constructor for Realisateur)
		super();
		// End of user code
	}

	// Start of user code (user defined methods for Realisateur)

	// End of user code
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
	 * Returns nom.
	 * @return nom 
	 */
	public String getNom() {
		return this.nom;
	}

	/**
	 * Sets a value to attribute nom. 
	 * @param newNom 
	 */
	public void setNom(String newNom) {
		this.nom = newNom;
	}

	/**
	 * Returns prenom.
	 * @return prenom 
	 */
	public String getPrenom() {
		return this.prenom;
	}

	/**
	 * Sets a value to attribute prenom. 
	 * @param newPrenom 
	 */
	public void setPrenom(String newPrenom) {
		this.prenom = newPrenom;
	}

	public List<Film> getFilms() {
		return films;
	}

	public void setFilms(List<Film> films) {
		this.films = films;
	}
	
	

}
