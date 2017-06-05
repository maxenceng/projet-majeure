package fct0.utils;

import java.io.Serializable;

/**
 * Classe permettant l'enregistrement des données x et y 
 * des éléments du jeu dans une même variable.
 * @author 
 *
 */
public class Coord implements Serializable {
	private int x;
	private int y;

	public Coord(int x, int y) {

		this.x = x;
		this.y = y;

	}
	
	@Override
	public String toString() {
		return "[x=" + this.x + ", y=" + this.y + "]";
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		Coord other = (Coord) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
}
