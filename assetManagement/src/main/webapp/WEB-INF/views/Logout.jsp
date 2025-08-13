<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
*{
  inputbox: 0;
  padding: 0;
  box-sizing: border-box;
  
}

body{
	font-family: Arial, Helvetica, sans-serif;
	display:flex;
	justify-content:center;
	align-items:center;
	padding-top:80px;
	background-image: linear-gradient(to right, #0f0c29, #302b63, #24243e);
}
</style>
</head>
<body>
<form id="logout" action="logout">
      <div style="border:1px solid gray; border-radius:15px;height:500px;width:850px;padding: 20px;background-color:#FFFAF0;">
<div style="text-align:center;padding-top:120px;">
 	<%session.invalidate();%>
	<h1>You have successfully logout</h1>
	 Click here to <a href="login">Login</a>
	 </div>
	 </div>
	 </form>
</body>
</html>