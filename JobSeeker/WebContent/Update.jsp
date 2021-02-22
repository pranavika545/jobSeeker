<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update User</title>
</head>
<body>

<form action="<%=request.getContextPath()%>/Admin" method="post">
            <table border="1">
                <caption>Edit User Details</caption>
                <tr>
                    <th>First Name</th>
                    <th>Las Name</th>
                </tr>
                <tr>
                    <td><input type="hidden" value="${u.getEmail()}" name="email"/>
                    	<input type="text" value="${u.getFirstName()}" name="firstName"/></td>
                    <td><input type="text" value="${u.getLastName()}" name="lastName"/></td>
                    <td><input type="submit" value="Update"/></td>
                </tr>
            </table>
            <a href="admin.jsp">Go Home</a>
        </form>

</body>
</html>