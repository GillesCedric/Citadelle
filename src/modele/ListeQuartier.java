/**
 * 
 */
package modele;

/**
 * @author Gilles C�dric
 *
 */
public enum ListeQuartier {
	TEMPLE("Temple",1,3,Quartier.TYPE_QUARTIERS[0]),
	EGLISE("Eglise",2,3,Quartier.TYPE_QUARTIERS[0]),
	MONASTERE("Monastère",3,3,Quartier.TYPE_QUARTIERS[0]),
	CATHEDRALE("Cathédrale",5,2,Quartier.TYPE_QUARTIERS[0]),
	TOUR_DE_GUET("Tour de guet",1,3,Quartier.TYPE_QUARTIERS[1]),
	PRISON("Prison",2,3,Quartier.TYPE_QUARTIERS[1]),
	CASERNE("Caserne",3,3,Quartier.TYPE_QUARTIERS[1]),
	FORTERESSE("Forteresse",5,2,Quartier.TYPE_QUARTIERS[1]),
	MANOIR("Manoir",3,5,Quartier.TYPE_QUARTIERS[2]),
	CHATEAU("Château",4,4,Quartier.TYPE_QUARTIERS[2]),
	PALAIS("Palais",5,3,Quartier.TYPE_QUARTIERS[2]),
	ECHOPPE("Echoppe",2,3,Quartier.TYPE_QUARTIERS[3]),
	TAVERNE("Taverne",1,5,Quartier.TYPE_QUARTIERS[3]),
	MARCHE("Marché",2,4,Quartier.TYPE_QUARTIERS[3]),
	COMPTOIR("Taverne",3,3,Quartier.TYPE_QUARTIERS[3]),
	HOTEL_DE_VILLE("Hôtel de ville",5,2,Quartier.TYPE_QUARTIERS[3]),
	PORT("Taverne",4,3,Quartier.TYPE_QUARTIERS[3]);

	private ListeQuartier(String nom,int cout,int nbMax, String type) {
		this.nom = nom;
		this.coutConstruction = cout;
		this.nbMax = nbMax;
		this.type = type;
	}


	private final String nom;
	private final String type;
	private int coutConstruction;
	private final int nbMax;
	
	/**
	 * @return the coutConstruction
	 */
	public int getCoutConstruction() {
		return coutConstruction;
	}
	/**
	 * @param coutConstruction the coutConstruction to set
	 */
	public void setCoutConstruction(int coutConstruction) {
		this.coutConstruction = coutConstruction;
	}
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @return the nbMax
	 */
	public int getNbMax() {
		return nbMax;
	}

}
