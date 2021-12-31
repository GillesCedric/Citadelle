package modele;

import java.util.Scanner;

/**
*
* @author Badugue Bonnet Igor-M
* 
*/

public class Assassin extends Personnage {

	public Assassin() {
		super("", 0, "");
		
	}

	@Override
	public void utiliserPouvoir() {
	
	PlateauDeJeu p= new PlateauDeJeu();
	 int n=0;
	p= getPlateau();
	
		for(int i=0; i< p.getNombrePersonnages(); i++) {
			
			n+=n;
			System.out.println(n+":"+p.getListePersonnages(i).getNom());
			n++;
		}
		
		System.out.print("Votre choix :");
		
		Scanner sc = new Scanner(System.in);  // Create a Scanner object
	    

	    int choix = sc.nextInt(); 
	    
	    if(p.getListePersonnages(choix).getNom()=="Assassin") {
	    	System.out.println("Vous ne pouvez pas vous assassiner ");
	    	
	    }else { System.out.println("Votre choix :");
	    	p.getListePersonnages(choix).remove();
	    	
	    }

		
	}

}
