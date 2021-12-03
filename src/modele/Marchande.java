
public class Marchande extends Personnage
{
	public Marchande(String nom, int rang, String caracteristiques)
	{
		super( nom, rang, caracteristiques);
	}
	public void percevoirRessourcesSpecifiques()
	{
		int i;
		Quartie cit[]= getJoueur().getCite();
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
		if(getRang()>=8)
		{
			getJoueur().ajouterPieces(1);
		}
		else
			System.out.println("Rang 8 minimum exigé");
	}
}
