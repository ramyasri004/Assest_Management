<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored ="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript"><%@ include file="js/jquery-3.6.0.min.js"%></script>
<title>Register</title>
<style>
*{
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  
}
body{
 font-family: Arial, Helvetica, sans-serif;
	display:flex;
	justify-content:center;
	align-items:center;
	padding-top:70px;
	background-image: linear-gradient(to right, #0f0c29, #302b63, #24243e);
	}
.errors{
	display: block;
  font-weight: 500;
  font-size:13px;
  color:red;
  margin-bottom: 1px;
    text-align: center;
  

}
.success{
	display: block;
  font-weight: 500;
  font-size:13px;
  color: blue;
  margin-bottom: 1px;
    text-align: center;
  

}
.give input{
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
   background: linear-gradient( to right, #434343 0%, black 100%);
   padding:4px;
}
.try{
 background-image:  linear-gradient( #434343 0%, black 100%);
  color: transparent;
  background-clip: text;
  -webkit-background-clip: text;
 
}
.inputbox{
    height: 30px;
    border-radius: 10px;
    margin: 5px;
    padding: 5px
}
</style>
</head>
<body>
<form:form id="form" modelAttribute="User"
		method="post">
<div style="border:1px solid gray; border-radius:25px;height:auto;width:420px;background-color:#FFFAF0;">
<div style="border-bottom:1px solid gray;">
<h2 style="padding:10px;">Registration Form</h2>
</div>
	<div id="response"></div>

<div>
	<div style="margin:20px;">
	<label class="try">Full Name:</label><br>
	<input class="inputbox" type="text" name="fullname" id="fullname" placeholder="Enter your fullname" size="45" maxlength="45" required>
	</div>
	<div style="margin:20px;">
	<label class="try">Username:</label><br>
	<input class="inputbox" type="text" name="username" id="username" placeholder="Enter your username" size="45" required>
	</div>
	<div style="margin:20px">
	<label class="try">Email:</label><br>
	<input class="inputbox" type="text" name="email" id="email" placeholder="Enter your email" size="45" required>
	</div>
	<div style="margin:20px">
	<label class="try">Password:</label><br>
	<input class="inputbox" type="password" name="password" id="password" placeholder="Enter your password" size="45" required>
	<p class="errors" id="p1" style="font-size: 13px; color: blue">
						password must contain minimum 8 to 20 characters and include one upper-case, one lower-case, a number and a special character</p>
	</div>
	<div style="margin:20px">
	<label class="try">Confirm Password:</label><br>
	<input class="inputbox" type="password" name="confirmpass" id="confirmpass" placeholder="Enter your password" size="45" required>
	</div>
	<div style="margin:20px">
	<label class="try">Gender: </label><br>
	  <input type="radio" name="gender" id="dot1" value="Male" required> Male<br>
	  <input type="radio" name="gender" id="dot2" value="Female" required> Female<br><br>
	<div class="give">
	<input type="submit" id="registerButton" value="Register"><br><br>
	Click here to <a href="login">Login</a>
	</div>
</div>
</div>
</div>
<!--   Importing the javascript file for validating the form	 -->
	</form:form>
	
	<script type="text/javascript">
	$(document).ready(function(){
	<%@ include file="js/validation.js"%>
	});
	</script>
	
	<script type="text/javascript">
		let message = "${registerResponse}"
        $(document).ready(function(){
        	
        	/* if ( window.history.replaceState ) {
			  window.history.replaceState( null, null, window.location.href );
			}
			 */
        	$("#form").removeAttr("action");
        	$("#response").html("<h4>"+message+"</h4>");
        	if(message == "REGISTRATION COMPLITED SUCCESSFULLY"){
        		$("#response").attr("class", "success");
        		
        		$("#response").fadeOut(5000, "linear", function(){
        			message = "";
        		});
        	}else{
        		$("#response").attr("class", "errors");
        	}
        });
    </script>
</body>
</html>