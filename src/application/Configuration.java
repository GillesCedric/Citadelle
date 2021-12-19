/**
 * 
 */
package application;

import java.util.Random;

import controlleur.Interaction;
import modele.Assassin;
import modele.Eveque;
import modele.Joueur;
import modele.JoueurIA;
import modele.ListeMerveille;
import modele.ListeQuartier;
import modele.Magicienne;
import modele.Marchande;
import modele.Personnage;
import modele.Pioche;
import modele.PlateauDeJeu;
import modele.Quartier;
import modele.Roi;

/**
 * @author Gilles Cédric
 *
 */
public class Configuration {
	
	public static Pioche nouvellePioche() {
		Pioche pioche = new Pioche();
		for (ListeQuartier quartier : ListeQuartier.values()) {
			for (int i = 0; i < quartier.getNbMax(); i++) {
				Quartier q = new Quartier(quartier.getNom(),quartier.getType(),quartier.getCoutConstruction());
				pioche.ajouter(q);
			}
		}
		return pioche;
	}
	
	public static PlateauDeJeu configurationDeBase(Pioche p) {
		Random generateur = new Random();
		PlateauDeJeu plateauDeJeu = new PlateauDeJeu();
		Joueur joueur = null;
		Personnage personnage = null;
		Quartier quartier = null;
		
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
		
		for (int i = 0; i < 3; i++) {
			joueur = new Joueur(JoueurIA.values()[generateur.nextInt(JoueurIA.values().length)].getNom());
			plateauDeJeu.ajouterJoueur(joueur);
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
}
