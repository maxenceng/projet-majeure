package fct1.rest;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import utils.AppelRobot;
import utils.AppelStatus;
import fct0.controllers.RobotCrt;
import fct0.models.Env;
import fct0.models.Measures;
import fct0.models.Robot;
import fct0.utils.Coord;
import fct0.utils.Orientation;
import fct0.utils.Direction;
import fct0.utils.Contenu;
import fct1.controllers.AdminControlService;


@Path("/cmd")
public class RobotControlService {
	
	//Inject servlet context (needed to get general context, application memory space, session memory space ...)
	@Context
	ServletContext context;
	@Context
	private HttpServletRequest request;

		RobotCrt robotControl =AppelRobot.getAppelRobot();
	
		@POST
		@Produces(MediaType.TEXT_PLAIN)
		@Path("UP")
		public String goUp(@PathParam("status")String status)
		{
			String userApp = AppelStatus.getUser();
			String userSession = (String) request.getSession().getAttribute("username");
			if(AppelStatus.getStatus().equals("started") && userApp.equals(userSession)) {
				if(robotControl.move(Direction.UP)) {
					return "OK";
				}
			}
			return "KO";
		}
		
		@POST
		@Produces(MediaType.TEXT_PLAIN)
		@Path("DOWN")
		public String goDown()
		{
			String userApp = AppelStatus.getUser();
			String userSession = (String) request.getSession().getAttribute("username");
			if(AppelStatus.getStatus().equals("started") && userApp.equals(userSession)) {
				if(robotControl.move(Direction.DOWN)) {
					return "OK";					
				}
			}
			return "KO";
		}
		
		@POST
		@Produces(MediaType.TEXT_PLAIN)
		@Path("RIGHT")
		public String goRight()
		{
			String userApp = AppelStatus.getUser();
			String userSession = (String) request.getSession().getAttribute("username");
			if(AppelStatus.getStatus().equals("started") && userApp.equals(userSession)) {
				robotControl.move(Direction.RIGHT);
				return "OK";
			}
			return "KO";
		}
		
		@POST
		@Produces(MediaType.TEXT_PLAIN)
		@Path("LEFT")
		public String goLeft()
		{
			String userApp = AppelStatus.getUser();
			String userSession = (String) request.getSession().getAttribute("username");
			if(AppelStatus.getStatus().equals("started") && userApp.equals(userSession)) {
				if(robotControl.move(Direction.LEFT)) {
					return "OK";
				}				
			}
			return "KO";		
		}
		
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		@Path("status")
		public String getStatus()
		{
			JSONObject obj = new JSONObject();
			obj.put("status", AppelStatus.getStatus());
			obj.put("user", AppelStatus.getUser());
			return obj.toJSONString();
		}
		
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		@Path("measures")
		public String getMeasures()
		{
			JSONObject obj = new JSONObject();
			obj.put("nbreCommande", Measures.getNbreCommande());
			obj.put("distanceParcourue", Measures.getDistanceParcourue());
			obj.put("nbreObstRencontres", Measures.getNbreObstRencontres());
			obj.put("nbreObstVisible",  Measures.getNbreObstVisible());
			return obj.toJSONString();
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
					currentContenu=robotControl.getEnvRobot().getGrille().getContenuG(x,y);		
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
}
