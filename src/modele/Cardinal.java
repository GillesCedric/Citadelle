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
public class Cardinal extends Personnage {

	/**
	 * @param nom
	 * @param rang
	 * @param caracteristiques
	 */
	public Cardinal() {
		super(Nom.CARDINAL, Rang.CARDINAL, Caracteristiques.CARDINAL);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void utiliserPouvoir() 
	{
		// TODO Auto-generated method stub
		

	}
	 @Override
    public void percevoirRessourcesSpecifiques(){
        if(!getAssassine()){
                Quartier[] cite = getJoueur().getCite();
                int count=0;
                for(int i=0; i < cite.length;i++){
                    if(cite[i] != null && cite[i].getType().equals("RELIGIEUX")){
                        count++;
                    }
                    if(cite[i] != null && cite[i].getNom().equals("Ecole de Magie")){
						count +=1;
                        System.out.println("L'école de magie vous rapprote 1 piece de plus");

					}
                }
                if(getPlateau().getPioche().nombreElements()>=count) {
                	for(int i = 0; i<count; i++) {
                		getJoueur().ajouterQuartierDansMain(getPlateau().getPioche().piocher());
                	}
                	if(getJoueur().isSimule()==true) {
                		System.out.println("     Vous avez recu "+count+" quartier(s) grace � votre cit�");
                	}
                	else {
                		System.out.println("Vous avez recu "+count+" quartier(s) gr�ce � votre cit�");
                	}
                }
                else {
                	int max = getPlateau().getPioche().nombreElements();
                	for(int i=0; i<max; i++) {
                		getJoueur().ajouterQuartierDansMain(getPlateau().getPioche().piocher());
                	}
                	if(getJoueur().isSimule()==true) {
                		System.out.println("     Vous avez recu  "+max+" quartier au lieu de "+count+"  la pioche n'a pas assez de carte");
                	}
                	else {
                		System.out.println("Vous n'avez re�u  "+max+" quartier  au lieu de "+count+"  la pioche n'a pas assez de carte");
                	}
                }
            }else if(getJoueur().equals(null)){
                System.out.println("Ce personnage n'a pas été attribué");
            }else{
                System.out.println("Vous avez été assassiné, vous ne pouvez pas utiliser votre pouvoir");
        }
    }
	@Override
	public void utiliserPouvoirAvatar() {
		// TODO Auto-generated method stub

	}

}
