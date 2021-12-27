package modele;

public class Architecte extends Personnage {
	

	Pioche pioche = new Pioche();
	
	public Architecte() {
		super(Nom.ARCHITECTE, Rang.ARCHITECTE, Caracteristiques.ARCHITECTE);
		// TODO Auto-generated constructor stub
	}

	
	public void utiliserPouvoir() {
			
		if (this.getPlateau().getPioche().nombreElements() >= 2) {
			
			for (int i=0; i<2; i++ ) {
				
				this.getJoueur().ajouterQuartierDansMain(this.getPlateau().getPioche().piocher());
				 
				 
			}
			System.out.println("\nvous avez pioché 2 cartes quartier supplémentaires !");

		} else {
			System.out.println("\nnombre de cartes quartier dans la pioche insuffisant !");

		}

		
		
	}


	@Override
	public void utiliserPouvoirAvatar() {
		// TODO Auto-generated method stub
		
	}

}
