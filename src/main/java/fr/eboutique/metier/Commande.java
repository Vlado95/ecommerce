/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package fr.eboutique.metier;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of Commande.
 * 
 * @author Fitec
 */
public class Commande {
	/**
	 * Description of the property id.
	 */
	private Integer id = 0;

	/**
	 * Description of the property status.
	 */
	private String status = "";

	/**
	 * Description of the property frais_port.
	 */
	private double frais_port = 0D;

	/**
	 * Description of the property montant_total.
	 */
	public double montant_total = 0D;

	/**
	 * Description of the property Date_date.
	 */
	private Date Date_date = new Date();

	/**
	 * Description of the property delai_jr.
	 */
	private Integer delai_jr = null;

	/**
	 * Description of the property adresse_livraison.
	 */
	private String adresse_livraison = "";

	/**
	 * Description of the property ligneCommandes.
	 */
	private List<LigneCommande> ligneCommandes = new ArrayList();

	/**
	 * Description of the property ref_cmd.
	 */
	private String ref_cmd = "";

	/**
	 * Description of the property clients.
	 */
	private Client clients = null;

	// Start of user code (user defined attributes for Commande)

	// End of user code

	/**
	 * The constructor.
	 */
	public Commande() {
		// Start of user code constructor for Commande)
		super();
		// End of user code
	}

	// Start of user code (user defined methods for Commande)

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
	public void setId(int newId) {
		this.id = newId;
	}

	/**
	 * Returns status.
	 * @return status 
	 */
	public String getStatus() {
		return this.status;
	}

	/**
	 * Sets a value to attribute status. 
	 * @param newStatus 
	 */
	public void setStatus(String newStatus) {
		this.status = newStatus;
	}

	/**
	 * Returns frais_port.
	 * @return frais_port 
	 */
	public double getFrais_port() {
		return this.frais_port;
	}

	/**
	 * Sets a value to attribute frais_port. 
	 * @param newFrais_port 
	 */
	public void setFrais_port(double newFrais_port) {
		this.frais_port = newFrais_port;
	}

	/**
	 * Returns montant_total.
	 * @return montant_total 
	 */
	public double getMontant_total() {
		return this.montant_total;
	}

	/**
	 * Sets a value to attribute montant_total. 
	 * @param newMontant_total 
	 */
	public void setMontant_total(double newMontant_total) {
		this.montant_total = newMontant_total;
	}

	/**
	 * Returns Date_date.
	 * @return Date_date 
	 */
	public Date getDate_date() {
		return this.Date_date;
	}

	/**
	 * Sets a value to attribute Date_date. 
	 * @param newDate_date 
	 */
	public void setDate_date(Date newDate_date) {
		this.Date_date = newDate_date;
	}

	/**
	 * Returns delai_jr.
	 * @return delai_jr 
	 */
	public Integer getDelai_jr() {
		return this.delai_jr;
	}

	/**
	 * Sets a value to attribute delai_jr. 
	 * @param newDelai_jr 
	 */
	public void setDelai_jr(Integer newDelai_jr) {
		this.delai_jr = newDelai_jr;
	}

	/**
	 * Returns adresse_livraison.
	 * @return adresse_livraison 
	 */
	public String getAdresse_livraison() {
		return this.adresse_livraison;
	}

	/**
	 * Sets a value to attribute adresse_livraison. 
	 * @param newAdresse_livraison 
	 */
	public void setAdresse_livraison(String newAdresse_livraison) {
		this.adresse_livraison = newAdresse_livraison;
	}

	/**
	 * Returns ligneCommandes.
	 * @return ligneCommandes 
	 */
	public List<LigneCommande> getLigneCommandes() {
		return this.ligneCommandes;
	}

	/**
	 * Returns ref_cmd.
	 * @return ref_cmd 
	 */
	public String getRef_cmd() {
		return this.ref_cmd;
	}

	/**
	 * Sets a value to attribute ref_cmd. 
	 * @param newRef_cmd 
	 */
	public void setRef_cmd(String newRef_cmd) {
		this.ref_cmd = newRef_cmd;
	}

	/**
	 * Returns clients.
	 * @return clients 
	 */
	public Client getClients() {
		return this.clients;
	}

	/**
	 * Sets a value to attribute clients. 
	 * @param newClients 
	 */
	public void setClients(Client newClients) {
		this.clients = newClients;
	}

}
