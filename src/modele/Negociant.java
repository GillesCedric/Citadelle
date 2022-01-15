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
public class Negociant extends Personnage {

	/**
	 * @param nom
	 * @param rang
	 * @param caracteristiques
	 */
	public Negociant() {
		super(Nom.NEGOCIANT, Rang.NEGOCIANT, Caracteristiques.NEGOCIANT);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void utiliserPouvoir() {
		// TODO Auto-generated method stub

	}

	@Override
	public void utiliserPouvoirAvatar() {
		// TODO Auto-generated method stub

	}
	@Override
	 public void percevoirRessourcesSpecifiques()
	 {
    		if(!getAssassine())
    		{ 
        	System.out.println("    Perception des ressources spécifiques");
        	Quartier[] cite = getJoueur().getCite();
            	int count=0;
            for(int i=0; i < cite.length;i++){
                if(cite[i] != null && cite[i].getType().equals("COMMERCANT")){
                    count++;
                }
                if(cite[i] != null && cite[i].getNom().equals("Ecole de Magie")){
                    count +=1;
                    System.out.println("L'école de magie vous rapprote 1 piece de plus");

                }
            }

            getJoueur().ajouterPieces(count);
	 
	}
    }

}
