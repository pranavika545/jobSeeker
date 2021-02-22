<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import= "org.com.web.model.User" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Dashboard</title>
</head>
<body>
<% 
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	
	String userName = null;
	if(session.getAttribute("user") == null)
		response.sendRedirect("index.jsp");
		
%>
Welcome <%= session.getAttribute("user") %><br>
Click <a href="<%= request.getContextPath() %>/Logout?action=logout">here</a> to Logout
<hr>

Below is the data you have provided.<br>

First Name: ${u.getFirstName()}<br>
Last Name: ${u.getLastName()}<br>
Email: ${u.getEmail()}<br>

<form method="post" action="<%=request.getContextPath()%>/uploadFile" enctype="multipart/form-data">

   Select file to upload:
   <input type="hidden" name=email value="${u.getEmail()}"/>
   <input type="file" name="file" />
   <br/>
   <input type="submit" value="Upload" name="upload" />
</form>


</body>
</html>