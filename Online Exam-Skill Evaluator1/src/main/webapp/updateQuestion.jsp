<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Update Question</h2>
    <form action="UpdateQuestionServlet" method="post">
        <label for="examId">Exam ID:</label><br>
        <input type="number" name="examId" id="examId"><br>
        <label for="examName">Exam Name:</label><br>
        <input type="text" name="examName" id="examName"><br>
        <label for="questionText">Question Text:</label><br>
        <textarea name="questionText" id="questionText"></textarea><br>
        <label for="option1">Option 1:</label><br>
        <input type="text" name="option1" id="option1"><br>
        <label for="option2">Option 2:</label><br>
        <input type="text" name="option2" id="option2"><br>
        <label for="option3">Option 3:</label><br>
        <input type="text" name="option3" id="option3"><br>
        <label for="option4">Option 4:</label><br>
        <input type="text" name="option4" id="option4"><br>
        <label for="correctAnswer">Correct Answer:</label><br>
        <input type="text" name="correctAnswer" id="correctAnswer"><br><br>
        <input type="submit" value="Submit">
    </form>

</body>
</html>