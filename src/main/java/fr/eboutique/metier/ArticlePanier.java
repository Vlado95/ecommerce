package fr.eboutique.metier;

public class ArticlePanier {
	private Film film;
	private Integer quantite;

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

	public ArticlePanier(Film film, Integer quantite) {
		super();
		this.film = film;
		this.quantite = quantite;
	}

}
