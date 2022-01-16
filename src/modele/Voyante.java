package modele;

import java.util.ArrayList;
import java.util.Random;

import controlleur.Interaction;
import utilities.Caracteristiques;
import utilities.Nom;
import utilities.Rang;


public class Voyante extends Personnage {

	/**
	 * @param nom
	 * @param rang
	 * @param caracteristiques
	 */
	public Voyante() {
		super(Nom.VOYANTE, Rang.VOYANTE, Caracteristiques.VOYANTE);
		// TODO Auto-generated constructor stub
	}
	
	private ArrayList<Joueur> listJoueur= new ArrayList<Joueur>();
    private Random generateur = new Random();
    

    public void utiliserPouvoir(){
        listJoueur.clear();

        //récupèration des joueurs
        for(int i=0; i<getPlateau().getNombreJoueurs(); i++){
                listJoueur.add(getPlateau().getJoueur(i));
            
        }

        //supprimer le joueur actuel
        listJoueur.remove(getJoueur());

        ArrayList<Joueur> listJoueurPris = new ArrayList<Joueur>();
        ArrayList<Quartier> listCartePris = new ArrayList<Quartier>();
        for(int i=0 ; i< listJoueur.size() ;i++){
            if(listJoueur.get(i).getMain().size()>0){
                listJoueurPris.add(listJoueur.get(i));
                listCartePris.add(listJoueur.get(i).getMain().get(generateur.nextInt(listJoueur.get(i).getMain().size())));
            }
        }

        //ajout des cartes dans la main du joueur
        for(int i=0; i<listCartePris.size(); i++){
            getJoueur().ajouterQuartierDansMain(listCartePris.get(i));
        }

        
        for(int i=0 ; i< listJoueurPris.size() ;i++){
            Joueur joueur = listJoueurPris.get(i);
            System.out.println("Choisissez la carte que vous voulez donner à: " + joueur.getNom());
            for(int j=0; j< getJoueur().getMain().size(); j++){
                Quartier q=getJoueur().getMain().get(j);
                System.out.println("    " + (j+1) + ": " + q.getNom() + " -- Type: " + q.getType() + " -- cout: " + q.getCout() );
            }
            System.out.println("Faites votre choix: ");
            Quartier carte = getJoueur().getMain().get(Interaction.lireUnEntier(1, getJoueur().getMain().size()+1)-1);
            getJoueur().retirerQuartierDansMain(carte);
            joueur.ajouterQuartierDansMain(carte);
        }



    }

    public void utiliserPouvoirAvatar(){
        
        //récupèration des joueurs
        for(int i=0;i<getPlateau().getNombreJoueurs();i++){
            listJoueur.add(getPlateau().getJoueur(i));
        
        }

        //supprimer le joueur actuel
        listJoueur.remove(getJoueur());

        ArrayList<Joueur> listJoueurPris = new ArrayList<Joueur>();
        ArrayList<Quartier> listCartePris = new ArrayList<Quartier>();
        for(int i=0 ; i< listJoueur.size() ;i++){
            if(listJoueur.get(i).getMain().size()>0){
                listJoueurPris.add(listJoueur.get(i));
                listCartePris.add(listJoueur.get(i).getMain().get(generateur.nextInt(listJoueur.get(i).getMain().size())));
            }
        }

        //ajout des cartes dans la main du joueur
        for(int i=0 ;i<listCartePris.size();i++){
            getJoueur().ajouterQuartierDansMain(listCartePris.get(i));
        }

        
        for(int i=0 ; i< listJoueurPris.size() ;i++){
            Joueur joueur = listJoueurPris.get(i);
            Quartier carte = getJoueur().getMain().get(generateur.nextInt(getJoueur().getMain().size()));
            getJoueur().retirerQuartierDansMain(carte);
            joueur.ajouterQuartierDansMain(carte);
        }

    }



}
