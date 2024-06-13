<%@page import="com.chainsys.model.AddQuestion"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Question table</title>
</head>
<style>
table {
	border-collapse: collapse;
	width: 80%;
	text-align: center;
}

th, td {
	border: 1px solid black;
	padding: 8px;
	text-align: left;
}

/* th:nth-child(even),td:nth-child(even) {
  background-color: #D6EEEE;
  }*/
tr:hover {
	background-color: #D6EEEE;
}

th, td {
	border-style: solid;
	border-color: #96D4D4;
}

th, td {
	text-align: center;
}

th {
	background-color: green;
}

a {
	text-decoration: none;
	color: green;
}

a:hover {
	color: blue;
}
</style>

<body>
	<h2>Question Details</h2>

	<table>
		<tr>

			<th>Exam Id</th>
			<th>Exam Name</th>
			<th>Question Text</th>
			<th>Option1</th>
			<th>Option2</th>
			<th>Option3</th>
			<th>Option4</th>
			<th>Correct Answer</th>
			<th>Delete</th>
			<th>Edit</th>


		</tr>


		<%
		// RegisterDetails details = new RegisterDetails();
		ArrayList<AddQuestion> list = (ArrayList<AddQuestion>) request.getAttribute("list");
		
		if (list != null) {
			for (AddQuestion item : list) {
		%>
		<tr>
			<td><%=item.getExamId()%></td>
			<td><%=item.getExamName()%></td>
			<td><%=item.getQuestionText()%></td>
			<td><%=item.getOption1()%></td>
			<td><%=item.getOption2()%></td>
			<td><%=item.getOption3()%></td>
			<td><%=item.getOption4()%></td>
			<td><%=item.getCorrectAnswer()%></td>

			<td>
				
					<form>
					<input type="hidden" name="action" value="Delete"> <input
						type="hidden" name="deleteExamId" value="<%=item.getExamId()%>">
					<button class="edit-btn" type="button"
						onclick="location.href = 'deleteQuestion.jsp?editExamId=<%=item.getExamId()%>'">Delete</button>
                   </form>
				
			</td>
			<td>
			<input type="hidden" name="action" value="update"> <input
				type="hidden" name="editexamId" value="<%=item.getExamId()%>">
				<button class="edit-btn" type="button"
					onclick="location.href = 'updateQuestion.jsp?editid=<%=item.getExamId()%>'">Edit</button>

			</td>
		</tr>

		<%
		}
		}
		%>
	</table>
</body>
</html>












































