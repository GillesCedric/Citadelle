/**
 * 
 */
package controlleur;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * @author Gilles Cédric
 *
 */
public class Interaction {
	private static Scanner sc = new Scanner(System.in);

	public static int lireUnEntier() {
		int i = 0;
		boolean continu = true;
		do {
			try {
				i = sc.nextInt();
				continu = false;
			} catch (InputMismatchException e) {
				System.out.print("Veuillez rentrer un chiffre : ");
			} finally {
				sc.nextLine();
			}
		} while(continu);
		return i;
	}

	// renvoie un entier lu au clavier compris dans l'intervalle
	//     [borneMin, borneMax[
	public static int lireUnEntier(int borneMin, int borneMax) {
		int i = 0;
		boolean continu = true;
		do {
			try {
				i = sc.nextInt();
				if(i < borneMin || i >= borneMax)
					throw new InputMismatchException();
				continu = false;
			} catch (InputMismatchException e) {
				System.out.print("Veuillez rentrer un chiffre entre : "+borneMin+" et "+(borneMax-1)+" ");
			} finally {
				sc.nextLine();
			}
		} while(continu);	
		return i;
	}

	// lit les r�ponses "oui", "non", "o" ou "n" et renvoie un bool�en
	public static boolean lireOuiOuNon() {
		String response = "";
		boolean continu = true;
		do {
			try {
				response = sc.nextLine();
				if(!response.equals("oui") && !response.equals("non") && response.charAt(0) != 'o' && response.charAt(0) != 'n')
					throw new NoSuchElementException();
				continu = false;
			} catch (NoSuchElementException e) {
				System.out.print("Veuillez rentrer une réponse");
			}
		} while(continu);	
		return (response.equals("oui") || response.charAt(0) == 'o') ? true : false;
	}

	// renvoie une cha�ne de caract�re lue au clavier:
	public static String lireUneChaine() {
		String retour = "";
		try {
			retour = sc.nextLine();
		} catch (NoSuchElementException e) {
			System.out.print("Veuillez rentrer une chaîne");
			sc.next();
		}
		return retour;
	}


	
}
