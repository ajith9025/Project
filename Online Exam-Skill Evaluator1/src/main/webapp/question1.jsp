<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.chainsys.model.AddQuestion"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Arrays"%>
<html>
<head>
<title>Questions</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f0f0f0;
	padding: 20px;
}

.question {
	background-color: #ffffff;
	border: 1px solid #ccc;
	padding: 10px;
	margin-bottom: 15px;
}

.question p {
	margin: 30px 0;
}

.question input[type="radio"] {
	margin-right: 10px;
}

button {
	background-color: orange;
	color: black;
	border: none;
	padding: 10px 20px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin-top: 10px;
	cursor: pointer;
}

button:hover {
	background-color: black;
}
</style>

</head>

<body>
	<form id="quizForm" action="CheckResults" method="post"
		onsubmit="return validateForm();">
		<%
		ArrayList<AddQuestion> list = (ArrayList<AddQuestion>) request.getAttribute("list");
		int i = 0;
		for (AddQuestion items : list) {
		%>
		<div class="question" style="display: none;">
			<p>
				<strong><%=++i%></strong> .
				<%=items.getQuestionText()%></p>
			<div class="timer" data-seconds="60">Time remaining: 60 seconds</div>
			<input type="hidden" name="examId" value="<%=items.getExamId()%>">
			<p>
				<input type="radio" name="answer<%=items.getExamId()%>"
					value="option1">
				<%=items.getOption1()%></p>
			<p>
				<input type="radio" name="answer<%=items.getExamId()%>"
					value="option2">
				<%=items.getOption2()%></p>
			<p>
				<input type="radio" name="answer<%=items.getExamId()%>"
					value="option3">
				<%=items.getOption3()%></p>
			<p>
				<input type="radio" name="answer<%=items.getExamId()%>"
					value="option4">
				<%=items.getOption4()%></p>
		</div>
		<%
		}
		%>
	
		<button type="button" onclick="previousQuestion()">PreviousQuestion</button>
		<button type="button" onclick="nextQuestion()">Next Question</button>

		<input id="submitBtn" type="submit" style="display: none;"
			value="Submit">
	</form>
	  <script src="question.js"></script>
</body>
</html>
