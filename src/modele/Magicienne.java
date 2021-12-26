/**
 * 
 */
package modele;

import java.util.ArrayList;

import controlleur.Interaction;

/**
 * @author Gilles Cédric
 *
 */
public class Magicienne extends Personnage {
	
	public Magicienne() {
		super(Nom.MAGICIENNE, Rang.MAGICIENNE, Caracteristiques.MAGICIENNE);
	}

	@Override
	public void utiliserPouvoir() {
		ArrayList<Quartier> copieMainMagicienne = null;
		ArrayList<Quartier> copieMainJoueur = null;
		System.out.println("Voulez échanger vos cartes avec celle d'un autre joueur ? (oui/non) ");
		if (Interaction.lireOuiOuNon()) {
			for (int i = 0; i < this.getPlateau().getNombreJoueurs(); i++) {
				if(!this.getPlateau().getJoueur(i).monPersonnage.getNom().equals(this.getNom())) {
					System.out.println((i + 1) + " : Le joueur " + this.getPlateau().getJoueur(i).getNom() + " possède "
							+ this.getPlateau().getJoueur(i).nbQuartiersDansMain() + " cartes dans sa main");
				}
			}
			System.out.println("Veuillez choisir un joueur en entrant son numéro ");
			int joueur = Interaction.lireUnEntier(1, this.getPlateau().getNombreJoueurs()+1);
			copieMainMagicienne = new ArrayList<Quartier>(this.getJoueur().getMain());
			copieMainJoueur = new ArrayList<Quartier>(
					this.getPlateau().getJoueur(joueur - 1).getMain());
			int nbQuartiersDansMainMagicienne = this.getJoueur().nbQuartiersDansMain();
			int nbQuartiersDansMainJoueur = this.getPlateau().getJoueur(joueur-1).nbQuartiersDansMain();
			for (int i = 0; i < nbQuartiersDansMainMagicienne; i++) {
				this.getJoueur().retirerQuartierDansMain();
			}
			for (int i = 0; i < nbQuartiersDansMainJoueur; i++) {
				this.getPlateau().getJoueur(joueur - 1).retirerQuartierDansMain();
			}
			for (Quartier quartier : copieMainMagicienne) {
				this.getPlateau().getJoueur(joueur - 1).ajouterQuartierDansMain(quartier);
			}
			for (Quartier quartier : copieMainJoueur) {
				this.getJoueur().ajouterQuartierDansMain(quartier);
			}
		} else {
			if (this.getJoueur().nbQuartiersDansMain() == 0) {
				return;
			} else {
				System.out.println("Combien de cartes voulez-vous prendre dans la pioche ? ");
				int nb = Interaction.lireUnEntier(0, this.getJoueur().nbQuartiersDansMain() + 1);
				if (nb == 0) {
					return;
				}
				if (nb == this.getJoueur().nbQuartiersDansMain()) {
					int n = this.getJoueur().nbQuartiersDansMain();
					for (int i = 0; i < n; i++) {
						this.getPlateau().getPioche().ajouter(this.getJoueur().retirerQuartierDansMain());
					}
					for (int i = 0; i < n; i++) {
						this.getJoueur().ajouterQuartierDansMain(this.getPlateau().getPioche().piocher());
					}
				} else {
					copieMainMagicienne = new ArrayList<Quartier>(this.getJoueur().getMain());
					for (int i = 0; i < copieMainMagicienne.size(); i++) {
						System.out.println("Voici les cartes de votre main :");
						System.out.println((i + 1) + " " + copieMainMagicienne.get(i).getNom() + " - type : "
								+ copieMainMagicienne.get(i).getType() + " - pièces : "
								+ copieMainMagicienne.get(i).getCout());
					}
					for (int i = 0; i < nb; i++) {
						System.out.println("Quel est le numéro de la carte que vous voulez retirer ? ");
						int carte = Interaction.lireUnEntier(1, copieMainMagicienne.size() + 1);
						this.getPlateau().getPioche().ajouter(copieMainMagicienne.remove(carte-1));
					}
					for (int i = 0; i < nb; i++) {
						copieMainMagicienne.add(this.getPlateau().getPioche().piocher());
					}
					int n = this.getJoueur().nbQuartiersDansMain();
					for (int i = 0; i < n; i++) {
						this.getJoueur().retirerQuartierDansMain();
					}
					for (Quartier quartier : copieMainMagicienne) {
						this.getJoueur().ajouterQuartierDansMain(quartier);
					}
				}

			}
		}

	}

	@Override
	public void utiliserPouvoirAvatar() {
		// TODO Auto-generated method stub
		
	}

}
