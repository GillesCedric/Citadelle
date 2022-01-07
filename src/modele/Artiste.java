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
public class Artiste extends Personnage {

	/**
	 * @param nom
	 * @param rang
	 * @param caracteristiques
	 */
	public Artiste() {
		super(Nom.ARTISTE, Rang.ARTISTE, Caracteristiques.ARTISTE);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void utiliserPouvoir() {
		// TODO Auto-generated method stub

	}

	@Override
	public void utiliserPouvoirAvatar() {
		// TODO Auto-generated method stub

	}

}
