/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package fr.eboutique.metier;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

// Start of user code (user defined imports)

// End of user code

/**
 * Description of Genre.
 * 
 * @author Fitec
 */

@Entity
@Table(name="genre")
@NamedQueries({ @NamedQuery(name = "genre.all", query = "SELECT g FROM Genre g"),
	@NamedQuery(name = "genre.search", query = "SELECT g FROM Genre g WHERE g.nom like ?1") })
public class Genre implements Serializable{
	
	private static final long serialVersionUID = 1L; 
	/**
	 * Description of the property id.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_genre")
	private Integer id = null;

	/**
	 * Description of the property nom.
	 */
	private String nom;

	// Start of user code (user defined attributes for Genre)

	// End of user code
	
	//add collection of Film
	@JsonIgnore
	@OneToMany(mappedBy = "genre" ,fetch = FetchType.LAZY)
	private List<Film> filmsList = new ArrayList<>();
	

	/**
	 * The constructor.
	 */
	public Genre() {
		// Start of user code constructor for Genre)
		super();
		// End of user code
	}

	// Start of user code (user defined methods for Genre)

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
	 * Returns nom .
	 * @return nom 
	 */
	public String getNom() {
		return this.nom ;
	}

	/**
	 * Sets a value to attribute nom. 
	 * @param newNom 
	 */
	public void setNom (String newNom ) {
		this.nom  = newNom ;
	}

	public List<Film> getFilmsList() {
		return filmsList;
	}

	public void setFilmsList(List<Film> filmsList) {
		this.filmsList = filmsList;
	}
	
	public String toString() {
		return "Genre [id=" + id + ", nom=" + nom + "]";
	}
	
	

}
