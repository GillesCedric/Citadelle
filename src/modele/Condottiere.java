package modele;
import java.util.Scanner;

import controlleur.Interaction;

public class Condottiere extends Personnage {

	public Condottiere() {
		super(Nom.CONDOTTIERE, Rang.CONDOTTIERE, Caracteristiques.CONDOTTIERE);
		// TODO Auto-generated constructor stub
	}

	public void percevoirRessourcesSpecifiques() {
		super.percevoirRessourcesSpecifiques();
	}
	
	@Override
	public void utiliserPouvoir() {
		// TODO Auto-generated method stub
		
		
		String ouiNon;
		int joueurChoisi;
		int quartierChoisi;
		Scanner sc = new Scanner (System.in);

		
		System.out.print("\nVoulez-vous utiliser votre pouvoir de destruction ? (saisir o si oui)");
		if (Interaction.lireOuiOuNon()) {
			
			
			System.out.print("\nVoici la liste des joueurs et le contenu de leur cit� :\n");
			
			//parcours et affichage des joueurs et le contenus de leurs cit�s
			 for (int i=0; i < this.getPlateau().getNombreJoueurs() ; i++) {
				 
				
				System.out.println( i+1 + " " + this.getPlateau().getJoueur(i).getNom() + " : ");
				
				for (int j=0; j < this.getPlateau().getJoueur(i).getCite().length; j++) {
					
					System.out.println(j+1 + " " + this.getPlateau().getJoueur(i).getCite()[j].getNom() + 
					" (Co�t " + this.getPlateau().getJoueur(i).getCite()[j].getCout() + "), ");
				}
			 }
			
			
			//affichage du nombre des pi�ces d'or du joueur actuel
			System.out.print("\nPour plus d'information, vous avez " + this.getJoueur().nbPieces() + " pi�ces d'or "
					+ "dans votre tr�sor ");
			
			//demande de choisir un joueur
			System.out.println("\nQuel joueur choisissez-vous ? (0 pour ne rien faire) ");
			joueurChoisi = sc.nextInt();
			
			if (joueurChoisi != 0) {
				
				System.out.println("\nQuel quartier choisissez-vous ?");
				quartierChoisi = sc.nextInt();
				
			} else {
				
				return;
			}
			
			
			while (this.getJoueur().nbPieces() < this.getPlateau().getJoueur(joueurChoisi).getCite()[quartierChoisi].getCout()) {
				
					System.out.println("\nVotre tr�sor n'est pas suffisant");
					System.out.println("\nVotre choix ? ");
					quartierChoisi = sc.nextInt();
				
			}
			
			System.out.println("\n=> non retire l'" + this.getPlateau().getJoueur(joueurChoisi).getCite()[quartierChoisi].getNom() +
					" � " + this.getPlateau().getJoueur(joueurChoisi).getNom());
			
			this.getPlateau().getJoueur(joueurChoisi).retirerQuartierDansCite(this.getPlateau().getJoueur(joueurChoisi).getCite()[quartierChoisi].getNom());
			
			System.out.println("\nPour information, votre tr�sor est constitu� de " + this.getJoueur().nbPieces() + 
					" pi�ces d'or");
			
			
		} else {
			
			return;
		}
		
		
	}

	@Override
	public void utiliserPouvoirAvatar() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	

}
