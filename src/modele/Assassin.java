package modele;

import java.util.Scanner;

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
	 int n=0;
	
		for(int i=0; i< p.getNombrePersonnages(); i++) {
			
			n+=n;
			System.out.println(n+":"+this.getPlateau().getPersonnage(i).getNom().getNom());
			n++;
		}
		
		System.out.print("Votre choix :");
		
		Scanner sc = new Scanner(System.in);  // Create a Scanner object
	    s

	    int choix = sc.nextInt(); 
	    
	    if(this.getPlateau().getPersonnage(choix).getNom()=="Assassin") {
	    	System.out.println("Vous ne pouvez pas vous assassiner ");
	    	
	    }else { 
	    	this.getPlateau().setAssassin();
	    	
	    }

		
	}

	@Override
	public void utiliserPouvoirAvatar() {
		// TODO Auto-generated method stub
		
	}

}
