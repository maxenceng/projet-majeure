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


@Path("/cmd")
public class RobotControlService {
	
	//private final static String ROBOT_SIMULATOR_LABEL="robot_simulator";
	
	//Inject servlet context (needed to get general context, application memory space, session memory space ...)
	@Context
	ServletContext context;
	
	
	Coord coordonnee=new Coord(0,0);
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
		}
		
		@POST
		@Produces(MediaType.TEXT_PLAIN)
		@Path("DOWN")
		public void goDown()
		{
			robotControl.move(Direction.DOWN);
		}
		
		@POST
		@Produces(MediaType.TEXT_PLAIN)
		@Path("RIGHT")
		public void goRight()
		{
			robotControl.move(Direction.RIGHT);
		}
		
		@POST
		@Produces(MediaType.TEXT_PLAIN)
		@Path("LEFT")
		public void goLeft()
		{
			robotControl.move(Direction.LEFT);
		}
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		@Path("env")
		public String getEnv()
				{
			//create Json container Object
			JSONObject objContainer = new JSONObject();
			
			//create set of json objects
			JSONObject objVal1 = new JSONObject();
			//objVal1.put("x",coordonnee.getX());
			objVal1.put("x",new Integer(0));
			objVal1.put("y",new Integer(0));
			objVal1.put("val","FREE");
			JSONObject objVal2 = new JSONObject();
			objVal2.put("x",new Integer(0));
			objVal2.put("y",new Integer(1));
			objVal2.put("val","WALL");
			JSONObject objVal3 = new JSONObject();
			objVal3.put("x",new Integer(1));
			objVal3.put("y",new Integer(1));
			objVal3.put("val","ROBOT");
			
			/*environnement.generateEnvironnement();
			
			JSONObject objTest = new JSONObject();
			objTest.put("grille",environnement.printMatrix(environnement.getGrille().getMatrice()));*/
			
			
			//create a json list
			JSONArray list = new JSONArray();
			//add json objects to jsonlist
			list.add(objVal1);
			list.add(objVal2);
			list.add(objVal3);
			//list.add(objTest);
			
			//add jsonlist to json container
			objContainer.put("data", list);
			
			//return json string of the json container
			return objContainer.toJSONString();
			
			
			//ALTERNATIVE send direct a json String
			//return "{\"data\":[{\"x\":0,\"y\":0,\"val\":\"FREE\"},{\"x\":0,\"y\":1,\"val\":\"WALL\"},{\"x\":1,\"y\":1,\"val\":\"ROBOT\"}]}";
		}

}
