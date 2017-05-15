package fct0.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import fct0.controllers.RobotCrt;
import fct0.models.Env;
import fct0.models.Robot;
import fct0.utils.Contenu;
import fct0.utils.Coord;
import fct0.utils.Direction;
import fct0.utils.Orientation;

public class RobotCrtTest {

	@Test
	public void testIsMoveOk() {
		Robot robot = new Robot(new Coord(1, 5), Orientation.N);
		Env env = new Env(10, 10, 30);
		RobotCrt robotCrt = new RobotCrt(env, robot);
		for(int i = 0; i < robotCrt.getEnv().getTailleX(); i++) {
			for(int j = 0; j < robotCrt.getEnv().getTailleY(); j++) {
				assertEquals(robotCrt.isMoveOk(i, j), (robotCrt.getEnv().findContenu(i, j) == Contenu.FREE));
			}
		}
		for(int i = -100; i < 0; i++) {
			for(int j = -100; j < 0; j++) {
				assertEquals(robotCrt.isMoveOk(i, j), false);
			}
		}
		for(int i = robotCrt.getEnv().getTailleX() + 1; i < robotCrt.getEnv().getTailleX() + 100; i++) {
			for(int j = robotCrt.getEnv().getTailleX() + 1; j < robotCrt.getEnv().getTailleX() + 100; j++) {
				assertEquals(robotCrt.isMoveOk(i, j), false);
			}
		}
	}
	
	@Test
	public void testMove() {
		Robot robot = new Robot(new Coord(1, 5), Orientation.N);
		Coord copieCoord;
		Env env = new Env(10, 10, 30);
		RobotCrt robotCrt = new RobotCrt(env, robot);
		
		
		Direction d = Direction.RIGHT;
		copieCoord = robotCrt.getRobot().getCoord();
		if(robotCrt.isMoveOk(robotCrt.getRobot().getCoord().getX() + d.x, robotCrt.getRobot().getCoord().getY() + d.y)) {
			robotCrt.move(d);
			assertNotEquals(robotCrt.getRobot().getCoord(), copieCoord);
		} else {
			assertEquals(robotCrt.getRobot().getCoord(), copieCoord);
		}

		
		d = Direction.LEFT;
		copieCoord = robotCrt.getRobot().getCoord();
		if(robotCrt.isMoveOk(robotCrt.getRobot().getCoord().getX() + d.x, robotCrt.getRobot().getCoord().getY() + d.y)) {
			robotCrt.move(d);
			assertNotEquals(robotCrt.getRobot().getCoord(), copieCoord);
		} else {
			assertEquals(robotCrt.getRobot().getCoord(), copieCoord);
		}
		
		
		d = Direction.UP;
		copieCoord = robotCrt.getRobot().getCoord();
		if(robotCrt.isMoveOk(robotCrt.getRobot().getCoord().getX() + d.x, robotCrt.getRobot().getCoord().getY() + d.y)) {
			robotCrt.move(d);
			assertNotEquals(robotCrt.getRobot().getCoord(), copieCoord);
		} else {
			assertEquals(robotCrt.getRobot().getCoord(), copieCoord);
		}
		
		
		d = Direction.DOWN;
		copieCoord = robotCrt.getRobot().getCoord();
		if(robotCrt.isMoveOk(robotCrt.getRobot().getCoord().getX() + d.x, robotCrt.getRobot().getCoord().getY() + d.y)) {
			robotCrt.move(d);
			assertNotEquals(robotCrt.getRobot().getCoord(), copieCoord);
		} else {
			assertEquals(robotCrt.getRobot().getCoord(), copieCoord);
		}
	}

}
