<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Login</title>
<style>
body {
    font-family: Arial, Helvetica, sans-serif;
    background-image: url(pexels-tirachard-kumtanom-112571-733857.jpg);
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
  box-shadow:10px 10px 20px rgba(0,0,0,0.03);
  border-radius: 5px;
  border: 1px solid #f3f3f3;
  padding: 50px 10px 50px 10px;
 background-image: url(pexels-tirachard-kumtanom-112571-733852.jpg);
 background-repeat: no-repeat;
 background-position: center;
 background-size: cover;
}

.input-container {
  display: -ms-flexbox; 
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
  border: 2px solid blanchedalmond;
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
</style>

<script>
  function validateForm() {
    
   
    var email = document.forms["loginForm"]["email"].value;
    var password = document.forms["loginForm"]["password"].value;
    
    if (email == "") {
      alert("Email must be filled out");
      return false;
    }
    
    var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!email.match(emailRegex)) {
      alert("Invalid email format");
      return false;
    }
    
    if (password == "") {
      alert("Password must be filled out");
      return false;
    }
 
    var passwordRegex = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}$/;
    if (!password.match(passwordRegex)) {
      alert("Password must contain at least one uppercase letter, one lowercase letter, one number, and be at least 8 characters long");
      return false;
    }
  
  }
  </script>
</head>
<body>
   
    <h2>Login Form</h2>
    <form name="loginForm" action="Login" method="post" onsubmit="return validateForm()"> 
  <div class="input-container">
    <i class="fa fa-envelope icon"></i>
    <input class="input-field" type="email" placeholder="Email" name="email" required>
  </div> 
  <div class="input-container">
    <i class="fa fa-key icon"></i>
    <input class="input-field" type="password" placeholder="Password" name="password"required>
  </div>
  <button type="submit" class="btn">Login</button>
</form>
</body>
</html>
