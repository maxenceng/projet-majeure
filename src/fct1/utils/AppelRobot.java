package fct1.utils;

import java.util.Random;

import fct0.controllers.RobotCrt;
import fct0.models.Env;
import fct0.models.Robot;
import fct0.utils.Coord;
import fct0.utils.Orientation;
import fct0.utils.Direction;
import fct0.utils.Contenu;

public class AppelRobot {

	private static Coord coordonnee;
	private static Robot robinet;
	private static Env environnement;
	private static RobotCrt robotControl;
	
	boolean auto=false;

	
	public static RobotCrt getAppelRobot(){
		
		if(robotControl==null)
		{
			coordonnee=new Coord(2,1);
			robinet=new Robot(coordonnee,Orientation.S);
			environnement=new Env(8,12,30);
			robotControl=new RobotCrt(environnement,robinet);
		}
		return robotControl;
	}
	
	
	public void deplacerAuto()
	{
		Random rand = new Random();
		while(auto==true)
		{			
			int randomNum = rand.nextInt(101);
			Coord c=new Coord(robotControl.getRobot().getCoord().getX(), robotControl.getRobot().getCoord().getY());
			robotControl.move(Direction.DOWN);
			
			if(robotControl.getRobot().getCoord().equals(c))
			{
				if(randomNum > 50) {
					robotControl.move(Direction.RIGHT);
				} else {
					robotControl.move(Direction.LEFT);
				}				
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}