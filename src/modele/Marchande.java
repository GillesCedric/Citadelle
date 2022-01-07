package modele;

import utilities.Caracteristiques;
import utilities.Nom;
import utilities.Rang;

public class Marchande extends Personnage
{
	public Marchande()
	{
		super( Nom.MARCHANDE, Rang.MARCHANDE, Caracteristiques.MARCHANDE);
	}
	public void percevoirRessourcesSpecifiques()
	{
		int i;
		Quartier cit[]= getJoueur().getCite();
		for(i=0; i< getJoueur().nbQuartiersDansCite();i++)
		{
			
			if(cit[i].getType().equals(Quartier.TYPE_QUARTIERS[3]))
			{
				getJoueur().ajouterPieces(1);
			}
		}
	}
	public void utiliserPouvoir()
	{
		getJoueur().ajouterPieces(1);
	}
	@Override
	public void utiliserPouvoirAvatar() {
		utiliserPouvoir();
		
	}
}
