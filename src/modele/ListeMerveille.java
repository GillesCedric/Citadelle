/**
 * 
 */
package modele;

/**
 * @author Gilles Cédric
 *
 */
public enum ListeMerveille {
	BASILIQUE("Basilique",4,"A la fin de la partie, marquez 1 point supplémentaire pour chaque quartier au coût de construction impair dans votre cité"),
	BIBLIOTHEQUE("Bibliothèque",6,"Si vous choisissez de piocher des cartes au début du tour, concervez-les toutes"),
	CAPITOLE("Capitole",5,"A la fin de la partie, marquez 3 points supplémentaires si vous avez au moins 3 quartiers du même type (couleur) dans votre cité. Vous ne pouvez utiliser l’effet du capitole qu’une seule fois"),
	CARRIERE("Carrière",5,"Vous pouvez bâtir des quartiers identiques à d’autres quartiers de votre cité. Le propriétaire de la carrière peut bâtir autant de quartiers identiques qu’il le souhaite, mais ne peut utiliser le pouvoir de l’Echevin, du Diplomate ou du Capitaine pour acquérir des quartiers identiques"),
	CATACOMBES("Catacombes",0,"Les catacombes ne peuvent pas être bâties. A la fin de la partie, si vous avez les catacombes dans votre main, marquez 3 points supplémentaires"),
	CHANTIER("Chantier",3,"Pour bâtir un quartier, vous pouvez détruire le chantier au lieu de payer le coût de construction. L’Echevin ne peut pas confisquer un quartier bâti en détruisant le chantier"),
	COURS_DES_MIRACLES("Cours des miracles",2,"Pour le calcul du score final, la Cour des Miracles est considérée comme un quartier de type (couleur) de votre choix. Dans la cas où le propriétaire la considère comme un quartier noble, militaire, marchant ou religieux, la Cour des Miracles ne peut plus être considérée comme une merveille"),
	DONJON("Donjon",3,"Le Donjon ne peut être affecté par les pouvoirs des personnages de rang 8"),
	DRACOPORT("Dracoport",6,"Marquez 2 points supplémentaires à la fin de la partie"),
	ECOLE_DE_MAGIE("Ecole de Magie",6,"Pour la perception des revenus des personnages, l’Ecole de Magie est considérée comme un quartier du type (couleur) de votre choix"),
	ECURIES("Ecuries",2,"Vous pouvez bâtir les Ecuries sans qu’elles comptent dans votre permis de construire. Si les Ecuries sont confisquées par l’Echevin, il peut quand même bâtir un autre quartier que celui-ci"),
	FONTAINE_AUX_SOUHAITS("Fontaine aux Souhaits",5,"A la fin de la partie, marquez 1 point supplémentaire par merveille dans votre cité, y compris la Fontaine aux Souhaits"),
	FORGE("Forge",5,"Une fois par tour, vous pouvez payez 2 pièces d’or pour piocher 3 cartes"),
	GRANDE_MURAILLE("Grande Muraille",6,"Les personnages de rang 8 doivent payer 1 pièce d’or supplémentaire pour affecter un quartier de votre cité. La Grande Muraille n’affecte pas le coût de construction des quartiers de la cité du Diplomate quand il utilise son pouvoir"),
	HOSPICE("Hospice",4,"Si vous n’avez aucune pièce d’or dans votre trésor à la fin de votre tour, gagnez 1 pièce d’or. Si la Sorcière ne reprend pas son tour de jeu, elle ne le termine donc pas et ne peut pas utiliser l’effet de l’Hospice à la fin de son tour. L’Alchimiste utilise l’effet de l’Hospice avant d’appliquer son propre pouvoir"),
	LABORATOIRE("Laboratoire",5,"Une fois par tour, vous pouvez défausser 1 carte pour recevoir 2 pièces d’or"),
	MANUFACTURE("Manufacture",5,"Payez 1 pièce d’or de moins lorsque vous bâtissez une autre merveille"),
	MINE_DOR("Mine d'Or",6,"Si vous choisissez de recevoir des pièces d’or en début de tour, prenez-en 1 supplémentaire"),
	MONUMENT("Monument",4,"Vous ne pouvez pas bâtir le Monument si vous avez déjà au moins 5 quartiers dans votre cité. Le Monument compte comme 2 quartiers pour compléter votre cité"),
	MUSEE("Musée",4,"Une fois par tour, vous pouvez placer une carte de votre main, face cachée, sous le Musée. A la fin de la partie, marquez 1 point supplémentaire par carte sous le Musée. Si le Musée est déplacé d’une cité à une autre, il conserve toutes les cartes qui étaient dessous. Si le Musée est détruit, les cartes sont défaussées, face cachée, sous la pioche"),
	NECROPOLE("Nécropole",5,"Pour bâtir la nécropole, vous pouvez détruire un quartier de votre cité au lieu de payer son coût de construction. Le Bailli ne peut pas confisquer la Nécropole sans payer son coût de construction"),
	OBSERVATOIRE("Observatoire",4,"Si vous choisissez de piocher des cartes au début de votre tour, vous choisissez la carte parmi 3 cartes au lieu de 2"),
	PARC("Parc",6,"Si vous n’avez aucune carte en main à la fin de votre tour, piochez 2 cartes. Si la Sorcière ne reprend pas son tour, elle ne peut pas utiliser l’effet du Parc `a la fin de son tour"),
	PODRIERE("Poudrière",3,"Durant votre tour, vous pouvez détuire simultan´ement la Poudrière et un autre quartier votre choix. Vous ne pouvez pas détruire un quartier d’une cité complète"),
	SALLES_DES_CARTES("Salles des Cartes",5,"A la fin de la partie, marquez 1 point supplémentaire par carte dans votre main"),
	STATUE_EQUESTRE("Statue Equestre",3,"Si vous détenez le Couronne à la fin de la partie, marquez 5 points supplémentaires"),
	THEATRE("Théâtre",6,"A la fin de la phase de sélection, vous pouvez échanger votre carte Personnage face cachée avec celle d’un autre joueur. Le propriétaire du Théâtre choisit avec qui il fait l’échange, sans avoir vu aucune des cartes des autres joueurs. Les cartes échangées en peuvent être révélées aux autres joueurs avant d’être appelées. Dans une partie à 2 ou 3 joueurs, le propriétaire "),
	TOUR_DIVOIRE("Tour d'Ivoire",5,"Si la Tour d’Ivoir est votre unique merveille à la fin de la partie, marquez 5 points supplémentaires. Si la Cour des Miracles et la Tour d’Ivoire sont les deux seules merveilles d’une cité, et que le joueur décide de considérer la Cour des Miracles comme n’étant pas plus une merveille, alors il peut bénéficier du bonus de la Tour d’Ivoire"),
	TRESOR_IMPERIAL("Trésor Impérial",5,"A la fin de la partie, marquez 1 point supplémentaire par pièce d’or dans votre trésor"),
	TRIPOT("Tripot",6,"Vous pouvez payer tout ou partie du coût de construction du Tripot en cartes de votre main, au prix de 1 carte pour 1 pièce d’or. Si le Tripot est confisqué par l’Echevin, le joueur n’est remboursé que de l’or qu’il a dépensé, pas des cartes");

	private ListeMerveille(String nom,int cout,String caracteristique) {
		this.nom = nom;
		this.coutConstruction = cout;
		this.type = Quartier.TYPE_QUARTIERS[4];
		this.caracteristique = caracteristique;
	}


	private final String nom;
	private final String type;
	private int coutConstruction;
	private String caracteristique;
	
	/**
	 * @return the caracteristique
	 */
	public String getCaracteristique() {
		return caracteristique;
	}
	/**
	 * @param caracteristique the caracteristique to set
	 */
	public void setCaracteristique(String caracteristique) {
		this.caracteristique = caracteristique;
	}
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

}
