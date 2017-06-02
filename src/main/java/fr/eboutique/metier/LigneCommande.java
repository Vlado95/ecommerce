/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package fr.eboutique.metier;

// Start of user code (user defined imports)

// End of user code

/**
 * Description of LigneCommande.
 * 
 * @author Fitec
 */
public class LigneCommande {
	/**
	 * Description of the property quantite.
	 */
	private Integer quantite = 0;

	/**
	 * Description of the property prix.
	 */
	private Double prix = Double.valueOf(0D);

	/**
	 * Description of the property id.
	 */
	private Integer id = null;

	/**
	 * Description of the property films.
	 */
	private Film films = null;

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
	public Film getFilms() {
		return this.films;
	}

	/**
	 * Sets a value to attribute films. 
	 * @param newFilms 
	 */
	public void setFilms(Film newFilms) {
		this.films = newFilms;
	}

}
