<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Exam List</title>
    <style>
        table {
            width: 50%;
            border-collapse: collapse;
            margin: 50px 0;
            font-size: 18px;
            text-align: left;
        }
        th, td {
            padding: 12px;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h2>List of Exams</h2>
    <table>
        <thead>
            <tr>
                <th>Exam ID</th>
                <th>Exam Name</th>
                <th>Exam Date</th>
                <th>Duration</th>
                <th>Total Marks</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="exam" items="${exams}">
                <tr>
                    <td>${exam.examId}</td>
                    <td>${exam.examName}</td>
                    <td>${exam.examDate}</td>
                    <td>${exam.duration}</td>
                    <td>${exam.totalMarks}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
