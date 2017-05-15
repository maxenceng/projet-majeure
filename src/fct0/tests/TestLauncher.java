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
		Robot robot = new Robot(new Coord(3, 2), Orientation.W);
		Coord c = robot.getCoord();
		Capteur cap = robot.getCapteur();
		cap.updateMatrice(robot.getOrientation(), Orientation.E);
		
		Env env = new Env(7,7,10);
		RobotCrt robotCrt = new RobotCrt(env, robot);
		Contenu[][] matrice = robotCrt.getEnv().getGrille().getMatrice();
		System.out.println(robotCrt.getEnv().printMatrix(matrice));
		System.out.println(robotCrt.getRobot().getCoord());
		System.out.println("-------");
		robotCrt.move(Direction.LEFT);
		System.out.println(robotCrt.getRobot().getCoord());
		System.out.println(robotCrt.getEnv().printMatrix(matrice));
		//System.out.println(robotCrt.getRobot().getCapteur());
		
		System.out.println("----------------------");
		robotCrt.move(Direction.DOWN);
		System.out.println(robotCrt.getRobot().getCoord());
		System.out.println(robotCrt.getEnv().printMatrix(matrice));
		
	}
}
