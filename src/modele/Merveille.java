/**
 * 
 */
package modele;

import java.util.Random;

import controlleur.Interaction;

/**
 * @author Gilles Cédric
 *
 */
public class Merveille {
	private static PlateauDeJeu plateauDeJeu = null;
	
	

	/**
	 * @param plateauDeJeu the plateauDeJeu to set
	 */
	public static void setPlateauDeJeu(PlateauDeJeu plateauDeJeu) {
		Merveille.plateauDeJeu = plateauDeJeu;
	}

	/**
	 * @param args
	 */
	public static void effetManufacture(int personnage, int carte) {
		if(Merveille.isExist(personnage, ListeMerveille.MANUFACTURE.getNom()))
		{
				for (ListeMerveille merveille : ListeMerveille.values()) 
				{
					if(plateauDeJeu.getPersonnage(personnage).getJoueur().getMain().get(carte - 1).getNom().equals(merveille.getNom()))
						plateauDeJeu.getPersonnage(personnage).getJoueur().getMain().get(carte - 1).setCout(plateauDeJeu.getPersonnage(personnage).getJoueur().getMain().get(carte - 1).getCout()-1);;
				}
		}
	}
	
	public static void effetForge(int personnage) {
		int nbCartesPiocher = 2;
		//Parcours de la citÃ© du Joueur afin de dÃ©ternminÃ© si le joueur possÃ¨de la Merveille Forge
		if(Merveille.isExist(personnage, ListeMerveille.FORGE.getNom()))
		{
			System.out.println("Voulez vous payez deux pieces d'or pour piocher une carte de plus? ");
			boolean choix = Interaction.lireOuiOuNon();
			if(choix)
			{
				if(plateauDeJeu.getPersonnage(personnage).getJoueur().nbPieces() >= 2)
				{
					plateauDeJeu.getPersonnage(personnage).getJoueur().retirerPieces(2);
					nbCartesPiocher = 3;
				}
				else
					System.out.println("Vous ne possÃ©dez pas assez de piÃ¨ces pour utiliser cet effet");
			}
		}
	}
	
	public static void effetLaboratoire(int personnage) {
		if(Merveille.isExist(personnage, ListeMerveille.LABORATOIRE.getNom()))
		{
			System.out.println("Voulez vous vous dÃ©faussez d'une carte de votre main pour percevoir deux piÃ¨ces d'or supplÃ©mentaires? ");
			boolean choice = Interaction.lireOuiOuNon();
			if(choice)
			{
				if(plateauDeJeu.getPersonnage(personnage).getJoueur().nbQuartiersDansMain() >= 0)
				{
					plateauDeJeu.getPersonnage(personnage).getJoueur().retirerQuartierDansMain();
					plateauDeJeu.getPersonnage(personnage).getJoueur().ajouterPieces(2);
				}
				else
					System.out.println("Vous n'avez pas de cartes dans votre main vous ne pouvez donc pas activer l'effet de cette merveille ");
			}
		}
	}
	
	public static int effetSalleDesCartes(int i) {
		int score = 0;
		//ImplÃ©mentatioon de l'augmentation du score pour chaque carte dans la main du joueur
		if(Merveille.isExist(i, ListeMerveille.SALLES_DES_CARTES.getNom()))
		{
			for (int j = 0; j < plateauDeJeu.getJoueur(i).nbQuartiersDansMain(); j++) 
			{
				score++;
			}
		}
		return score;
	}
	
	public static int effetFontaineAuxSouhaits(int i) {
		// la somme des diffÃ©rents bonus des merveilles de sa citÃ©
		int score = 0;
		//ImplÃ©mentatioon de l'augmentation du score pour chaque carte dans la main du joueur
		if(Merveille.isExist(i, ListeMerveille.FONTAINE_AUX_SOUHAITS.getNom()))
		{
			for (int j = 0; j < plateauDeJeu.getJoueur(i).nbQuartiersDansMain(); j++) 
			{
				for (ListeMerveille merveille : ListeMerveille.values()) {
					if(plateauDeJeu.getJoueur(j).getCite()[i].getNom().equals(merveille.getNom()))
						score++;
				}
			}
		}
		return score;
	}
	
	public static void effetBibliotheque(int personnage, Quartier[] quartiers) {
		//Parcours de la citÃ© du Joueur afin de dÃ©ternminÃ© si le joueur possÃ¨de la Merveille Forge
		if(Merveille.isExist(personnage, ListeMerveille.BIBLIOTHEQUE.getNom()))
		{
			System.out.println("Quelle carte voulez vous gardez ? : ");
			int carte = 0;
			if (!plateauDeJeu.getPersonnage(personnage).getJoueur().isSimule())
				carte = Interaction.lireUnEntier(1, 3);
			else {
				do {
					carte = new Random().nextInt(3);
				} while (carte == 0);
			}
			plateauDeJeu.getPersonnage(personnage).ajouterQuartier(quartiers[carte-1]);
			for (int i = 0; i < quartiers.length; i++) {
				if (!quartiers[carte-1].getNom().equals(quartiers[i].getNom())) {
					plateauDeJeu.getPioche().ajouter(quartiers[i]);
					break;
				}
			}
		}else {
			System.out.println("Grâce à  votre Merveille Bibliothèque, vous gardez vos deux cartes!");
			for (int i = 0; i < quartiers.length; i++) {
				plateauDeJeu.getPersonnage(personnage).ajouterQuartier(quartiers[i]);
			}
		}
	}
	
	private static boolean isExist(int personnage, String name) {
		//ImplÃ©mentation de la Merveille Manufacture
		//Parcours de la citÃ© du joueur afin de dÃ©terminer si il possÃ¨de la merveille Manufacture
		for (int j = 0; j < plateauDeJeu.getPersonnage(personnage).getJoueur().nbQuartiersDansMain(); j++) 
		{
			if(plateauDeJeu.getPersonnage(personnage).getJoueur().getMain().get(j).getNom().equals(name))
			{
				return true;
			}
		}
		return false;
	}

}
