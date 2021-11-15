/**
 * 
 */
package modele;

/**
 * @author Gilles Cédric
 * @since 10/11/2021
 * @see https://moodle3.esaip.org/mod/resource/view.php?id=36274
 *
 */
public class Quartier {
	public static final String[] TYPE_QUARTIERS = {"RELIGIEUX","MILITAIRE","NOBLE","COMMERCANT","MERVEILLE"};
	private String nom;
	private String type;
	private int coutConstruction;
	private String caracteristiques;
	
	
	
	public Quartier() {
		this("","",0,"");
	}
	
	public Quartier(String nom, String type, int coutConstruction) {
		this.setNom(nom);
		this.setType(type);
		this.setCout(coutConstruction);
		this.setCaracteristiques("");
	}

	public Quartier(String nom, String type, int coutConstruction, String caracteristiques) {
		this.setNom(nom);
		this.setType(type);
		this.setCout(coutConstruction);
		this.setCaracteristiques(caracteristiques);
	}

	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		for (int i = 0; i < TYPE_QUARTIERS.length; i++) {
			if(TYPE_QUARTIERS[i].equals(type)) {
				this.type = type;
				return;
			}
		}
		this.type = "";
	}
	
	public int getCout() {
		return coutConstruction;
	}
	
	public void setCout(int coutConstruction) {
		if(coutConstruction >= 1 && coutConstruction <= 6)
			this.coutConstruction = coutConstruction;
		else
			this.coutConstruction = 0;
	}

	public String getCaracteristiques() {
		return caracteristiques;
	}

	public void setCaracteristiques(String caracteristiques) {
		this.caracteristiques = caracteristiques;
	}

	public boolean getEmbelli() {
		// TODO Auto-generated method stub
		return false;
	}

	public void embellir() {
		// TODO Auto-generated method stub
		
	}
	
}
