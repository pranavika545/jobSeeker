<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Dashboard</title>
</head>
<body>
<h3> Welcome Admin, <%=session.getAttribute("user") %></h3>
Click <a href="<%= request.getContextPath() %>/Logout?action=logout">here</a> to Logout
<hr>

	<table border="1">
      <caption>User List</caption>
      <tr>
          <th>First Name</th>
          <th>Last Name</th>
          <th>Email</th>
          <th colspan="2">Action</th>
      </tr>
      <c:forEach var="user" items="${userList}">
          <tr>
              <td><c:out value="${user.getFirstName()}"/></td>
              <td><c:out value="${user.getLastName()}"/></td>
              <td><c:out value="${user.getEmail()}"/></td>
              <td><a href="<%= request.getContextPath() %>/Admin?email=<c:out value="${user.getEmail()}&action=edit"/>">Edit</a></td>
              <td><a href="<%= request.getContextPath() %>/Admin?email=<c:out value="${user.getEmail()}&action=delete"/>')">Delete</a></td>
               
          </tr>
      </c:forEach>
  	</table>


</body>
</html>