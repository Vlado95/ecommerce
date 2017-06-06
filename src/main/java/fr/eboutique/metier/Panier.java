/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package fr.eboutique.metier;

import java.io.Serializable;
import java.util.*;

public class Panier implements Serializable {
	private Map<Integer, LigneCommande> items = new HashMap<Integer, LigneCommande>();

	public void addItem(Film f, Integer quantite) {
		LigneCommande lc = items.get(f.getId());
		if (lc == null) {
			LigneCommande art = new LigneCommande();
			art.setFilm(f);
			art.setQuantite(quantite);
			art.setPrix(f.getPrix());
			items.put(f.getId(), art);
		} else {
			lc.setQuantite(lc.getQuantite() + quantite);
		}
	}

	public Collection<LigneCommande> getItems() {
		return items.values();
	}

	public int getSize() {
		return items.size();
	}

	public double getTotal() {
		double total = 0;
		for (LigneCommande lc : items.values()) {
			total += lc.getPrix() * lc.getQuantite();
		}
		return total;
	}

	public void deleteItem(Integer idFilm) {
		items.remove(idFilm);
	}
}

// import java.util.ArrayList;
// import java.util.List;
//
// import javax.persistence.OneToMany;

// Start of user code (user defined imports)

// End of user code

/**
 * Description of Panier.
 * 
 * @author Fitec
 */
// public class Panier {
/**
 * Description of the property Total.
 */
// private double Total;

/**
 * Description of the property ligneCommandes.
 */
// private List<LigneCommande> ligneCommandes = new ArrayList<>();

// Start of user code (user defined attributes for Panier)

// End of user code

/**
 * The constructor.
 */
// public Panier() {
// // Start of user code constructor for Panier)
// super();
// // End of user code
// }

// Start of user code (user defined methods for Panier)

// End of user code
/**
 * Returns Total.
 * 
 * @return Total
 */
// public double getTotal() {
// return this.Total;
// }

/**
 * Sets a value to attribute Total.
 * 
 * @param newTotal
 */
// public void setTotal(double newTotal) {
// this.Total = newTotal;
// }

/**
 * Returns ligneCommandes.
 * 
 * @return ligneCommandes
 */
// public List<LigneCommande> getLigneCommandes() {
// return this.ligneCommandes;
// }

// }



//autre facon de faire
// private Map<Integer, ArticlePanier> items = new HashMap<Integer,
// ArticlePanier>();
//
// public void addItem(Film f, Integer quantite) {
// ArticlePanier art = items.get(f.getId());
// if (art != null){
// art.setQuantite(art.getQuantite() + quantite);
// System.out.println("quanite en panie: "+art.getQuantite() + quantite);
// }else{
// items.put(f.getId(), new ArticlePanier(f, quantite));
// }
// }
//
// public Collection<ArticlePanier> getItems() {
// return items.values();
// }
//
// public double getTotal() {
// double total = 0;
// Collection<ArticlePanier> items = getItems();
// for (ArticlePanier art : items) {
// total += art.getQuantite() * art.getFilm().getPrix();
// }
// return total;
// }
//
// public void deleteItem(Long idProduit) {
// items.remove(idProduit);
// }
//
// public int getSize() {
// int nb = 0;
// Collection<ArticlePanier> items = getItems();
// for (ArticlePanier art : items) {
// nb += art.getQuantite();
// }
// return nb;
// }
