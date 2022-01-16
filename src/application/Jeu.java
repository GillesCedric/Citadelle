/**
 * 
 */
package application;

import java.util.ArrayList;
import java.util.Random;
import controlleur.Interaction;
import modele.Joueur;
import modele.Personnage;
import modele.PlateauDeJeu;
import modele.Quartier;
import utilities.Browser;
import utilities.ListeConfiguration;
import utilities.Merveille;
import utilities.Nom;

/**
 * @author Gilles Cédric
 *
 */
public class Jeu {
	private PlateauDeJeu plateauDeJeu;
	private int numeroConfiguration;
	private Random generateur;
	private int joueurPersoRangMax = 0;
	
	/**
	 *
	 */
	public Jeu() {
		this.plateauDeJeu = new PlateauDeJeu();
		this.numeroConfiguration = 1;
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
		System.out.print("\r\n"
				+ "________/\\\\\\\\\\\\\\\\\\____________________________________________/\\\\\\__________________/\\\\\\\\\\\\_____/\\\\\\\\\\\\___________________        \r\n"
				+ " _____/\\\\\\////////____________________________________________\\/\\\\\\_________________\\////\\\\\\____\\////\\\\\\___________________       \r\n"
				+ "  ___/\\\\\\/____________/\\\\\\_____/\\\\\\____________________________\\/\\\\\\____________________\\/\\\\\\_______\\/\\\\\\___________________      \r\n"
				+ "   __/\\\\\\_____________\\///___/\\\\\\\\\\\\\\\\\\\\\\__/\\\\\\\\\\\\\\\\\\___________\\/\\\\\\______/\\\\\\\\\\\\\\\\_____\\/\\\\\\_______\\/\\\\\\________/\\\\\\\\\\\\\\\\__     \r\n"
				+ "    _\\/\\\\\\______________/\\\\\\_\\////\\\\\\////__\\////////\\\\\\_____/\\\\\\\\\\\\\\\\\\____/\\\\\\/////\\\\\\____\\/\\\\\\_______\\/\\\\\\______/\\\\\\/////\\\\\\_    \r\n"
				+ "     _\\//\\\\\\____________\\/\\\\\\____\\/\\\\\\________/\\\\\\\\\\\\\\\\\\\\___/\\\\\\////\\\\\\___/\\\\\\\\\\\\\\\\\\\\\\_____\\/\\\\\\_______\\/\\\\\\_____/\\\\\\\\\\\\\\\\\\\\\\__   \r\n"
				+ "      __\\///\\\\\\__________\\/\\\\\\____\\/\\\\\\_/\\\\___/\\\\\\/////\\\\\\__\\/\\\\\\__\\/\\\\\\__\\//\\\\///////______\\/\\\\\\_______\\/\\\\\\____\\//\\\\///////___  \r\n"
				+ "       ____\\////\\\\\\\\\\\\\\\\\\_\\/\\\\\\____\\//\\\\\\\\\\___\\//\\\\\\\\\\\\\\\\/\\\\_\\//\\\\\\\\\\\\\\/\\\\__\\//\\\\\\\\\\\\\\\\\\\\__/\\\\\\\\\\\\\\\\\\__/\\\\\\\\\\\\\\\\\\__\\//\\\\\\\\\\\\\\\\\\\\_ \r\n"
				+ "        _______\\/////////__\\///______\\/////_____\\////////\\//___\\///////\\//____\\//////////__\\/////////__\\/////////____\\//////////__\r\n"
				+ "");
		System.out.println("\r\n*-*-*-*-*Bienvenue dans le jeu Citadelles*-*-*-*-*\n");
	}
	
	private void afficherMenu() {
		System.out.println("Veuillez entrer le chiffre correspondant à  votre choix!!!");
		System.out.println("	1 : 	Jouer une nouvelle partie. ");
		System.out.println("	2 : 	Afficher les règles du jeu. ");
		System.out.println("	3 : 	Quitter l'application. ");
	}
	
	private void afficherLesRegles() {
		//try {
			//Desktop.getDesktop().open(new File("C"+System.getProperty("")+""+System.getProperty(null)+"Users\\HP\\eclipse-2021-workspace\\Citadelle\\src\\ressources\\presentationJeuCitadelles.pdf"));
			Browser.open("https://drive.google.com/file/d/1FxyMtdVkxvK9qeMBQQM_Y7ZyvyR8g-Wv/view?usp=sharing");
			System.out.println("Les règles vont s'ouvrir dans le navigateur");
		/*} catch (IOException e) {
			System.err.println("Erreur lors de l'ouverture des règles du jeu : "+e.getMessage());
		}*/
	}
	
	private void quitter() {
		System.out.println("\r\n"
				+ "  /$$$$$$                                                          /$$           /$$ /$$ /$$\r\n"
				+ " /$$__  $$                                                        |__/          | $$| $$| $$\r\n"
				+ "| $$  \\ $$ /$$   /$$        /$$$$$$   /$$$$$$  /$$    /$$ /$$$$$$  /$$  /$$$$$$ | $$| $$| $$\r\n"
				+ "| $$$$$$$$| $$  | $$       /$$__  $$ /$$__  $$|  $$  /$$//$$__  $$| $$ /$$__  $$| $$| $$| $$\r\n"
				+ "| $$__  $$| $$  | $$      | $$  \\__/| $$$$$$$$ \\  $$/$$/| $$  \\ $$| $$| $$  \\__/|__/|__/|__/\r\n"
				+ "| $$  | $$| $$  | $$      | $$      | $$_____/  \\  $$$/ | $$  | $$| $$| $$                  \r\n"
				+ "| $$  | $$|  $$$$$$/      | $$      |  $$$$$$$   \\  $/  |  $$$$$$/| $$| $$       /$$ /$$ /$$\r\n"
				+ "|__/  |__/ \\______/       |__/       \\_______/    \\_/    \\______/ |__/|__/      |__/|__/|__/\r\n"
				+ "                                                                                            \r\n"
				+ "                                                                                            \r\n"
				+ "                                                                                            \r\n"
				+ "");
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
	
	private int choixNombreJoueurs() {
		System.out.println("Pour commencer une partie, veuillez entrer le nombre de joueurs!");
		return Interaction.lireUnEntier(2, 9);
	}
	
	private void choixConfiguration() {
		System.out.println("A présent, veuillez choisir la configuration du jeu");
		for (int i = 0; i < ListeConfiguration.values().length; i++) {
			System.out.println((i+1)+" : "+ListeConfiguration.values()[i].getNom());
		}
		System.out.println("Veuillez entrer le numéro correspondant à votre choix");
		this.numeroConfiguration = Interaction.lireUnEntier(0, ListeConfiguration.values().length+1);
	}
	
	private void initialisation() {
		int nbJoueur = choixNombreJoueurs();
		choixConfiguration();
		//ici on initialise le plateau avec la configuration de base du projet
		switch (this.numeroConfiguration) {
		case 1:
			this.plateauDeJeu = Configuration.configurationDeBase(Configuration.nouvellePioche(),nbJoueur);
			break;
		case 2:
			this.plateauDeJeu = Configuration.configurationAristocratesAmbitieux(Configuration.nouvellePioche(),nbJoueur);
			break;
		case 3:
			this.plateauDeJeu = Configuration.configurationIntrigantsSubtils(Configuration.nouvellePioche(),nbJoueur);
			break;
		case 4:
			this.plateauDeJeu = Configuration.configurationEmissairesIllustres(Configuration.nouvellePioche(),nbJoueur);
			break;
		case 5:
			this.plateauDeJeu = Configuration.configurationDignitairesSournois(Configuration.nouvellePioche(),nbJoueur);
			break;
		case 6:
			this.plateauDeJeu = Configuration.configurationOligarquesTenaces(Configuration.nouvellePioche(),nbJoueur);
			break;
		case 7:
			this.plateauDeJeu = Configuration.configurationNoblesRetors(Configuration.nouvellePioche(),nbJoueur);
			break;
		default:
			this.plateauDeJeu = Configuration.configurationDeBase(Configuration.nouvellePioche(),nbJoueur);
			break;
		}
		Merveille.setPlateauDeJeu(plateauDeJeu);
		//on ajoute deux pièces à  tous les joueurs
		for (int i = 0; i < this.plateauDeJeu.getNombreJoueurs(); i++) {
			this.plateauDeJeu.getJoueur(i).ajouterPieces(2);
			for (int j = 0; j < 4; j++) {
				//on ajoute à  la main de chaque joueur un quatier qu'il a pioché dans la pioche
				this.plateauDeJeu.getJoueur(i).ajouterQuartierDansMain(this.plateauDeJeu.getPioche().piocher());
			}
		}
		//ici on attribue la couronne à  un jooueur aléatoire
		this.plateauDeJeu.getJoueur(this.generateur.nextInt(this.plateauDeJeu.getNombreJoueurs())).setPossedeCouronne(true);
	}
	
	private void gestionCouronne() {
		//on détermine le joueur qui possède la couronne et on lui enlève la couronne
		for (int i = 0; i < this.plateauDeJeu.getNombreJoueurs(); i++) {
			if(this.plateauDeJeu.getJoueur(i).getPossedeCouronne())
				this.plateauDeJeu.getJoueur(i).setPossedeCouronne(false);
		}
		//on attribue la couronne au joueur qui possède le peesonnage Roi
		for (int i = 0; i < this.plateauDeJeu.getNombreJoueurs(); i++) {
			if(this.plateauDeJeu.getJoueur(i).getPersonnage().getNom().equals(Nom.ROI)) {
				System.out.println(this.plateauDeJeu.getJoueur(i).getNom()+" possède la couronne");
				this.plateauDeJeu.getJoueur(i).setPossedeCouronne(true);
			}
		}
	}
	
	private void reinitialisationPersonnages() {
		//on réinitialise tous les personnage
		for (int i = 0; i < this.plateauDeJeu.getNombrePersonnages(); i++) {
			if(this.plateauDeJeu.getPersonnage(i).getJoueur() != null)
				this.plateauDeJeu.getPersonnage(i).reinitialiser();
		}
	}
	
	private boolean partieFinie() {
		//on parcoure tous les joueurs pour vérifier si un possède une cité complète
		for (int i = 0; i < this.plateauDeJeu.getNombreJoueurs(); i++) {
			if (this.plateauDeJeu.getJoueur(i).nbQuartiersDansCite() >= 7) {
				System.out.println("La partie est terminé : "+this.plateauDeJeu.getJoueur(i).getNom()+" possède une cité complète");
				//on affecte l'attribut isPremier de joueur à  true pour dire qu'il est le premier à  avoir une cité complète
				this.plateauDeJeu.getJoueur(i).setPremier(true);
				this.plateauDeJeu.getJoueur(joueurPersoRangMax).setRangPlusEleve();
				return true;
			}
		}
		return false;
	}
	
	private void tourDeJeu() {
		//on effectue le choix des personnages
		choixPersonnages();
		System.out.println("***************Le tour de jeu commence***************");
		for (int personnage = 0; personnage <this.plateauDeJeu.getNombrePersonnages(); personnage++) {
			System.out.println("Le jeu appelle " + this.plateauDeJeu.getPersonnage(personnage).getNom());
			//on vérifie si le personnage est associé à un joueur
			if (this.plateauDeJeu.getPersonnage(personnage).getJoueur() != null) {
				//on vérifie si le joueur associé au personnage n'est pas simulé par l'ordinateur en testant son attribut simule de la classe joueur
				if(!this.plateauDeJeu.getPersonnage(personnage).getJoueur().isSimule()) {
					//on affiche la main du joueur
					System.out.println("Voici votre Main :");
					for (int i = 0; i < this.plateauDeJeu.getPersonnage(personnage).getJoueur().nbQuartiersDansMain(); i++) {
						System.out.println((i + 1) + " " + this.plateauDeJeu.getPersonnage(personnage).getJoueur().getMain().get(i).getNom() + " - type : "
								+  this.plateauDeJeu.getPersonnage(personnage).getJoueur().getMain().get(i).getType() + " - pièces : "
								+  this.plateauDeJeu.getPersonnage(personnage).getJoueur().getMain().get(i).getCout());
					}
				}
				//on affiche la cité du joueur
				System.out.println("Voici votre Cité :");
				if(this.plateauDeJeu.getPersonnage(personnage).getJoueur().nbQuartiersDansCite()  > 0) {
					for (int i = 0; i < this.plateauDeJeu.getPersonnage(personnage).getJoueur().nbQuartiersDansCite(); i++) {
						System.out.println((i + 1) + " " +  this.plateauDeJeu.getPersonnage(personnage).getJoueur().getCite()[i].getNom() + " - type : "
								+ this.plateauDeJeu.getPersonnage(personnage).getJoueur().getCite()[i].getType() + " - pièces : "
								+ this.plateauDeJeu.getPersonnage(personnage).getJoueur().getCite()[i].getCout());
					}
				}else{
					System.out.println("Votre cité est vide !");
				}
				System.out.println("Vous possédez "+this.plateauDeJeu.getPersonnage(personnage).getJoueur().nbPieces()+" pièces");
				//on vérifie si le personnage n'est pas assassiné
				if (!this.plateauDeJeu.getPersonnage(personnage).getAssassine()) 
				{
					//on vérifie si le personnage n'est pas volé
					if (this.plateauDeJeu.getPersonnage(personnage).getVole()) 
					{
						System.out.println("Le " + this.plateauDeJeu.getPersonnage(personnage).getNom() + " est volé !");
						System.out.println("Le " + this.plateauDeJeu.getPersonnage(personnage).getNom() + " donne toutes ses pièces au voleur !");
						int nbPieces = this.plateauDeJeu.getPersonnage(personnage).getJoueur().nbPieces();
						//si le personnage est volé il donne toutes ses pièces au voleur
						this.plateauDeJeu.getPersonnage(personnage).getJoueur().retirerPieces(nbPieces);
						for (int i = 0; i < this.plateauDeJeu.getNombrePersonnages(); i++) 
						{
							if (this.plateauDeJeu.getJoueur(i).getNom().equals(Nom.VOLEUR))
								this.plateauDeJeu.getJoueur(i).ajouterPieces(nbPieces);
						}
					} 
					else 
					{
						//le personnage percoit les ressources (cartes ou pièces d'or)
						percevoirRessource(personnage);
						this.plateauDeJeu.getPersonnage(personnage).percevoirRessourcesSpecifiques();
						
						//L'Alchimiste utilise Hospice avant d'utiliser son pouvoir 
						if(this.plateauDeJeu.getPersonnage(personnage).getNom().equals("Alchimiste"))
							Merveille.effetHospice(personnage);
						//Fin de l'effet Hospice pour l'Alchimiste
						
						System.out.println("Voulez vous utiliser votre pouvoir ?");
						boolean res = false;
						//on teste si le personnage n'est pas simulé par l'ordinateur
						if (!this.plateauDeJeu.getPersonnage(personnage).getJoueur().isSimule())
							res = Interaction.lireOuiOuNon();
						else {
							//sinon on génère un nombre aléatoire qui correspond au choix de l'ordinateur
							res = this.generateur.nextInt(2) == 1;
						}
						if (res) {
							System.out.println("Le " + this.plateauDeJeu.getPersonnage(personnage).getNom() + " utilise son pouvoir !");
							if (!this.plateauDeJeu.getPersonnage(personnage).getJoueur().isSimule())
								this.plateauDeJeu.getPersonnage(personnage).utiliserPouvoir();
							else
								this.plateauDeJeu.getPersonnage(personnage).utiliserPouvoirAvatar();
						}
						System.out.println("Voulez vous construire ?");
						if (!this.plateauDeJeu.getPersonnage(personnage).getJoueur().isSimule())
							res = Interaction.lireOuiOuNon();
						else {
							res = this.generateur.nextInt(2) == 1;
						}
						if (res) {
							boolean peutConstruire = false;
							boolean check = false;
							int carte = 0;
							do {
								System.out.println("Quel cartier voulez vous construire ?");
								int i = 1;
								//on affiche la main du joueur
								for (Quartier quartier : this.plateauDeJeu.getPersonnage(personnage).getJoueur().getMain()) {
									System.out.println((i) + " " + quartier.getNom() + " - type : " + quartier.getType()
											+ " - pièces : " + quartier.getCout());
									i++;
								}
								System.out.println("0 : Annuler la construction");
								if (!this.plateauDeJeu.getPersonnage(personnage).getJoueur().isSimule())
									carte = Interaction.lireUnEntier(0,
											this.plateauDeJeu.getPersonnage(personnage).getJoueur().nbQuartiersDansMain() + 1);
								else {
									carte = this.generateur
											.nextInt(this.plateauDeJeu.getPersonnage(personnage).getJoueur().nbQuartiersDansMain() + 1);
								}
								if (carte == 0)
									break;
								// Application des effets des Merveilles pouvant affecter le cout de construction
								//Implémentation de la Merveille Manufacture
								Merveille.effetManufacture(personnage, carte);
								//Fin de l'effet de la merveille Manufacture
								
								//Implémentation de la Merveille Tripot
								Merveille.effetTripot(personnage, carte);
								//Fin de l'effet de la merveille Tripot
								
								//on vérifie si le joueur peut construire la carte choisie
								
								//Implementation de la construction de la Necropole avec destruction de carte quartier dans cite 
								if(this.plateauDeJeu.getPersonnage(personnage).getJoueur().getMain().get(carte - 1).getNom().equals("Nécropole"))
								{
									if(this.plateauDeJeu.getPersonnage(personnage).getJoueur().nbQuartiersDansCite()>0)
									{
										boolean det = false;
										int detchoix =0;
										System.out.println(" Voulez vous détruire un quartier pour construire la Necropole ? ");
										//On recupere le choix en fonction du type joueur 
										if (!this.plateauDeJeu.getPersonnage(personnage).getJoueur().isSimule())
											det = Interaction.lireOuiOuNon();
										else 
										{
											det = this.generateur.nextInt(2) == 1;
										}
										if(det)
										{
											//Affichage de la cite
											System.out.println(" Voici votre cite ");
											for (int k = 0; k < this.plateauDeJeu.getPersonnage(personnage).getJoueur().nbQuartiersDansCite(); k++) 
											{
												System.out.println((k + 1) + " " +  this.plateauDeJeu.getPersonnage(personnage).getJoueur().getCite()[k].getNom() + " - type : "
												+ this.plateauDeJeu.getPersonnage(personnage).getJoueur().getCite()[k].getType() + " - pièces : "
												+ this.plateauDeJeu.getPersonnage(personnage).getJoueur().getCite()[k].getCout());
											}
											//On recupere le choix de la cite a detruire
											System.out.println(" Quel quartier voulez vous détruire pour construire la Necropole ? ");
											if (!this.plateauDeJeu.getPersonnage(personnage).getJoueur().isSimule())
												detchoix = Interaction.lireUnEntier(1, this.plateauDeJeu.getPersonnage(personnage).getJoueur().nbQuartiersDansCite() + 1);
											else 
											{
												detchoix = this.generateur.nextInt(this.plateauDeJeu.getPersonnage(personnage).getJoueur().nbQuartiersDansCite() + 1);
											}
											System.out.println(" Le quartier : "  +this.plateauDeJeu.getPersonnage(personnage).getJoueur().getCite()[detchoix - 1].getNom() +" est retire de votre cite ");
											this.plateauDeJeu.getPersonnage(personnage).getJoueur().retirerQuartierDansCite(this.plateauDeJeu.getPersonnage(personnage).getJoueur().getCite()[detchoix - 1].getNom());
											//Le coût de construction de la Necropole passe donc a 0 pour être construit
											this.plateauDeJeu.getPersonnage(personnage).getJoueur().getMain().get(carte - 1).setCout(0);
										}
										else
											System.out.println(" Tres bien! Votre cite reste intacte, vous aurez donc a payer le cout de construction de la Necropole ");//Dans le cas ou le joueur ne voudrait pas detruire son quartier
									}
									else
									{
										System.out.println(" Vous avez certes  la Necropole mais votre cite est vide, vous ne pouvez pas par consequent detruire de quartier ");
									}
								}
								//Fin de l'Implementation de la construction de la Necropole avec destruction de carte quartier dans cite 
								
								//Implementation de la construction de quartier en detruisant la merveille Chantier
								if(Merveille.checkChantier(personnage))
								{
									System.out.println(" Voulez vous detruire votre merveille Chantier afin de construire votre carte ? ");
									boolean chan = false;
									//On recupere le choix en fonction du type joueur 
									if (!this.plateauDeJeu.getPersonnage(personnage).getJoueur().isSimule())
										chan = Interaction.lireOuiOuNon();
									else 
									{
										chan = this.generateur.nextInt(2) == 1;
									}
									if(chan)
									{
										System.out.println(" La merveille Chantier est retirée de votre cité  ");
										this.plateauDeJeu.getPersonnage(personnage).getJoueur().retirerQuartierDansCite("Chantier");
										this.plateauDeJeu.getPersonnage(personnage).getJoueur().getMain().get(carte - 1).setCout(0);
									}
									else
										System.out.println(" Tres bien! Votre Merveille Chantier reste intacte, vous aurez donc a payer le cout de construction de la carte choisie ");//Dans le cas ou le joueur ne voudrait pas detruire sa merveille
								}
								
								
								//Fin de l'Implementation de la construction de quartier en detruisant la merveille Chantier
								
								//Restreinte de l'effet de la Merveille Monument empêchant de construire le quartier Monument pour une cite d'au moins 5 quartier
								if(this.plateauDeJeu.getPersonnage(personnage).getJoueur().getMain().get(carte - 1).getNom().equals("Monument"))
								{
									if(this.plateauDeJeu.getPersonnage(personnage).getJoueur().nbQuartiersDansCite()>4)
									{
										System.out.println("Vous ne pouvez pas bâtir le Monnment avec au moins cinq quartier dans votre cité, merci de choisir une autre carte");
										check = true;
									}
								}
								//Fin de l'implementation de la restreinte sur le Monument
								
								//Restreinte sur les catacombes : elles ne peuvent pas être bâties
								if(this.plateauDeJeu.getPersonnage(personnage).getJoueur().getMain().get(carte - 1).getNom().equals("Catacombes"))
								{
									check=true;
									System.out.println(" Vous ne pouvez pas bâtir les Catacombes, cette merveille aura effet au calcul des points. Merci de choisir une autre carte ");
								}
								//Fin de l'implementation de la restreinte sur le Monument
								
								//Merveille Carriere
								if(Merveille.effetCarriere(personnage))
								{
									if (this.plateauDeJeu.getPersonnage(personnage).getJoueur().nbPieces() >= this.plateauDeJeu.getPersonnage(personnage)
											.getJoueur().getMain().get(carte - 1).getCout())
										peutConstruire = true;
								}
								else
								{
									if (this.plateauDeJeu.getPersonnage(personnage).getJoueur().nbPieces() >= this.plateauDeJeu.getPersonnage(personnage)
										.getJoueur().getMain().get(carte - 1).getCout()
										&& !this.plateauDeJeu.getPersonnage(personnage).getJoueur().quartierPresentDansCite(this.plateauDeJeu.getPersonnage(personnage).getJoueur().getMain().get(carte - 1).getNom()))
										peutConstruire = true;
									else
									System.out.println(" Vous ne pouvez pas construire ce quartier. Veuillez choisir un autre quartier !");
								}
							} while ( (!peutConstruire) || (check) );
							
							if (carte != 0) 
							{
								//on constuit le quartier choisit
								System.out.println("Le " + this.plateauDeJeu.getPersonnage(personnage).getNom()  + " a construit le "+this.plateauDeJeu.getPersonnage(personnage).getJoueur().getMain().get(carte-1).getNom());
								this.plateauDeJeu.getPersonnage(personnage)
										.construire(this.plateauDeJeu.getPersonnage(personnage).getJoueur().getMain().get(carte - 1));
							}
						}
						//Imlementation des effets agissants en fin de tour 
						
						//Implémentation de la Merveille Parc
						Merveille.effetParc(personnage);
						//Fin de l"implementation de la merveile Parc
						
						//Implémentation de la Merveille Hospice
						//L'alchimiste utilise Hospice avant d'utiliser son pouvoir 
						if(!this.plateauDeJeu.getPersonnage(personnage).getNom().equals("Alchimiste"))
							Merveille.effetHospice(personnage);
						//Fin de l"implementation de la merveile Hospice
					}
				} 
				else {
					System.out.println("Le " + this.plateauDeJeu.getPersonnage(personnage).getNom() + " est assasiné !");
				}
			} else {
				System.out.println("Aucun joueur ne possède le " + this.plateauDeJeu.getPersonnage(personnage).getNom());
			}
		}
		joueurPersoRangMax = this.plateauDeJeu.getJoueur(0).getPersonnage().getRang();
		//on détermine l'id du joueur qui possède le personnage de rang le plus élévé à la fin de la partie
		for (int j = 0; j < this.plateauDeJeu.getNombreJoueurs(); j++) {
			if(this.plateauDeJeu.getJoueur(j).getPersonnage().getRang() > joueurPersoRangMax)
				joueurPersoRangMax = j;
		}
		System.out.println("***************Fin du tour de jeu***************");
	}
	
	private void choixPersonnages() {
		System.out.println("***************Choix des personnages***************");
		ArrayList<Joueur> joueurs = new ArrayList<>();
		Personnage persoFaceVisible1 = null;
		Personnage persoFaceVisible2 = null;
		Personnage persoFaceCache = null;
		int response = 0;
		for (int i = 0; i < this.plateauDeJeu.getNombreJoueurs(); i++) {
			joueurs.add(this.plateauDeJeu.getJoueur(i));
		}
		do {
			persoFaceVisible1 = this.plateauDeJeu.getPersonnage(this.generateur.nextInt(this.plateauDeJeu.getNombrePersonnages()));
			persoFaceVisible2 = this.plateauDeJeu.getPersonnage(this.generateur.nextInt(this.plateauDeJeu.getNombrePersonnages()));
			persoFaceCache = this.plateauDeJeu.getPersonnage(this.generateur.nextInt(this.plateauDeJeu.getNombrePersonnages()));
			
		}while(persoFaceVisible1.getRang() == 4 || persoFaceVisible2.getRang() == 4 || persoFaceCache.getNom().equals(persoFaceVisible1.getNom()) || persoFaceCache.getNom().equals(persoFaceVisible2.getNom()) || persoFaceVisible1.getNom().equals(persoFaceVisible2.getNom()));
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
				if(this.plateauDeJeu.getPersonnage(i).getJoueur() == null && !this.plateauDeJeu.getPersonnage(i).getNom().equals(persoFaceCache.getNom()) && !this.plateauDeJeu.getPersonnage(i).getNom().equals(persoFaceVisible1.getNom()) && !this.plateauDeJeu.getPersonnage(i).getNom().equals(persoFaceVisible2.getNom())) {
					System.out.println((i+1)+" "+this.plateauDeJeu.getPersonnage(i).getNom());
				}
			}
			if(!joueurs.get(0).isSimule()) {
				do {
					System.out.println("Quel personnage choisissez vous ?");
					response = Interaction.lireUnEntier(1, this.plateauDeJeu.getNombrePersonnages()+1);
				}while(this.plateauDeJeu.getPersonnage(response-1).getJoueur() != null || this.plateauDeJeu.getPersonnage(response-1).getNom().equals(persoFaceCache.getNom()) || this.plateauDeJeu.getPersonnage(response-1).getNom().equals(persoFaceVisible1.getNom()) || this.plateauDeJeu.getPersonnage(response-1).getNom().equals(persoFaceVisible2.getNom()));
				this.plateauDeJeu.getPersonnage(response-1).setJoueur(joueurs.get(0));
			}else {
				int perso = 0;
				do {
					perso = this.generateur.nextInt(this.plateauDeJeu.getNombrePersonnages());
				}while(this.plateauDeJeu.getPersonnage(perso).getJoueur() != null || this.plateauDeJeu.getPersonnage(perso).getNom().equals(persoFaceCache.getNom()) || this.plateauDeJeu.getPersonnage(perso).getNom().equals(persoFaceVisible1.getNom()) || this.plateauDeJeu.getPersonnage(perso).getNom().equals(persoFaceVisible2.getNom()));
				this.plateauDeJeu.getPersonnage(perso).setJoueur(joueurs.get(0));
			}
			joueurs.remove(0);
		}while(joueurs.size() > 0);
		
	}
	
	private void percevoirRessource(int personnage) 
	{
		// Implémentation de la merveille Forge 
		Merveille.effetForge(personnage);
		//Fin de l'effet de la Merveille Forge
		
		//Implémentation de la merveille Laboratoire
		Merveille.effetLaboratoire(personnage);
		//Fin de l'implémentation de la Merveille Laboratoire
		
		System.out.println("Voulez vous percevoir des cartes ou des pièces d'or ?");
		System.out.println("1 : deux cartes");
		System.out.println("2 : deux pièces d'or");
		int response = 0;
		if (!this.plateauDeJeu.getPersonnage(personnage).getJoueur().isSimule())
			response = Interaction.lireUnEntier(1, 3);
		else {
			do {
				response = this.generateur.nextInt(3);
			} while (response == 0);
		}
		if (response == 1) 
		{
			Quartier[] quartiers = new Quartier[2];
			if(Merveille.ObservatoireActif(personnage))
			{
				Merveille.effetObservatoire(personnage);
			}
			else
			{
				System.out.println("Vous avez pioché deux cartes");
				
				for (int i = 0; i < quartiers.length; i++) 
				{
					quartiers[i] = this.plateauDeJeu.getPioche().piocher();
				}
				System.out.println("Voici les cartes que vous avez pioché : ");
				for (int i = 0; i < quartiers.length; i++) 
				{
					System.out.println((i + 1) + " " + quartiers[i].getNom() + " - type : "
					+ quartiers[i].getType() + " - pièces : " + quartiers[i].getCout());
				}
			}
				
			//Implémentation de la merveille Bibliothèque
			Merveille.effetBibliotheque(personnage, quartiers);
			//Fin de l'implémentation de la Merveille Bibliothèque	
		}
		else 
		{
			System.out.println("Vous avez perçu deux pièces d'or");
			this.plateauDeJeu.getPersonnage(personnage).ajouterPieces();
			
			// Implémentation de la merveille Mine d'or
			Merveille.effetMineDor(personnage);
			//Fin de l'effet de la Merveille Mine d'or
		}
	}
	
	private void calculDesPoints() {
		int[][] scores = new int[this.plateauDeJeu.getNombreJoueurs()][1];
		int score = 0;
		for (int i = 0; i < this.plateauDeJeu.getNombreJoueurs(); i++) 
		{
			ArrayList<String> quartiers = new ArrayList<>();
			for (int j = 0; j < this.plateauDeJeu.getJoueur(i).nbQuartiersDansCite(); j++) 
			{
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
			//Implémentation de la merveille Cour des Miracles
			Merveille.effetCourDesMiracles(i);
			//Fin de l'implémentation de la Cour des Miracles
			
			//Implémentation de la merveille Fontaine aux souhaits
			score += Merveille.effetFontaineAuxSouhaits(i);
			//Fin de l'implémentation de la Fontaine aux souhaits
			
			//Implémentation de la merveille Salle des Cartes
			score += Merveille.effetSalleDesCartes(i);
			//Fin de l'implémentation de la Merveille Salle de Cartes
			
			//Implémentation de la merveille Basilique
			score += Merveille.effetBasilique(i);
			//Fin de l'implémentation de la Merveille Basilique
			
			//Implémentation de la merveille Capitole
			score += Merveille.effetCapitole(i);
			//Fin de l'implémentation de la Merveille Capitole
			
			//Implémentation de la merveille Catacombes
			score += Merveille.effetCatacombes(i);
			//Fin de l'implémentation de la Merveille Catacombes
			
			//Implémentation de la merveille Dracoport
			score += Merveille.effetDracoport(i);
			//Fin de l'implémentation de la Merveille Dracoport
			
			//Implémentation de la merveille Statue Equestre
			score += Merveille.effetStatueEquestre(i);
			//Fin de l'implémentation de la Merveille Statue Equestre
			
			//Implémentation de la merveille Statue Tresor Imperial
			score += Merveille.effetTresorImperial(i);
			//Fin de l'implémentation de la Merveille Tresor Imperial
			
			//Implémentation de la merveille Tour d'ivoire
			score += Merveille.effetTourIvoire(i);
			//Fin de l'implémentation de la Merveille Tour d'ivoire
			
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
		System.out.println(this.plateauDeJeu.getJoueur(joueurMax).getNom()+" a remporté la partie avec un total de "+scoreMax+" points.");
		System.out.println("Félicitation "+this.plateauDeJeu.getJoueur(joueurMax).getNom()+"!!!");
	}
	
}
