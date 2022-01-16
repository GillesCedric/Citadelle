/**
 * 
 */
package modele;

import utilities.Caracteristiques;
import utilities.Nom;
import utilities.Rang;

/**
 * @author cedri
 *
 */
public class Alchimiste extends Personnage {

	/**
	 * @param nom
	 * @param rang
	 * @param caracteristiques
	 */
	public Alchimiste() {
		super(Nom.ALCHIMISTE, Rang.ALCHIMISTE, Caracteristiques.ALCHIMISTE);
		// TODO Auto-generated constructor stub
	}

	public void utiliserPouvoir(){
        if(!getAssassine()){
            
        }else if(getJoueur().equals(null)){
            System.out.println("Ce personnage n'a pas été attribué");
        }else{
            System.out.println("Vous avez été assassiné, vous ne pouvez pas utiliser votre pouvoir");
        }
    }

    public void utiliserPouvoirAvatar(){
        if(!getAssassine()){
            
        }else if(getJoueur().equals(null)){
            System.out.println("Ce personnage n'a pas été attribué");
        }else{
            System.out.println("Vous avez été assassiné, vous ne pouvez pas utiliser votre pouvoir");
    }
    }

    @Override
    public void percevoirRessourcesSpecifiques(){
    	
    }
}
