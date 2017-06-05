package fct0.models;

/**
 * Cette classe permet de gérer les données de mesures à 
 * retourner pour l'affichage des graphiques.
 * @author Zhi, Maxence
 *
 */
public class Measures {
	
	private static int nbreCommande=0,nbreObstRencontres=0,nbreObstVisible=0,distanceParcourue=0;

	/**
	 * Getter de nbreCommande
	 * @return
	 */
	public static int getNbreCommande() {
		return nbreCommande;
	}

	/**
	 * Incremente la valeur de nbreCommande
	 */
	public static void incrementNbreCommande() {
		nbreCommande++;
	}

	/**
	 * Getter de nbreObstRencontres
	 * @return
	 */
	public static int getNbreObstRencontres() {
		return nbreObstRencontres;
	}

	/**
	 * Incremente la valeur de nbreObstRencontres
	 */
	public static void incrementNbreObstRencontres() {
		nbreObstRencontres++;
	}

	/**
	 * Getter de nbreObstVisible
	 * @return
	 */
	public static int getNbreObstVisible() {
		return nbreObstVisible;
	}

	/**
	 * Incremente la valeur de nbreObstVisible
	 */
	public static void incrementNbreObstVisible() {
		nbreObstVisible++;
	}

	/**
	 * Getter de distanceParcourue
	 * @return
	 */
	public static int getDistanceParcourue() {
		return distanceParcourue;
	}

	/**
	 * Incremente la valeur de distanceParcourue
	 */
	public static void incrementDistanceParcourue() {
		distanceParcourue++;
	}
	
	
}