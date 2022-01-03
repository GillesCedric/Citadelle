/**
 * 
 */
package modele;

import controlleur.Interaction;

/**
 * @author Badugue Bonnet Igor-Marie
 *
 */
public class Voleur extends Personnage {

	/**
	 * @param nom
	 * @param rang
	 * @param caracteristiques
	 */
	public Voleur() {
		super(Nom.VOLEUR, Rang.VOLEUR, Caracteristiques.VOLEUR);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void utiliserPouvoir() {
		System.out.print("Voila la liste de personnage !");
		for(int i=0; i< this.getPlateau().getNombrePersonnages(); i++) {
			System.out.println(i+1+": "+this.getPlateau().getPersonnage(i).getNom());
		}

	    int choix = Interaction.lireUnEntier(1, this.getPlateau().getNombrePersonnages()+1); 
	    
	    if(this.getPlateau().getPersonnage(choix).getNom().equals(Nom.VOLEUR)) {
	    	System.out.println("Vous ne pouvez pas vous auto-voler ");
	    	
	    }else { 
	    	this.getPlateau().getPersonnage(choix).setVole();
	    	
	    }
	}


	@Override
	public void utiliserPouvoirAvatar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void percevoirRessourcesSpecifiques() {
		// TODO Auto-generated method stub
		super.percevoirRessourcesSpecifiques();
	}
	
	

}
