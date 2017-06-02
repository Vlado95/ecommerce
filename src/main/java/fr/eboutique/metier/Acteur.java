/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package fr.eboutique.metier;

// Start of user code (user defined imports)

// End of user code

/**
 * Description of Acteur.
 * 
 * @author Fitec
 */
public class Acteur {
	/**
	 * Description of the property id.
	 */
	private Integer id ;

	/**
	 * Description of the property nom.
	 */
	private String nom;

	/**
	 * Description of the property prenom.
	 */
	private String prenom ;

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

}
