package modele;

public class Architecte extends Personnage {
	

	Pioche P = new Pioche();
	
	public Architecte() {
		super(Nom.ARCHITECTE, Rang.ARCHITECTE, Caracteristiques.ARCHITECTE);
		// TODO Auto-generated constructor stub
	}

	
	public void utiliserPouvoir() {
			
		if (P.nombreElements() >= 2) {
			
			for (int i=0; i<2; i++ ) {
				
				 P.piocher();
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
