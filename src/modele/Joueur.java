package modele;
import java.util.*;

public class Joueur {
	
	
	private String nom;
	private int trésor;
    private Quartier cité[];
    private ArrayList<Quartier> main = new ArrayList<>();
	private int nbQuartier;
	private boolean possedeCouronne;

	public Joueur(String nom) {
		// TODO Auto-generated constructor stub

		this.nom = nom;
		this.trésor = 0;
		this.nbQuartier = 0;
		this.possedeCouronne = false;
		this.cité = new Quartier[8];
	    this.main = new ArrayList<Quartier>();

		
	}
	
	public String getNom() {
		return nom;
	}
	
	public int nbPieces() {
		return trésor;
	}
	
	public int nbQuartiersDansCite() {
		return nbQuartier;
	}
	
	public Quartier[] getCite() {

		return cité;
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
		if (nbPieces > 0) {
		trésor = trésor + nbPieces;
		}
	}
	
	public void retirerPiece(int nbPieces) {
		
		if (nbPieces > 0) {
			
		if ( (trésor - nbPieces) >= 0) {
			
			trésor = trésor - nbPieces;
		}
	}
		
	}
	
	public void ajouterQuartierDansCite(Quartier quartier) {
		
		if (cité.length != 0) {
			
			main.add(quartier);
		}
		
	}
	
	public boolean quartierPresentDansCite(String nom) {
		
		boolean trouve = false;
		
		for (int i=0; i< cité.length; i++) {
		
			if (cité[i].equals(nom)) {
				
			    trouve = true;
				
			}
		}
		return trouve;
		
	}
	
	public Quartier retirerQuartierDansCite(String nom) {
		
		Quartier quartSupprimé = null;
		
		for (int i=0; i< cité.length; i++) {
			
			if (cité[i].equals(nom)) {
				
				quartSupprimé = cité[i];
				cité[i] = null;
			
			}
		}
		return quartSupprimé;
		
	}
	
	public void ajouterQuartierDansMain(Quartier quartier) {
		
		main.add(quartier);
		
	}
	
	public Quartier retirerQuartierDansMain() {
		
		if (main.size() != 0) {
			
			Random generateur = new Random();
			int numeroHasard = generateur.nextInt(this.nbQuartiersDansMain());
			
		} else return null;
		return null;

	}
	
	public void reinitialiser() {
		
		trésor = 0;
		main.removeAll(main);
		cité = null;
	}	

}
