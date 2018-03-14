<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
   
  <title>restaurant</title>
  <link href='https://fonts.googleapis.com/css?family=Titillium+Web:400,300,600' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
    <link rel="stylesheet" href="css/style.css">
    <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script> 
   <script  src="js/index.js"></script>
</head>
<body>

	<div class="form">

		<ul class="tab-group">
			<li class="tab active"><a href="#login">Log In</a></li>
			<li class="tab "><a href="#signup">Sign Up</a></li>

		</ul>

		<div class="tab-content">
			<div id="login">
				<h1>Welcome Back!</h1>
				<%String error=request.getParameter("error"); %>
				<%if(error != null){
				out.print("<p class='error'>" + error + "</p>");   
			} %>

				<form action="UserController" method="post">

					<div class="field-wrap">
						<label>Username<span class="req">*</span>
						</label> <input type="text" name="uname" required autocomplete="off" />
					</div>

					<div class="field-wrap">
						<label> Password<span class="req">*</span>
						</label> <input type="password" name="password" required
							autocomplete="off" />
					</div>

					<p class="forgot">
						<a href="#">Forgot Password?</a>
					</p>

					<button class="button button-block">Log In</button>

				</form>

			</div>
			<div id="signup">
				<h1>Sign Up for Free</h1>

				<form action="RegistrationController" method="Post">

					<div class="top-row">
						<div class="field-wrap">
							<label> First Name<span class="req">*</span>
							</label> <input type="text" name="FirstName" required autocomplete="off" />
						</div>

						<div class="field-wrap">
							<label> Last Name<span class="req">*</span>
							</label> <input type="text" name="LastName" required autocomplete="off" />
						</div>
					</div>

					<div class="field-wrap">
						<label> Username<span class="req">*</span>
						</label> <input type="text" name="Uname" required autocomplete="off" />
					</div>
			
			<div class="field-wrap">
				<label> Phone Number<span class="req">*</span>
				</label> <input type="text" name="Phone" min="0" required
					autocomplete="off">
			</div>
			<div class="field-wrap">
				<label> EGN<span class="req">*</span>
				</label> <input type="text" name="EGN" required autocomplete="off" />
			</div>


			<div class="field-wrap">
				<label> Email Address<span class="req">*</span>
				</label> <input type="email" name="Email" required autocomplete="off" />
			</div>

			<div class="field-wrap">
				<label> Set A Password<span class="req">*</span>
				</label> <input type="password" name="Password" required autocomplete="off" />
			</div>

			<button type="submit" class="button button-block">Get
				Started</button>

			</form>

		</div>



	</div>

	</div>

	<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

  

    <script  src="js/index.js"></script>



	
</body>
</html>