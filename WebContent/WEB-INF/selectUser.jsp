<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
</head>

<body>
	<div class="header">
		<h1>Select type of user</h1>
		<link rel="stylesheet" href="css/selectUser.css">
	</div>
	<form action="ListUser" method="Get">
	<div class="page" >
		<div class="cook">
			<h1>
			<button name="action" type="submit" value="cook">Cook</button>
			</h1>
			<br>
		</div>
		<div class="waiter">
			<h1>
			<button name="action" type="submit" value="waiter">Waiter</button>
			</h1>
			<br>
		</div>
		<div class="user">
			<h1>
			<button name="action" type="submit" value="user">User</button>
			</h1>
			<br>
		</div>
		<div class="admin">
			<h1>
			<button name="action" type="submit" value="admin">Admin</button>
			</h1>
			<br>
		</div>
	</div>
</form>
</body>
</html>
