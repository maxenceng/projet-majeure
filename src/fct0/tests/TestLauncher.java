package fct0.tests;

import fct0.controllers.RobotCrt;
import fct0.models.Capteur;
import fct0.models.Env;
import fct0.models.Robot;
import fct0.utils.Contenu;
import fct0.utils.Coord;
import fct0.utils.Direction;
import fct0.utils.Orientation;

public class TestLauncher {
	public static void main(String[] args) {
		Robot robot = new Robot(new Coord(1, 2), Orientation.W);
		Coord c = robot.getCoord();
		Capteur cap = robot.getCapteur();
		cap.updateMatrice(robot.getOrientation(), Orientation.E);
		
		Env env = new Env(6,6,10);
		env.generateEnvironnement();
		RobotCrt robotCrt = new RobotCrt(env, robot);
		Contenu[][] matrice = robotCrt.getEnv().getGrille().getMatrice();
		System.out.println(robotCrt.getEnv().printMatrix(matrice));
		System.out.println(robotCrt.getRobot().getCoord());
		robotCrt.move(Direction.UP);
		System.out.println(robotCrt.getRobot().getCoord());
		
		System.out.println(robotCrt.getRobot().getCapteur());
		
	}
}
