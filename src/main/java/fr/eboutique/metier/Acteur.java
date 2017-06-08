/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package fr.eboutique.metier;

import java.io.Serializable;
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import com.fasterxml.jackson.annotation.JsonIgnore;

// Start of user code (user defined imports)

// End of user code

/**
 * Description of Acteur.
 * 
 * @author Fitec
 */
@Entity
@NamedQueries({ @NamedQuery(name = "acteur.all", query = "SELECT a FROM Acteur a"),
	@NamedQuery(name = "acteur.search", query = "SELECT a FROM Acteur a WHERE a.nom like ?1") })
public class Acteur implements Serializable{
	private static final long serialVersionUID = 1L; 
	/**
	 * Description of the property id.
	 */
	@Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_acteur")
	private Integer id ;

	/**
	 * Description of the property nom.
	 */
	private String nom;

	/**
	 * Description of the property prenom.
	 */
	private String prenom ;
	
	//add relationship between Film and Acteur
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinTable(name = "film_acteur", joinColumns = { @JoinColumn(name = "id_film") }, inverseJoinColumns = { @JoinColumn(name = "id_acteur") })
	private List<Film> listFilms;
	

	// Start of user code (user defined attributes for Acteur)

	// End of user code

	/**
	 * The constructor.
	 */
	public Acteur() {
		// Start of user code constructor for Acteur)
		super();
		// End of user code
	}

	// Start of user code (user defined methods for Acteur)

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

	public List<Film> getListFilms() {
		return listFilms;
	}

	public void setListFilms(List<Film> listFilms) {
		this.listFilms = listFilms;
	}

	@Override
	public String toString() {
		return "Acteur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", listFilms=" + listFilms + "]";
	}
	
	
	


}
