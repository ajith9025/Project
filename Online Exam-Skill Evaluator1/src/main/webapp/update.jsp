<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Update Exam</title>
</head>
<body>
	<h2>Update Exam</h2>
	<form action="UpdateExamServlet" method="post">
		Exam ID: <input type="text" name="examId"><br> Exam Name:
		<input type="text" name="examName"><br> Exam Date: <input
			type="text" name="examDate"><br> Duration: <input
			type="text" name="duration"><br> Total Marks: <input
			type="text" name="totalMarks"><br> <input type="submit"
			value="Update">
	</form>
</body>
</html>
