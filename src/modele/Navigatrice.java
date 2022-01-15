/**
 * 
 */
package modele;

import utilities.Caracteristiques;
import utilities.Nom;
import utilities.Rang;

/**
 * @author cedri
 *
 */
public class Navigatrice extends Personnage {

	/**
	 * @param nom
	 * @param rang
	 * @param caracteristiques
	 */
	public Navigatrice() {
		super(Nom.NAVIGATRICE, Rang.NAVIGATRICE, Caracteristiques.NAVIGATRICE);
		// TODO Auto-generated constructor stub
	}

	@Override
	   public void utiliserPouvoir(){
        if(!getAssassine()){
        	System.out.println("Voulez-vous 4 pi�ces (entrez non pour 4 quartiers) ? :");
        	boolean choix = Interaction.lireOuiOuNon();
        	if(choix) {
        		getJoueur().ajouterPieces(4);
        	}
        	else {
        		int compte=0;
        		while(getPlateau().getPioche().nombreElements()>0 && compte<4) {
        			getJoueur().getMain().add(getPlateau().getPioche().piocher());
        			compte++;
        		}
        	}
        }else if(getJoueur().equals(null)){
            System.out.println("Ce personnage n'a pas été attribué");
        }else{
            System.out.println("Vous avez été assassiné, vous ne pouvez pas utiliser votre pouvoir");
        }
    }

    public void utiliserPouvoirAvatar(){
        if(!getAssassine()){
        	Random random = new Random();
        	boolean choix = random.nextBoolean();
        	System.out.println(choix);
        	if(choix) {
        		getJoueur().ajouterPieces(4);
        	}
        	else {
        		int compte=0;
        		while(getPlateau().getPioche().nombreElements()>0 && compte<4) {
        			getJoueur().getMain().add(getPlateau().getPioche().piocher());
        			compte++;
        		}
        	}
        }else if(getJoueur().equals(null)){
            System.out.println("Ce personnage n'a pas été attribué");
        }else{
            System.out.println("Vous avez été assassiné, vous ne pouvez pas utiliser votre pouvoir");
        }
    }

}
