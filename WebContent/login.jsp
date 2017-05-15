<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<form action="checkAuth"> 
		<ul>
			<li>
				<label for="name"> Nom &nbsp;:</label>
				<input type="text" name="name" placeholder="anonyme" required>
			</li>
			<li>
				<label for="password"> pwd &nbsp;:</label>
				<input type="password" name="password" required>
			</li>
			<li>
				<input type="submit" value="valid" /> 
			</li>
		</ul>
	</form>
</body>
</html>


</html>