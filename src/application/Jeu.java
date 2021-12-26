/**
 * 
 */
package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import controlleur.Interaction;
import modele.Joueur;
import modele.Nom;
import modele.Personnage;
import modele.PlateauDeJeu;
import modele.Quartier;

/**
 * @author Gilles C�dric
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
		System.out.println("Veuillez entrer le chiffre correspondant � votre choix!!!");
		System.out.println("	1 : 	Jouer une nouvelle partie. ");
		System.out.println("	2 : 	Afficher les r�gles du jeu. ");
		System.out.println("	3 : 	Quitter l'application. ");
	}
	
	private void afficherLesRegles() {
		try {
			Desktop.getDesktop().open(new File("C:\\Users\\HP\\eclipse-2021-workspace\\Citadelle\\src\\ressources\\presentationJeuCitadelles.pdf"));
		} catch (IOException e) {
			System.err.println("Erreur lors de l'ouverture des r�gles du jeu : "+e.getMessage());
		}
	}
	
	private void quitter() {
		System.out.println("Au revoir et � tr�s bient�t !!!");
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
		for (int i = 0; i < this.plateauDeJeu.getNombreJoueurs(); i++) {
			if(this.plateauDeJeu.getJoueur(i).getPossedeCouronne())
				this.plateauDeJeu.getJoueur(i).setPossedeCouronne(false);
		}
		for (int i = 0; i < this.plateauDeJeu.getNombreJoueurs(); i++) {
			if(this.plateauDeJeu.getJoueur(i).getPersonnage().getNom().equals(Nom.ROI)) {
				System.out.println(this.plateauDeJeu.getJoueur(i).getNom()+" poss�de la couronne");
				this.plateauDeJeu.getJoueur(i).setPossedeCouronne(true);
			}
		}
	}
	
	private void reinitialisationPersonnages() {
		for (int i = 0; i < this.plateauDeJeu.getNombrePersonnages(); i++) {
			if(this.plateauDeJeu.getPersonnage(i).getJoueur() != null)
				this.plateauDeJeu.getPersonnage(i).reinitialiser();
		}
	}
	
	private boolean partieFinie() {
		for (int i = 0; i < this.plateauDeJeu.getNombreJoueurs(); i++) {
			if (this.plateauDeJeu.getJoueur(i).nbQuartiersDansCite() >= 7) {
				System.out.println("La partie est termin� : "+this.plateauDeJeu.getJoueur(i).getNom()+" poss�de une cit� compl�te");
				this.plateauDeJeu.getJoueur(i).setPremier(true);
				int joueurPersoRangMax = this.plateauDeJeu.getJoueur(0).getPersonnage().getRang();
				for (int j = 0; j < this.plateauDeJeu.getNombreJoueurs(); j++) {
					if(this.plateauDeJeu.getJoueur(j).getPersonnage().getRang() > joueurPersoRangMax)
						joueurPersoRangMax = this.plateauDeJeu.getJoueur(j).getPersonnage().getRang();
				}
				this.plateauDeJeu.getJoueur(joueurPersoRangMax).setRangPlusEleve();;
				return true;
			}
		}
		return false;
	}
	
	private void tourDeJeu() {
		choixPersonnages();
		ArrayList<Personnage> personnages = new ArrayList<>();
		for (int i = 0; i < this.plateauDeJeu.getNombrePersonnages(); i++) {
			personnages.add(this.plateauDeJeu.getPersonnage(i));
		}
		do {
			int personnage = 0;
			for (int i = 0; i < personnages.size(); i++) {
				if (personnages.get(i).getRang() > personnages.get(personnage).getRang())
					personnage = i;

			}
			System.out.println("Le jeu appelle le " + personnages.get(personnage).getNom());
			if (personnages.get(personnage).getJoueur() != null) {
				if (!personnages.get(personnage).getAssassine()) {
					if (personnages.get(personnage).getVole()) {
						System.out.println("Le " + personnages.get(personnage).getNom() + " est vol� !");
						int nbPieces = personnages.get(personnage).getJoueur().nbPieces();
						this.plateauDeJeu.getPersonnage(personnage).getJoueur().retirerPieces(nbPieces);
						for (int i = 0; i < this.plateauDeJeu.getNombrePersonnages(); i++) {
							if (this.plateauDeJeu.getJoueur(i).getNom().equals(Nom.VOLEUR))
								this.plateauDeJeu.getJoueur(i).ajouterPieces(nbPieces);
						}
					} else {
						percevoirRessource(personnage);
						this.plateauDeJeu.getPersonnage(personnage).percevoirRessourcesSpecifiques();
						System.out.println("Voulez vous utiliser votre pouvoir ?");
						boolean res = false;
						if (!personnages.get(personnage).getJoueur().isSimule())
							res = Interaction.lireOuiOuNon();
						else {
							res = this.generateur.nextInt(2) == 1;
						}
						if (res) {
							if (!personnages.get(personnage).getJoueur().isSimule())
								this.plateauDeJeu.getPersonnage(personnage).utiliserPouvoir();
							else
								this.plateauDeJeu.getPersonnage(personnage).utiliserPouvoirAvatar();
						}
						System.out.println("Voulez vous construire ?");
						if (!personnages.get(personnage).getJoueur().isSimule())
							res = Interaction.lireOuiOuNon();
						else {
							res = this.generateur.nextInt(2) == 1;
						}
						if (res) {
							boolean peutConstruire = false;
							int carte = 0;
							do {
								System.out.println("Quel cartier voulez vous construire ?");
								int i = 1;
								for (Quartier quartier : personnages.get(personnage).getJoueur().getMain()) {
									System.out.println((i) + " " + quartier.getNom() + " - type : " + quartier.getType()
											+ " - pi�ces : " + quartier.getCout());
									i++;
								}
								System.out.println("0 : Annuler la construction");
								if (!personnages.get(personnage).getJoueur().isSimule())
									carte = Interaction.lireUnEntier(0,
											personnages.get(personnage).getJoueur().nbQuartiersDansMain() + 1);
								else {
									carte = this.generateur
											.nextInt(personnages.get(personnage).getJoueur().nbQuartiersDansMain() + 1);
								}
								if (carte == 0)
									break;
								if (personnages.get(personnage).getJoueur().nbPieces() >= personnages.get(personnage)
										.getJoueur().getMain().get(carte - 1).getCout()
										&& !personnages.get(personnage).getJoueur().quartierPresentDansCite(personnages
												.get(personnage).getJoueur().getMain().get(carte - 1).getNom()))
									peutConstruire = true;
								else
									System.out.println(
											"Vous ne pouvez pas construire ce quartier. Veuillez choisir un autre quartier !");
							} while (!peutConstruire);
							if (carte != 0) {
								this.plateauDeJeu.getPersonnage(personnage)
										.construire(personnages.get(personnage).getJoueur().getMain().get(carte - 1));
								this.plateauDeJeu.getPersonnage(personnage).getJoueur().getMain().remove(carte - 1);
							}
						}
					}
				} else {
					System.out.println("Le " + personnages.get(personnage).getNom() + " est assasin� !");
				}
			} else {
				System.out.println("Aucun joueur ne poss�de le " + personnages.get(personnage).getNom());
			}
			personnages.remove(personnage);
		} while (personnages.size() > 0);
	}
	
	private void choixPersonnages() {
		ArrayList<Joueur> joueurs = new ArrayList<>();
		Personnage persoFaceVisible1 = null;
		Personnage persoFaceVisible2 = null;
		Personnage persoFaceCach� = null;
		int response = 0;
		for (int i = 0; i < this.plateauDeJeu.getNombreJoueurs(); i++) {
			joueurs.add(this.plateauDeJeu.getJoueur(i));
		}
		do {
			persoFaceVisible1 = this.plateauDeJeu.getPersonnage(this.generateur.nextInt(this.plateauDeJeu.getNombrePersonnages()));
			persoFaceVisible2 = this.plateauDeJeu.getPersonnage(this.generateur.nextInt(this.plateauDeJeu.getNombrePersonnages()));
			persoFaceCach� = this.plateauDeJeu.getPersonnage(this.generateur.nextInt(this.plateauDeJeu.getNombrePersonnages()));
			
		}while(persoFaceVisible1.getRang() == 4 || persoFaceVisible2.getRang() == 4 || persoFaceCach�.getNom().equals(persoFaceVisible1.getNom()) || persoFaceCach�.getNom().equals(persoFaceVisible2.getNom()) || persoFaceVisible1.getNom().equals(persoFaceVisible2.getNom()));
		int n = joueurs.size();
		for (int i = 0; i < n; i++) {
			if(joueurs.get(i).getPossedeCouronne()) {
				joueurs.add(0, joueurs.remove(i));
			}
		}
		do {
			System.out.println("Choix des personnages :");
			System.out.println("Le personnage \""+persoFaceVisible1.getNom()+"\" est �cart� face visible");
			System.out.println("Le personnage \""+persoFaceVisible2.getNom()+"\" est �cart� face visible");
			System.out.println("Un personnage est �cart� face cach�e");
			if(joueurs.get(0).getPossedeCouronne())
				System.out.println("Vous avez la couronne ! ");
			for (int i = 0; i < this.plateauDeJeu.getNombrePersonnages(); i++) {
				if(this.plateauDeJeu.getPersonnage(i).getJoueur() == null && !this.plateauDeJeu.getPersonnage(i).getNom().equals(persoFaceCach�.getNom()) && !this.plateauDeJeu.getPersonnage(i).getNom().equals(persoFaceVisible1.getNom()) && !this.plateauDeJeu.getPersonnage(i).getNom().equals(persoFaceVisible2.getNom())) {
					System.out.println((i+1)+" "+this.plateauDeJeu.getPersonnage(i).getNom());
				}
			}
			if(!joueurs.get(0).isSimule()) {
				do {
					System.out.println("Quel personnage choisissez vous ?");
					response = Interaction.lireUnEntier(1, this.plateauDeJeu.getNombrePersonnages()+1);
				}while(this.plateauDeJeu.getPersonnage(response-1).getJoueur() != null || this.plateauDeJeu.getPersonnage(response-1).getNom().equals(persoFaceCach�.getNom()) || this.plateauDeJeu.getPersonnage(response-1).getNom().equals(persoFaceVisible1.getNom()) || this.plateauDeJeu.getPersonnage(response-1).getNom().equals(persoFaceVisible2.getNom()));
				this.plateauDeJeu.getPersonnage(response-1).setJoueur(joueurs.get(0));
			}else {
				int perso = 0;
				do {
					perso = this.generateur.nextInt(this.plateauDeJeu.getNombrePersonnages());
				}while(this.plateauDeJeu.getPersonnage(perso).getJoueur() != null || this.plateauDeJeu.getPersonnage(perso).getNom().equals(persoFaceCach�.getNom()) || this.plateauDeJeu.getPersonnage(perso).getNom().equals(persoFaceVisible1.getNom()) || this.plateauDeJeu.getPersonnage(perso).getNom().equals(persoFaceVisible2.getNom()));
				this.plateauDeJeu.getPersonnage(perso).setJoueur(joueurs.get(0));
			}
			joueurs.remove(0);
		}while(joueurs.size() > 0);
		
	}
	
	private void percevoirRessource(int personnage) {
		System.out.println("Voulez vous percevoir des cartes ou des pi�ces d'or ?");
		System.out.println("1 : deux cartes");
		System.out.println("2 : deux pi�ces d'or");
		int response = 0;
		if (!this.plateauDeJeu.getPersonnage(personnage).getJoueur().isSimule())
			response = Interaction.lireUnEntier(1, 3);
		else {
			do {
				response = this.generateur.nextInt(3);
			} while (response == 0);
		}
		if (response == 1) {
			System.out.println("Vous avez pioch� deux cartes");
			Quartier[] quartiers = new Quartier[2];
			for (int i = 0; i < quartiers.length; i++) {
				quartiers[i] = this.plateauDeJeu.getPioche().piocher();
			}
			System.out.println("Voici les cartes que vous avez pioch� : ");
			for (int i = 0; i < quartiers.length; i++) {
				System.out.println((i + 1) + " " + quartiers[i].getNom() + " - type : "
						+ quartiers[i].getType() + " - pi�ces : " + quartiers[i].getCout());
			}
			System.out.println("Quel carte voulez vous gardez ? : ");
			int carte = 0;
			if (!this.plateauDeJeu.getPersonnage(personnage).getJoueur().isSimule())
				carte = Interaction.lireUnEntier(1, 3);
			else {
				do {
					carte = this.generateur.nextInt(3);
				} while (carte == 0);
			}
			this.plateauDeJeu.getPersonnage(personnage).ajouterQuartier(quartiers[carte-1]);
			for (int i = 0; i < quartiers.length; i++) {
				if (!quartiers[carte-1].getNom().equals(quartiers[i].getNom())) {
					this.plateauDeJeu.getPioche().ajouter(quartiers[i]);
					break;
				}
			}
		} else {
			System.out.println("Vous avez per�u deux pi�ces d'or");
			this.plateauDeJeu.getPersonnage(personnage).ajouterPieces();
		}
	}
	
	private void calculDesPoints() {
		int[][] scores = new int[this.plateauDeJeu.getNombreJoueurs()][1];
		int score = 0;
		for (int i = 0; i < this.plateauDeJeu.getNombreJoueurs(); i++) {
			ArrayList<String> quartiers = new ArrayList<>();
			for (int j = 0; j < this.plateauDeJeu.getJoueur(i).nbQuartiersDansCite(); j++) {
				score += this.plateauDeJeu.getJoueur(i).getCite()[j].getCout();
				if(!quartiers.contains(this.plateauDeJeu.getJoueur(i).getCite()[j].getType()))
					quartiers.add(this.plateauDeJeu.getJoueur(i).getCite()[j].getType());
			}
			if(quartiers.size() >= 5)
				score += 3;
			if(this.plateauDeJeu.getJoueur(i).isPremier())
				score += 4;
			else {
				if(this.plateauDeJeu.getJoueur(i).nbQuartiersDansCite() >= 7)
					score += 2;
			}
			// la somme des diff�rents bonus des merveilles de sa cit�
			scores[i][0] = score;
			System.out.println( this.plateauDeJeu.getJoueur(i).getNom()+" a un total de "+score+" points !");
		}
		int joueurMax = 0;
		int scoreMax = scores[0][0];
		for (int i = 0; i < scores.length; i++) {
			if(scores[i][0] >= scoreMax) {
				if(scores[i][0]  == scoreMax) {
					if(this.plateauDeJeu.getJoueur(i).isRangPlusEleve()) {
						scoreMax = scores[i][0];
						joueurMax = i;
					}
				}else {
					scoreMax = scores[i][0];
					joueurMax = i;
				}
			}
		}
		System.out.println(this.plateauDeJeu.getJoueur(joueurMax).getNom()+" a remport� la partie avec un total de "+scoreMax+" points.");
		System.out.println("F�licitation "+this.plateauDeJeu.getJoueur(joueurMax).getNom()+"!!!");
	}
	
}
