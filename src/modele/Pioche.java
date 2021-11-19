package modele;

import java.util.ArrayList;
import java.util.Random;

public class Pioche {
	private ArrayList<Quartier> listPioche;

	public void setlistPioche(ArrayList<Quartier> neuve) {
		this.listPioche = neuve;
	}

	public ArrayList<Quartier> getlistPioche() {
		return listPioche;
	}

	public Pioche() {
		listPioche = new ArrayList<Quartier>();
	}

	public Quartier piocher() {
		if (listPioche.size() >= 1) {
			return listPioche.remove(((listPioche.size()) - 1)); /* Retourne le dernier élément de la liste */
		} else
			return null;
	}

	public void ajouter(Quartier nouveau) {
		listPioche.add(0, nouveau);
	}

	public int nombreElements() {
		return listPioche.size();
	}

	public void melanger() {
		Random generateur = new Random();
		for (int i = 1; i < 100; i++) {
			int a = generateur.nextInt(listPioche.size()-1);
			int b = generateur.nextInt(listPioche.size()-1);

			Quartier quartier = listPioche.get(a);
			listPioche.set(a, listPioche.get(b));
			listPioche.set(b, quartier);

		}

	}
}
