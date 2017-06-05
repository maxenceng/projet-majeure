package fct0.models;

import fct0.utils.Contenu;
import fct0.utils.Coord;
import fct0.utils.Orientation;

/**
 * Cette classe permet de gérer le robot du jeu.
 * @author Cecile, Abdeljabar
 *
 */
public class Robot {
	
	private Coord coord;
	private Orientation orientation;
	private Env env;
	private Capteur capteur;
	
	
	/**
	 * Cette méthode initialise les coordonnées du robot et son orientation dans le jeu
	 * @param coordonnee
	 * @param orientation
	 */
	public Robot(Coord coordonnee,Orientation orientation) {

		this.coord =coordonnee;
		this.orientation = orientation;
		this.env = null;
		this.capteur = new Capteur();
		this.capteur.updateMatrice(Orientation.S, orientation);
	}
	
	/**
	 * Getter de coord
	 * @return
	 */
	public Coord getCoord() {
		return this.coord;
	}
	
	/**
	 * Setter de coord
	 * @param c
	 */
	public void setCoord(Coord c) {
		this.coord = c;
	}
	
	/**
	 * Getter de capteur
	 * @return
	 */
	public Capteur getCapteur() {
		return this.capteur;
	}
	
	/**
	 * Getter de orientation
	 * @return
	 */
	public Orientation getOrientation() {
		return this.orientation;
	}
	
	/**
	 * Setter de orientation
	 * @return
	 */
	public void setOrientation(Orientation o) {
		this.orientation = o;
	}
	
	/**
	 * Getter de env
	 * @return
	 */
	public Env getEnv() {
		return this.env;
	}
	
	/**
	 * Setter de env
	 * @param env
	 */
	public void setEnv(Env env) {
		this.env = env;
	}
}
