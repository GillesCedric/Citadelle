/**
 * 
 */
package modele;

/**
 * @author Gilles Cédric
 * @since 15/11/2021
 */
public class Roi extends Personnage {

	public Roi() {
		super("Roi", 4, Caracteristiques.ROI);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void utiliserPouvoir() {
		// TODO Auto-generated method stub
		System.out.println("Je prends la couronne");
		this.getJoueur().setPossedeCouronne(true);
	}

	@Override
	public void percevoirRessourcesSpecifiques() {
		// TODO Auto-generated method stub
		int nbQuartierNoble = 0;
		for (Quartier quartier : this.getJoueur().getCite()) {
			if(quartier.getType().equals(Quartier.TYPE_QUARTIERS[2]))
				nbQuartierNoble ++;
		}
		this.getJoueur().ajouterPiece(nbQuartierNoble);
	}
	
	

}
