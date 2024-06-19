<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Sign Up</title>
<style>
body {

    font-family: Arial, Helvetica, sans-serif;
    background-image: url(pexels-nietjuh-843266.jpg);
    background-repeat: no-repeat;
    background-position: center;
    min-height: 80vh;
    background-size: cover;
    max-width: 400px;
    margin: 40px auto;
    padding: 10px;
}
* {
    box-sizing: border-box;
}
form{
  box-shadow: 10px rgba(0,0,0,0.03);
  border-radius: 5px;
  border: 1px solid #f3f3f3;
 padding: 50px 10px 50px 10px;  
 background-image: url(tyler-franta-iusJ25iYu1c-unsplash.jpg);
 background-repeat: no-repeat;
 background-position: center;
 background-size: cover;
}

.input-container {
  display: -ms-flexbox; /* IE10 */
  display: flex;
  width: 100%;
  margin-bottom: 15px;
}

.icon {
  padding: 10px;
  background:black;
  color: white;
  min-width: 50px;
  text-align: center;
}

.input-field {
  width: 100%;
  padding: 10px;
  outline: none;
}

.input-field:focus {
  border: 2px solid dodgerblue;
}


.btn {
  background-color:blanchedalmond;
  color:black;
  padding: 15px 20px;
  border: none;
  cursor: pointer;
  width: 50%;
  opacity: 0.9;
}

.btn:hover {
  opacity: 1; 
}

.error-message {
  color: red;
}

</style>

<script>
function validateForm() {
  var username = document.forms["signupForm"]["username"].value;
  var password = document.forms["signupForm"]["password"].value;
  var email = document.forms["signupForm"]["email"].value;
  var contact_no = document.forms["signupForm"]["contact_no"].value;
  
  if (username == "") {
    alert("Username must be filled out");
    return false;
  }
  
  if (password == "") {
    alert("Password must be filled out");
    return false;
  }
  
  if (email == "") {
    alert("Email must be filled out");
    return false;
  }
  
  // Regular expression for validating email format
  var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  if (!email.match(emailRegex)) {
    alert("Invalid email format");
    return false;
  }
  
  // Regular expression for validating mobile number format
  var mobileRegex = /^\d{10}$/;
  if (!contact_no.match(mobileRegex)) {
    alert("Invalid mobile number format. Please enter a 10-digit number");
    return false;
  }
}
</script>

</head>
<body>
  <h2>Register Form</h2>
<form name="signupForm" action="Registeration" method="post" onsubmit="return validateForm()">
  <div class="input-container">
    <i class="fa fa-user icon"></i>
    <input class="input-field" type="text" placeholder="Username" name="username" required>
  </div> 
  <div class="input-container">
    <i class="fa fa-key icon"></i>
    <input class="input-field" type="password" placeholder="Password" name="password" required>
  </div>
  <div class="input-container">
    <i class="fa fa-envelope icon"></i>
    <input class="input-field" type="email" placeholder="Email" name="email" required>
  </div>
  <div class="input-container">
    <i class="fa fa-address-book icon"></i>
    <input class="input-field" type="text" placeholder="Contact no" name="contact_no" required>
  </div>

  <button type="submit" class="btn">Register</button>
</form>
</body>
</html>
