/**
 * 
 */
package modele;

import utilities.Caracteristiques;
import utilities.Nom;
import utilities.Rang;
import java.util.ArrayList;
import java.util.Random;

import controlleur.Interaction;
/**
 * @author cedric
 *
 */
public class Abee extends Personnage {

	/**
	 * @param nom
	 * @param rang
	 * @param caracteristiques
	 */
	public Abee() {
		super(Nom.ABBE, Rang.ABBE, Caracteristiques.ABBE);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void utiliserPouvoir() 
	{
		// TODO Auto-generated method stub
		int i,j,k;
		ArrayList <Integer> richestMultiple = new ArrayList();
		int richest = 0;
		for( i=0; i < this.getPlateau().getNombreJoueurs(); i++)
		{
			if( this.getPlateau().getJoueur(i).nbPieces() > this.getPlateau().getJoueur(richest).nbPieces() )
				richest = i;
		}
		for( j=0; i < this.getPlateau().getNombreJoueurs(); j++)
		{
			if( this.getPlateau().getJoueur(j).nbPieces() == this.getPlateau().getJoueur(richest).nbPieces() )
				richestMultiple.add(j);
		}
		if(this.getPlateau().getJoueur(richest).nbPieces() > this.getJoueur().nbPieces())
		{
			if(richestMultiple.size()>1)
			{
				System.out.println(" Les joueurs les plus riches sont : ");
				for(k=0; k<richestMultiple.size(); k++)
				{
					System.out.println(" Joueur" +(richestMultiple.get(k) + 1));
				}
				System.out.println(" Chez quel joueur voulez vous prendre une piece d'or ? : ");
				int choix = Interaction.lireUnEntier();
				System.out.println(" Le joueur" +choix +" vous donne une piece d'or.");
				this.getPlateau().getJoueur(choix-1).retirerPieces(1);
				this.getJoueur().ajouterPieces(1);
			}
			else
			{
				System.out.println(" Le joueur le plus riche vous donne une piece d'or. ");
				this.getPlateau().getJoueur(richest).retirerPieces(1);
				this.getJoueur().ajouterPieces(1);
			}
		}
		else
			System.out.println(" Vous êtes le joueur le plus riche, vous ne recevez donc ps de piece d'or d'un autre joueur. ");
		for(i=0; i< getJoueur().nbQuartiersDansCite();i++)
		{
			
			if( getJoueur().getCite()[i].getType().equals(Quartier.TYPE_QUARTIERS[0]))
			{
				System.out.println( (i+1) +" quartier de type religieux reperé ");
				System.out.println(" Grace à celui ci vous pouvez : soit piocher une carte ou recevoir une piece d'or ");
				System.out.println(" Vous voulez piocher une carte ? ");
				boolean choix = Interaction.lireOuiOuNon();
				if(choix)
				{
					Quartier gift = new Quartier();
					gift = this.getPlateau().getPioche().piocher();
					this.getJoueur().ajouterQuartierDansMain(gift);
				}
				else
				{
					System.out.println(" Vous recevez donc une piece d'or ");
					this.getJoueur().ajouterPieces(1);
				}
			}
		}
		   
	}

	@Override
	public void utiliserPouvoirAvatar() {
		// TODO Auto-generated method stub

	}
	
	@Override
    public void percevoirRessourcesSpecifiques(){
        if(!getAssassine()){
                Quartier[] cite = getJoueur().getCite();
                int count=0;
                int choix=0;
                int richesse=0;
                int positionRiche=0;
                int nombreDePauvre=0;
                ArrayList<Integer> positionsRiches=new ArrayList<Integer>();
                Random r=new Random();
                for(int i=0; i<getPlateau().getNombreJoueurs(); i++) {
                	if(getPlateau().getJoueur(i).getPersonnage().getNom().equals("Abbe")) {
                		
                	}
                	else {
                		if(richesse==getPlateau().getJoueur(i).nbPieces()) {
                    		positionsRiches.add(i);
                    	}
                    	if(getPlateau().getJoueur(i).nbPieces()==0) {
                    		nombreDePauvre+=1;
                    	}
                		if(i==0) {
                    		richesse=getPlateau().getJoueur(i).nbPieces();
                    		positionRiche=i;
                    		positionsRiches.add(i);
                    	}
                    	else {
                    		if(richesse<getPlateau().getJoueur(i).nbPieces()) {
                    			richesse=getPlateau().getJoueur(i).nbPieces();
                    			positionRiche=i;
                    			positionsRiches.clear();
                    			positionsRiches.add(i);
                    		}
                    	}
                	}
                }
                if(nombreDePauvre==(getPlateau().getNombreJoueurs()-1)) {
                	if(getJoueur().isSimule()==false) {
                		System.out.println("Aucun joueur n'a d'argent");
                	}
                }
                else if(positionsRiches.size()>1) {
                	String message="";
                	for(int i=0;i<positionsRiches.size();i++) {
                		if(i==0) {
                			message="Joueur "+i+" ("+getPlateau().getJoueur(positionsRiches.get(i)).getNom()+")";
                		}
                		else {
                			message = message+" et le Joueur "+i+" ("+getPlateau().getJoueur(positionsRiches.get(i)).getNom()+")";
                		}
                	}
                	if(getJoueur().isSimule()==true) {
                		choix=r.nextInt(positionsRiches.size());
                	}
                	else {
                		System.out.println(message+" sont les plus riches. Quel joueur choississez-vous ?");
                		choix=Interaction.lireUnEntier(0, positionsRiches.size());
                	}
                	getJoueur().ajouterPieces(1);
                	getPlateau().getJoueur(positionsRiches.get(choix)).retirerPieces(1);
                	if(getJoueur().isSimule()==true) {
                		System.out.println("     "+getPlateau().getJoueur(positionsRiches.get(choix)).getNom()+" a perdu une pi�ce");
                	}
                	else {
                		System.out.println(getPlateau().getJoueur(positionsRiches.get(choix)).getNom()+" a perdu une pi�ce");
                	}
                }
                else {
                	getPlateau().getJoueur(positionRiche).retirerPieces(1);
                	getJoueur().ajouterPieces(1);
                	if(getJoueur().isSimule()==true) {
                		System.out.println("     "+getPlateau().getJoueur(positionRiche).getNom()+" a perdu une pi�ce");
                	}
                	else {
                		System.out.println(getPlateau().getJoueur(positionRiche).getNom()+" a perdu une pi�ce");
                	}
                }
                for(int i=0; i < cite.length;i++){
                    if(cite[i] != null && cite[i].getType().equals("RELIGIEUX")){
                        count++;
                    }
                    if(cite[i] != null && cite[i].getNom().equals("Ecole de Magie")){
						count +=1;
                        System.out.println("L'école de magie vous rapporte 1 piece de plus");

					}
                }
                if(count==0) {
                	System.out.println("Vous n'avez pas de quartier religieux dans votre cite");
                }
                else if(getJoueur().isSimule()==false) {
                	System.out.println("Vous avez "+count+" quartiers religieux. Combien voulez-vous utliser de quartier pour avoir des pi�ces (le reste sera donn� en carte) :");
                	choix = Interaction.lireUnEntier(0, count+1);
                	getJoueur().ajouterPieces(choix);
                	if(count-choix==0) {
                		
                	}
                	else if(getPlateau().getPioche().nombreElements()>=(count-choix)) {
                		for(int i=0; i<(count-choix); i++) {
                			getJoueur().ajouterQuartierDansMain(getPlateau().getPioche().piocher());
                		}
                		System.out.println("Vous r�cup�rez "+choix+" pi�ce(s) et "+(count-choix)+" quartier(s)");
                	}
                	else {
                		int max=getPlateau().getPioche().nombreElements();
                		while(getPlateau().getPioche().nombreElements()>0) {
                			getJoueur().ajouterQuartierDansMain(getPlateau().getPioche().piocher());
                		}
                		System.out.println("La pioche est vide, nous vous donnons donc des pi�ces");
                		getJoueur().ajouterPieces(count-choix-max);
                		System.out.println("Vous r�cup�rez "+(choix+max)+" pi�ce(s) et "+(count-choix-max)+" quartier(s)");
                	}
                }
                else {
                	choix= r.nextInt(count+1);
                	getJoueur().ajouterPieces(choix);
                	if(count-choix==0) {
                		
                	}
                	else if(getPlateau().getPioche().nombreElements()>=(count-choix)) {
                		for(int i=0; i<(count-choix); i++) {
                			getJoueur().ajouterQuartierDansMain(getPlateau().getPioche().piocher());
                		}
                		System.out.println("     Vous r�cup�rez "+choix+" pi�ce(s) et "+(count-choix)+" quartier(s)");
                	}
                	else {
                		int max=getPlateau().getPioche().nombreElements();
                		while(getPlateau().getPioche().nombreElements()>0) {
                			getJoueur().ajouterQuartierDansMain(getPlateau().getPioche().piocher());
                		}
                		getJoueur().ajouterPieces(count-choix-max);
                		System.out.println("     Vous r�cup�rez "+(choix+max)+" pi�ce(s) et "+(count-choix-max)+" quartier(s)");
                	}
                }
            }else if(getJoueur().equals(null)){
                System.out.println("Ce personnage n'a pas été attribué");
            }else{
                System.out.println("Vous avez été assassiné, vous ne pouvez pas utiliser votre pouvoir");
        }
    }
}
