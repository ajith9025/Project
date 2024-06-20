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
	    <label for="userid"> UserId </label> 
		<input type="number" name="userid"><br>
		<label for="username"> Username </label> 
		<input type="text" name="username"><br>
		<label for="password">Password</label> 
		<input type="password" name="password"><br>
		<label for="email">Email</label> 
		<input type="email" name="email"> <br>
		<label for="contact no">Contact no</label> <input type="text" name="contact_no"><br>
		<br> <input type="submit" value="update">
	</form>
</body>
</html>