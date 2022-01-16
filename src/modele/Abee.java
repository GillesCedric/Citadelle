/**
 * 
 */
package modele;

import utilities.Caracteristiques;
import utilities.Nom;
import utilities.Rang;
import java.util.ArrayList;

import controlleur.Interaction;
/**
 * @author cedric
 *
 */
public class Abee extends Personnage {

	/**
	 * @param nom
	 * @param rang
	 * @param caracteristiques
	 */
	public Abee() {
		super(Nom.ABBE, Rang.ABBE, Caracteristiques.ABBE);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void utiliserPouvoir() 
	{
		// TODO Auto-generated method stub
		int i,j,k;
		ArrayList <Integer> richestMultiple = new ArrayList();
		int richest = 0;
		for( i=0; i < this.getPlateau().getNombreJoueurs(); i++)
		{
			if( this.getPlateau().getJoueur(i).nbPieces() > this.getPlateau().getJoueur(richest).nbPieces() )
				richest = i;
		}
		for( j=0; i < this.getPlateau().getNombreJoueurs(); j++)
		{
			if( this.getPlateau().getJoueur(j).nbPieces() == this.getPlateau().getJoueur(richest).nbPieces() )
				richestMultiple.add(j);
		}
		if(this.getPlateau().getJoueur(richest).nbPieces() > this.getJoueur().nbPieces())
		{
			if(richestMultiple.size()>1)
			{
				System.out.println(" Les joueurs les plus riches sont : ");
				for(k=0; k<richestMultiple.size(); k++)
				{
					System.out.println(" Joueur" +(richestMultiple.get(k) + 1));
				}
				System.out.println(" Chez quel joueur voulez vous prendre une piece d'or ? : ");
				int choix = Interaction.lireUnEntier();
				System.out.println(" Le joueur" +choix +" vous donne une piece d'or.");
				this.getPlateau().getJoueur(choix-1).retirerPieces(1);
				this.getJoueur().ajouterPieces(1);
			}
			else
			{
				System.out.println(" Le joueur le plus riche vous donne une piece d'or. ");
				this.getPlateau().getJoueur(richest).retirerPieces(1);
				this.getJoueur().ajouterPieces(1);
			}
		}
		else
			System.out.println(" Vous êtes le joueur le plus riche, vous ne recevez donc ps de piece d'or d'un autre joueur. ");
		for(i=0; i< getJoueur().nbQuartiersDansCite();i++)
		{
			
			if( getJoueur().getCite()[i].getType().equals(Quartier.TYPE_QUARTIERS[0]))
			{
				System.out.println( (i+1) +" quartier de type religieux reperé ");
				System.out.println(" Grace à celui ci vous pouvez : soit piocher une carte ou recevoir une piece d'or ");
				System.out.println(" Vous voulez piocher une carte ? ");
				boolean choix = Interaction.lireOuiOuNon();
				if(choix)
				{
					Quartier gift = new Quartier();
					gift = this.getPlateau().getPioche().piocher();
					this.getJoueur().ajouterQuartierDansMain(gift);
				}
				else
				{
					System.out.println(" Vous recevez donc une piece d'or ");
					this.getJoueur().ajouterPieces(1);
				}
			}
		}
		   
	}

	@Override
	public void utiliserPouvoirAvatar() {
		// TODO Auto-generated method stub

	}

}
