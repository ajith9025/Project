<%@page import="com.chainsys.model.Register"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Table</title>
</head>
<style>
 
        table {
            border-collapse: collapse;
            width: 50%;
            text-align:center;
        }

        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: left;
            
            
        }
        
       /* th:nth-child(even),td:nth-child(even) {
  background-color: #D6EEEE;
  }*/
  tr:hover {background-color: #D6EEEE;}
  
  th, td {
  border-style:solid;
  border-color: #96D4D4;}
  th,td {
  text-align: center;
}

        th {
            background-color: green;
        }
        a{
            text-decoration:none;
            color:green;
            
        }
        
        a:hover{
            color:blue;
        }
    </style>
 
<body>
<h2>Register Details</h2>

    <table>
     <tr>
       
        <th>Username</th>
        <th>Password</th>
         <th>Email</th>
        <th>Contact_no</th>
         <th>Delete</th>
         <th>Edit</th>
         
    </tr>
 
 
        <%
         
                          // RegisterDetails details = new RegisterDetails();
                           ArrayList<Register> list =(ArrayList<Register>) request.getAttribute("list"); ;
                        if(list!= null){
                            for (Register item : list) {
        %>
        <tr>
            <td><%= item.getUsername() %></td>
            <td><%= item.getPassword() %></td>
            <td><%= item.getEmail() %></td>
            <td><%= item.getContactno() %></td>
             <td>
                            <form action="" method="post">
                                <input type="hidden" name="action" value="Delete">
                                <input type="hidden" name="deleteid" value="<%=item.getId()%>">
                                <button type="submit" title="Delete">Delete</button>
                                
                            </form>
                        </td>
                          <td>
                        
                        <input type="hidden" name="action" value="update">
                         <input type="hidden" name="editid" value="<%= item.getId() %>">
                         <button class="edit-btn" type="button" onclick="location.href = 'Update.jsp?editid=<%=item.getId()%>'">Edit</button>
                       
                     </td>
         </tr>  
        
        <%
            }
                        }
        %>
    </table>
   <a href='http://localhost:8080/Online Exam-Skill Evaluator1/'>Add account</a>
</body>
</html>












































