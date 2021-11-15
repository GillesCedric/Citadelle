package modele;
import java.util.*;

/*
 * @author Razi Askri
 * @edit 15/11/2021
 */

//notfinished- work in progress

public class PlateauDeJeu {
	
	
	private Personnage listePersonnages[];
	private Joueur listeJoueurs[];
	private Pioche pioche;
	private int nombrePersonnages;
	private int nombreJoueurs;
	
	
	public PlateauDeJeu() {
		
		this.listeJoueurs = new Joueur[9];
		this.listePersonnages = new Personnage[9];
		this.nombrePersonnages = 0;
		this.nombreJoueurs = 0;
		Pioche p;
		
	}
	
	public int getNombrePersonnages() {
		
		return nombrePersonnages;
	}
	
	public int getNombreJoueurs() {
		
		return nombreJoueurs;
	}
	
	public Pioche getPioche() {
		
		return pioche;
	}
	
	public Personnage getPersonnage(int i) {
		
		Personnage p1 = null;
		
		for (int j=0; j< listePersonnages.length; j++) {
			
			if (j == i) {
				
				 p1 = listePersonnages[j];
			}
		}
		return p1;						
	}
	
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
