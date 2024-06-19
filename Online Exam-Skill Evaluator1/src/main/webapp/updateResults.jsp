<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
    <title>Results</title>
</head>
<body>
    <h2>Update Results</h2>
      <form action="UpdateResultsServlet" method="post">
        <input type="hidden" name="action" value="insertResult">
        Result ID: <input type="number" name="resultId"><br>
        User ID: <input type="number" name="userId"><br>
        Exam ID: <input type="number" name="examId"><br>
        Marks Obtained: <input type="number" name="marksObtained"><br>
        <input type="submit" value="submit">
    </form>
</body>
</html>