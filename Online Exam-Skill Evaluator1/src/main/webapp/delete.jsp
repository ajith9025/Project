<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Delete Exam</title>
</head>
<body>
    <h2>Delete Exam</h2>
    <form action="DeleteExamServlet" method="post">
        Exam ID: <input type="text" name="examId"><br>
        <input type="submit" value="Delete">
    </form>
</body>
</html>
    