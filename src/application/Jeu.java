/**
 * 
 */
package application;

import java.util.ArrayList;
import java.util.Random;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import controlleur.Interaction;
import modele.Joueur;
import modele.Personnage;
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
		try {
			Desktop.getDesktop().open(new File("C:\\Users\\HP\\eclipse-2021-workspace\\Citadelle\\src\\ressources\\presentationJeuCitadelles.pdf"));
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
		choixPersonnages();
	}
	
	private void choixPersonnages() {
		ArrayList<Joueur> joueurs = new ArrayList<>();
		Personnage persoFaceVisible1 = null;
		Personnage persoFaceVisible2 = null;
		Personnage persoFaceCaché = null;
		int response = 0;
		for (int i = 0; i < this.plateauDeJeu.getNombreJoueurs(); i++) {
			joueurs.add(this.plateauDeJeu.getJoueur(i));
		}
		do {
			persoFaceVisible1 = this.plateauDeJeu.getPersonnage(this.generateur.nextInt(this.plateauDeJeu.getNombrePersonnages()));
			persoFaceVisible2 = this.plateauDeJeu.getPersonnage(this.generateur.nextInt(this.plateauDeJeu.getNombrePersonnages()));
			persoFaceCaché = this.plateauDeJeu.getPersonnage(this.generateur.nextInt(this.plateauDeJeu.getNombrePersonnages()));
			
		}while(persoFaceVisible1.getRang() == 4 || persoFaceVisible2.getRang() == 4 || persoFaceCaché.getNom().equals(persoFaceVisible1.getNom()) || persoFaceCaché.getNom().equals(persoFaceVisible2.getNom()) || persoFaceVisible1.getNom().equals(persoFaceVisible2.getNom()));
		int n = joueurs.size();
		for (int i = 0; i < n; i++) {
			if(joueurs.get(i).getPossedeCouronne()) {
				joueurs.add(0, joueurs.remove(i));
			}
		}
		do {
			System.out.println("Choix des personnages :");
			System.out.println("Le personnage \""+persoFaceVisible1.getNom()+"\" est écarté face visible");
			System.out.println("Le personnage \""+persoFaceVisible2.getNom()+"\" est écarté face visible");
			System.out.println("Un personnage est écarté face cachée");
			if(joueurs.get(0).getPossedeCouronne())
				System.out.println("Vous avez la couronne ! ");
			for (int i = 0; i < this.plateauDeJeu.getNombrePersonnages(); i++) {
				if(this.plateauDeJeu.getPersonnage(i).getJoueur() == null && !this.plateauDeJeu.getPersonnage(i).getNom().equals(persoFaceCaché.getNom()) && !this.plateauDeJeu.getPersonnage(i).getNom().equals(persoFaceVisible1.getNom()) && !this.plateauDeJeu.getPersonnage(i).getNom().equals(persoFaceVisible2.getNom())) {
					System.out.println((i+1)+" "+this.plateauDeJeu.getPersonnage(i).getNom());
				}
			}
			if(!joueurs.get(0).isSimule()) {
				do {
					System.out.println("Quel personnage choisissez vous ?");
					response = Interaction.lireUnEntier(1, this.plateauDeJeu.getNombrePersonnages()+1);
				}while(this.plateauDeJeu.getPersonnage(response-1).getJoueur() != null || this.plateauDeJeu.getPersonnage(response-1).getNom().equals(persoFaceCaché.getNom()) || this.plateauDeJeu.getPersonnage(response-1).getNom().equals(persoFaceVisible1.getNom()) || this.plateauDeJeu.getPersonnage(response-1).getNom().equals(persoFaceVisible2.getNom()));
				this.plateauDeJeu.getPersonnage(response-1).setJoueur(joueurs.get(0));
			}else {
				int perso = 0;
				do {
					perso = this.generateur.nextInt(this.plateauDeJeu.getNombrePersonnages());
				}while(this.plateauDeJeu.getPersonnage(perso).getJoueur() != null || this.plateauDeJeu.getPersonnage(perso).getNom().equals(persoFaceCaché.getNom()) || this.plateauDeJeu.getPersonnage(perso).getNom().equals(persoFaceVisible1.getNom()) || this.plateauDeJeu.getPersonnage(perso).getNom().equals(persoFaceVisible2.getNom()));
				this.plateauDeJeu.getPersonnage(perso).setJoueur(joueurs.get(0));
			}
			joueurs.remove(0);
		}while(joueurs.size() > 0);
		
	}
	
	private void percevoirRessource() {
		
	}
	
	private void calculDesPoints() {
		
	}
	
}
