/**
 * 
 */
package modele;

import utilities.Caracteristiques;
import utilities.Nom;
import utilities.Rang;
import java.util.ArrayList;
import java.util.Random;

import Controleur.Interaction;

/**
 * @author cedri
 *
 */
public class Sorcier extends Personnage {

	/**
	 * @param nom
	 * @param rang
	 * @param caracteristiques
	 */
	 private ArrayList<Joueur> listDeJoueur= new ArrayList<Joueur>();
    	private Random generateur = new Random();
	public Sorcier() 
	{
		super(Nom.SORCIER, Rang.SORCIER, Caracteristiques.SORCIER);
		// TODO Auto-generated constructor stub
	}

	@Override
	 public void utiliserPouvoir()
	 {
        	listDeJoueur.clear();
        	for(int i=0;i<getPlateau().getNombreJoueurs();i++)
		{
                	listDeJoueur.add(getPlateau().getJoueur(i));
        	}

        	listDeJoueur.remove(super.getJoueur());

        	System.out.println("Les joueurs pouvant être choisi sont :");
        	for(int i=0 ; i< listDeJoueur.size() ;i++)
		{
            		System.out.println("    " + (i+1) + ": " + listDeJoueur.get(i).getNom() + " -- " + listDeJoueur.get(i).getMain().size() + " cartes dans la main");
        	}
        	System.out.println("Vous voulez voir les cartes de quel joueur? Entrez 0 pour annuler l'action:");
        	int choix = Interaction.lireUnEntier(0, listDeJoueur.size()+1);
        	if(choix ==0)
		{
			System.out.println("Action annulée ");
        	}
		else
		{
            	choix--;
            	Joueur victime = listDeJoueur.get(choix);

            	if(victime.getMain().size()>0)
		{
			System.out.println(" Voici ses  ses cartes");
                	for(int i=0 ; i< victime.getMain().size() ; i++)
			{
                    		Quartier carte = victime.getMain().get(i);
                    		System.out.println("    " + (i+1) + ": " + carte.getNom() + " -- Type: " + carte.getType() + " -- cout: " + carte.getCout() );
                	}

                	System.out.println("Vous pouvez choisir l'une d'elle");
                	int cartePrise = Interaction.lireUnEntier(1, victime.getMain().size()+1)-1;
                	Quartier carte = victime.getMain().get(cartePrise);

                	System.out.println("Que voulez vous faire du quartier pris ?");
                	System.out.println("1: Construire le quartier");
                	System.out.println("2: Garder le quartier en main");

                	int nouveauChoix = Interaction.lireUnEntier(1, 2);
                    		if(nouveauChoix == 1)
				{
                        		if(carte.getCout() < getJoueur().nbPieces())
					{
                            			getJoueur().ajouterQuartierDansCite(carte);
                            			victime.retirerQuartierDansMain(carte);
                            			getJoueur().retirerPieces(carte.getCout());
                            			System.out.println("Le quartier : " + carte.getNom() +" est construit ");
                        		}
					else
					{
                            			System.out.println("Vous ne pouvez construire ce quartier vous n'avez pas assez d'argent. Le quartier ira donc dans votre main.");
                            			getJoueur().ajouterQuartierDansMain(carte);
                            			victime.retirerQuartierDansMain(carte);
                        		}
                    		}
				else
				{
                        		getJoueur().ajouterQuartierDansMain(carte);
                        		victime.retirerQuartierDansMain(carte);
                    		}
            	}
		else
		{
                	System.out.println("La victime n'a pas de cartes");
            	}

        }

	@Override
	public void utiliserPouvoirAvatar() 
	{
		// TODO Auto-generated method stub
		
		listDeJoueur.clear();
        	for(int i=0;i<getPlateau().getNombreJoueurs();i++)
		{
                	listDeJoueur.add(getPlateau().getJoueur(i));
        	}

        	listDeJoueur.remove(super.getJoueur());
        	int choix = generateur.nextInt(listJoueur.size());
		
            	Joueur victime = listDeJoueur.get(choix);

            	if(victime.getMain().size()>0)
		{
                	int cartePrise = generateur.nextInt(victime.getMain().size());
                	Quartier carte = victime.getMain().get(cartePrise);
			int nouveauChoix = generateur.nextInt(2);
                    		if(nouveauChoix == 0)
				{
                        		if(carte.getCout() < getJoueur().nbPieces())
					{
                            			getJoueur().ajouterQuartierDansCite(carte);
                            			victime.retirerQuartierDansMain(carte);
                            			getJoueur().retirerPieces(carte.getCout());
                            			System.out.println("Le quartier : " + carte.getNom() +" est construit ");
                        		}
					else
					{
                            			System.out.println("Vous ne pouvez construire ce quartier vous n'avez pas assez d'argent. Le quartier ira donc dans votre main.");
                            			getJoueur().ajouterQuartierDansMain(carte);
                            			victime.retirerQuartierDansMain(carte);
                        		}
                    		}
				else
				{
                        		getJoueur().ajouterQuartierDansMain(carte);
                        		victime.retirerQuartierDansMain(carte);
                    		}
            	}
		else
		{
                	System.out.println("La victime n'a pas de cartes");
            	}

        }

}
