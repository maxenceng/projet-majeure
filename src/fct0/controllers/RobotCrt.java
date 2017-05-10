package fct0.controllers;

import fct0.models.Env;
import fct0.models.Robot;
import fct0.utils.Coord;
import fct0.utils.Direction;

public class RobotCrt {

	private Env env;
	private Robot robot;
	
	public RobotCrt(Env env, Robot robot) {
		this.env = env;
		this.robot = robot;
	}
	
	public void move(Direction d) {
		int xFinal = this.robot.getCoord().getX() + d.x; 
		int yFinal = this.robot.getCoord().getY() + d.y;
		if(this.isMoveOk(xFinal, yFinal)) {
			this.robot.getCapteur().updateMatrice(this.robot.getOrientation(), d.o);
			this.robot.setOrientation(d.o);
			this.robot.setCoord(new Coord(xFinal, yFinal));
		}
	}
	
	public Boolean isMoveOk(int xFinal, int yFinal) {
		if(xFinal < 0 || xFinal > this.env.getTailleX() || yFinal < 0 || yFinal > this.env.getTailleY()) {
			return false;
		}
		return true;
	}
	
	public Integer[][] getDonneesCapteur() {
		return this.robot.getCapteur().getMatrice();
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
	
}
