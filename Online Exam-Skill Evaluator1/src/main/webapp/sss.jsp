<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Start Exam</title>
    <style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f7f7f7;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
    }
    
    .container {
        text-align: center;
        background-color: #fff;
        padding: 40px;
        border-radius: 10px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    }
    
    h1 {
        margin-bottom: 20px;
        color: #333;
    }
    
    p {
        margin-bottom: 30px;
        color: #666;
    }
    
    .start-button {
        background-color: red;
        color: white;
        padding: 15px 30px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        font-size: 16px;
    }
    
    .start-button:hover {
        background-color: black;
    }
</style>
 <script>
        function startExam() {
            window.location.href = "examPage.jsp";
        }
    </script>
</head>

<body>
    <div class="container">
        <h1>Welcome to the Exam</h1>
        <p>Please read the instructions carefully before starting the exam.</p>
        <button class="start-button" onclick="startExam()">Start Exam</button>
    </div>
</body>
</html>
