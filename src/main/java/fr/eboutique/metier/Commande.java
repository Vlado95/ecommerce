/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package fr.eboutique.metier;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
// Start of user code (user defined imports)
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

// End of user code

/**
 * Description of Commande.
 * 
 * @author Fitec
 */
@Entity
public class Commande {
	/**
	 * Description of the property id.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_commande")
	private Integer id;

	/**
	 * Description of the property status.
	 */
	private String status;

	/**
	 * Description of the property frais_port.
	 */
	@Column(name = "frais_port")
	private double fraisPort;

	/**
	 * Description of the property montant_total.
	 */
	@Column(name = "montant_total")
	private double montantTotal;

	/**
	 * @Description of the property Date de commande.
	 */
	@Column(name = "date_cmd")
	private Date DateCmd = new Date();

	/**
	 * @Description of the property delais de livraision.
	 */
	@Column(name = "delai_jr")
	private Integer delaisLivraison;

	/**
	 * Description of the property adresse_livraison.
	 */
	@Column(name = "adresse_liv")
	private String adresseLivraison;

	/**
	 * Description of the property ligneCommandes.
	 */
	@OneToMany
	@JoinColumn(name="id_lcmd")
	private List<LigneCommande> ligneCommandes = new ArrayList();

	/**
	 * Description of the property ref_cmd.
	 */
	@Column(name = "ref_cmd")
	private String reference;

	/**
	 * Description of the property clients.
	 */
	@ManyToOne
	@JoinColumn(name = "id_client")
	private Client client;

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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getFraisPort() {
		return fraisPort;
	}

	public void setFraisPort(double fraisPort) {
		this.fraisPort = fraisPort;
	}

	public double getMontantTotal() {
		return montantTotal;
	}

	public void setMontantTotal(double montantTotal) {
		this.montantTotal = montantTotal;
	}

	public Date getDateCmd() {
		return DateCmd;
	}

	public void setDateCmd(Date dateCmd) {
		DateCmd = dateCmd;
	}

	public Integer getDelaisLivraison() {
		return delaisLivraison;
	}

	public void setDelaisLivraison(Integer delaisLivraison) {
		this.delaisLivraison = delaisLivraison;
	}

	public String getAdresseLivraison() {
		return adresseLivraison;
	}

	public void setAdresseLivraison(String adresseLivraison) {
		this.adresseLivraison = adresseLivraison;
	}

	public List<LigneCommande> getLigneCommandes() {
		return ligneCommandes;
	}

	public void setLigneCommandes(List<LigneCommande> ligneCommandes) {
		this.ligneCommandes = ligneCommandes;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}



}
