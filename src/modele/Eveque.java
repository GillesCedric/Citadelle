package modele;


public class Eveque extends Personnage
{
	public Eveque(String nom, int rang, String caracteristiques)
	{
		super( nom, rang, caracteristiques);
	}
	public void percevoirRessourcesSpecifiques()
	{
		int i;
		Quartier cit[]= getJoueur().getCite();
		for(i=0; i< getJoueur().nbQuartiersDansCite()-1;i++)
		{
			
			if(cit[i].getType().equals("RELIGIEUX"))
			{
				getJoueur().ajouterPieces(1);
			}
		}
	}
	public void utiliserPouvoir()
	{
	}
}
