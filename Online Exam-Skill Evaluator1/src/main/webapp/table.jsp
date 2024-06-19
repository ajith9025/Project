<%@page import="com.chainsys.model.Register"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Register Table</title>
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
	<h2>Register Details</h2>

	<table>
		<tr>
            <th>UserId</th>
			<th>Username</th>
			<th>Password</th>
			<th>Email</th>
			<th>Contact_no</th>
			<th>Delete</th>
			<th>Edit</th>

		</tr>


		<%
		// RegisterDetails details = new RegisterDetails();
		ArrayList<Register> list = (ArrayList<Register>) request.getAttribute("list");
		
		if (list != null) {
			for (Register item : list) {
		%>
		<tr>
            <td><%=item.getUserId()%></td>
			<td><%=item.getUsername()%></td>
			<td><%=item.getPassword()%></td>
			<td><%=item.getEmail()%></td>
			<td><%=item.getContactno()%></td>
			<td>
				<form action="" method="post">
					<input type="hidden" name="action" value="Delete"> <input
						type="hidden" name="deleteid" value="<%=item.getUserId()%>">
						<button class="edit-btn" type="button"
						onclick="location.href = 'deleteUser.jsp?editExamId=<%=item.getUserId()%>'">Delete</button>
				</form>
			</td>
			<td><input type="hidden" name="action" value="update"> <input
				type="hidden" name="editemail" value="<%=item.getUserId()%>">
				<button class="edit-btn" type="button"
					onclick="location.href = 'updateUser.jsp?editemail=<%=item.getUserId()%>'">Edit</button>


			</td>
		</tr>

		<%
		}
		}
		%>
	</table>
</body>
</html>












































