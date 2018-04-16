<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
</head>

<body>
	<div class="header">
		<h1>Select type of user</h1>
		<link rel="stylesheet" href="css/selectUser.css">
	</div>
	
	<div class="page" action="SelectUser" method="Get" >
		<div class="cook">
			<h1>
				<a href="cookList.jsp">Cook</a>
			</h1>
			<br>

		</div>
		<div class="waiter">
			<h1>
				<a href="waiterList.jsp">Waiter</a>
			</h1>
			<br>

		</div>

		<div class="user">
			<h1>
				<a href="userList.jsp">User</a>
			</h1>
			<br>


		</div>


		<div class="admin">
			<h1>
				<a href="adminList.jsp">Admin</a>
			</h1>
			<br>

		</div>

	</div>

</body>
</html>
