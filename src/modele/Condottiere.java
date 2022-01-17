package modele;
import controlleur.Interaction;
import utilities.Caracteristiques;
import utilities.Nom;
import utilities.Rang;

public class Condottiere extends Personnage {

	public Condottiere() {
		super(Nom.CONDOTTIERE, Rang.CONDOTTIERE, Caracteristiques.CONDOTTIERE);
		// TODO Auto-generated constructor stub
	}

		public void percevoirRessourcesSpecifiques() {
		if(getAssassine()){

        }else{
            
            Quartier[] cite = getJoueur().getCite();
            int count=0;
            for(int i=0; i < cite.length;i++){
                if(cite[i] != null && cite[i].getType().equals("MILITAIRE")){
                    count++;
                }
                if(cite[i] != null && cite[i].getNom().equals("Ecole de Magie")){
                    count +=1;
                    System.out.println("L'école de magie vous rapprote 1 piece de plus");
                }
            }

            getJoueur().ajouterPieces(count);
            
        }	}
        	
	
	@Override
	public void utiliserPouvoir() {
		// TODO Auto-generated method stub
		
		
		
		int joueurChoisi;
		int quartierChoisi;

		
		System.out.print("\nVoulez-vous utiliser votre pouvoir de destruction ? (saisir o si oui)");
		if (Interaction.lireOuiOuNon()) {
			
			System.out.print("\nVoici la liste des joueurs et le contenu de leur cité :\n");
			
			//parcours et affichage des joueurs et le contenus de leurs cités
			 for (int i=0; i < this.getPlateau().getNombreJoueurs() ; i++) {
				 
				int x= i+1;
				System.out.println("\n" + x + " " + this.getPlateau().getJoueur(i).getNom() + " : ");
				System.out.print("\n");
				for (int j=0; j < this.getPlateau().getJoueur(i).nbQuartiersDansCite(); j++) {					
					
					System.out.println(j+1 + " " + this.getPlateau().getJoueur(i).getCite()[j].getNom() + 
					" (Coût " + this.getPlateau().getJoueur(i).getCite()[j].getCout() + "), ");
				}
			 }
			 
			
			//affichage du nombre des pièces d'or du joueur actuel
			System.out.print("\nPour plus d'information, vous avez " + this.getJoueur().nbPieces() + " piéces d'or "
					+ "dans votre trésor ");
			
			//demande de choisir un joueur
			System.out.println("\nQuel joueur choisissez-vous ? (0 pour ne rien faire) ");
			
		    joueurChoisi = Interaction.lireUnEntier(1, this.getPlateau().getNombreJoueurs()+1);
			joueurChoisi = joueurChoisi - 1;

			System.out.print(joueurChoisi);
			System.out.println(this.getPlateau().getJoueur(joueurChoisi).getNom());

			if (joueurChoisi >= 0) {
				
				System.out.println("\nQuel quartier choisissez-vous ?");
			    quartierChoisi = Interaction.lireUnEntier(1, this.getPlateau().getJoueur(joueurChoisi).nbQuartiersDansCite()+1);
				quartierChoisi = quartierChoisi - 1;
				System.out.println(this.getPlateau().getJoueur(joueurChoisi).getCite()[quartierChoisi].getNom());

			} else {
				
				return;
			}


			while ((this.getJoueur().nbPieces() < this.getPlateau().getJoueur(joueurChoisi).getCite()[quartierChoisi].getCout())
					|| this.getPlateau().getJoueur(joueurChoisi).getPersonnage().getRang() == Rang.EVEQUE)
			
			{
					System.out.println("\nVotre trésor n'est pas suffisant");
					System.out.println("\nVotre choix ? ");
				    quartierChoisi = Interaction.lireUnEntier(1, this.getPlateau().getJoueur(joueurChoisi).nbQuartiersDansCite()+1);
					
				
			}

			
			System.out.println("\n=> on retire l'" + this.getPlateau().getJoueur(joueurChoisi).getCite()[quartierChoisi].getNom() +
					" de " + this.getPlateau().getJoueur(joueurChoisi).getNom());
			
			this.getJoueur().retirerPieces(this.getPlateau().getJoueur(joueurChoisi).getCite()[quartierChoisi].getCout());
			this.getPlateau().getJoueur(joueurChoisi).retirerQuartierDansCite(this.getPlateau().getJoueur(joueurChoisi).getCite()[quartierChoisi].getNom());
			System.out.println("\nPour information, votre trésor est constitué de " + this.getJoueur().nbPieces() + 
					" pièces d'or");
			
			//System.out.println(this.getPlateau().getJoueur(joueurChoisi).nbQuartiersDansCite());
			
			
		} else {
			
			return;
		}		
		
	}

	
	@Override
	public void utiliserPouvoirAvatar() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	

}