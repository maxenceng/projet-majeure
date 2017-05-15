package fct1.com.rest.services;

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

	
	public static RobotCrt getAppelRobot(){
		
		if(robotControl==null)
		{
			coordonnee=new Coord(2,1);
			robinet=new Robot(coordonnee,Orientation.S);
			environnement=new Env(5,5,10);
			robotControl=new RobotCrt(environnement,robinet);
		}
		return robotControl;
		
	}
}
