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
public class Empereur extends Personnage {

	/**
	 * @param nom
	 * @param rang
	 * @param caracteristiques
	 */
	public Empereur() {
		super(Nom.EMPEREUR, Rang.EMPEREUR, Caracteristiques.EMPEREUR);
		// TODO Auto-generated constructor stub
	}
	public void percevoirRessourcesSpecifiques()
	{
		int piece = 0;
		if (super.getJoueur() != null) 
		{
			Quartier[] cite = super.getJoueur().getCite();
			for (int i = 0; i<cite.length ; i++) 
			{
				if (cite[i] != null && cite[i].getType().equals(TYPE_QUARTIERS[2]))
				{
					piece += 1;
				}
				if(cite[i] != null && cite[i].getNom().equals("Ecole de Magie"))
				{
					piece +=1;
				}
			}
			System.out.println(" Vous gagnez " +piece +" en plus grace à vos quartier nobles et à la merveille Ecole de magie");
			super.getJoueur().ajouterPieces(piece);
		}
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
