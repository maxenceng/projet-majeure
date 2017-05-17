package fct0.models;

import java.util.Formatter;
import java.util.Locale;

import fct0.utils.Contenu;



public class Env {
	private double pourcentageObstacle=0;
	private Grille grille;
	private int tailleX=0,tailleY=0;
	
	
	/**
	 * Cette méthode initialise la taille de la matrice et le pourcentage de chance d'avoir un obstacle dans une cellule
	 * @param xinit
	 * @param yinit
	 * @param pourcentageinit
	 */
	public Env(int xinit,int yinit,double pourcentageinit) {
		tailleX=xinit;
		tailleY=yinit;
		pourcentageObstacle=pourcentageinit;
		grille = new Grille(tailleX, tailleY);
	}
	
	/**
	 * 
	 */
	public void generateEnvironnement(){
		grille=new Grille(tailleX,tailleY); //Création de la matrice
		int x=0,y=0;
		double chance=0;
		pourcentageObstacle=pourcentageObstacle*0.01;
		
		
		for(x=0;x<tailleX;x++)
		{
			for(y=0;y<tailleY;y++)
			{
				chance=Math.random();
				if(chance<pourcentageObstacle)
					grille.setMatrice(x,y,Contenu.OBSTACLE);
				else
					grille.setMatrice(x,y,Contenu.FREE);
			}
		}
		
	}
	
	@Override
	public String toString() {
		Contenu[][] matrice = this.grille.getMatrice();
		return this.printMatrix(matrice);
	}
	
	public Contenu findContenu(int x,int y){
		if(x < 0 || x > this.tailleX - 1 || y < 0 || y > this.tailleY - 1) {
			return null;
		}
		return grille.getMatrice()[x][y];
	}

	public void setContenu(Contenu contenu,int x,int y)
	{
		grille.setContenuG(contenu,x,y);
	}
	public Contenu getContenu(int x,int y)
	{
		return grille.getContenuG(x,y);
	}
	
	
	
	public String printMatrix(Contenu[][] matrix) {
		StringBuilder sb = new StringBuilder();
		Formatter formatter = new Formatter(sb, Locale.FRENCH);
		String formatS = "%1$5s";
		String[] valueTab = new String[tailleX+1];
		valueTab[0]="";
		for (int index = 0; index < tailleX; index++) {
			formatS = formatS + " %" + (index + 2) + "$5s";
			valueTab[index+1] = String.valueOf(index);
		}
		formatter.format(formatS + "\n", valueTab);
		formatter.format("%1$5s | %2$47s\n", "","_______________________________________________");
				for (int i = 0; i < tailleY; i++) {
					String formatS2 = "%1$5s | ";
					String[] valueTab2 = new String[tailleY+1];
					valueTab2[0]=String.valueOf(i);
					for (int j = 0; j < tailleX; j++) {
						formatS2 = formatS2 + " %" + (j + 2) + "$5s";
						valueTab2[j+1] = matrix[i][j].toString();
					}
					formatter.format(formatS2 + "\n", valueTab2);
				}
		return formatter.toString() ;
	}		
	
	public Grille getGrille() {
		return this.grille;
	}
	
	public int getTailleX() {
		return this.tailleX;
	}
	
	public int getTailleY() {
		return this.tailleY;
	}
	
	public int getTailleXY(){
		int taille;
		taille=this.tailleX*this.tailleY;
		return taille;
	}

}