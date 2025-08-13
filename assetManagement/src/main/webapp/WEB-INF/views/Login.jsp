

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

body {
	font-family: Arial, Helvetica, sans-serif;
	display: flex;
	justify-content: center;
	align-items: center;
	padding-top: 170px;
	background-image: linear-gradient(to right, #0f0c29, #302b63, #24243e);
}

.errors {
	display: block;
	font-weight: 500;
	font-size: 13px;
	color: red;
	margin-bottom: 1px;
	text-align: center;
}

.give input {
	height: 100%;
	width: 100%;
	border-radius: 5px;
	border: none;
	color: #fff;
	font-size: 18px;
	font-weight: 500;
	letter-spacing: 1px;
	cursor: pointer;
	transition: all 0.3s ease;
	background: linear-gradient(to right, #434343 0%, black 100%);
	padding: 4px;
}

.try {
	background-image: linear-gradient(#434343 0%, black 100%);
	color: transparent;
	background-clip: text;
	-webkit-background-clip: text;
}

.inputbox {
	height: 30px;
	border-radius: 10px;
	margin: 5px;
	padding: 5px;
}

.super {
	display: block;
	font-weight: 500;
	font-size: 13px;
	color: orange;
	margin-bottom: 1px;
	text-align: center;
}
</style>

</head>
<body>
	<form:form id="loginForm" modelAttribute="Login" action="entryprocess"
		method="post">
		<div
			style="border: 1px solid gray; border-radius: 15px; height: auto; width: 420px; background-color: #FFFAF0;">
			<div style="border-bottom: 1px solid gray;">
				<h2 style="margin: 20px;">
					Login Form
					</h3>
			</div>
			<%--  <div id="errorresponse" class ="errors"><p>${loginResponse}</p></div>
           <div id="success" class="super"><p>${registerResponse}</p></div> --%>
			<div class="errors">
				<div id="errorresponse">${loginResponse}</div>
			</div>
			<div class="super">
				<div id="success">${registerResponse}</div>


			</div>
			<div>
				<div style="margin: 20px;">
					<label>Username : </label> <input class="inputbox" type="text"
						min="6" max="15" name="username" placeholder="Enter Your Username"
						size="30" required />
				</div>
				<div style="margin: 20px;">
					<label>Password : </label> <input class="inputbox" type="password"
						name="password" placeholder="Enter Your Password" size="30"
						required />
				</div>
			</div>
			<div style="margin: 20px;">
				<button
					style="padding: 10px; border-color: white; background-color: blue; color: white; margin: 0px 10px 0px 0px;">
					Submit</button>
				<a href="register"> Register </a>
			</div>
		</div>
	</form:form>
	<script type="text/javascript">
		        $(window).load(function () {
		        
		        	$("#errorresponse").delay(1000).fadeOut(5000);
		        });
		        </script>
	<script type="text/javascript">
		        $(window).load(function () {
		        
		        	$("#success").delay(1000).fadeOut(5000);
		        });
		        </script>
</body>
</html>