<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Results</title>
</head>
<body>
	<h2>Results</h2>
	<%
	int correctCount = (int) request.getAttribute("correctCount");
	System.out.println(correctCount);
	int incorrectCount = (int) request.getAttribute("incorrectCount");
	System.out.println(incorrectCount);
	double percentage = (double) request.getAttribute("percentage");
	System.out.println(percentage);
	%>
	<p>
		Correct Answers:
		<%=correctCount%></p>
	<p>
		Incorrect Answers:
		<%=incorrectCount%></p>
	<p>
		Percentage:
		<%=String.format("%.2f", percentage)%>
	</p>
</body>
</html>
