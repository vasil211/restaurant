<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>All Users</title>
<link
	href='https://fonts.googleapis.com/css?family=Titillium+Web:400,300,600'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">


  <link rel="stylesheet" href="css/loginStyle.css">
</head>
<body>
	<form action="UserController" method="Get">
		<table border=1>
			<thead>
				<tr>
					<th>User Name</th>
					<th>FirstName</th>
					<th>LastName</th>
					<th>Phone</th>
					<th>EGN</th>
					<th>Email</th>
					<th>Registration date</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach items="${users}" var="user">
					<tr>
						<td><c:out value="${user.getUname()}" /></td>
						<td><c:out value="${user.getFirstName()}" /></td>
						<td><c:out value="${user.getLastName()}" /></td>
						<td><c:out value="${user.getPhone()}" /></td>
						<td><c:out value="${user.getEGN()}" /></td>
						<td><c:out value="${user.getEmail()}" /></td>
						<td><c:out value="${user.getRegistration()}" /></td>
						<td><a
							href="UserController?action=edit&user_Id=<c:out value="${user.getUname()}"/>">Update</a></td>
						<td><a
							href="UserController?action=delete&user_Id=<c:out value="${user.getUname()}"/>">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<p>
			<a href="UserController?action=insert">Add User</a>
		</p>
	</form>
</body>
</html>