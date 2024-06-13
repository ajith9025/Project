<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Sign Up</title>
</head>
<body>
	<h2>Update user</h2>
	<form action="UpdateUserServlet" method="post">
		<label> Username </label> 
		<input type="text" name="username"><br>
		<label>Password</label> 
		<input type="password" name="password"><br>
		<label>Email</label> 
		<input type="email" name="email"> <br>
		<label>Contact no</label> <input type="text" name="contact_no"><br>
		<br> <input type="submit" value="update">
	</form>
</body>
</html>