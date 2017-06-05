package fct0.controllers;

import java.util.ArrayList;
import java.util.List;

import fct0.models.Env;
import fct0.models.Measures;
import fct0.models.Robot;
import fct0.utils.Coord;
import fct0.utils.Direction;
import fct0.utils.Contenu;

/**
 * Cette classe permet de gérer l'environnement du robot et le déplacement du robot.
 * @author Maxence
 *
 */
public class RobotCrt {

	private Env env;
	private Robot robot;
	
	/**
	 * RobotCrt est le constructeur de la classe RobotCrt. 
	 * Il permet d'initialiser un environnement et un robot.
	 * @param env
	 * @param robot
	 */
	public RobotCrt(Env env, Robot robot) {
		this.env = env;
		this.env.generateEnvironnement();
		this.robot = robot;
		env.setContenu(Contenu.ROBOT,this.robot.getCoord().getX(),this.robot.getCoord().getY());
		this.robot.setEnv(new Env(this.env.getTailleX(), this.env.getTailleY(), 0));
		this.updateEnvRobot();
	}
	
	/**
	 * Cette méthode permet de bouger le robot selon une direction.
	 * La méthode vérifie tout d'abord la possibilité du déplacement 
	 * et d'effectuer le déplacement si le déplacement est possible.
	 * De plus, cette méthode effectue une mise à jour de l'environnement
	 * du robot une fois le déplacement effectué.
	 * @param d
	 */
	public boolean move(Direction d) {
		Measures.incrementNbreCommande();
		int xInit=this.robot.getCoord().getX();
		int xFinal = xInit + d.x; 
		int yInit=this.robot.getCoord().getY();
		int yFinal = yInit + d.y;
		if(this.isMoveOk(xFinal, yFinal)) {
			this.robot.getCapteur().updateMatrice(this.robot.getOrientation(), d.o);
			this.robot.setOrientation(d.o);
			this.robot.setCoord(new Coord(xFinal, yFinal));
			env.setContenu(Contenu.FREE,xInit,yInit);
			env.setContenu(Contenu.ROBOT,xFinal,yFinal);
			this.updateEnvRobot();
			Measures.incrementDistanceParcourue();
			return true;
		}
		return false;
		
	}
	
	/**
	 * Cette méthode permet de vérifier grâce aux coordonnées finales
	 * si le déplacement est possible.
	 * 
	 * @param xFinal
	 * @param yFinal
	 * @return "true" si le déplacement est possible, sinon "false"
	 */
	public Boolean isMoveOk(int xFinal, int yFinal) {
		if(xFinal < 0 || xFinal >= this.env.getTailleX() || yFinal < 0 || yFinal >= this.env.getTailleY()) {
			return false;
		}
		if(this.getEnv().findContenu(xFinal, yFinal) == Contenu.OBSTACLE) {
			Measures.incrementNbreObstRencontres();
			return false;
		}
		if(this.getEnv().findContenu(xFinal, yFinal) == Contenu.ROBOT) {
			return false;
		}
		return true;
	}
	
	/**
	 * Récupère les données du capteur
	 * @return Integer[][]
	 */
	public Integer[][] getDonneesCapteur() {
		return this.robot.getCapteur().getMatrice();
	}
	

	/**
	 * Récupère la taille du capteur.
	 * @return Int
	 */
	public int getCapteurTaille() {
		return this.robot.getCapteur().getTaille();
	}
	

	/**
	 * Récupère l'environnement du RobotCrt
	 * @return Env
	 */
	public Env getEnv() {
		return this.env;
	}
	
	/**
	 * Récupère l'environnement du robot de RobotCrt
	 * @return Env
	 */
	public Env getEnvRobot() {
		return this.robot.getEnv();
	}
	

	/**
	 * Récupère le robot de RobotCrt.
	 * @return Robot
	 */
	public Robot getRobot() {
		return this.robot;
	}
	
	/**
	 * Retourne les coordonnées de la position du Robot.
	 * @return Coord
	 */
	private Coord getPositionRobotMatrice() {
		Integer[][] data = this.getDonneesCapteur();
		for(int i = 0; i < this.getCapteurTaille(); i++) {
			for(int j = 0; j < this.getCapteurTaille(); j++) {
				if(data[i][j] == 2) {
					return new Coord(i, j);
				}
			}
		}
		return null;
	}
	
	/**
	 * Retourne une liste des coordonnées des cases encore non découvertes.
	 * @return List<Coord>
	 */
	private List<Coord> getPositionsADecouvrirMatrice() {
		List<Coord> list = new ArrayList<Coord>();
		Integer[][] data = this.getDonneesCapteur();
		Coord posRobot = this.getPositionRobotMatrice();
		for(int i = 0; i < this.getCapteurTaille(); i++) {
			for(int j = 0; j < this.getCapteurTaille(); j++) {
				if(data[i][j] == 1) {
					list.add(new Coord(posRobot.getX() - i, posRobot.getY() -j));
				}
			}
		}
		return list;
	}
	
	/**
	 * Met à jour l'environnement du robot.
	 */
	public void updateEnvRobot() {
		int x = this.robot.getCoord().getX();
		int y = this.robot.getCoord().getY();
		for(Coord c : this.getPositionsADecouvrirMatrice()) {
			Contenu contenuEnv = this.env.findContenu(x + c.getX(), y + c.getY());
			Contenu contenuEnvRobot = this.getEnvRobot().findContenu(x + c.getX(), y + c.getY());
			if(contenuEnv != null && contenuEnvRobot != null) {
				if(contenuEnvRobot.equals(Contenu.UNKNOWN) || contenuEnvRobot.equals(Contenu.ROBOT)) {
					this.getEnvRobot().setContenu(contenuEnv, x + c.getX(), y + c.getY());
					if(contenuEnv.equals(Contenu.OBSTACLE)) {
						Measures.incrementNbreObstVisible();
					}
				}
			}
		}
		this.getEnvRobot().setContenu(Contenu.ROBOT, x, y);
	}

}