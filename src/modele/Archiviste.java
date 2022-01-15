/**
 * 
 */
package modele;

import utilities.Caracteristiques;
import utilities.Nom;
import utilities.Rang;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author cedri
 *
 */
public class Archiviste extends Personnage {

	/**
	 * @param nom
	 * @param rang
	 * @param caracteristiques
	 */
	public Archiviste() {
		super(Nom.ARCHIVISTE, Rang.ARCHIVISTE, Caracteristiques.ARCHIVISTE);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void utiliserPouvoir() 
	{
		// TODO Auto-generated method stub
		 if(!getAssassine())
		 {
        		System.out.println("Voici les cartes :");
        		int compte = 0;
        		ArrayList<Quartier> puissance = new ArrayList<Quartier>();
            		while(getPlateau().getPioche().nombreElements()>0 && compte<7) 
			{
            			puissance.add(getPlateau().getPioche().piocher());
            			System.out.println((compte+1)+". "+puissance.get(compte).getNom()+" - "+puissance.get(compte).getType()+" - "+puissance.get(compte).getCout());
            			compte ++;
            		}
            		if(compte==0) 
			{
            			System.out.println("La pioche est vide");
            		}
            		else 
			{
            			System.out.println("Quelle carte choississez-vous ?");
            			int choix = Interaction.lireUnEntier(1, compte+1)-1;
            			getJoueur().ajouterQuartierDansMain(puissance.get(choix));
            		}
        	}
		else if(getJoueur().equals(null))
		{
            		System.out.println("Le personnage n'est pas attribué");
        	}
		else
		{
            		System.out.println("Vous avez été assassiné, vous ne pouvez pas utiliser votre pouvoir");
        	}

	}

	@Override
	public void utiliserPouvoirAvatar() 
	{
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		 if(!getAssassine())
		 {
        		System.out.println("Voici les cartes :");
        		int compte = 0;
			Random random = new Random();
        		ArrayList<Quartier> puissance = new ArrayList<Quartier>();
            		while(getPlateau().getPioche().nombreElements()>0 && compte<7) 
			{
            			puissance.add(getPlateau().getPioche().piocher());
            			System.out.println((compte+1)+". "+puissance.get(compte).getNom()+" - "+puissance.get(compte).getType()+" - "+puissance.get(compte).getCout());
            			compte ++;
            		}
            		if(compte==0) 
			{
            			System.out.println("La pioche est vide");
            		}
            		else 
			{
            			System.out.println("Quelle carte choississez-vous ?");
            			int choix = random.nextInt(compte)+1;
            			getJoueur().ajouterQuartierDansMain(puissance.get(choix-1));
            		}
        	}
		else if(getJoueur().equals(null))
		{
            		System.out.println("Le personnage n'est pas attribué");
        	}
		else
		{
            		System.out.println("Vous avez été assassiné, vous ne pouvez pas utiliser votre pouvoir");
        	}

	}

}
