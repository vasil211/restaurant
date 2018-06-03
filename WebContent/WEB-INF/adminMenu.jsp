<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html> 
<head>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Food4U</title>
	<link rel="stylesheet" type="text/css" href="css/menuStyle.css" />	
	<link href="css/font-awesome.min.css" rel="stylesheet"/>
	<link rel="shortcut-icon" type="image/png" href="../try%2520try%2520again/logo.png"/>
</head>
<body>
	<header>
	
		<div id="header-inner">
			
			<nav>
				<ul>
					<li><a href="HomePage?action=Home">Home</a></li>
                    <li><a href="HomePage?action=Menu">Menu</a></li>
                    <li><a href="HomePage?action=Account">Account</a></li>
                    <li><a href="HomePage?action=Login">Login</a></li>

				</ul>
			</nav>
		</div>
		
	</header>
    
     <div class="side-menu">
         <div class="buttons-side">
            <button class="bar-item button tablink" onclick="openDish(event, 'Starters')">Starters</button>
            <button class="bar-item button tablink" onclick="openDish(event, 'Soups')">Soups</button>
            <button class="bar-item button tablink" onclick="openDish(event, 'Meats')">Dishes with meat</button>
         </div>
        </div>

        <div class="menu-switching">
            <div id="Starters" class="container dish" >
                <h2>Starters</h2>
                <form>
                    <table>
                <thead>
				<tr>
					<th> Name </th>
                    <th> Price </th>
                    <th> Ingredients </th>
				</tr>
			</thead>
                <tbody>
                <c:forEach items="${menu}" var="menu">
					<tr>
						<td><c:out value="${menu.getName()}" /></td>
						<td><c:out value="${menu.getPrice()}" /></td>
						<td><c:out value="${menu.getDescription()}" />
						<td><a
							href="UserController?action=delete&menu_Id=<c:out value="${user.getName()}"/>">Delete</a></td>
                        </td>
					</tr>
					</c:forEach>
                </tbody>
                     </table>
                 </form>
            </div>
            <div id="Soups" class="container dish" style="display:none">
                <h2>Soups</h2>
                <form>
                    <table>
                <thead>
				<tr>
					<th> Name </th>
                    <th> Price </th>
                    <th> Ingredients </th>
				</tr>
			</thead>
                <tbody>
                <c:forEach items="${menu}" var="menu">
					<tr>
						<td><c:out value="${menu.getName()}" /></td>
						<td><c:out value="${menu.getPrice()}" /></td>
						<td><c:out value="${menu.getDescription()}" />
                        </td>
					</tr>
					</c:forEach>
                </tbody>
                     </table>
                 </form>

            </div>

            <div id="Meats" class="container dish" style="display:none">
                <h2>Dishes with meat</h2>
                <form>
                    <table>
                <thead>
				<tr>
					<th>Name</th>
                    <th>Price</th>
                    <th>Ingredients</th>
				</tr>
			</thead>
                <tbody>
                <c:forEach items="${menu}" var="menu">
					<tr>
						<td><c:out value="${menu.getName()}" /></td>
					<td><c:out value="${menu.getPrice()}" /></td>
						<td><c:out value="${menu.getDescription()}" />
                        </td>
					</tr>
					 </c:forEach>
                </tbody>
                     </table>
                 </form>
                   
            </div>
        </div>
                </body>
        <script>
            function openDish(evt, dishName) {
                var i, x;
                x = document.getElementsByClassName("dish");
                for (i = 0; i < x.length; i++) {
                    x[i].style.display = "none";
                }
                document.getElementById(dishName).style.display = "block";
                document.getElementById(dishName).style.position = "relative";
                document.getElementById(dishName).style.marginLeft = "160px";
            }

        </script>