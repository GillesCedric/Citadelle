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
public class Artiste extends Personnage {

	/**
	 * @param nom
	 * @param rang
	 * @param caracteristiques
	 */
	public Artiste() {
		super(Nom.ARTISTE, Rang.ARTISTE, Caracteristiques.ARTISTE);
		// TODO Auto-generated constructor stub
	}
	public void utiliserPouvoir(){
        boolean choix;
        int choixInt=0;
        boolean boucle = false;
        int nbQuartier=0;
        int nbEmbelli=0;
        int compte = 0;
        while(compte<super.getJoueur().nbQuartiersDansCite()) {
        	if(super.getJoueur().getCite()[compte].getEstEmbelli()==true) {
        		nbEmbelli+=1;
        	}
        	compte++;
        }
        if(super.getJoueur().nbQuartiersDansCite()==0) {
        	System.out.println("Vous n'avez pas de quartier dans votre cit�");
        }
        else if(super.getJoueur().nbPieces()==0) {
        	System.out.println("Vous n'avez pas de pi�ces");
        }
        else if(nbEmbelli>=super.getJoueur().nbQuartiersDansCite()) {
        	System.out.println("Vous n'avez que des quartiers embellis");
        }
        else {
        	System.out.println("Voulez-vous embellir un de vos quartiers ? (oui/non)");
            choix = Interaction.lireOuiOuNon();
            if(choix) {
            	do {
            		boucle = false;
            		System.out.println("Combien de quartier voulez-vous embellir (max 2)");
                	nbQuartier = Interaction.lireUnEntier(0, 3);
                	if(nbQuartier!=0 && nbQuartier<=super.getJoueur().nbPieces()) {
                		for(int i = 0; i<nbQuartier; i++) {
                			ArrayList<Quartier> listeAEmbellir = new ArrayList<Quartier>();
                			compte=0;
                			for(int j=0; j<super.getJoueur().nbQuartiersDansCite(); j++) {
                				if(super.getJoueur().getCite()[j].getEstEmbelli()==false) {
                					compte +=1;
                					listeAEmbellir.add(super.getJoueur().getCite()[j]);
                					System.out.println(compte+". "+super.getJoueur().getCite()[j].getNom()+" co�t : "+super.getJoueur().getCite()[j].getCout());
                				}
                			}
                			System.out.println("Quel quartier voulez-vous embellir ?");
                			choixInt=Interaction.lireUnEntier(1, compte+1)-1;
                			listeAEmbellir.get(choixInt).setCout(listeAEmbellir.get(choixInt).getCout()+1);
                			listeAEmbellir.get(choixInt).setEmbelli(true);
                			nbEmbelli += 1;
                			super.getJoueur().retirerPieces(1);
                			if(nbEmbelli==super.getJoueur().nbQuartiersDansCite()) {
                        		System.out.println("Tout vos quartiers on �t� embelli");
                				break;
                        	}
                		}
                	}
                	else if(nbQuartier>super.getJoueur().nbPieces()) {
                		System.out.println("Vous n'avez pas assez de pi�ce");
                		boucle = true;
                	}
                	else {
                		
                	}
            	} while(boucle);
            }
            else {
            	
            }
        }
    }

    public void utiliserPouvoirAvatar(){
    	Random random = new Random();
    	boolean choix;
        int choixInt=0;
        boolean boucle = false;
        int nbQuartierEmbelliDurantCeTour=0;
        int nbQuartier=0;
        int nbEmbelli=0;
        int compte = 0;
        while(compte<super.getJoueur().nbQuartiersDansCite()) {
        	if(super.getJoueur().getCite()[compte] != null && super.getJoueur().getCite()[compte].getEstEmbelli()==true) {
        		nbEmbelli+=1;
        	}
        	compte++;
        }
        if(super.getJoueur().nbQuartiersDansCite()==0) {
        	
        }
        else if(super.getJoueur().nbPieces()==0) {
        	
        }
        else if(nbEmbelli>=super.getJoueur().nbQuartiersDansCite()) {
        	
        }
        else {
            choix = random.nextBoolean();
            if(choix) {
            	do {
            		boucle = false;
                	nbQuartier = random.nextInt(3);
                	if(nbQuartier!=0 && nbQuartier<=super.getJoueur().nbPieces()) {
                		for(int i = 0; i<nbQuartier; i++) {
                			ArrayList<Quartier> listeAEmbellir = new ArrayList<Quartier>();
                			compte=0;
                			for(int j=0; j<super.getJoueur().nbQuartiersDansCite(); j++) {
                				if(super.getJoueur().getCite()[j] != null && super.getJoueur().getCite()[j].getEstEmbelli()==false) {
                					compte +=1;
                					listeAEmbellir.add(super.getJoueur().getCite()[j]);
                				}
                			}

							if(compte == 0){

							}else{
								choixInt=random.nextInt(compte);
								listeAEmbellir.get(choixInt).setCout(listeAEmbellir.get(choixInt).getCout()+1);
								listeAEmbellir.get(choixInt).setEmbelli(true);
								nbEmbelli += 1;
								nbQuartierEmbelliDurantCeTour+=1;
								super.getJoueur().retirerPieces(1);
								if(nbEmbelli==super.getJoueur().nbQuartiersDansCite()) {
									break;
								}
							}
                		}
                	}
                	else if(nbQuartier>super.getJoueur().nbPieces()) {
                		boucle = true;
                	}
                	else {
                		
                	}
            	} while(boucle);
            }
            else {
            	
            }
        }
        System.out.println("Le joueur a embelli "+nbQuartierEmbelliDurantCeTour+" quartier(s)");
    }

    @Override
    public void percevoirRessourcesSpecifiques(){
        if(!getAssassine()){
        	 
            }else if(getJoueur().equals(null)){
                System.out.println("Ce personnage n'a pas été attribué");
            }else{
                System.out.println("Vous avez été assassiné, vous ne pouvez pas utiliser votre pouvoir");
        }
    }
}
