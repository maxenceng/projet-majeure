package fct0.models;

import fct0.utils.Contenu;

public class Grille {
	private int x=0;
	private int y=0;
	private Contenu matrice[][];

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
	
	public Contenu[][] getMatrice() {
		return matrice;
	}
	
	public void setMatrice(int x,int y, Contenu type) {
		if(x < 0 || x > this.x - 1 || y < 0 || y > this.y - 1) {
			return;
		}
		matrice[x][y]=type;
	}
	
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
}