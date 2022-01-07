package modele;

import utilities.Caracteristiques;
import utilities.Nom;
import utilities.Rang;

public class Eveque extends Personnage
{
	public Eveque()
	{
		super( Nom.EVEQUE, Rang.EVEQUE, Caracteristiques.EVEQUE);
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
	public void utiliserPouvoir()
	{
	}
	@Override
	public void utiliserPouvoirAvatar() {
		// TODO Auto-generated method stub
		
	}
}
