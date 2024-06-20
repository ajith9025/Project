<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Results Page</title>
</head>
<body>
    <h1>Results</h1>
    <table border="1">
        <thead>
            <tr>
                <th>Result ID</th>
                <th>User ID</th>
                <th>Exam ID</th>
                <th>Marks Obtained</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${results}" var="result">
                <tr>
                    <td>${result.resultId}</td>
                    <td>${result.userId}</td>
                    <td>${result.examId}</td>
                    <td>${result.marksObtained}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
    