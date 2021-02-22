<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Job Seeker Application</title>
</head>
<body>
<h2>Welcome to Job Seeker Application</h2>
<h3>Please Login</h3>
<hr>
<form action="<%=request.getContextPath()%>/SeekerLogin" method="post">
	<input type="email" name="email" placeholder="Enter Email" required="required">
	<input type="password" name="password" placeholder="Enter Password" required="required">
	
		<input type="submit" value="Login"/>
</form>
Not Registered yet? click <a href = "register.jsp">here</a> to Register.
</body>
</html>