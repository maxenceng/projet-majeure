package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AdminModel;
import db.DB;


/**
 * Servlet implementation class checkAuth
 */
@WebServlet("/checkAuth")
public class checkAuth extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DB db;
    /**
     * Default constructor. 
     */
    public checkAuth() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    this.db = new DB();
		String uname =request.getParameter("name");
		String pwd = request .getParameter("password");
		AdminModel user = this.db.checkUser(uname, pwd);
		if(user != null)
		{
			HttpSession session = request.getSession();
			session.setAttribute("username",user.getLogin());
			response.sendRedirect("admin.jsp");
		}
		else
		{
			response.sendRedirect("login.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}