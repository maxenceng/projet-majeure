package fct0.models;

import fct0.utils.Contenu;

/**
 * Cette classe permet de gérer les cases d'une grille.
 * @author Cecile, Abdeljabar
 *
 */
public class Grille {
	private int x=0;
	private int y=0;
	private Contenu matrice[][];
	
	/**
	 * Ce constructeur permet d'initialiser toutes les cases
	 * d'une grille à UNKNOWN.
	 * @param xinit
	 * @param yinit
	 */
	public Grille(int xinit,int yinit) {
		x=xinit;
		y=yinit;
		matrice=new Contenu[x][y];
		for(x=0;x<xinit;x++)
		{
			for(y=0;y<yinit;y++)
			{
				matrice[x][y]=Contenu.UNKNOWN;
			}
		}
	}
	
	/**
	 * Cette méthode permet de récupérer le contenu de toute la grille.
	 * @return Contenu
	 */
	public Contenu[][] getMatrice() {
		return matrice;
	}
	
	/**
	 * Cette permet de mettre à jour une case de la grille.
	 * @param x
	 * @param y
	 * @param type
	 */
	public void setMatrice(int x,int y, Contenu type) {
		if(x < 0 || x > this.x - 1 || y < 0 || y > this.y - 1) {
			return;
		}
		matrice[x][y]=type;
	}
	
	/**
	 * Cette méthode permet de récupérer la coordonnée en x.
	 * @return int
	 */
	public int getX(){
		return this.x;
	}
	
	
	/**
	 * Cette méthode permet de récupérer la coordonnée en y.
	 * @return int
	 */
	public int getY(){
		return this.y;
	}
	
	/**
	 * Cette méthode permet de récupérer le contenu d'une case.
	 * @param x
	 * @param y
	 * @return Contenu
	 */
	public Contenu getContenuG(int x,int y){
		return this.matrice[x][y];
		
	}
	
	/**
	 * Cette méthode permet de mettre à jour le contenu
	 * d'une case.
	 * @param contenu
	 * @param x
	 * @param y
	 */
	public void setContenuG(Contenu contenu,int x,int y){
		this.matrice[x][y]=contenu;
		
	}
	
	
}