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
		return nbQuartier;
	}
	
	public Quartier[] getCite() {
		return cite;
	}package modele;
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
		if(nbPieces >= 0) {
			tresor = tresor + nbPieces;
		}
	}
	
	public void retirerPiece(int nbPieces) {
		
		if (nbPieces <= tresor && nbPieces >= 0) {
			
			tresor = tresor - nbPieces;
		}
		
	}
	
	public void ajouterQuartierDansCite(Quartier quartier) {
		
		if (nbQuartier < 8) {
			cite[nbQuartier] = quartier;
			nbQuartier++;
		}
		
	}
	
	public boolean quartierPresentDansCite(String nom) {
		
		for (int i=0; i< nbQuartier; i++) {package modele;
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

		
			if (cite[i].getNom().equals(nom)) {
				
			    return true;
				
			}
		}
		return false;
		
	}
	
	public Quartier retirerQuartierDansCite(String nom) {
		
		Quartier quartSupprime = null;
		
		for (int i=0; i< nbQuartier; i++) {
			
			if (cite[i].getNom().equals(nom)) {
				
				quartSupprime = cite[i];
				cite[i] = null;
				nbQuartier--;
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
			main.remove(numeroHasard);
			
		} else return;

	}
	
	public void reinitialiser() {
		
		tresor = 0;
		main = new ArrayList<Quartier>();
		cite = new Quartier[8];
	}	

}
