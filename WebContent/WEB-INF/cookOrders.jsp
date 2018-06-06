<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>cook orders</title>
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
					<th>id</th>
					<th>Name</th>
					
					
 
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${orders}" var="orders"> 
				
					<tr action="GetOrders" method="Get">
						<td><c:out value="${orders.getOrderId()}" /></td>
						<td><c:out value="${orders.getTable()}" /></td>
						
				</c:forEach>
			</tbody>
		</table>
		
	</form>
</body>
</html>