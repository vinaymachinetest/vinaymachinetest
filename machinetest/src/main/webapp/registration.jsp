<!DOCTYPE html>
<head>
<title>User Registration</title>
</head>
<body style="height: 208px; width: 842px">
	<h3>User Registration</h3>

	<form action="register" method="post">
		<pre>
	    <strong>Register Here | <a href="login.jsp">Click here to Login</a></strong>
		
		User Id: <input type="text" name="userId" />
		
		Password: <input type="password" name="password" />
	
		<input type="submit" value="Register" />
	</pre>
	</form>

	${msg}
</body>
</html>