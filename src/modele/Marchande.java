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
		int piece = 0;
		Quartier cit[]= getJoueur().getCite();
		for(i=0; i< getJoueur().nbQuartiersDansCite();i++)
		{
			
			if(cit[i].getType().equals(Quartier.TYPE_QUARTIERS[3]))
			{
				getJoueur().ajouterPieces(1);
				piece++;
			}
			if(cit[i].getNom().equals("Ecole de Magie"))
			{
				getJoueur().ajouterPieces(1);
				piece++;
			}
		}
		System.out.println("Grace à vos quartier religieux et/ou la merveille Ecole de magie vous gagnez : " +piece +"pieces" );
	}
	public void utiliserPouvoir()
	{
		getJoueur().ajouterPieces(1);
		System.out.println("Grace à votre pouvoir vous gagnez une piece d'or");
	}
	@Override
	public void utiliserPouvoirAvatar() {
		utiliserPouvoir();
		
	}
}
