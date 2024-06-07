<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login</title>
<style>
body{
    margin: 0;
    padding: 0;
    font-family: Arial, Helvetica, sans-serif;
    background-image: url(bram-naus-n8Qb1ZAkK88-unsplash.jpg);   
    background-repeat: no-repeat;
    background-position: center;
    min-height :80vh;;
    background-size: cover;
}
ul{
    margin: 0;
    padding: 0;
    font-family: Arial, Helvetica, sans-serif;
}

nav {
    background-color:black;
    overflow: hidden;
}

.navbar {
    list-style-type: none;
    display: flex;
    justify-content:space-evenly;
}
.navbar li {
    float: left;
}
.navbar a {
    display: block;
    color: white;
    text-align: center;
    padding: 14px 20px;
    text-decoration: none;
}
.navbar a:hover {
  background-color: #ddd;
  color: black;
}
.navbar a.active {
  background-color:aqua;
  color: white;
}


</style>
</head>
<body>
         <nav>
            <ul class="navbar">
               <li><a href="question.html">Add Question</a></li>
                 <li><a href="#">View All Question</a></li>
                 <li><a href="exam.jsp">Add Exam</a></li>
              <!--  <li><a href="#">Update Question</a></li>
               <li><a href="#">Delete Question</a></li> -->
                <li><a href="index.jsp">Logout</a></li>
            </ul>
        </nav>
        <h1>Online Exam</h1>
</body>
</html>
