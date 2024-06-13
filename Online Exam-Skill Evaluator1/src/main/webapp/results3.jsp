<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

    <h2>Result</h2>
    <table border="1">
        <tr>
            
            <th>Total Questions Attempted</th>
            <th>Correct Answers</th>
            <th>Percentage</th>
        </tr>
        <tr>
            
            <td><%= request.getAttribute("totalCount") %></td>
            <td><%= request.getAttribute("correctCount") %></td>
            <td><%= request.getAttribute("percentage") %>%</td>
        </tr>
    </table>  
</body>
</html>