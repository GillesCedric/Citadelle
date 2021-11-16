package modele;
package com.mycompany.citadelle;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Badugue Bonnet Igor-M
 */
public class PlateauDeJeu {
    private Personnage[] listePersonnages;
    private Joueur[] listeJoueurs;
    private Pioche pioche;
    private int nombrePersonnages;
    private int nombreJoueurs;

    public PlateauDeJeu() {
        listePersonnages= new Personnage[9];
        listeJoueurs= new Joueur[9];
        pioche= new Pioche();
        nombrePersonnages=0;
        nombreJoueurs=0;
    }
    
    public PlateauDeJeu(Personnage[] listePersonnages, Joueur[] listeJoueurs, Pioche pioche, int nombrePersonnages, int nombreJoueurs) {
        this.listePersonnages = listePersonnages;
        this.listeJoueurs = listeJoueurs;
        this.pioche = pioche;
        this.nombrePersonnages = nombrePersonnages;
        this.nombreJoueurs = nombreJoueurs;
    }    
	
    public Personnage getPersonnage(int i) {
        if(i < listePersonnages.length && i>=0) {
            return listePersonnages[i];
        }else
            return null;
    }

    public Joueur getJoueur(int i) {
        if(i < listeJoueurs.length && i>=0) {
            return listeJoueurs[i];
        }else
            return null;
    }

    public Pioche getPioche() {
        return pioche;
    }

    public int getNombrePersonnages() {
        return nombrePersonnages;
    }

    public int getNombreJoueurs() {
        return nombreJoueurs;
    }
    
    public void ajouterPersonnage(Personnage p){
        for(int i=0; i < listePersonnages.length ;i++){
        if(listePersonnages[i] != null){
            listePersonnages[i] = p;
        }
        else
            System.out.println("liste de Personnage aux complet");
    }   
        PlateauDeJeu pl= new PlateauDeJeu(listePersonnages,listeJoueurs,pioche,nombrePersonnages,nombreJoueurs);
        p.setPlateau(pl);
    }
    
    public void ajouterJoueur(Joueur j){
        for(int i=0; i < listeJoueurs.length ;i++){
        if(listeJoueurs[i] != null){
            listeJoueurs[i] = j;
        }
        else
            System.out.println("liste de joueuers aux complet");
    }
    }
 
}
