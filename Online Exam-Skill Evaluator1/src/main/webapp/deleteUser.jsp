<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>User Management</title>
</head>
<body>
    <h2>Delete User</h2>
    <form action="DeleteUserServlet" method="post">
        userId: <input type="number" name="userId"><br>
        <input type="submit" value="Delete">
    </form>
</body>
</html>