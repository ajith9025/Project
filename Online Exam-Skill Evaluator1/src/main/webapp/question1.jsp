<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.chainsys.model.AddQuestion" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Arrays" %>
<html>
<head>
    <title>Questions</title>
</head>
<body>
    <form action="CheckResults" method="post">
        <%
            // Retrieve questions from servlet/controller
            ArrayList<AddQuestion> list = (ArrayList<AddQuestion>)request.getAttribute("list");
            int i=1;
            for(AddQuestion items:list) {
           
            
        %>
                    <div>
                        <p><strong><%=i++ %></strong> .<%= items.getQuestionText() %></p>
                        <p><input type="hidden" name="examId" value="<%= items.getExamId() %>"></p>
                        <p><input type="radio" name="answer<%= items.getExamId() %>" value="option1"> <%= items.getOption1() %></p>
                        <p><input type="radio" name="answer<%= items.getExamId() %>" value="option2"> <%= items.getOption2() %></p>
                        <p><input type="radio" name="answer<%= items.getExamId() %>" value="option3"> <%= items.getOption3() %></p>
                        <p><input type="radio" name="answer<%= items.getExamId() %>" value="option4"> <%= items.getOption4() %></p>
                    </div>
        <%
                }
            
        %>
        <input type="submit" value="Submit"> 
        
    </form>
</body>
</html>