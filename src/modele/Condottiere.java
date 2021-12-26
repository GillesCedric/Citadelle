package modele;
import java.util.Scanner;

public class Condottiere extends Personnage {
	
	public Condottiere(String nom, int rang, String caracteristiques) {
		super(nom, rang, caracteristiques);
		// TODO Auto-generated constructor stub
	}

	public void percevoirRessourcesSpecifiques() {
		super.percevoirRessourcesSpecifiques();
	}
	
	@Override
	public void utiliserPouvoir() {
		// TODO Auto-generated method stub
		
		String ouiNon;
		int choixDuJoueur;
		int choixDuQuartier;
		Scanner sc = new Scanner (System.in);

		
		do {
		System.out.print("\nVoulez-vous utiliser votre pouvoir de destruction ? (saisir o si oui)");
		ouiNon = sc.nextLine();
		
		} while(ouiNon != "o"); 


		System.out.print("\nVoici la liste des joueurs et le contenu de leur cité :\n");
		
		//parcours et affichage des joueurs et le contenus de leurs cités
		 for (int i=0; i < this.getPlateau().getNombreJoueurs() ; i++) {
			 
			
			System.out.println( i+1 + " " + this.getPlateau().getJoueur(i).getNom() + " : ");
			
			for (int j=0; j < this.getPlateau().getJoueur(i).getCite().length; j++) {
				
				System.out.println(j+1 + " " + this.getPlateau().getJoueur(i).getCite()[j].getNom() + 
				" (Coût " + this.getPlateau().getJoueur(i).getCite()[j].getCout() + "), ");
			}
		 }
		
		
		//affichage du nombre des piéces d'or du joueur actuel
		System.out.print("\nPour plus d'information, vous avez " + this.getJoueur().nbPieces() + " piéces d'or "
				+ "dans votre trésor ");
		
		//demande de choisir un joueur
		System.out.println("\nQuel joueur choisissez-vous ? (0 pour ne rien faire) ");
		choixDuJoueur = sc.nextInt();
		System.out.println("\nQuel quartier choisissez-vous ?");
		choixDuQuartier = sc.nextInt();
		
		while (this.getJoueur().nbPieces() < this.getPlateau().getJoueur(choixDuJoueur).getCite()[choixDuQuartier].getCout()) {
			
				System.out.println("\nVotre trésor n'est pas suffisant");
				System.out.println("\nVotre choix ? ");
				choixDuQuartier = sc.nextInt();
			
		}
		
		System.out.println("\n=> non retire l'" + this.getPlateau().getJoueur(choixDuJoueur).getCite()[choixDuQuartier].getNom() +
				" à " + this.getPlateau().getJoueur(choixDuJoueur).getNom());
		
		this.getPlateau().getJoueur(choixDuJoueur).retirerQuartierDansCite(this.getPlateau().getJoueur(choixDuJoueur).getCite()[choixDuQuartier].getNom());
		
		System.out.println("\nPour information, votre trésor est constitué de " + this.getJoueur().nbPieces() + 
				" piéces d'or");

	}

}
