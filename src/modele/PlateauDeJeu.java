package modele;

import java.util.Arrays;

/**
 *
 * @author Badugue Bonnet Igor-M
 * @since 13/11/2021
 */
public class PlateauDeJeu {
	private Personnage[] listePersonnages;
	private Joueur[] listeJoueurs;
	private Pioche pioche;
	private int nombrePersonnages;
	private int nombreJoueurs;

	public PlateauDeJeu() {
		listePersonnages = new Personnage[9];
		listeJoueurs = new Joueur[9];
		pioche = new Pioche();
		nombrePersonnages = 0;
		nombreJoueurs = 0;
	}
	
	public void sortPersonnage() {
		Arrays.sort(this.listePersonnages);
	}

	/**
	 * @param pioche the pioche to set
	 */
	public void setPioche(Pioche pioche) {
		this.pioche = pioche;
	}

	public Personnage getPersonnage(int i) {
		if (i < listePersonnages.length && i >= 0) {
			return listePersonnages[i];
		} else
			return null;
	}

	public Joueur getJoueur(int i) {
		if (i < listeJoueurs.length && i >= 0) {
			return listeJoueurs[i];
		} else
			return null;
	}

	public Pioche getPioche() {
		return pioche;
	}

	public int getNombrePersonnages() {
		return nombrePersonnages;
	}

	public int getNombreJoueurs() {
		return nombreJoueurs;
	}

	public void ajouterPersonnage(Personnage p) {
		if(p != null && this.nombrePersonnages < this.listePersonnages.length) {
			this.listePersonnages[this.nombrePersonnages] = p;
			p.setPlateau(this);
			this.nombrePersonnages++;
		}
	}

	public void ajouterJoueur(Joueur j) {
		if(j != null && this.nombreJoueurs < this.listeJoueurs.length) {
			this.listeJoueurs[this.nombreJoueurs] = j;
			this.nombreJoueurs++;
		}
	}

}
