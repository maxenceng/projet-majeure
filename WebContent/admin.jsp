<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>administration page</title>
</head>
<body>
	<%
		if(session.getAttribute("username")==null)
		{
			response.sendRedirect("login.jsp");
		}
		String etat = (String) application.getAttribute("statusCourant");
		if( application.getAttribute("statusCourant") == null){

			application.setAttribute("statusCourant", "stopped");
		}
	%>
	
		
		${statusCourant}
		
		Welcome ${username}
		<form action="adminControlService">
		<input type="submit" NAME="submit" value="started">
		<input type="submit" NAME="submit" value="stopped">
		<input type="submit" NAME="submit" value="logout">
		</form>
</body>
</html>