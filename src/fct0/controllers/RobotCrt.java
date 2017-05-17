package fct0.controllers;

import java.util.ArrayList;
import java.util.List;

import fct0.models.Env;
import fct0.models.Measures;
import fct0.models.Robot;
import fct0.utils.Coord;
import fct0.utils.Direction;
import fct0.utils.Contenu;

public class RobotCrt {

	private Env env;
	private Robot robot;
	
	public RobotCrt(Env env, Robot robot) {
		this.env = env;
		this.env.generateEnvironnement();
		this.robot = robot;
		env.setContenu(Contenu.ROBOT,this.robot.getCoord().getX(),this.robot.getCoord().getY());
		this.robot.setEnv(new Env(this.env.getTailleX(), this.env.getTailleY(), 0));
		this.updateEnvRobot();
	}
	
	public void move(Direction d) {
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
		}
		
	}
	
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
	
	public Integer[][] getDonneesCapteur() {
		return this.robot.getCapteur().getMatrice();
	}
	
	public int getCapteurTaille() {
		return this.robot.getCapteur().getTaille();
	}
	
	public Env getEnv() {
		return this.env;
	}
	
	public Env getEnvRobot() {
		return this.robot.getEnv();
	}
	
	public Robot getRobot() {
		return this.robot;
	}
	
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