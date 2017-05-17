package fct0.models;

public class Measures {
	
	private static int nbreCommande=0,nbreObstRencontres=0,nbreObstVisible=0,distanceParcourue=0;

	public static int getNbreCommande() {
		return nbreCommande;
	}

	public static void incrementNbreCommande() {
		nbreCommande++;
	}

	public static int getNbreObstRencontres() {
		return nbreObstRencontres;
	}

	public static void incrementNbreObstRencontres() {
		nbreObstRencontres++;
	}

	public static int getNbreObstVisible() {
		return nbreObstVisible;
	}

	public static void incrementNbreObstVisible() {
		nbreObstVisible++;
	}

	public static int getDistanceParcourue() {
		return distanceParcourue;
	}

	public static void incrementDistanceParcourue() {
		distanceParcourue++;
	}
	
	
}