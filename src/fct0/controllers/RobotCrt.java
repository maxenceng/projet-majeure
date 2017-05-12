package fct0.controllers;

import fct0.models.Env;
import fct0.models.Robot;
import fct0.utils.Coord;
import fct0.utils.Direction;
import fct0.utils.Contenu;

public class RobotCrt {

	private Env env;
	private Robot robot;
	
	public RobotCrt(Env env, Robot robot) {
		this.env = env;
		this.robot = robot;
		
	
		env.setContenu(Contenu.ROBOT,this.robot.getCoord().getX(),this.robot.getCoord().getY());
	}
	
	public void move(Direction d) {
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
