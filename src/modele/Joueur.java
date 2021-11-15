package modele;
import java.util.*;

/*
 * @author Razi Askri
 * @edit 10/11/2021
 */

public class Joueur {
	
	
	private String nom;
	private int tresor;
    private Quartier cite[];
    private ArrayList<Quartier> main = new ArrayList<>();
	private int nbQuartier;
	private boolean possedeCouronne;

	public Joueur(String nom) {
		// TODO Auto-generated constructor stub

		this.nom = nom;
		this.tresor = 0;
		this.nbQuartier = 0;
		this.possedeCouronne = false;
		this.cite = new Quartier[8];
	    this.main = new ArrayList<Quartier>();

		
	}
	
	public String getNom() {
		return nom;
	}
	
	public int nbPieces() {
		return tresor;
	}
	
	public int nbQuartiersDansCite() {
		return cite.length;
	}
	
	public Quartier getCite() {
		for (int i=0; i < cite.length; i++) {
			
			return cite[i];
		}
		return null;
	}
	
	public ArrayList<Quartier> getMain() {
		return main;
	}
	
	public int nbQuartiersDansMain() {
			
		return main.size();

	}
	
	public Boolean getPossedeCouronne() {
		return possedeCouronne;
	}
	
	public void setPossedeCouronne(boolean b) {
		this.possedeCouronne = b;
	}
	
	public void ajouterPiece(int nbPieces ) {
		tresor = tresor + nbPieces;
		
	}
	
	public void retirerPiece(int nbPieces) {
		
		if (tresor - nbPieces >= 0) {
			
			tresor = tresor - nbPieces;
		}
		
	}
	
	public void ajouterQuartierDansCite(Quartier quartier) {
		
		if (cite.length != 0) {
			
			main.add(quartier);
		}
		
	}
	
	public boolean quartierPresentDansCite(String nom) {
		
		boolean trouve = false;
		
		for (int i=0; i< cite.length; i++) {
		
			if (cite[i].equals(nom)) {
				
			    trouve = true;
				
			}
		}
		return trouve;
		
	}
	
	public Quartier retirerQuartierDansCite(String nom) {
		
		Quartier quartSupprime = null;
		
		for (int i=0; i< cite.length; i++) {
			
			if (cite[i].equals(nom)) {
				
				quartSupprime = cite[i];
				cite[i] = null;
			
			}
		}
		return quartSupprime;
		
	}
	
	public void ajouterQuartierDansMain(Quartier quartier) {
		
		main.add(quartier);
		
	}
	
	public void retirerQuartierDansMain() {
		
		if (main.size() != 0) {
			
			Random generateur = new Random();
			int numeroHasard = generateur.nextInt(this.nbQuartiersDansMain());
			
		} else return;

	}
	
	public void reinitialiser() {
		
		tresor = 0;
		main.removeAll(main);
		cite = null;
	}	

}
