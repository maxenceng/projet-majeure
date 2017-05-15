package servlet;

import java.io.IOException;

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
public class adminControlService extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminControlService() {
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
			}
			redirectJsp = "admin.jsp";
			break;		
		case "stopped":
			if(etatSession=="started"){
				etatSession="stopped";
				app.setAttribute("statusCourant", etatSession);
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