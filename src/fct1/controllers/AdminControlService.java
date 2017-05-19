package fct1.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import utils.AppelStatus;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class adminControl
 */
@WebServlet("/adminControlService")
public class AdminControlService extends HttpServlet {
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminControlService() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext app = request.getServletContext();
		String etatSession = (String) app.getAttribute("statusCourant"); 
		String redirectJsp = null;
	
        //writing data to json
        response.setContentType("application/json;charset=utf-8");


		String submit = request.getParameter("submit");
		switch(submit){
		case "logout":
			HttpSession session = request.getSession(true);
			session.removeAttribute("username");
			session.invalidate();
			redirectJsp = "login.jsp";
			break;
		case "started":
			if(etatSession=="stopped"){
				etatSession="started";
				app.setAttribute("statusCourant", etatSession);
				AppelStatus.setStatus(etatSession);
			}
			redirectJsp = "admin.jsp";
			break;		
		case "stopped":
			if(etatSession=="started"){
				etatSession="stopped";
				app.setAttribute("statusCourant", etatSession);
				AppelStatus.setStatus(etatSession);
			}
			redirectJsp = "admin.jsp";
			break;	
		}
		response.sendRedirect(redirectJsp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}