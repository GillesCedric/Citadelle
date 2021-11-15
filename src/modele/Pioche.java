import java.util.*;
public class Pioche
{
	private LinkedList <Quartier> listPioche = new LinkedList(); /* */
	public void setlistPioche(LinkedList neuve)
	{
		this.listPioche= neuve;
	}
	public LinkedList getlistPioche()
	{
		return  listPioche;
	}
	public Pioche()
	{
		 LinkedList <Quartier> listPioche = new LinkedList();
	}
	public Quartier Piocher()
	{
		if(listPioche.size()>1)
		{
			return listPioche.get(((listPioche.size())-1));  /*Retourne le dernier élément de la liste */
		}
		else
			return null;
	}
	public void ajouter(Quartier nouveau)
	{
		listPioche.addFirst(nouveau);
	}
	public int nombreElements()
	{
		return listPioche.size();
	}
	
	public void melanger() 
	{
		 Random generateur = new Random();
		 for (int i = 0; i < listPioche.size(); i++) {
			int a = generateur.nextInt();
			int b = generateur.nextInt();
			 
			Quartier quartier = listPioche.get(a);
			listPioche.set(a, listPioche.get(b));
			listPioche.set(b, quartier);
			
		}

	}
}
