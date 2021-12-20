/**
 * 
 */
package application;

import java.util.Random;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import controlleur.Interaction;
import modele.Joueur;
import modele.PlateauDeJeu;

/**
 * @author Gilles Cédric
 *
 */
public class Jeu {
	private PlateauDeJeu plateauDeJeu;
	private int numeroConfiguration;
	private Random generateur;
	
	/**
	 *
	 */
	public Jeu() {
		this.plateauDeJeu = new PlateauDeJeu();
		this.numeroConfiguration = 0;
		this.generateur = new Random();
	}
	
	public void jouer() {
		int response = 0;
		afficherBienvenue();
		do {
			afficherMenu();
			response = Interaction.lireUnEntier(1, 4);
			if (response == 1) {
				jouerPartie();
			}else if(response == 2) {
				afficherLesRegles();
			}
		}while(response != 3);
		quitter();
	}
	
	private void afficherBienvenue() {
		System.out.println("Bienvenue dans le jeu Citadelles");
	}
	
	private void afficherMenu() {
		System.out.println("Veuillez entrer le chiffre correspondant à votre choix!!!");
		System.out.println("	1 : 	Jouer une nouvelle partie. ");
		System.out.println("	2 : 	Afficher les règles du jeu. ");
		System.out.println("	3 : 	Quitter l'application. ");
	}
	
	private void afficherLesRegles() {
		Desktop desktop = Desktop.getDesktop();
		try {
			desktop.open(new File("C:\\Users\\HP\\eclipse-2021-workspace\\Citadelle\\src\\ressources\\presentationJeuCitadelles.pdf"));
		} catch (IOException e) {
			System.err.println("Erreur lors de l'ouverture des règles du jeu : "+e.getMessage());
		}
	}
	
	private void quitter() {
		System.out.println("Au revoir et à très bientôt !!!");
		System.exit(0);
	}
	
	private void jouerPartie() {
		initialisation();
		do {
			tourDeJeu();
			gestionCouronne();
			reinitialisationPersonnages();
		} while (!partieFinie());
		calculDesPoints();
	}
	
	private void initialisation() {
		this.plateauDeJeu = Configuration.configurationDeBase(Configuration.nouvellePioche());
		for (int i = 0; i < this.plateauDeJeu.getNombreJoueurs(); i++) {
			this.plateauDeJeu.getJoueur(i).ajouterPieces(2);
			for (int j = 0; j < 4; j++) {
				this.plateauDeJeu.getJoueur(i).ajouterQuartierDansMain(this.plateauDeJeu.getPioche().piocher());
			}
		}
		this.plateauDeJeu.getJoueur(this.generateur.nextInt(this.plateauDeJeu.getNombreJoueurs())).setPossedeCouronne(true);
	}
	
	private void gestionCouronne() {
		
	}
	
	private void reinitialisationPersonnages() {
		
	}
	
	private boolean partieFinie() {
		return true;
	}
	
	private void tourDeJeu() {
		
	}
	
	private void choixPersonnages() {
		
	}
	
	private void percevoirRessource() {
		
	}
	
	private void calculDesPoints() {
		
	}
	
}
