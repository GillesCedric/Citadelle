import java.util.*;

public class Pioche
{
	private ArrayList <Quartier> listPioche = new ArrayList(); 
	public void setlistPioche(ArrayList neuve)
	{
		this.listPioche= neuve;
	}
	public ArrayList getlistPioche()
	{
		return  listPioche;
	}
	public Pioche()
	{
		 ArrayList <Quartier> listPioche = new ArrayList();
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
		listPioche.add(nouveau);
	}
	public int nombreElements()
	{
		return listPioche.size();
	}
	
	public void melanger() 
	{
		 Collections.reverse(listPioche);
	}
}
