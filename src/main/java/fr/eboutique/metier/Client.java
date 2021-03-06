/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package fr.eboutique.metier;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * Description of Client.
 * 
 * @author Fitec
 */
@Entity
@Table(name="clients")
@NamedQueries({ @NamedQuery(name = "client.all", query = "SELECT a FROM Client a"),
	@NamedQuery(name = "client.search", query = "SELECT a FROM Client a WHERE a.nom like ?1"),
	@NamedQuery(name = "client.byEmailPwd", query = "SELECT c FROM Client c WHERE c.email = ?1 AND c.mdp = ?2")})
public class Client implements Serializable{
	/**
	 * Description of the property id.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_client")
	private Integer id ;

	/**
	 * Description of the property nom.
	 */
	private String nom ;

	/**
	 * Description of the property premon.
	 */
	private String prenom ;

	/**
	 * Description of the property email.
	 */
	private String email ;

	/**
	 * Description of the property adresse.
	 */
	private String adresse ;

	/**
	 * Description of the property telephone.
	 */
	private String telephone ;

	/**
	 * Description of the property mdp.
	 */
	@Column(name="pwd")
	private String mdp ;

	@JsonIgnore
	@OneToMany(mappedBy="client")
	private List<Commande> commandes = new ArrayList<>();

	/**
	 * The constructor.
	 */
	public Client() {
		// Start of user code constructor for Client)
		super();
		// End of user code
	}



	// Start of user code (user defined methods for Client)

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
	 * Returns premon.
	 * @return premon 
	 */
	public String getPrenom() {
		return this.prenom;
	}

	/**
	 * Sets a value to attribute premon. 
	 * @param newPremon 
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
	 * Returns adresse.
	 * @return adresse 
	 */
	public String getAdresse() {
		return this.adresse;
	}

	/**
	 * Sets a value to attribute adresse. 
	 * @param newAdresse 
	 */
	public void setAdresse(String newAdresse) {
		this.adresse = newAdresse;
	}

	/**
	 * Returns telephone.
	 * @return telephone 
	 */
	public String getTelephone() {
		return this.telephone;
	}

	/**
	 * Sets a value to attribute telephone. 
	 * @param newTelephone 
	 */
	public void setTelephone(String newTelephone) {
		this.telephone = newTelephone;
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

	public List<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", adresse=" + adresse
				+ ", telephone=" + telephone + ", mdp=" + mdp + ", commandes=" + commandes + "]";
	}
	

	

	
}
