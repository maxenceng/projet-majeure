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

@Path("/cmd")
public class RobotControlService {
	
	//private final static String ROBOT_SIMULATOR_LABEL="robot_simulator";
	
	//Inject servlet context (needed to get general context, application memory space, session memory space ...)
	@Context
	ServletContext context;
	
	
	Coord coordonnee=new Coord(0,2);
	Robot robinet=new Robot(coordonnee,Orientation.S);
	Env environnement=new Env(5,5,10);
	RobotCrt robotControl=new RobotCrt(environnement,robinet);
	
	
	//After RestService construction launches init method
		/*@PostConstruct
		public void init(){
			checkRobot();
		}

		private void checkRobot() {
			Object obj=context.getAttribute(ROBOT_SIMULATOR_LABEL);
			if(obj==null){
				
				//TODO
			}else{
				//TODO
			}
			
		}
		*/
	
	
		@POST
		@Produces(MediaType.TEXT_PLAIN)
		@Path("UP")
		public void goUp()
		{
			robotControl.move(Direction.UP);
			getEnv();
		}
		
		@POST
		@Produces(MediaType.TEXT_PLAIN)
		@Path("DOWN")
		public void goDown()
		{
			robotControl.move(Direction.DOWN);
			getEnv();
		}
		
		@POST
		@Produces(MediaType.TEXT_PLAIN)
		@Path("RIGHT")
		public void goRight()
		{
			robotControl.move(Direction.RIGHT);
			getEnv();
		}
		
		@POST
		@Produces(MediaType.TEXT_PLAIN)
		@Path("LEFT")
		public String goLeft()
		{
			
			Contenu[][] matrice1=robotControl.getEnv().getGrille().getMatrice();
			System.out.println(robotControl.getEnv().printMatrix(matrice1));
			robotControl.move(Direction.LEFT);
			matrice1=robotControl.getEnv().getGrille().getMatrice();
			System.out.println(robotControl.getEnv().printMatrix(matrice1));
			return "";
		
		}
		
		
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		@Path("env")
		public String getEnv()
		{
			JSONObject objContainer = new JSONObject();
			int x=0; 
			int y=0;
			int tailleX=environnement.getTailleX();
			int tailleY=environnement.getTailleY();
			int tailleXY=environnement.getTailleXY();
			Contenu currentContenu;
			
			
			JSONArray list = new JSONArray();
			
			for(x=0;x<tailleX;x++)
			{
				for(y=0;y<tailleY;y++)
				{
					JSONObject objVal1 = new JSONObject();
					currentContenu=robotControl.getEnv().getGrille().getContenuG(x,y);		
				
					objVal1.put("x",x);
					list.add(objVal1);	
					objVal1.put("y",y);	
					list.add(objVal1);
					objVal1.put("état",currentContenu.toString());
					list.add(objVal1);
			
					//objContainer.put("data", list);
				}
				
			}
				
	
			
			
			//add jsonlist to json container
			objContainer.put("cissou", list);
			
			
			
			//return json string of the json container
			return objContainer.toJSONString();

	
		}
		public static void main(String[] args){
			RobotControlService robottest=new RobotControlService();
			System.out.println(robottest.getEnv());
			System.out.println("-----------------------------------------------------");
			System.out.println(robottest.goLeft());
			System.out.println("-----------------------------------------------------");
			System.out.println(robottest.getEnv());
			
		}
}
