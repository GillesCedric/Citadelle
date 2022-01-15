/**
 * 
 */
package utilities;

import java.util.Random;

import controlleur.Interaction;
import modele.PlateauDeJeu;
import modele.Quartier;

/**
 * @author Gilles Cédric
 *
 */
public class Merveille {
	private static PlateauDeJeu plateauDeJeu = null;
	private static Random random = new Random();
	private static int score = 0;
	

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
	
	public static void effetForge(int personnage) 
	{
		//Parcours de la cité du Joueur afin de déternminé si le joueur possède la Merveille Forge
		if(Merveille.isExist(personnage, ListeMerveille.FORGE.getNom()))
		{
			System.out.println("Voulez vous payez deux pieces d'or pour piocher trois cartes ? ");
			boolean choix;
			if (!plateauDeJeu.getPersonnage(personnage).getJoueur().isSimule())
				choix = Interaction.lireOuiOuNon();
			else 
			{
				//sinon on génère un nombre aléatoire qui correspond au choix de l'ordinateur
				choix = random.nextInt(2) == 1;
			}
			if(choix)
			{
				if(plateauDeJeu.getPersonnage(personnage).getJoueur().nbPieces() >= 2)
				{
					plateauDeJeu.getPersonnage(personnage).getJoueur().retirerPieces(2);
					Quartier[] quartiers = new Quartier[3];
					for (int i = 0; i < quartiers.length; i++) 
					{
						quartiers[i] = plateauDeJeu.getPioche().piocher();
					}
					System.out.println("Voici les cartes que vous avez pioché : ");
					for (int i = 0; i < quartiers.length; i++) 
					{
						System.out.println((i + 1) + " " + quartiers[i].getNom() + " - type : "
							+ quartiers[i].getType() + " - pièces : " + quartiers[i].getCout());
					}
				}
				else
					System.out.println("Vous ne possédez pas assez de pièces pour utiliser cet effet");
				}
			}
	}
	//Fin de l'implémentation de l'effet Forge
	public static void effetLaboratoire(int personnage) 
	{
		if(Merveille.isExist(personnage, ListeMerveille.LABORATOIRE.getNom()))
		{
			System.out.println("Voulez vous vous défaussez d'une carte de votre main pour percevoir deux pièces d'or supplémentaires? ");
			boolean choix;
			if (!plateauDeJeu.getPersonnage(personnage).getJoueur().isSimule())
				choix = Interaction.lireOuiOuNon();
			else 
			{
				//sinon on génère un nombre aléatoire qui correspond au choix de l'ordinateur
				choix = random.nextInt(2) == 1;
			}
			if(choix)
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
	//Fin de l'implémentation de l'effet Laboratoire

	public static int effetSalleDesCartes(int i) {
		int score = 0;
		//Implémentatioon de l'augmentation du score pour chaque carte dans la main du joueur
		if(Merveille.isExist(i, ListeMerveille.SALLES_DES_CARTES.getNom()))
		{
			for (int j = 0; j < plateauDeJeu.getJoueur(i).nbQuartiersDansMain(); j++) 
			{
				score++;
			}
		}
		return score;
	}
	//Debut de l'implémentation dde l'effet Basilique 
	
	public static int effetBasilique(int i)
	{
		int score;
		if(Merveille.isExist(i, ListeMerveille.BASILIQUE.getNom()))
		{
			for (int j = 0; j < plateauDeJeu.getJoueur(i).nbQuartiersDansCite(); j++)
			{
				if(!(plateauDeJeu.getJoueur(i).getCite()[j].getCout() % 2 == 0))
					score ++;
			}
		}
		
	}
	
	//Fin de l'implémentation dde l'effet Basilique 
	
	//Debut de l'implémentation dde l'effet Capitole 
	
	public static int effetCapitole(int i) 
	{
		int score;
		if(Merveille.isExist(i, ListeMerveille.CAPITOLE.getNom()))
		{
			int nbReli;
			int nbCom;
			int nbMer;
			int nbMili;
			int nbNoble;
			for (int j = 0; j < plateauDeJeu.getJoueur(i).nbQuartiersDansCite(); j++) 
			{
				if(plateauDeJeu.getJoueur(i).getCite()[j].getType().equals(Quartier.TYPE_QUARTIERS[0])
					nbReli++;
				if(plateauDeJeu.getJoueur(i).getCite()[j].getType().equals(Quartier.TYPE_QUARTIERS[1])
					nbMili++;
				if(plateauDeJeu.getJoueur(i).getCite()[j].getType().equals(Quartier.TYPE_QUARTIERS[2])
					nbNoble++;
				if(plateauDeJeu.getJoueur(i).getCite()[j].getType().equals(Quartier.TYPE_QUARTIERS[3])
					nbCom++;
				if(plateauDeJeu.getJoueur(i).getCite()[j].getType().equals(Quartier.TYPE_QUARTIERS[4])
					nbMer++;
				if((nbReli >= 3 ) || (nbCom >= 3 ) || (nbMer >= 3 ) || (nbMili >= 3 ) || (nbNoble >= 3 ) )
				{
					score += 3;	
					return score;
				}
				   
			}
			
		}
	}	
	
	//Fin de l'implémentation dde l'effet Capitole 
	
	//Debut de l'implémentation dde l'effet CATACOMBES 
				   
	public static int effetCatacombes(int i) 
	{
		int score;
		if(Merveille.isExistDansMain(i, ListeMerveille.CATACOMBES.getNom()))	
		{
			score += 3;
			return score;
		}
				   
	//Fin de l'implémentation dde l'effet CATACOMBES
	
	//Début de l'effet Mine d'Or 
	
	public static int effetMineDor(int i)
	{
		if(Merveille.isExist(i, ListeMerveille.MINE_DOR.getNom()))
		{
			System.out.println("Grace à votre Merveille Mine d'Or vous recevez une piece d'or de plus");
			plateauDeJeu.getJoueur(j).ajouterPieces(1);
		}
	}
		
	//Fin de l'effetMine d'Or
	
	//Début de l'implémentation de l'effet Observatoire
		
	public static int effetObservatoire(int i)
	{
		if(Merveille.isExist(i, ListeMerveille.OBSERVATOIRE.getNom()))
		{
			System.out.println("Grace à votre Merveille OBSERVATOIRE vous pouvez piocher 3 cartes plutot que 2 et en choisir une");
			Quartier[] quartiers = new Quartier[3];
			for (int i = 0; i < quartiers.length; i++) 
			{
				quartiers[i] = plateauDeJeu.getPioche().piocher();
			}
			System.out.println("Voici les cartes que vous avez pioché : ");
			for (int i = 0; i < quartiers.length; i++) 
			{
				System.out.println((i + 1) + " " + quartiers[i].getNom() + " - type : "
							+ quartiers[i].getType() + " - pièces : " + quartiers[i].getCout());
			}
			
		}
	}
		
	//Fin de l'implémentation de l'effet Observatoire
		
	//Début de l'implémentation de l'effet Tour d'Ivoire
		
	public static int effetTourIvoire(int i) 
	{
		int score = 0;
		int nbMerveille == 0; 
		if(Merveille.isExist(i, ListeMerveille.TOUR_DIVOIRE.getNom()))
		{
			for (int j = 0; j < plateauDeJeu.getJoueur(i).nbQuartiersDansCite(); j++) 
			{
				for (ListeMerveille merveille : ListeMerveille.values())
				{
					if(plateauDeJeu.getJoueur(i).getCite()[j].getNom().equals(merveille.getNom()))
					{
						if(plateauDeJeu.getJoueur(i).getCite()[j].getNom().equals("COURS_DES_MIRACLES"))
						{
							if(!plateauDeJeu.getJoueur(i).getCite()[j].getType().equals(Quartier.TYPE_QUARTIERS[4]))
								continue;
						}
						if(plateauDeJeu.getJoueur(i).getCite()[j].getNom().equals("TOUR_DIVOIRE"))
							continue;
						
						 nbMerveille ++;
					}
				}
				if( nbMerveille >= 1)
					return score;
				if(nbMerveille == 0)
				{
					score += 5;
					return score;
				}
				
			}
		}
	}
		
	//Fin de l'implémentation de l'effet Tour d'Ivoire
	
	//Début de l'implémentation de l'effet Monument
		
	public static void effetMonument (int i)
	{
		//la restriction de construction du Monument sera implémentée dans tour de Jeu
		if(Merveille.isExist(i, ListeMerveille.MONUMENT.getNom()))
			plateauDeJeu.getPersonnage(personnage).getJoueur().nbQuartiersDansCite() ++;
	}
		
	//Fin de l'implémentation de l'effet Monument
		
	//Début de l'implémentation de l'effet Cour des Miracles
		
	public static int effetCourDesMiracles (int i)
	{
		System.out.println("Quel type désirez vous avoir pour la Cour des Miracles ?");
		for(i=0; i < 4; i++)
		{
			System.out.println( i+1 "  "+Quartier.TYPE_QUARTIER[i]);
		}
		choix = Interaction.lireUnEntier(1, 4);
		if(! choix == 0)
		{
			if(choix==1)
			{
				ListeMerveille.settype
			}
		}
	}
		
	//Fin de l'implémentation de l'effet Cour des Miracles
		
	// Debut de l'effet Dracoport
		
	public static int effetDracoport(int i)
	{
		int score;
		if(Merveille.isExist(i, ListeMerveille.DRACOPORT.getNom()))
		{
			score++;
		}
	}
		
	//Fin de l'effet Dracoport
		
	//Début de l'effet Ecole de Magie
		
	public static void efetEcoleDeMagie(int i)
	{
		if(Merveille.isExist(i, ListeMerveille.ECOLE_DE_MAGIE.getNom()))
		{
			System.out.println("Quel type désirez vous avoir pour l'ECOLE DE MAGIE ?");
			for(i=0; i < 4; i++)
			{
				System.out.println( i+1 "  "+Quartier.TYPE_QUARTIER[i]);
			}
			choix = Interaction.lireUnEntier(1, 4);
		}
	
	}
	
	//Fin de l'effet Ecole Magie
	public static int effetFontaineAuxSouhaits(int i) {
		// la somme des différents bonus des merveilles de sa cité
		int score = 0;
		//Implémentatioon de l'augmentation du score pour chaque carte dans la main du joueur
		if(Merveille.isExist(i, ListeMerveille.FONTAINE_AUX_SOUHAITS.getNom()))
		{
			for (int j = 0; j < plateauDeJeu.getJoueur(i).nbQuartiersDansMain(); j++) 
			{
				for (ListeMerveille merveille : ListeMerveille.values())
				{
					if(plateauDeJeu.getJoueur(j).getCite()[i].getNom().equals(merveille.getNom()))
						score++;
				}
			}
		}
		return score;
	}
	
	public static void effetBibliotheque(int personnage, Quartier[] quartiers) {
		//Parcours de la cité du Joueur afin de déternminé si le joueur possède la Merveille Forge
		if(Merveille.isExist(personnage, ListeMerveille.BIBLIOTHEQUE.getNom()))
		{
			System.out.println("Quelle carte voulez vous gardez ? : ");
			int carte = 0;
			if (!plateauDeJeu.getPersonnage(personnage).getJoueur().isSimule())
				carte = Interaction.lireUnEntier(1, 3);
			else {
				do {
					carte = random.nextInt(3);
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
	
	//Methode permetant de vérifier si une merveille existe dans la cité d'un joueur	
	private static boolean isExist(int personnage, String name) 
	{
		//Parcours de la cité du joueur afin de déterminer si il possède la merveille 
		for (int j = 0; j < plateauDeJeu.getPersonnage(personnage).getJoueur().nbQuartiersDansCite(); j++) 
		{
			if(plateauDeJeu.getPersonnage(personnage).getJoueur().getMain().get(j).getNom().equals(name))
			{
				return true;
			}
		}
		return false;
	}
	
	//Methode permetant de vérifier si une merveille existe dans la main d'un joueur
	private static boolean isExistDansMain(int personnage, String name) 
	{
		//Parcours de la cité du joueur afin de déterminer si il possède la merveille 
		for (int j = 0; j < plateauDeJeu.getPersonnage(personnage).getJoueur().nbQuartiersDansMain(); j++) 
		{
			if(plateauDeJeu.getPersonnage(personnage).getJoueur().getMain().get(j).getNom().equals(name))
			{
				return true;
			}
		}
		return false;
	}
	
	
		
	public static int effetTrésorImpérial(int i) 
	{
			

			if(Merveille.isExist(i, ListeMerveille.TRESOR_IMPERIAL.getNom()))
			{
				for (int j = 0; j < plateauDeJeu.getJoueur(i).nbQuartiersDansMain(); j++) 
				{
					//parcours du trésor du joueur
					for (int k=0; k < plateauDeJeu.getJoueur(j).nbPieces(); k++) {
						
						score++;
					}
			}
				
			return score;
			
		} else {
			
			return score;
		}	
	}
		
		


public static int effetStatueEquestre(int i) {
	

	if(Merveille.isExist(i, ListeMerveille.STATUE_EQUESTRE.getNom()))
	{
       if (plateauDeJeu.getJoueur(i).getPossedeCouronne()) {
    	   
    	   score = score + 5;
       }

		
	return score;
	
} else {
	
	return score;
}
			
		
}		
		
}