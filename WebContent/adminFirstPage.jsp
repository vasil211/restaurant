<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE>
<html>

<head>
<meta charset="UTF-8">
<title>Welcome back</title>
<link rel="stylesheet" href="css/adminFirstPage.css">



</head>

<body>
	<div class="header">
		<h1>Welcome back</h1>
	</div>
	<div class="page">
		<div class="user" >
			<h2>
				<a href="selectUser.jsp">Users</a>
			</h2>
			<br>

		</div>
		<div class="menu">
			<h2>
				<a href="menuList.jsp">menu</a>
			</h2>
			<br>

		</div>

		<div class="orders">
			<h2>
				<a href="ordersList.jsp">orders</a>
			</h2>
			<br>


		</div>


		<div class="tables">
			<h2>
				<a href="tablesList.jsp">tables</a>
			</h2>
			<br>

		</div>

	</div>

</body>