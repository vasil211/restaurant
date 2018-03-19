<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add new user</title>
</head>
<body>
	<form method="POST" action='UserController' name="frmAddUser">
		<%
			String action = request.getParameter("action");
			System.out.println(action);
		%>
		<%
			if (action.equalsIgnoreCase("edit")) {
		%>
		User Name : <input type="text" name="uname"
			value="<c:out value="${user.getUname()}" />" readonly="readonly" />
		(You Can't Change this)<br />
		<%
			} else {
		%>
		User Name : <input type="text" name="uname"
			value="<c:out value="${user.getUname()}" />" /> <br />
		<%
			}
		%>
		FirstName: <input type="text" name="FirstName"
			value="<c:out value="${user.getFirstName()}" />" /> <br />
		LastName: <input type="text" name="LastName"
			value="<c:out value="${user.getLastName()}" />" /> <br /> 
	    Email : <input type="text" name="email" 
	        value="<c:out value="${user.getEmail()}" />" />  <br />
		Roles_id : <input type="text" name="Roles_id"
			value="<c:out value="${user.getRoles_id()}" />" /> <br /> <br />

		<%
			if (action.equalsIgnoreCase("edit")) {
		%>
		Registration : <input type="text" name="dob"
			value="<fmt:formatDate pattern="yyyy/MM/dd" value="${user.getRegistration()}" />"
			readonly="readonly" />(You Can't Change this) <br />
		<%
			} else {
		%>
		Registration : <input type="text" name="dob"
			value="<fmt:formatDate pattern="yyyy/MM/dd" value="${user.getRegistration()}" />" />(yyyy/MM/dd)
		<br />
		<%
			}
		%>
		<input type="submit" value="Submit" />
	</form>
</body>
</html>