class Sorciere() extends Personnage
{
       public Sorciere() 
       {
              super( Nom.Sorciere, Rang.Sorciere, Caracteristiques.Sorciere);
       }
       public void utiliserPouvoir()
       {
              
       }
       public void  utiliserPouvoir()
       {
              //Annoncer le personnage à ensorceler
                     System.out.println(" Quel personnage voulez vous ensorceler ?");
                     //Afficher la liste des personnages 
                     for (i=0 ; i < this.getPlateau().getNombreJoueurs(); i++)
                     {
                            System.out.println( i+1 +" " +this.getPlateau().getJoueur(i).monPersonnage.getNom();
                     }
                     int choix = Interaction.lireUnEntier(1, this.getPlateau().getNombreJoueurs()+1);
              //Révélation du personnage par le joueur qui le possède et perception des ressources
                     percevoirRessource(choix - 1);
             
       }
}
