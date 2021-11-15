package modele;

public abstract class Personnage {
	private String nom;
	private int rang;
	private String caracteristiques;
	private Joueur joueur;
	private boolean assasine;
	private boolean vole;
	private PlateauDeJeu plateauDeJeu;
	
	/**
	 * @param nom
	 * @param rang
	 * @param caracteristiques
	 */
	public Personnage(String nom, int rang, String caracteristiques) {
		super();
		this.nom = nom;
		this.rang = rang;
		this.caracteristiques = caracteristiques;
		this.joueur = null;
		this.assasine = false;
		this.vole = false;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @return the rang
	 */
	public int getRang() {
		return rang;
	}

	/**
	 * @return the caracteristiques
	 */
	public String getCaracteristiques() {
		return caracteristiques;
	}

	/**
	 * @return the joueur
	 */
	public Joueur getJoueur() {
		return joueur;
	}

	/**
	 * @return the assasine
	 */
	public boolean isAssasine() {
		return assasine;
	}

	/**
	 * @return the vole
	 */
	public boolean isVole() {
		return vole;
	}

	/**
	 * @return the plateauDeJeu
	 */
	public PlateauDeJeu getPlateauDeJeu() {
		return plateauDeJeu;
	}

	/**
	 * @param joueur the joueur to set
	 */
	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}

	/**
	 * @return void
	 */
	public void setAssasine() {
		this.assasine = true;
	}

	/**
	 * @return void
	 */
	public void setVole() {
		this.vole = true;
	}
	
	/**
	 * @return void
	 */
	public void ajouterPieces() {
		if(this.joueur != null && !this.assasine) {
			this.joueur.ajouterPiece(2);
		}
	}
	
	/**
	 * @return void
	 */
	public void ajouterQuartier(Quartier quartier) {
		if(this.joueur != null && !this.assasine) {
			this.joueur.ajouterQuartierDansMain(quartier);
		}
	}
	
	/**
	 * @return void
	 */
	public void construire(Quartier quartier) {
		if(this.joueur != null && !this.assasine) {
			this.joueur.ajouterQuartierDansCite(quartier);
		}
	}
	
	/**
	 * @return void
	 */
	public void percevoirRessourcesSpecifiques() {
		if(this.joueur != null && !this.assasine) {
			System.out.println("Aucune ressources spécifiques");
		}
	}
	
	/**
	 * @return void
	 */
	public abstract void utiliserPouvoir();
	
	/**
	 * @return void
	 */
	public void reinitialiser() {
		this.joueur = null;
		this.assasine = false;
		this.vole = false;
	}
	
}
