/**
 * 
 */
package modele;

/**
 * @author Gilles C�dric
 *
 */
public enum JoueurIA {
	
	TED("Ted"),
	MATHIAS("Mathias"),
	MARIE("Marie"),
	AUDREY("Audrey"),
	IGOR("Igor"),
	LOAN("Loan"),
	RAZI("Razi"),
	BISSANE("Bissane"),
	CEDRIC("Cédric"),
	MILAINE("Milaine");
	
	private JoueurIA(String nom) {
		this.nom = nom;
	}
	
	public String getNom() {
		return nom;
	}

	private final String nom;
}
