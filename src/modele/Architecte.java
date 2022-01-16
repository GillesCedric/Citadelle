package modele;

import utilities.Caracteristiques;
import utilities.Nom;
import utilities.Rang;

public class Architecte extends Personnage {
	

	Pioche pioche = new Pioche();
	
	public Architecte() {
		super(Nom.ARCHITECTE, Rang.ARCHITECTE, Caracteristiques.ARCHITECTE);
		// TODO Auto-generated constructor stub
	}

	
	public void utiliserPouvoir() {
		
		
		if(this.getJoueur() == null) {
			
			System.out.println("Il n'y a pas de joueur associé");
		}
		
		else if (super.getAssassine() == true) {
			
			System.out.println("Le personnage est assassiné");
		}
		
		else if (this.getPlateau().getPioche().nombreElements() >= 2) {
			
			for (int i=0; i<2; i++ ) {
				
				this.getJoueur().ajouterQuartierDansMain(this.getPlateau().getPioche().piocher());
				 
				 
			}
			
			System.out.println("\nvous avez pioché 2 cartes quartier supplémentaires !");

		} else {
			
			System.out.println("\nnombre de cartes quartier dans la pioche insuffisant !");

		}

		
		
	}


	@Override
	public void utiliserPouvoirAvatar(){
        if(!getAssassine()){
            int m=0;
            while(getPlateau().getPioche().nombreElements()>0 && m<2){
                m++;
                getJoueur().getMain().add(getPlateau().getPioche().piocher());
            }
        }else if(getJoueur().equals(null)){
            System.out.println("Ce personnage n'a pas été attribué");
        }else{
            System.out.println("Vous avez été assassiné, vous ne pouvez pas utiliser votre pouvoir");
        }
    }

}
