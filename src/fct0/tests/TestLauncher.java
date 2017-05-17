package fct0.tests;

import fct0.controllers.RobotCrt;
import fct0.models.Capteur;
import fct0.models.Env;
import fct0.models.Measures;
import fct0.models.Robot;
import fct0.utils.Contenu;
import fct0.utils.Coord;
import fct0.utils.Direction;
import fct0.utils.Orientation;

public class TestLauncher {
	public static void main(String[] args) {
		Robot robot = new Robot(new Coord(1, 4), Orientation.N);
		Coord c = robot.getCoord();
		
		Env env = new Env(6,6,10);
		RobotCrt robotCrt = new RobotCrt(env, robot);
		robotCrt.move(Direction.RIGHT);
		System.out.println(robotCrt.getEnvRobot());
		robotCrt.move(Direction.LEFT);
		System.out.println(robotCrt.getEnvRobot());
		robotCrt.move(Direction.DOWN);
		System.out.println(robotCrt.getEnvRobot());
		robotCrt.move(Direction.DOWN);
		System.out.println(robotCrt.getEnvRobot());
		robotCrt.move(Direction.DOWN);
		System.out.println(robotCrt.getEnvRobot());
		robotCrt.move(Direction.LEFT);
		System.out.println(robotCrt.getEnvRobot());
		robotCrt.move(Direction.LEFT);
		System.out.println(robotCrt.getEnvRobot());
		
	}
}