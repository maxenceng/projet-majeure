<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
   <link rel="stylesheet" href="lib/cssprojet/style3.css">
    <link href="https://fonts.googleapis.com/css?family=Alfa+Slab+One" rel="stylesheet"> 
</head>
<body>
<header class="header">
<div id="administration"> Administration Page</div>


<div id="started">${statusCourant}</div>
</header>	

<%
		if(session.getAttribute("username")==null)
		{
			response.sendRedirect("login.jsp");
		}
		//ServletContext app = request.getServletContext();
		// String etat = (String) app.getAttribute("statusCourant"); 
		String etat = (String) application.getAttribute("statusCourant");
		if( application.getAttribute("statusCourant") == null){

			application.setAttribute("statusCourant", "stopped");
		}
	%>
	
		<form action="adminControlService">
		<input type="submit" NAME="submit" value="started" class="bouton17">
		<input type="submit" NAME="submit" value="stopped" class="bouton18"></br></br></br>
		<input type="submit" NAME="submit" value="logout" class="bouton13">
		</form>


</body>

</html>