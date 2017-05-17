package fct0.models;

import fct0.utils.Contenu;
import fct0.utils.Coord;
import fct0.utils.Orientation;

public class Robot {
	
	private Coord coord;
	private Orientation orientation;
	private Env env;
	private Capteur capteur;
	
	public Robot(Coord coordonnee,Orientation orientation) {

		this.coord =coordonnee;
		this.orientation = orientation;
		this.env = null;
		this.capteur = new Capteur();
		this.capteur.updateMatrice(Orientation.S, orientation);
	}
	
	public Coord getCoord() {
		return this.coord;
	}
	
	public void setCoord(Coord c) {
		this.coord = c;
	}
	
	public Capteur getCapteur() {
		return this.capteur;
	}
	
	public Orientation getOrientation() {
		return this.orientation;
	}
	
	public void setOrientation(Orientation o) {
		this.orientation = o;
	}
	
	public Env getEnv() {
		return this.env;
	}
	
	public void setEnv(Env env) {
		this.env = env;
	}
}
