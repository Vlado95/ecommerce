/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package fr.eboutique.metier;

// Start of user code (user defined imports)

// End of user code

/**
 * Description of User.
 * 
 * @author Fitec
 */
public class User {
	/**
	 * Description of the property id.
	 */
	private Integer id;

	/**
	 * Description of the property nom.
	 */
	private String nom;

	/**
	 * Description of the property prenom.
	 */
	private String prenom = "";

	/**
	 * Description of the property email.
	 */
	private String email = "";

	/**
	 * Description of the property mdp.
	 */
	private String mdp = "";

	/**
	 * Description of the property role.
	 */
	private String role = "";

	// Start of user code (user defined attributes for User)

	// End of user code

	/**
	 * The constructor.
	 */
	public User() {
		// Start of user code constructor for User)
		super();
		// End of user code
	}

	// Start of user code (user defined methods for User)

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

	/**
	 * Returns email.
	 * @return email 
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * Sets a value to attribute email. 
	 * @param newEmail 
	 */
	public void setEmail(String newEmail) {
		this.email = newEmail;
	}

	/**
	 * Returns mdp.
	 * @return mdp 
	 */
	public String getMdp() {
		return this.mdp;
	}

	/**
	 * Sets a value to attribute mdp. 
	 * @param newMdp 
	 */
	public void setMdp(String newMdp) {
		this.mdp = newMdp;
	}

	/**
	 * Returns role.
	 * @return role 
	 */
	public String getRole() {
		return this.role;
	}

	/**
	 * Sets a value to attribute role. 
	 * @param newRole 
	 */
	public void setRole(String newRole) {
		this.role = newRole;
	}

}
