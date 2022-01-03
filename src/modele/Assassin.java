package modele;

import java.util.Scanner;

import controlleur.Interaction;

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
	
	PlateauDeJeu p= new PlateauDeJeu();
	
	System.out.print("Quel personnage voulez vous assassiner?");
		for(int i=0; i< p.getNombrePersonnages(); i++) {
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
		// TODO Auto-generated method stub
		
	}

}
