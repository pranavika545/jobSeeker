<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Job Seeker Registration</title>
</head>
<body>

	<h1>Please Register Below</h1>
	<form action="<%=request.getContextPath()%>/Register" method="post">
			<table style="with: 50%">
				<tr>
					<td>First Name</td>
					<td><input type="text" name="firstName" required="required" /></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><input type="text" name="lastName" required="required"/></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><input type="email" name="email" required="required"/></td>
				</tr>
					<tr>
					<td>Password</td>
					<td><input type="password" name="password" required="required"/></td>
				</tr>
			</table>
			<input type="submit" value="Register" />
	</form>
	Already Registered? click <a href = "index.jsp">here</a> to Login.

</body>
</html>