<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <h2>Delete Question</h2>
    <form action="DeleteQuestionServlet" method="post">
        Exam ID: <input type="text" name="examId"><br>
        <input type="submit" value="Delete">
    </form>
</body>
</html>