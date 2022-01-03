package modele;


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
		for(i=0; i< getJoueur().nbQuartiersDansCite()-1;i++)
		{
			
			if(cit[i].getType().equals("COMMERCANT"))
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
		// TODO Auto-generated method stub
		
	}
}
