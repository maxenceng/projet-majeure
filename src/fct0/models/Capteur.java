package fct0.models;

import fct0.utils.Orientation;

public class Capteur {
	
	private static final int LEN = 7;
	
	private Integer[][] matrice = new Integer[LEN][LEN];
	
	public Capteur() {
		for(int i = 0; i < LEN; i ++) {
			for(int j = 0; j < LEN; j++) {
					this.matrice[i][j] = 0;
				if((j == (int) LEN/2  && (i != 0 && i != LEN-1)) || ((j == (int) LEN/2 - 1 || j == (int) LEN/2 + 1) && (i > 2 && i != LEN-1))) {
					this.matrice[i][j] = 1;
				}
			}
		}
		this.matrice[(int) LEN/2 + 1][(int) LEN/2] = 2;
	}
	
	@Override
	public String toString() {
		String s = "";
		for(int i = 0; i < LEN; i ++) {
			for(int j = 0; j < LEN; j++) {
				s += this.matrice[i][j] + "\t";
			}
			s += "\n";
		}
		return s;
	}
	
	private void rotationDroite() {
		Integer[][] rotate = new Integer[LEN][LEN];
		for(int i = 0; i < LEN; i ++) {
			for(int j = 0; j < LEN; j++) {
				rotate[j][LEN-1-i] = this.matrice[i][j];
			}
		}
		this.matrice = rotate;
	}
	
	private void rotationGauche() {
		Integer[][] rotate = new Integer[LEN][LEN];
		for(int i = 0; i < LEN; i ++) {
			for(int j = 0; j < LEN; j++) {
				rotate[LEN-1-j][i] = this.matrice[i][j];
			}
		}
		this.matrice = rotate;
	}
	
	
	public void updateMatrice(Orientation ancienne, Orientation nouvelle) {
		int diff = nouvelle.ordinal() - ancienne.ordinal();
		if(diff == 1 || diff == -3) {
			this.rotationDroite();
		}
		if(diff == -1 || diff == 3) {
			this.rotationGauche();
		}
		if(Math.abs(diff) == 2) {
			this.rotationDroite();
			this.rotationDroite();
		}
	}
	
	public Integer[][] getMatrice() {
		return this.matrice;
	}
	
	public int getTaille() {
		return this.matrice.length;
	}
	
}
