<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Update Exam</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f0f0f0;
        margin: 20px;
        padding: 20px;
    }
    h2 {
        color: #333;
    }
    form {
        background-color: #fff;
        padding: 20px;
        border-radius: 5px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        width: 300px;
        margin: 0 auto;
    }
    input[type="text"], input[type="submit"] {
        width: 100%;
        padding: 10px;
        margin-bottom: 10px;
        box-sizing: border-box;
        border: 1px solid #ccc;
        border-radius: 4px;
        font-size: 14px;
    }
    input[type="submit"] {
        background-color:red;
        color: white;
        border: none;
        cursor: pointer;
    }
    input[type="submit"]:hover {
        background-color:black;
    }
</style>
</head>
<body>
    <h2>Update Exam</h2>
    <form action="UpdateExamServlet" method="post">
        Exam ID:<input type="text" name="examId"><br>
        Exam Name:<input type="text" name="examName"><br>
        Exam Date:<input type="text" name="examDate"><br>
        Duration:<input type="text" name="duration"><br>
        Total Marks:<input type="text" name="totalMarks"><br>
        <input type="submit" value="Update">
    </form>
</body>
</html>
	