/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package fr.eboutique.metier;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.OneToMany;

// Start of user code (user defined imports)

// End of user code

/**
 * Description of Panier.
 * 
 * @author Fitec
 */
public class Panier {
	/**
	 * Description of the property Total.
	 */
	private double Total;

	/**
	 * Description of the property ligneCommandes.
	 */
	private List<LigneCommande> ligneCommandes = new ArrayList<>();

	// Start of user code (user defined attributes for Panier)

	// End of user code

	/**
	 * The constructor.
	 */
	public Panier() {
		// Start of user code constructor for Panier)
		super();
		// End of user code
	}

	// Start of user code (user defined methods for Panier)

	// End of user code
	/**
	 * Returns Total.
	 * @return Total 
	 */
	public double getTotal() {
		return this.Total;
	}

	/**
	 * Sets a value to attribute Total. 
	 * @param newTotal 
	 */
	public void setTotal(double newTotal) {
		this.Total = newTotal;
	}

	/**
	 * Returns ligneCommandes.
	 * @return ligneCommandes 
	 */
	public List<LigneCommande> getLigneCommandes() {
		return this.ligneCommandes;
	}

}
