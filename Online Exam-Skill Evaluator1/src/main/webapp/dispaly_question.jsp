<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="com.chainsys.model.AddQuestion" %>
<!DOCTYPE html>
<html>
<head>
    <title>Display Question</title>
</head>
<body>
    <h1>Question Details</h1>
    <%
       // HttpSession session = request.getSession();
        AddQuestion question = (AddQuestion) session.getAttribute("question");
        if (question != null) {
    %>
        <p><strong>Exam Id:</strong> <%= question.getExamId() %></p>
        <p><strong>Question Text:</strong> <%= question.getQuestionText() %></p>
        <p><strong>Option 1:</strong> <%= question.getOption1() %></p>
        <p><strong>Option 2:</strong> <%= question.getOption2() %></p>
        <p><strong>Option 3:</strong> <%= question.getOption3() %></p>
        <p><strong>Option 4:</strong> <%= question.getOption4() %></p>
        <p><strong>Correct Answer:</strong> <%= question.getCorrectAnswer() %></p>
    <%
        } else {
    %>
        <p>No question has been added yet.</p>
    <%
        }
    %>
</body>
</html>
