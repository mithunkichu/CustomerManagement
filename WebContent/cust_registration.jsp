<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Registration</title>
</head>
<body>
  <h1>Welcome to Registration page</h1>
<form action="register">
Name : <input type="text" placeholder="Enter name" name="tbname" required/>
<br>
Gender :<input type="radio" name="gender" value="Male"/>Male
		<input type="radio" name="gender" value="Female"/>Female
<br>		
Email : <input type="email" placeholder="Enter Email" name="tbmail" required/>
<br>
Password : <input type="password" placeholder="Enter password" name="tbpass" required/>
<br>
Mobile :<input type="text" placeholder="Enter mobile" name="tbmob" required/>
<br>
State : <select name="ddlstate" required>
		<option >----SELECT----</option>
		<option value="TN">TAMIL NADU</option>
		<option value="KL">KERALA</option>
		<option value="KAR">KARNATAKA</option>
		<option value="AP">ANDHRA</option>
		
		</select>
<br>		
		<button>Register</button>
</form>		
</body> 
</html>