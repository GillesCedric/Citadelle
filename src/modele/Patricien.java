/**
 * 
 */
package modele;

import utilities.Caracteristiques;
import utilities.Nom;
import utilities.Rang;

/**
 * @author cedric
 *
 */
public class Patricien extends Personnage {

	/**
	 * @param nom
	 * @param rang
	 * @param caracteristiques
	 */
	public Patricien() {
		super(Nom.PATRICIEN, Rang.PATRICIEN, Caracteristiques.PATRICIEN);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void utiliserPouvoir() {
		// TODO Auto-generated method stub
		if (super.getJoueur() != null) {
				for(int i=0; i< getPlateau().getNombreJoueurs();i++){
					if(getPlateau().getJoueur(i).getPossedeCouronne()){
						getPlateau().getJoueur(i).setPossedeCouronne(false);
					}
				}
				System.out.println("	Je prends la couronne");
				super.getJoueur().setPossedeCouronne(true);

	}

	@Override
	public void utiliserPouvoirAvatar() {
		// TODO Auto-generated method stub
		if (super.getJoueur() != null) {
				for(int i=0; i< getPlateau().getNombreJoueurs();i++){
					if(getPlateau().getJoueur(i).getPossedeCouronne()){
						getPlateau().getJoueur(i).setPossedeCouronne(false);
					}
				}
				System.out.println("	Je prends la couronne");
				super.getJoueur().setPossedeCouronne(true);

	}
	@Override
	public void percevoirRessourcesSpecifiques() {
			int NbCarte = 0;
			if (super.getJoueur() != null) {
				Quartier[] cite = super.getJoueur().getCite();
				for (int i = 0; i<cite.length ; i++) {
					if (cite[i] != null && cite[i].getType() == "NOBLE") {
						NbCarte += 1;
					}
					if(cite[i] != null && cite[i].getNom().equals("Ecole de Magie")){
						NbCarte +=1;
						System.out.println("L'école de magie vous rapprote 1 piece de plus");

					}
				}
				System.out.println(NbCarte + " cartes ont été ajouté a votre main ");
				
                int i=0;
                while(getPlateau().getPioche().nombreElements()>0 && i< NbCarte){
                    getJoueur().ajouterQuartierDansMain(getPlateau().getPioche().piocher());
                    i++;
	}
	
	public void reinitialiser() 
	{
		super.reintitialiser();
	}
}
