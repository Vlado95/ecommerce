/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package fr.eboutique.metier;

// Start of user code (user defined imports)

// End of user code

/**
 * Description of Genre.
 * 
 * @author Fitec
 */
public class Genre {
	/**
	 * Description of the property id.
	 */
	private Integer id = null;

	/**
	 * Description of the property nom.
	 */
	private String nom = "";

	// Start of user code (user defined attributes for Genre)

	// End of user code

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

}
