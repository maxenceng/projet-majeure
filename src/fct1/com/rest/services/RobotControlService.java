package fct1.com.rest.services;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import fct0.controllers.RobotCrt;
import fct0.models.Env;
import fct0.models.Robot;
import fct0.utils.Coord;
import fct0.utils.Orientation;
import fct0.utils.Direction;
import fct0.utils.Contenu;
import fct1.com.rest.services.AppelRobot;


@Path("/cmd")
public class RobotControlService {
	
	//Inject servlet context (needed to get general context, application memory space, session memory space ...)
	@Context
	ServletContext context;
	

		RobotCrt robotControl =AppelRobot.getAppelRobot();
	
		@POST
		@Produces(MediaType.TEXT_PLAIN)
		@Path("UP")
		public String goUp()
		{
			robotControl.move(Direction.UP);
			Contenu[][] matrice1=robotControl.getEnv().getGrille().getMatrice();
			System.out.println(robotControl.getEnv().printMatrix(matrice1));
			getEnvironnement();
			return "";
		}
		
		@POST
		@Produces(MediaType.TEXT_PLAIN)
		@Path("DOWN")
		public String goDown()
		{
			robotControl.move(Direction.DOWN);
			Contenu[][] matrice1=robotControl.getEnv().getGrille().getMatrice();
			System.out.println(robotControl.getEnv().printMatrix(matrice1));
			getEnvironnement();
			return "";
		}
		
		@POST
		@Produces(MediaType.TEXT_PLAIN)
		@Path("RIGHT")
		public String goRight()
		{
			robotControl.move(Direction.RIGHT);
			Contenu[][] matrice1=robotControl.getEnv().getGrille().getMatrice();
			System.out.println(robotControl.getEnv().printMatrix(matrice1));
			getEnvironnement();
			return "";
		}
		
		@POST
		@Produces(MediaType.TEXT_PLAIN)
		@Path("LEFT")
		public String goLeft()
		{
			
			robotControl.move(Direction.LEFT);
			Contenu[][] matrice1=robotControl.getEnv().getGrille().getMatrice();
			System.out.println(robotControl.getEnv().printMatrix(matrice1));
			getEnvironnement();
			return "";
		
		}
		
		
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		@Path("env")
		public String getEnvironnement()
		{
			JSONObject objContainer = new JSONObject();
			int x=0; 
			int y=0;
			int tailleX=robotControl.getEnv().getTailleX();
			int tailleY=robotControl.getEnv().getTailleY();
			int tailleXY=robotControl.getEnv().getTailleXY();
			Contenu currentContenu;
			
			
			JSONArray list = new JSONArray();
			
			for(x=0;x<tailleX;x++)
			{
				for(y=0;y<tailleY;y++)
				{
			
					JSONObject objVal1 = new JSONObject();
					currentContenu=robotControl.getEnv().getGrille().getContenuG(x,y);		
					objVal1.put("état",currentContenu.toString());
					//list.add(objVal1);
					objVal1.put("x",x);
					//list.add(objVal1);	
					objVal1.put("y",y);	
					list.add(objVal1);

				}
				
			}
		
			//add jsonlist to json container
			objContainer.put("donnees", list);
			
		
			//return json string of the json container
			return objContainer.toJSONString();

	
		}
		public static void main(String[] args){
			RobotControlService robottest=new RobotControlService();
			System.out.println(robottest.getEnvironnement());
			System.out.println("-----------------------------------------------------");
			System.out.println(robottest.goUp());
			System.out.println("-----------------------------------------------------");
			System.out.println(robottest.getEnvironnement());
			System.out.println(robottest.goLeft());
			System.out.println("-----------------------------------------------------");
			System.out.println(robottest.getEnvironnement());
		}
}
