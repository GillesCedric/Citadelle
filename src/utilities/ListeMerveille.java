/**
 * 
 */
package utilities;

import modele.Quartier;

/**
 * @author Gilles C�dric
 *
 */
public enum ListeMerveille {
	BASILIQUE("Basilique",4,"A la fin de la partie, marquez 1 point suppl�mentaire pour chaque quartier au co�t de construction impair dans votre cit�"),
	BIBLIOTHEQUE("Biblioth�que",6,"Si vous choisissez de piocher des cartes au d�but du tour, concervez-les toutes"),
	CAPITOLE("Capitole",5,"A la fin de la partie, marquez 3 points suppl�mentaires si vous avez au moins 3 quartiers du m�me type (couleur) dans votre cit�. Vous ne pouvez utiliser l�effet du capitole qu�une seule fois"),
	CARRIERE("Carrière",5,"Vous pouvez b�tir des quartiers identiques � d�autres quartiers de votre cit�. Le propri�taire de la carri�re peut b�tir autant de quartiers identiques qu�il le souhaite, mais ne peut utiliser le pouvoir de l�Echevin, du Diplomate ou du Capitaine pour acqu�rir des quartiers identiques"),
	CATACOMBES("Catacombes",0,"Les catacombes ne peuvent pas �tre b�ties. A la fin de la partie, si vous avez les catacombes dans votre main, marquez 3 points suppl�mentaires"),
	CHANTIER("Chantier",3,"Pour b�tir un quartier, vous pouvez d�truire le chantier au lieu de payer le co�t de construction. L�Echevin ne peut pas confisquer un quartier b�ti en d�truisant le chantier"),
	COURS_DES_MIRACLES("Cours des miracles",2,"Pour le calcul du score final, la Cour des Miracles est consid�r�e comme un quartier de type (couleur) de votre choix. Dans la cas o� le propri�taire la consid�re comme un quartier noble, militaire, marchant ou religieux, la Cour des Miracles ne peut plus �tre consid�r�e comme une merveille"),
	DONJON("Donjon",3,"Le Donjon ne peut �tre affect� par les pouvoirs des personnages de rang 8"),
	DRACOPORT("Dracoport",6,"Marquez 2 points suppl�mentaires � la fin de la partie"),
	ECOLE_DE_MAGIE("Ecole de Magie",6,"Pour la perception des revenus des personnages, l�Ecole de Magie est consid�r�e comme un quartier du type (couleur) de votre choix"),
	ECURIES("Ecuries",2,"Vous pouvez b�tir les Ecuries sans qu�elles comptent dans votre permis de construire. Si les Ecuries sont confisqu�es par l�Echevin, il peut quand m�me b�tir un autre quartier que celui-ci"),
	FONTAINE_AUX_SOUHAITS("Fontaine aux Souhaits",5,"A la fin de la partie, marquez 1 point suppl�mentaire par merveille dans votre cit�, y compris la Fontaine aux Souhaits"),
	FORGE("Forge",5,"Une fois par tour, vous pouvez payez 2 pi�ces d�or pour piocher 3 cartes"),
	GRANDE_MURAILLE("Grande Muraille",6,"Les personnages de rang 8 doivent payer 1 pi�ce d�or suppl�mentaire pour affecter un quartier de votre cit�. La Grande Muraille n�affecte pas le co�t de construction des quartiers de la cit� du Diplomate quand il utilise son pouvoir"),
	HOSPICE("Hospice",4,"Si vous n�avez aucune pi�ce d�or dans votre tr�sor � la fin de votre tour, gagnez 1 pi�ce d�or. Si la Sorci�re ne reprend pas son tour de jeu, elle ne le termine donc pas et ne peut pas utiliser l�effet de l�Hospice � la fin de son tour. L�Alchimiste utilise l�effet de l�Hospice avant d�appliquer son propre pouvoir"),
	LABORATOIRE("Laboratoire",5,"Une fois par tour, vous pouvez d�fausser 1 carte pour recevoir 2 pi�ces d�or"),
	MANUFACTURE("Manufacture",5,"Payez 1 pi�ce d�or de moins lorsque vous b�tissez une autre merveille"),
	MINE_DOR("Mine d'Or",6,"Si vous choisissez de recevoir des pi�ces d�or en d�but de tour, prenez-en 1 suppl�mentaire"),
	MONUMENT("Monument",4,"Vous ne pouvez pas b�tir le Monument si vous avez d�j� au moins 5 quartiers dans votre cit�. Le Monument compte comme 2 quartiers pour compl�ter votre cit�"),
	MUSEE("Musée",4,"Une fois par tour, vous pouvez placer une carte de votre main, face cach�e, sous le Mus�e. A la fin de la partie, marquez 1 point suppl�mentaire par carte sous le Mus�e. Si le Mus�e est d�plac� d�une cit� � une autre, il conserve toutes les cartes qui �taient dessous. Si le Mus�e est d�truit, les cartes sont d�fauss�es, face cach�e, sous la pioche"),
	NECROPOLE("Nécropole",5,"Pour b�tir la n�cropole, vous pouvez d�truire un quartier de votre cit� au lieu de payer son co�t de construction. Le Bailli ne peut pas confisquer la N�cropole sans payer son co�t de construction"),
	OBSERVATOIRE("Observatoire",4,"Si vous choisissez de piocher des cartes au d�but de votre tour, vous choisissez la carte parmi 3 cartes au lieu de 2"),
	PARC("Parc",6,"Si vous n�avez aucune carte en main � la fin de votre tour, piochez 2 cartes. Si la Sorci�re ne reprend pas son tour, elle ne peut pas utiliser l�effet du Parc `a la fin de son tour"),
	POUDRIERE("Poudrière",3,"Durant votre tour, vous pouvez d�tuire simultan�ement la Poudri�re et un autre quartier votre choix. Vous ne pouvez pas d�truire un quartier d�une cit� compl�te"),
	SALLES_DES_CARTES("Salles des Cartes",5,"A la fin de la partie, marquez 1 point suppl�mentaire par carte dans votre main"),
	STATUE_EQUESTRE("Statue Equestre",3,"Si vous d�tenez le Couronne � la fin de la partie, marquez 5 points suppl�mentaires"),
	THEATRE("Théâtre",6,"A la fin de la phase de s�lection, vous pouvez �changer votre carte Personnage face cach�e avec celle d�un autre joueur. Le propri�taire du Th��tre choisit avec qui il fait l��change, sans avoir vu aucune des cartes des autres joueurs. Les cartes �chang�es en peuvent �tre r�v�l�es aux autres joueurs avant d��tre appel�es. Dans une partie � 2 ou 3 joueurs, le propri�taire "),
	TOUR_DIVOIRE("Tour d'Ivoire",5,"Si la Tour d�Ivoir est votre unique merveille � la fin de la partie, marquez 5 points suppl�mentaires. Si la Cour des Miracles et la Tour d�Ivoire sont les deux seules merveilles d�une cit�, et que le joueur d�cide de consid�rer la Cour des Miracles comme n��tant pas plus une merveille, alors il peut b�n�ficier du bonus de la Tour d�Ivoire"),
	TRESOR_IMPERIAL("Trésor Impérial",5,"A la fin de la partie, marquez 1 point suppl�mentaire par pi�ce d�or dans votre tr�sor"),
	TRIPOT("Tripot",6,"Vous pouvez payer tout ou partie du coût de construction du Tripot en cartes de votre main, au prix de 1 carte pour 1 pièce d'or. Si le Tripot est confisqué par l'Echevin, le joueur n'est remboursé que de l'or qu�il a dépensé, pas des cartes");

	private ListeMerveille(String nom, int cout, String caracteristique) {
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
