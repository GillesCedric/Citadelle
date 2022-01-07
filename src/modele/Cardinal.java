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
public class Cardinal extends Personnage {

	/**
	 * @param nom
	 * @param rang
	 * @param caracteristiques
	 */
	public Cardinal() {
		super(Nom.CARDINAL, Rang.CARDINAL, Caracteristiques.CARDINAL);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void utiliserPouvoir() 
	{
		// TODO Auto-generated method stub
		

	}
	public void percevoirRessourcesSpecifiques()
	{
		int i;
		Quartier cit[]= getJoueur().getCite();
		for(i=0; i< getJoueur().nbQuartiersDansCite();i++)
		{
			
			if(cit[i].getType().equals(Quartier.TYPE_QUARTIERS[0]))
			{
				getJoueur().ajouterPieces(1);
			}
		}
	}
	@Override
	public void utiliserPouvoirAvatar() {
		// TODO Auto-generated method stub

	}

}
