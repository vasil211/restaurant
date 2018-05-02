<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
</head>

<body>
	<div class="header">
		<h1>Select type of user</h1>
		<link rel="stylesheet" href="css/selectUser.css">
	</div>
<<<<<<< HEAD
	<form action="SelectUser" method="Get">
	<div class="page" >
=======
	
	<div class="page" action="SelectUser" method="Get" >
>>>>>>> ac99de9924e1b835ae5d2147887c8f597fd36894
		<div class="cook">
			<h1>
			<button type="submit" value="cook">Cook</button>
			</h1>
			<br>

		</div>
		<div class="waiter">
			<h1>
			<button type="submit" value="waiter">Waiter</button>
			</h1>
			<br>

		</div>

		<div class="user">
			<h1>
			<button type="submit" value="user">User</button>
		<!--  	 <input type="button" name="userList" value="user">User
				<a href="userList.jsp" value="user">User</a> -->
			</h1>
			<br>


		</div>


		<div class="admin">
			<h1>
			<button type="submit" value="admin">Admin</button>
			</h1>
			<br>

		</div>

	</div>
</form>
</body>
</html>
