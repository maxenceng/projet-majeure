<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <link rel="stylesheet" href="lib/cssprojet/style2.css">
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<form action="checkAuth" id="monForm"> 

	  
		<ul>
				</br></br>
				<label for="Login"> Login :</label><input type="text" name="name" required/>
				</br></br></br></br>
				<label for="Password"> Password :</label>
				<input type="password" name="password" required></br></br></br></br></br>
				
				<a href="#" class="myButton">Cancel</a>
				<input type="submit" value="Ok" class="myButton1" />
		</ul>

	</form>
</body>
</html>
