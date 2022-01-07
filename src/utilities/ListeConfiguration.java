/**
 * 
 */
package utilities;

/**
 * @author cedric
 *
 */
public enum ListeConfiguration {
	CONFIGURATIONDEBASE("Configuration De Base"),
	ARISTOCRATEAMBITIEUX("Aristocrates Ambitieux"),
	INTRIGANTSSUBTILS("Intrigants Subtils"),
	EMMISSAIRESILLUSTRES("Emissaires Illustres"),
	DIGNITAIRESSOURNOIS("Dignitaires Sournois"),
	OLIGARQUESTENACES("Oligarques Tenaces"),
	NOBLESRETORS("Nobles Retors");
	
	private ListeConfiguration(String nom) {
		this.nom = nom;
	}


	private final String nom;
	
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
}
