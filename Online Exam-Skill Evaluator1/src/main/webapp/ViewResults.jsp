<%@page import="com.chainsys.model.Results"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Results table</title>
</head>
<style>
table {
	border-collapse: collapse;
	width: 50%;
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
	<h2>Results Details</h2>

	<table>
		<tr>
			<th>Result Id</th>
			<th>User Id</th>
			<th>Exam Id</th>
			<th>Marks Obtained</th>
			<th>Delete</th>
			<th>Edit</th>


		</tr>


		<%
		// RegisterDetails details = new RegisterDetails();
		ArrayList<Results> list = (ArrayList<Results>) request.getAttribute("list");
		
		if (list != null) {
			for (Results item : list) {
		%>
		<tr>
		    <td><%=item.getResultId()%></td>
			<td><%=item.getUserId()%></td>
			<td><%=item.getExamId()%></td>
			<td><%=item.getMarksObtained()%></td>
			
			<td>
				<form>

					<input type="hidden" name="action" value="Delete"> <input
						type="hidden" name="deleteExamId" value="<%=item.getExamId()%>">
					<button class="edit-btn" type="button"
						onclick="location.href = 'delete.jsp?editExamId=<%=item.getExamId()%>'">Delete</button>


				</form>
			</td>
			<td><input type="hidden" name="action" value="update"> <input
				type="hidden" name="editExamId" value="<%=item.getExamId()%>">
				<button class="edit-btn" type="button"
					onclick="location.href = 'update.jsp?editid=<%=item.getExamId()%>'">Edit</button>

			</td>
		</tr>

		<%
		}
		}
		%>
	</table>
</body>
</html>












































