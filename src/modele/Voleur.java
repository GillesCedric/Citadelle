/**
 * 
 */
package modele;

import java.util.Random;

import controlleur.Interaction;
import utilities.Caracteristiques;
import utilities.Nom;
import utilities.Rang;
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
		System.out.print("Voila la liste des personnages !");
		for(int i=0; i< this.getPlateau().getNombrePersonnages(); i++) {
			System.out.println(i+1+": "+this.getPlateau().getPersonnage(i).getNom());
		}

	    int choix = Interaction.lireUnEntier(1, this.getPlateau().getNombrePersonnages()+1); 
	    
	    if(this.getPlateau().getPersonnage(choix).getNom().equals(Nom.VOLEUR) || this.getPlateau().getPersonnage(choix).getRang()==1) {
	    	System.out.println(" Vous ne pouvez pas vous auto-voler ni meme choisir un personnage de rang 1 ");
	    	
	    }else { 
	    	this.getPlateau().getPersonnage(choix).setVole();
	    	
	    }
	}


	@Override
	public void utiliserPouvoirAvatar() {
		Random random = new Random();
		int res = random.nextInt(this.getPlateau().getNombreJoueurs()+1);
		System.out.print("Voila la liste de personnage !");
		for(int i=0; i< this.getPlateau().getNombrePersonnages(); i++) {
			System.out.println(i+1+": "+this.getPlateau().getPersonnage(i).getNom());
		}
		if(this.getPlateau().getPersonnage(res).getNom().equals(Nom.VOLEUR) || this.getPlateau().getPersonnage(res).getRang()==1) {
	    	System.out.println(" Vous ne pouvez pas vous auto-voler ni meme choisir un personnage de rang 1 ");
	    	
	    }else { 
	    	this.getPlateau().getPersonnage(res).setVole();
	    	
	    }
		
	}

	@Override
	public void percevoirRessourcesSpecifiques() {
		// TODO Auto-generated method stub
		super.percevoirRessourcesSpecifiques();
	}
	
	

}
