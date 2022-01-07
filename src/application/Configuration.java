/**
 * 
 */
package application;

import java.util.Random;

import controlleur.Interaction;
import modele.*;
import utilities.JoueurIA;
import utilities.ListeMerveille;
import utilities.ListeQuartier;

/**
 * @author Gilles C�dric
 *
 */
public class Configuration {
	private static Random generateur = new Random();
	private static PlateauDeJeu plateauDeJeu = new PlateauDeJeu();
	private static Joueur joueur = null;
	private static Personnage personnage = null;
	private static Quartier quartier = null;
	
	public static Pioche nouvellePioche() {
		Pioche pioche = new Pioche();
		for (ListeQuartier quartier : ListeQuartier.values()) {
			for (int i = 0; i < quartier.getNbMax(); i++) {
				Quartier q = new Quartier(quartier.getNom(),quartier.getType(),quartier.getCoutConstruction());
				pioche.ajouter(q);
			}
		}
		pioche.melanger();
		return pioche;
	}
	
	public static PlateauDeJeu configurationDeBase(Pioche p, int nbJoueur) {
		
		personnage = new Assassin();
		plateauDeJeu.ajouterPersonnage(personnage);
		personnage = new Voleur();
		plateauDeJeu.ajouterPersonnage(personnage);
		personnage = new Magicienne();
		plateauDeJeu.ajouterPersonnage(personnage);
		personnage = new Roi();
		plateauDeJeu.ajouterPersonnage(personnage);
		personnage = new Eveque();
		plateauDeJeu.ajouterPersonnage(personnage);
		personnage = new Marchande();
		plateauDeJeu.ajouterPersonnage(personnage);
		personnage = new Architecte();
		plateauDeJeu.ajouterPersonnage(personnage);
		personnage = new Condottiere();
		plateauDeJeu.ajouterPersonnage(personnage);
		
		System.out.println("Veuillez entrer votre nom");
		String nom = Interaction.lireUneChaine();
		joueur = new Joueur(nom);
		plateauDeJeu.ajouterJoueur(joueur);
		String IALastName = "";
		for (int i = 0; i < nbJoueur-1; i++) {
			do {
				joueur = new Joueur(JoueurIA.values()[generateur.nextInt(JoueurIA.values().length)].getNom());
			}while(joueur.getNom().equals(IALastName));
			joueur.setSimule(true);
			plateauDeJeu.ajouterJoueur(joueur);
			IALastName = joueur.getNom();
			//Corriger le bug sur les noms des IA
		}
		
		quartier = new Quartier(ListeMerveille.BIBLIOTHEQUE.getNom(),ListeMerveille.BIBLIOTHEQUE.getType(),ListeMerveille.BIBLIOTHEQUE.getCoutConstruction(),ListeMerveille.BIBLIOTHEQUE.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.CARRIERE.getNom(),ListeMerveille.CARRIERE.getType(),ListeMerveille.CARRIERE.getCoutConstruction(),ListeMerveille.CARRIERE.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.COURS_DES_MIRACLES.getNom(),ListeMerveille.COURS_DES_MIRACLES.getType(),ListeMerveille.COURS_DES_MIRACLES.getCoutConstruction(),ListeMerveille.COURS_DES_MIRACLES.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.DONJON.getNom(),ListeMerveille.DONJON.getType(),ListeMerveille.DONJON.getCoutConstruction(),ListeMerveille.DONJON.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.DRACOPORT.getNom(),ListeMerveille.DRACOPORT.getType(),ListeMerveille.DRACOPORT.getCoutConstruction(),ListeMerveille.DRACOPORT.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.ECOLE_DE_MAGIE.getNom(),ListeMerveille.ECOLE_DE_MAGIE.getType(),ListeMerveille.ECOLE_DE_MAGIE.getCoutConstruction(),ListeMerveille.ECOLE_DE_MAGIE.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.FONTAINE_AUX_SOUHAITS.getNom(),ListeMerveille.FONTAINE_AUX_SOUHAITS.getType(),ListeMerveille.FONTAINE_AUX_SOUHAITS.getCoutConstruction(),ListeMerveille.FONTAINE_AUX_SOUHAITS.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.FORGE.getNom(),ListeMerveille.FORGE.getType(),ListeMerveille.FORGE.getCoutConstruction(),ListeMerveille.FORGE.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.LABORATOIRE.getNom(),ListeMerveille.LABORATOIRE.getType(),ListeMerveille.LABORATOIRE.getCoutConstruction(),ListeMerveille.LABORATOIRE.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.MANUFACTURE.getNom(),ListeMerveille.MANUFACTURE.getType(),ListeMerveille.MANUFACTURE.getCoutConstruction(),ListeMerveille.MANUFACTURE.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.SALLES_DES_CARTES.getNom(),ListeMerveille.SALLES_DES_CARTES.getType(),ListeMerveille.SALLES_DES_CARTES.getCoutConstruction(),ListeMerveille.SALLES_DES_CARTES.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.STATUE_EQUESTRE.getNom(),ListeMerveille.STATUE_EQUESTRE.getType(),ListeMerveille.STATUE_EQUESTRE.getCoutConstruction(),ListeMerveille.STATUE_EQUESTRE.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.TRESOR_IMPERIAL.getNom(),ListeMerveille.TRESOR_IMPERIAL.getType(),ListeMerveille.TRESOR_IMPERIAL.getCoutConstruction(),ListeMerveille.TRESOR_IMPERIAL.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.TRIPOT.getNom(),ListeMerveille.TRIPOT.getType(),ListeMerveille.TRIPOT.getCoutConstruction(),ListeMerveille.TRIPOT.getCaracteristique());
		p.ajouter(quartier);
		
		plateauDeJeu.setPioche(p);
		return plateauDeJeu;
	}
	
	public static PlateauDeJeu configurationAristocratesAmbitieux(Pioche p, int nbJoueur) {
		
		personnage = new Echevin();
		plateauDeJeu.ajouterPersonnage(personnage);
		personnage = new Voleur();
		plateauDeJeu.ajouterPersonnage(personnage);
		personnage = new Sorcier();
		plateauDeJeu.ajouterPersonnage(personnage);
		personnage = new Patricien();
		plateauDeJeu.ajouterPersonnage(personnage);
		personnage = new Eveque();
		plateauDeJeu.ajouterPersonnage(personnage);
		personnage = new Negociant();
		plateauDeJeu.ajouterPersonnage(personnage);
		personnage = new Architecte();
		plateauDeJeu.ajouterPersonnage(personnage);
		personnage = new Capitaine();
		plateauDeJeu.ajouterPersonnage(personnage);
		if (nbJoueur > 2) {
			if (nbJoueur >= 5) {
				personnage = new Reine();
			}else {
				personnage = new Artiste();
			}
			plateauDeJeu.ajouterPersonnage(personnage);
		}
		
		System.out.println("Veuillez entrer votre nom");
		String nom = Interaction.lireUneChaine();
		joueur = new Joueur(nom);
		plateauDeJeu.ajouterJoueur(joueur);
		String IALastName = "";
		for (int i = 0; i < nbJoueur-1; i++) {
			do {
				joueur = new Joueur(JoueurIA.values()[generateur.nextInt(JoueurIA.values().length)].getNom());
			}while(joueur.getNom().equals(IALastName));
			joueur.setSimule(true);
			plateauDeJeu.ajouterJoueur(joueur);
			IALastName = joueur.getNom();
			//Corriger le bug sur les noms des IA
		}
		
		quartier = new Quartier(ListeMerveille.CAPITOLE.getNom(),ListeMerveille.CAPITOLE.getType(),ListeMerveille.CAPITOLE.getCoutConstruction(),ListeMerveille.CAPITOLE.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.CARRIERE.getNom(),ListeMerveille.CARRIERE.getType(),ListeMerveille.CARRIERE.getCoutConstruction(),ListeMerveille.CARRIERE.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.CHANTIER.getNom(),ListeMerveille.CHANTIER.getType(),ListeMerveille.CHANTIER.getCoutConstruction(),ListeMerveille.CHANTIER.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.COURS_DES_MIRACLES.getNom(),ListeMerveille.COURS_DES_MIRACLES.getType(),ListeMerveille.COURS_DES_MIRACLES.getCoutConstruction(),ListeMerveille.COURS_DES_MIRACLES.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.DONJON.getNom(),ListeMerveille.DONJON.getType(),ListeMerveille.DONJON.getCoutConstruction(),ListeMerveille.DONJON.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.ECOLE_DE_MAGIE.getNom(),ListeMerveille.ECOLE_DE_MAGIE.getType(),ListeMerveille.ECOLE_DE_MAGIE.getCoutConstruction(),ListeMerveille.ECOLE_DE_MAGIE.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.ECURIES.getNom(),ListeMerveille.ECURIES.getType(),ListeMerveille.ECURIES.getCoutConstruction(),ListeMerveille.ECURIES.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.GRANDE_MURAILLE.getNom(),ListeMerveille.GRANDE_MURAILLE.getType(),ListeMerveille.GRANDE_MURAILLE.getCoutConstruction(),ListeMerveille.GRANDE_MURAILLE.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.HOSPICE.getNom(),ListeMerveille.HOSPICE.getType(),ListeMerveille.HOSPICE.getCoutConstruction(),ListeMerveille.HOSPICE.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.MANUFACTURE.getNom(),ListeMerveille.MANUFACTURE.getType(),ListeMerveille.MANUFACTURE.getCoutConstruction(),ListeMerveille.MANUFACTURE.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.NECROPOLE.getNom(),ListeMerveille.NECROPOLE.getType(),ListeMerveille.NECROPOLE.getCoutConstruction(),ListeMerveille.NECROPOLE.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.PARC.getNom(),ListeMerveille.PARC.getType(),ListeMerveille.PARC.getCoutConstruction(),ListeMerveille.PARC.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.STATUE_EQUESTRE.getNom(),ListeMerveille.STATUE_EQUESTRE.getType(),ListeMerveille.STATUE_EQUESTRE.getCoutConstruction(),ListeMerveille.STATUE_EQUESTRE.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.TRIPOT.getNom(),ListeMerveille.TRIPOT.getType(),ListeMerveille.TRIPOT.getCoutConstruction(),ListeMerveille.TRIPOT.getCaracteristique());
		p.ajouter(quartier);
		
		p.melanger();
		plateauDeJeu.setPioche(p);
		return plateauDeJeu;
	}
	
	public static PlateauDeJeu configurationIntrigantsSubtils(Pioche p, int nbJoueur) {
		
		personnage = new Sorciere();
		plateauDeJeu.ajouterPersonnage(personnage);
		personnage = new MaitreChanteuse();
		plateauDeJeu.ajouterPersonnage(personnage);
		personnage = new Magicienne();
		plateauDeJeu.ajouterPersonnage(personnage);
		if (nbJoueur == 2 || nbJoueur == 3) {
			personnage = (generateur.nextBoolean()) ? new Patricien() : new Roi();
		}else {
			personnage = new Empereur();
		}
		plateauDeJeu.ajouterPersonnage(personnage);
		personnage = new Abee();
		plateauDeJeu.ajouterPersonnage(personnage);
		personnage = new Alchimiste();
		plateauDeJeu.ajouterPersonnage(personnage);
		personnage = new Architecte();
		plateauDeJeu.ajouterPersonnage(personnage);
		personnage = new Condottiere();
		plateauDeJeu.ajouterPersonnage(personnage);
		if (nbJoueur > 2) {
			personnage = new Bailli();
			plateauDeJeu.ajouterPersonnage(personnage);
		}
		
		System.out.println("Veuillez entrer votre nom");
		String nom = Interaction.lireUneChaine();
		joueur = new Joueur(nom);
		plateauDeJeu.ajouterJoueur(joueur);
		String IALastName = "";
		for (int i = 0; i < nbJoueur-1; i++) {
			do {
				joueur = new Joueur(JoueurIA.values()[generateur.nextInt(JoueurIA.values().length)].getNom());
			}while(joueur.getNom().equals(IALastName));
			joueur.setSimule(true);
			plateauDeJeu.ajouterJoueur(joueur);
			IALastName = joueur.getNom();
			//Corriger le bug sur les noms des IA
		}
		
		quartier = new Quartier(ListeMerveille.BASILIQUE.getNom(),ListeMerveille.BASILIQUE.getType(),ListeMerveille.BASILIQUE.getCoutConstruction(),ListeMerveille.BASILIQUE.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.CARRIERE.getNom(),ListeMerveille.CARRIERE.getType(),ListeMerveille.CARRIERE.getCoutConstruction(),ListeMerveille.CARRIERE.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.CATACOMBES.getNom(),ListeMerveille.CATACOMBES.getType(),ListeMerveille.CATACOMBES.getCoutConstruction(),ListeMerveille.CATACOMBES.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.DONJON.getNom(),ListeMerveille.DONJON.getType(),ListeMerveille.DONJON.getCoutConstruction(),ListeMerveille.DONJON.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.DRACOPORT.getNom(),ListeMerveille.DRACOPORT.getType(),ListeMerveille.DRACOPORT.getCoutConstruction(),ListeMerveille.DRACOPORT.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.MINE_DOR.getNom(),ListeMerveille.MINE_DOR.getType(),ListeMerveille.MINE_DOR.getCoutConstruction(),ListeMerveille.MINE_DOR.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.MONUMENT.getNom(),ListeMerveille.MONUMENT.getType(),ListeMerveille.MONUMENT.getCoutConstruction(),ListeMerveille.MONUMENT.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.FORGE.getNom(),ListeMerveille.FORGE.getType(),ListeMerveille.FORGE.getCoutConstruction(),ListeMerveille.FORGE.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.HOSPICE.getNom(),ListeMerveille.HOSPICE.getType(),ListeMerveille.HOSPICE.getCoutConstruction(),ListeMerveille.HOSPICE.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.MUSEE.getNom(),ListeMerveille.MUSEE.getType(),ListeMerveille.MUSEE.getCoutConstruction(),ListeMerveille.MUSEE.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.NECROPOLE.getNom(),ListeMerveille.NECROPOLE.getType(),ListeMerveille.NECROPOLE.getCoutConstruction(),ListeMerveille.NECROPOLE.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.PARC.getNom(),ListeMerveille.PARC.getType(),ListeMerveille.PARC.getCoutConstruction(),ListeMerveille.PARC.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.POUDRIERE.getNom(),ListeMerveille.POUDRIERE.getType(),ListeMerveille.POUDRIERE.getCoutConstruction(),ListeMerveille.POUDRIERE.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.THEATRE.getNom(),ListeMerveille.THEATRE.getType(),ListeMerveille.THEATRE.getCoutConstruction(),ListeMerveille.THEATRE.getCaracteristique());
		p.ajouter(quartier);
		
		p.melanger();
		plateauDeJeu.setPioche(p);
		return plateauDeJeu;
	}
	
	public static PlateauDeJeu configurationEmissairesIllustres(Pioche p, int nbJoueur) {
		
		personnage = new Sorciere();
		plateauDeJeu.ajouterPersonnage(personnage);
		personnage = new Espion();
		plateauDeJeu.ajouterPersonnage(personnage);
		personnage = new Voyante();
		plateauDeJeu.ajouterPersonnage(personnage);
		if (nbJoueur == 2 || nbJoueur == 3) {
			personnage = (generateur.nextBoolean()) ? new Patricien() : new Roi();
		}else {
			personnage = new Empereur();
		}
		plateauDeJeu.ajouterPersonnage(personnage);
		personnage = new Eveque();
		plateauDeJeu.ajouterPersonnage(personnage);
		personnage = new Marchande();
		plateauDeJeu.ajouterPersonnage(personnage);
		personnage = new Archiviste();
		plateauDeJeu.ajouterPersonnage(personnage);
		personnage = new Diplomate();
		plateauDeJeu.ajouterPersonnage(personnage);
		if (nbJoueur > 2) {
			personnage = new Artiste();
			plateauDeJeu.ajouterPersonnage(personnage);
		}
		
		System.out.println("Veuillez entrer votre nom");
		String nom = Interaction.lireUneChaine();
		joueur = new Joueur(nom);
		plateauDeJeu.ajouterJoueur(joueur);
		String IALastName = "";
		for (int i = 0; i < nbJoueur-1; i++) {
			do {
				joueur = new Joueur(JoueurIA.values()[generateur.nextInt(JoueurIA.values().length)].getNom());
			}while(joueur.getNom().equals(IALastName));
			joueur.setSimule(true);
			plateauDeJeu.ajouterJoueur(joueur);
			IALastName = joueur.getNom();
			//Corriger le bug sur les noms des IA
		}
		
		quartier = new Quartier(ListeMerveille.BIBLIOTHEQUE.getNom(),ListeMerveille.BIBLIOTHEQUE.getType(),ListeMerveille.BIBLIOTHEQUE.getCoutConstruction(),ListeMerveille.BIBLIOTHEQUE.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.CARRIERE.getNom(),ListeMerveille.CARRIERE.getType(),ListeMerveille.CARRIERE.getCoutConstruction(),ListeMerveille.CARRIERE.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.COURS_DES_MIRACLES.getNom(),ListeMerveille.COURS_DES_MIRACLES.getType(),ListeMerveille.COURS_DES_MIRACLES.getCoutConstruction(),ListeMerveille.COURS_DES_MIRACLES.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.DONJON.getNom(),ListeMerveille.DONJON.getType(),ListeMerveille.DONJON.getCoutConstruction(),ListeMerveille.DONJON.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.CHANTIER.getNom(),ListeMerveille.CHANTIER.getType(),ListeMerveille.CHANTIER.getCoutConstruction(),ListeMerveille.CHANTIER.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.ECOLE_DE_MAGIE.getNom(),ListeMerveille.ECOLE_DE_MAGIE.getType(),ListeMerveille.ECOLE_DE_MAGIE.getCoutConstruction(),ListeMerveille.ECOLE_DE_MAGIE.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.GRANDE_MURAILLE.getNom(),ListeMerveille.GRANDE_MURAILLE.getType(),ListeMerveille.GRANDE_MURAILLE.getCoutConstruction(),ListeMerveille.GRANDE_MURAILLE.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.FORGE.getNom(),ListeMerveille.FORGE.getType(),ListeMerveille.FORGE.getCoutConstruction(),ListeMerveille.FORGE.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.HOSPICE.getNom(),ListeMerveille.HOSPICE.getType(),ListeMerveille.HOSPICE.getCoutConstruction(),ListeMerveille.HOSPICE.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.MANUFACTURE.getNom(),ListeMerveille.MANUFACTURE.getType(),ListeMerveille.MANUFACTURE.getCoutConstruction(),ListeMerveille.MANUFACTURE.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.MUSEE.getNom(),ListeMerveille.MUSEE.getType(),ListeMerveille.MUSEE.getCoutConstruction(),ListeMerveille.MUSEE.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.OBSERVATOIRE.getNom(),ListeMerveille.OBSERVATOIRE.getType(),ListeMerveille.OBSERVATOIRE.getCoutConstruction(),ListeMerveille.OBSERVATOIRE.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.PARC.getNom(),ListeMerveille.PARC.getType(),ListeMerveille.PARC.getCoutConstruction(),ListeMerveille.PARC.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.TOUR_DIVOIRE.getNom(),ListeMerveille.TOUR_DIVOIRE.getType(),ListeMerveille.TOUR_DIVOIRE.getCoutConstruction(),ListeMerveille.TOUR_DIVOIRE.getCaracteristique());
		p.ajouter(quartier);
		
		p.melanger();
		plateauDeJeu.setPioche(p);
		return plateauDeJeu;
	}
	
	public static PlateauDeJeu configurationDignitairesSournois(Pioche p, int nbJoueur) {
		
		personnage = new Echevin();
		plateauDeJeu.ajouterPersonnage(personnage);
		personnage = new MaitreChanteuse();
		plateauDeJeu.ajouterPersonnage(personnage);
		personnage = new Sorcier();
		plateauDeJeu.ajouterPersonnage(personnage);
		personnage = new Roi();
		plateauDeJeu.ajouterPersonnage(personnage);
		personnage = new Abee();
		plateauDeJeu.ajouterPersonnage(personnage);
		personnage = new Alchimiste();
		plateauDeJeu.ajouterPersonnage(personnage);
		personnage = new Navigatrice();
		plateauDeJeu.ajouterPersonnage(personnage);
		personnage = new Capitaine();
		plateauDeJeu.ajouterPersonnage(personnage);
		if (nbJoueur > 2) {
			if (nbJoueur >= 5) {
				personnage = new Reine();
			}else {
				personnage = (generateur.nextBoolean()) ? new Artiste() : new Bailli();
			}
			plateauDeJeu.ajouterPersonnage(personnage);
		}
		
		System.out.println("Veuillez entrer votre nom");
		String nom = Interaction.lireUneChaine();
		joueur = new Joueur(nom);
		plateauDeJeu.ajouterJoueur(joueur);
		String IALastName = "";
		for (int i = 0; i < nbJoueur-1; i++) {
			do {
				joueur = new Joueur(JoueurIA.values()[generateur.nextInt(JoueurIA.values().length)].getNom());
			}while(joueur.getNom().equals(IALastName));
			joueur.setSimule(true);
			plateauDeJeu.ajouterJoueur(joueur);
			IALastName = joueur.getNom();
			//Corriger le bug sur les noms des IA
		}
		
		quartier = new Quartier(ListeMerveille.CATACOMBES.getNom(),ListeMerveille.CATACOMBES.getType(),ListeMerveille.CATACOMBES.getCoutConstruction(),ListeMerveille.CATACOMBES.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.CHANTIER.getNom(),ListeMerveille.CHANTIER.getType(),ListeMerveille.CHANTIER.getCoutConstruction(),ListeMerveille.CHANTIER.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.COURS_DES_MIRACLES.getNom(),ListeMerveille.COURS_DES_MIRACLES.getType(),ListeMerveille.COURS_DES_MIRACLES.getCoutConstruction(),ListeMerveille.COURS_DES_MIRACLES.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.ECURIES.getNom(),ListeMerveille.ECURIES.getType(),ListeMerveille.ECURIES.getCoutConstruction(),ListeMerveille.ECURIES.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.DRACOPORT.getNom(),ListeMerveille.DRACOPORT.getType(),ListeMerveille.DRACOPORT.getCoutConstruction(),ListeMerveille.DRACOPORT.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.HOSPICE.getNom(),ListeMerveille.HOSPICE.getType(),ListeMerveille.HOSPICE.getCoutConstruction(),ListeMerveille.HOSPICE.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.NECROPOLE.getNom(),ListeMerveille.NECROPOLE.getType(),ListeMerveille.NECROPOLE.getCoutConstruction(),ListeMerveille.NECROPOLE.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.FORGE.getNom(),ListeMerveille.FORGE.getType(),ListeMerveille.FORGE.getCoutConstruction(),ListeMerveille.FORGE.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.LABORATOIRE.getNom(),ListeMerveille.LABORATOIRE.getType(),ListeMerveille.LABORATOIRE.getCoutConstruction(),ListeMerveille.LABORATOIRE.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.MANUFACTURE.getNom(),ListeMerveille.MANUFACTURE.getType(),ListeMerveille.MANUFACTURE.getCoutConstruction(),ListeMerveille.MANUFACTURE.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.PARC.getNom(),ListeMerveille.PARC.getType(),ListeMerveille.PARC.getCoutConstruction(),ListeMerveille.PARC.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.THEATRE.getNom(),ListeMerveille.THEATRE.getType(),ListeMerveille.THEATRE.getCoutConstruction(),ListeMerveille.THEATRE.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.FONTAINE_AUX_SOUHAITS.getNom(),ListeMerveille.FONTAINE_AUX_SOUHAITS.getType(),ListeMerveille.FONTAINE_AUX_SOUHAITS.getCoutConstruction(),ListeMerveille.FONTAINE_AUX_SOUHAITS.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.NECROPOLE.getNom(),ListeMerveille.NECROPOLE.getType(),ListeMerveille.NECROPOLE.getCoutConstruction(),ListeMerveille.NECROPOLE.getCaracteristique());
		p.ajouter(quartier);
		
		p.melanger();
		plateauDeJeu.setPioche(p);
		return plateauDeJeu;
	}
	
	public static PlateauDeJeu configurationNoblesRetors(Pioche p, int nbJoueur) {
		
		personnage = new Assassin();
		plateauDeJeu.ajouterPersonnage(personnage);
		personnage = new Voleur();
		plateauDeJeu.ajouterPersonnage(personnage);
		personnage = new Magicienne();
		plateauDeJeu.ajouterPersonnage(personnage);
		personnage = new Patricien();
		plateauDeJeu.ajouterPersonnage(personnage);
		personnage = new Cardinal();
		plateauDeJeu.ajouterPersonnage(personnage);
		personnage = new Marchande();
		plateauDeJeu.ajouterPersonnage(personnage);
		personnage = new Navigatrice();
		plateauDeJeu.ajouterPersonnage(personnage);
		personnage = new Condottiere();
		plateauDeJeu.ajouterPersonnage(personnage);
		if (nbJoueur > 2) {
			personnage = new Bailli();
			plateauDeJeu.ajouterPersonnage(personnage);
		}
		
		System.out.println("Veuillez entrer votre nom");
		String nom = Interaction.lireUneChaine();
		joueur = new Joueur(nom);
		plateauDeJeu.ajouterJoueur(joueur);
		String IALastName = "";
		for (int i = 0; i < nbJoueur-1; i++) {
			do {
				joueur = new Joueur(JoueurIA.values()[generateur.nextInt(JoueurIA.values().length)].getNom());
			}while(joueur.getNom().equals(IALastName));
			joueur.setSimule(true);
			plateauDeJeu.ajouterJoueur(joueur);
			IALastName = joueur.getNom();
			//Corriger le bug sur les noms des IA
		}
		
		quartier = new Quartier(ListeMerveille.DRACOPORT.getNom(),ListeMerveille.DRACOPORT.getType(),ListeMerveille.DRACOPORT.getCoutConstruction(),ListeMerveille.DRACOPORT	.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.BASILIQUE.getNom(),ListeMerveille.BASILIQUE.getType(),ListeMerveille.BASILIQUE.getCoutConstruction(),ListeMerveille.BASILIQUE.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.MINE_DOR.getNom(),ListeMerveille.MINE_DOR.getType(),ListeMerveille.MINE_DOR.getCoutConstruction(),ListeMerveille.MINE_DOR.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.MONUMENT.getNom(),ListeMerveille.MONUMENT.getType(),ListeMerveille.MONUMENT.getCoutConstruction(),ListeMerveille.MONUMENT.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.MUSEE.getNom(),ListeMerveille.MUSEE.getType(),ListeMerveille.MUSEE.getCoutConstruction(),ListeMerveille.MUSEE.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.ECOLE_DE_MAGIE.getNom(),ListeMerveille.ECOLE_DE_MAGIE.getType(),ListeMerveille.ECOLE_DE_MAGIE.getCoutConstruction(),ListeMerveille.ECOLE_DE_MAGIE.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.FONTAINE_AUX_SOUHAITS.getNom(),ListeMerveille.FONTAINE_AUX_SOUHAITS.getType(),ListeMerveille.FONTAINE_AUX_SOUHAITS.getCoutConstruction(),ListeMerveille.FONTAINE_AUX_SOUHAITS.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.POUDRIERE.getNom(),ListeMerveille.POUDRIERE.getType(),ListeMerveille.POUDRIERE.getCoutConstruction(),ListeMerveille.POUDRIERE.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.LABORATOIRE.getNom(),ListeMerveille.LABORATOIRE.getType(),ListeMerveille.LABORATOIRE.getCoutConstruction(),ListeMerveille.LABORATOIRE.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.STATUE_EQUESTRE.getNom(),ListeMerveille.STATUE_EQUESTRE.getType(),ListeMerveille.STATUE_EQUESTRE.getCoutConstruction(),ListeMerveille.STATUE_EQUESTRE.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.TOUR_DIVOIRE.getNom(),ListeMerveille.TOUR_DIVOIRE.getType(),ListeMerveille.TOUR_DIVOIRE.getCoutConstruction(),ListeMerveille.TOUR_DIVOIRE.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.SALLES_DES_CARTES.getNom(),ListeMerveille.SALLES_DES_CARTES.getType(),ListeMerveille.SALLES_DES_CARTES.getCoutConstruction(),ListeMerveille.SALLES_DES_CARTES.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.TRESOR_IMPERIAL.getNom(),ListeMerveille.TRESOR_IMPERIAL.getType(),ListeMerveille.TRESOR_IMPERIAL.getCoutConstruction(),ListeMerveille.TRESOR_IMPERIAL.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.TRIPOT.getNom(),ListeMerveille.TRIPOT.getType(),ListeMerveille.TRIPOT.getCoutConstruction(),ListeMerveille.TRIPOT.getCaracteristique());
		p.ajouter(quartier);
		
		p.melanger();
		plateauDeJeu.setPioche(p);
		return plateauDeJeu;
	}
	
	public static PlateauDeJeu configurationOligarquesTenaces(Pioche p, int nbJoueur) {
		
		personnage = new Assassin();
		plateauDeJeu.ajouterPersonnage(personnage);
		personnage = new Espion();
		plateauDeJeu.ajouterPersonnage(personnage);
		personnage = new Voyante();
		plateauDeJeu.ajouterPersonnage(personnage);
		personnage = new Roi();
		plateauDeJeu.ajouterPersonnage(personnage);
		personnage = new Cardinal();
		plateauDeJeu.ajouterPersonnage(personnage);
		personnage = new Negociant();
		plateauDeJeu.ajouterPersonnage(personnage);
		personnage = new Archiviste();
		plateauDeJeu.ajouterPersonnage(personnage);
		personnage = new Diplomate();
		plateauDeJeu.ajouterPersonnage(personnage);
		if (nbJoueur > 2) {
			personnage = new Artiste();
			plateauDeJeu.ajouterPersonnage(personnage);
		}
		
		System.out.println("Veuillez entrer votre nom");
		String nom = Interaction.lireUneChaine();
		joueur = new Joueur(nom);
		plateauDeJeu.ajouterJoueur(joueur);
		String IALastName = "";
		for (int i = 0; i < nbJoueur-1; i++) {
			do {
				joueur = new Joueur(JoueurIA.values()[generateur.nextInt(JoueurIA.values().length)].getNom());
			}while(joueur.getNom().equals(IALastName));
			joueur.setSimule(true);
			plateauDeJeu.ajouterJoueur(joueur);
			IALastName = joueur.getNom();
			//Corriger le bug sur les noms des IA
		}
		
		quartier = new Quartier(ListeMerveille.BIBLIOTHEQUE.getNom(),ListeMerveille.BIBLIOTHEQUE.getType(),ListeMerveille.BIBLIOTHEQUE.getCoutConstruction(),ListeMerveille.BIBLIOTHEQUE.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.CARRIERE.getNom(),ListeMerveille.CARRIERE.getType(),ListeMerveille.CARRIERE.getCoutConstruction(),ListeMerveille.CARRIERE.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.COURS_DES_MIRACLES.getNom(),ListeMerveille.COURS_DES_MIRACLES.getType(),ListeMerveille.COURS_DES_MIRACLES.getCoutConstruction(),ListeMerveille.COURS_DES_MIRACLES.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.DONJON.getNom(),ListeMerveille.DONJON.getType(),ListeMerveille.DONJON.getCoutConstruction(),ListeMerveille.DONJON.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.DRACOPORT.getNom(),ListeMerveille.DRACOPORT.getType(),ListeMerveille.DRACOPORT.getCoutConstruction(),ListeMerveille.DRACOPORT.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.ECOLE_DE_MAGIE.getNom(),ListeMerveille.ECOLE_DE_MAGIE.getType(),ListeMerveille.ECOLE_DE_MAGIE.getCoutConstruction(),ListeMerveille.ECOLE_DE_MAGIE.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.FONTAINE_AUX_SOUHAITS.getNom(),ListeMerveille.FONTAINE_AUX_SOUHAITS.getType(),ListeMerveille.FONTAINE_AUX_SOUHAITS.getCoutConstruction(),ListeMerveille.FONTAINE_AUX_SOUHAITS.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.FORGE.getNom(),ListeMerveille.FORGE.getType(),ListeMerveille.FORGE.getCoutConstruction(),ListeMerveille.FORGE.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.LABORATOIRE.getNom(),ListeMerveille.LABORATOIRE.getType(),ListeMerveille.LABORATOIRE.getCoutConstruction(),ListeMerveille.LABORATOIRE.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.MANUFACTURE.getNom(),ListeMerveille.MANUFACTURE.getType(),ListeMerveille.MANUFACTURE.getCoutConstruction(),ListeMerveille.MANUFACTURE.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.SALLES_DES_CARTES.getNom(),ListeMerveille.SALLES_DES_CARTES.getType(),ListeMerveille.SALLES_DES_CARTES.getCoutConstruction(),ListeMerveille.SALLES_DES_CARTES.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.STATUE_EQUESTRE.getNom(),ListeMerveille.STATUE_EQUESTRE.getType(),ListeMerveille.STATUE_EQUESTRE.getCoutConstruction(),ListeMerveille.STATUE_EQUESTRE.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.TRESOR_IMPERIAL.getNom(),ListeMerveille.TRESOR_IMPERIAL.getType(),ListeMerveille.TRESOR_IMPERIAL.getCoutConstruction(),ListeMerveille.TRESOR_IMPERIAL.getCaracteristique());
		p.ajouter(quartier);
		quartier = new Quartier(ListeMerveille.BASILIQUE.getNom(),ListeMerveille.BASILIQUE.getType(),ListeMerveille.BASILIQUE.getCoutConstruction(),ListeMerveille.BASILIQUE.getCaracteristique());
		p.ajouter(quartier);
		
		p.melanger();
		plateauDeJeu.setPioche(p);
		return plateauDeJeu;
	}
}
