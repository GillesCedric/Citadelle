package modele;


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
	@Override
	public void utiliserPouvoirAvatar() {
		// TODO Auto-generated method stub
		
	}
}
