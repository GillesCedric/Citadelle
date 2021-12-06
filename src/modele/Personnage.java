package modele;


/**
 * @author Gilles CÈdric
 * @since 12/11/2021
 * @see https://moodle3.esaip.org/mod/resource/view.php?id=36274
 *
 */
public abstract class Personnage {
	private String nom;
	private int rang;
	private String caracteristiques;
	private Joueur joueur;
	private boolean assassine;
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
		this.assassine = false;
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
	public boolean getAssassine() {
		return assassine;
	}

	/**
	 * @return the vole
	 */
	public boolean getVole() {
		return vole;
	}

	/**
	 * @param joueur the joueur to set
	 */
	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
		this.joueur.monPersonnage = this;
	}

	/**
	 * @return void
	 */
	public void setAssassine() {
		this.assassine = true;
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
		if (this.joueur != null && !this.assassine) {
			this.joueur.ajouterPieces(2);
		}
	}

	/**
	 * @return void
	 */
	public void ajouterQuartier(Quartier quartier) {
		if (this.joueur != null && !this.assassine) {
			this.joueur.ajouterQuartierDansMain(quartier);
		}
	}

	/**
	 * @return void
	 */
	public void construire(Quartier quartier) {
		if (this.joueur != null && !this.assassine) {
			this.joueur.ajouterQuartierDansCite(quartier);
		}
	}

	/**
	 * @return void
	 */
	public void percevoirRessourcesSpecifiques() {
		if (this.joueur == null || this.assassine) {
			System.out.println("Aucune ressources sp√©cifiques");
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
		this.assassine = false;
		this.vole = false;
		this.joueur.monPersonnage = null;
	}

	/**
	 * @return void
	 */
	public PlateauDeJeu getPlateau() {
		return plateauDeJeu;
	}

	/**
	 * @return void
	 */
	public void setPlateau(PlateauDeJeu plateau) {
		this.plateauDeJeu = plateau;
	}
}
