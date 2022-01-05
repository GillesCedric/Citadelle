package modele;

import java.util.Random;
import java.util.Scanner;
import controlleur.Interaction;
import utilities.Nom;

/**
*
* @author Badugue Bonnet Igor-M
* 
*/

public class Assassin extends Personnage {

	public Assassin() {
		super(Nom.ASSASSIN, Rang.ASSASSIN, Caracteristiques.ASSASSIN);

	}

	@Override
	public void utiliserPouvoir() {
	
	System.out.print("voila la liste de personnage de jeu");
		for(int i=0; i< this.getPlateau().getNombrePersonnages(); i++) {
			System.out.println(i+1+": "+this.getPlateau().getPersonnage(i).getNom());
		}

	    int choix = Interaction.lireUnEntier(1, this.getPlateau().getNombrePersonnages()+1); 
	    
	    if(this.getPlateau().getPersonnage(choix).getNom().equals(Nom.ASSASSIN)) {
	    	System.out.println("Vous ne pouvez pas vous assassiner ");
	    	
	    }else { 
	    	this.getPlateau().getPersonnage(choix).setAssassine();
	    	
	    }
	}

	@Override
	public void utiliserPouvoirAvatar() {
		Random random = new Random();
		int res = random.nextInt(this.getPlateau().getNombreJoueurs()+1);
		System.out.print("Voila la liste des personnages !");
		for(int i=0; i< this.getPlateau().getNombrePersonnages(); i++) {
			System.out.println(i+1+": "+this.getPlateau().getPersonnage(i).getNom());
		}
		if(this.getPlateau().getPersonnage(res).getNom().equals(Nom.ASSASSIN)) {
	    	System.out.println(" Vous ne pouvez pas vous auto-assassiner");
	    	
	    }else { 
	    	this.getPlateau().getPersonnage(res).setAssassine();
	    	
	    }
		
	}
		
	

}
