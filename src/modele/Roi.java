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
		if(this.getJoueur() == null)
			return;
		System.out.println("Je prends la couronne");
		this.getJoueur().setPossedeCouronne(true);
	}

	@Override
	public void percevoirRessourcesSpecifiques() {
		// TODO Auto-generated method stub
		if(this.getJoueur() == null)
			return;
		int nbQuartierNoble = 0;
		for (int i = 0; i < this.getJoueur().nbQuartiersDansCite(); i++) {
			if(this.getJoueur().getCite()[i].getType().equals(Quartier.TYPE_QUARTIERS[2]))
				nbQuartierNoble ++;
		}
		this.getJoueur().ajouterPieces(nbQuartierNoble);
	}
	
	

}
