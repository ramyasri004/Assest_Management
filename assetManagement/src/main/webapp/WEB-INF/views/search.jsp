<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored ="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script  src="https://code.jquery.com/jquery-2.2.4.js"></script>
<%-- <script type="text/javascript"><%@ include file="js/jquery-3.6.0.min.js"%></script>  --%>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    
<!--  <script type="text/javascript"  src="js/entryvalidation.js"></script>

 --><title>Search Results</title>

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

.errors{
	display: block;
  font-weight: 500;
  font-size:13px;
  color:green;
  inputbox-bottom: 1px;
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

.inputbox {
    padding : 3px;
	margin : 5px;
}

.inputbox label{
	display: inline-block;
    max-width: 250px;
    width: 38%;
    margin-bottom: 5px;
    font-weight: 700;
}

.inputbox input,select{
	height: 30px;
    border-radius: 10px;
	width : 50%;
	padding : 5px;
	border: solid 1px;
}

.navbar-brand>img {
  padding-top: 11px;
  width: 130px;
  inputbox-left: 60px;
}

.navbar-brand {
    height: auto;
    inputbox: 0;
    padding: 0;
    inputbox-right: 20px;
}

.navbar {
	background: #1BAAC2;
}

.navbar-default .navbar-nav > .active > a {
  padding: 8px 19px 9px !important;
}

.navbar-nav > li.active {
  padding: 8px 0px 9px 0;
}

.navbar-right {
  padding-top: 0;
}

.navbar-default .navbar-nav > li > a::after {
  background-color: transparent;
  border-bottom: 3px solid #d2282e;
}

.navbar-default .navbar-nav>li {
  display: inline-block;
  text-align: center;
  float: none;
}

.navbar-default .navbar-nav>li>a {
    color: #fff;
}
.navbar-default .navbar-nav>li>a:hover {
    color: #fff;
    background-color: #2FC2DA;
}

body > .container {
  padding: 60px 15px 0;
}

.container .text-muted {
  inputbox: 20px 0;
}

.btns{
	margin : 10px;
	padding: 10px;
}
.btns button{
	padding: 10px;
    margin: 10px;
    color: white;
    border-radius: 5px;
    width: 100px;
}
.topnav {
    inputbox-right: 20px;
}

.topnav a {
  float: left;
  color: black;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}


.topnav a.active {
  background-color: #04AA6D;
  color: white;
}

.topnav-right {
  float: right;
  font-weight:800px;
  color:red;
}
a:link {
  color: black;
  background-color: transparent;
  text-decoration: none;
  font-weight: bold;
}
a:hover {
  color: blue;
  background-color: transparent;
  text-decoration: underline;
    font-weight: bold;
}
span {
  content: "\002A";
  color:red;
}

</style>
<!-- <script>

/* 
$("#submitentryform").click(function(){
	 alert("submitentryform");
   var entryFormError = validateentryform();
   if(entryFormError){
        $("#form").attr("onsubmit","return true");
    }else{
        $("#form").attr("onsubmit","return false");
    }
});
 */

</script> -->

</head>
<body>
    <form id="searchresults" modelAttribute="Search" action="searchresults" method="post" onsubmit="return validatesearchform();">
     
  

      <div style="border:1px solid gray; border-radius:15px;height:auto;width:auto;padding: 20px;background-color:#FFFAF0;">
      <div class="topnav">
 
  <div class="topnav-right">
    <a href="entryForm" >Entry form</a>
	<a href="logout">Logout</a>
  </div>
</div>
			<div style="border-bottom:1px solid gray;padding: 3px;margin:10px;">
                <h2>Search</h2>
            </div>
             
           <%--  <div class="errors">
	<div id="errorresponse">${entryResponse}</div>
</div> --%>
            
          
            
        <div style="width: 100%;">
            <div style="width: 50%; float: left;"> 
              
               <div class="inputbox">
                    <label>Asset Type:</label> 
                    <select id="assettype" name="assettype" >
					  <option value="" style='disabled'>Choose Asset</option>
				      <option value="Laptop">Laptop</option>
				      <option value="Desktop">Desktop</option>
				      <option value="Server">Server</option>
				      <option value="Monitor">Monitor</option>

				    </select>
                </div>
              
    
                
                <div class="inputbox">
					<label>Memory Details:</label>
					<input   type="text"  id="memorydetails" name="memorydetails" placeholder="Memory" />
                </div>
                
               <div class="inputbox">
                    <label>Operating System: </label>
                    <select id="operatingsystem" name="operatingsystem"  placeholder="Operating System">
				      <option value="" style='disabled'>Choose OS</option>
					  <option value="Macintosh">Macintosh</option>
				      <option value="Windows Server 2016">Windows Server 2016</option>
				      <option value="Windows 7  ">Windows 7  </option>
				      <option value="Windows 10">Windows 10</option>
				      <option value="Windows 10 Professional">Windows 10 Professional</option>
				      <option value="Windows 11 Professional">Windows 11 Professional</option>
				      <option value="Windows Server 2016 Standard">Windows Server 2016 Standard</option>
				      <option value="Windows Server 2012 R2 Standard">Windows Server 2012 R2 Standard</option>
				      <option value="Windows XP Pro">Windows XP Pro</option>
				      <option value="Windows 7 Pro">Windows 7 Pro</option>
				      <option value="Windows Server 2019 Standard">Windows Server 2019 Standard</option>
				      <option value="Windows 11 Pro">Windows 11 Pro</option>
				    </select>
                </div>
				
                <div class="inputbox">
					<label>Serial Number:</label>
					<input   type="text"  id="serialno" name="serialno" placeholder="Serial number" />
                </div>
				
            
				
            </div>
			
            <div style="width: 50%;float:right;"> 
                <div class="inputbox">
					<label>Hardware AssetId:</label>
					<input   type="text"  id="hardwareassetid" name="hardwareassetid" placeholder=" Hardware AssetId" />
                </div>
				
                <div class="inputbox">
                    <label>Current Status:</label>
                    <select id="currentstatus" name="currentstatus"  >
					  <option value="" style='disabled'>Choose status</option>
				      <option value="Idle">Idle</option>
				      <option value="Assigned">Assigned</option>
				      <option value="Hardware Issue"> Hardware Issue</option>
				      <option value="Scrapped">Scrapped</option>
				      <option value="ToBeRepaired">ToBeRepaired</option>
				      <option value="ToBeScrapped">ToBeScrapped</option>
					</select>
                </div>
				
                <div class="inputbox">
					<label>Assigned To: </label>
					<input   type="text"  id="assignedto" name="assignedto" placeholder="Assigned To" />
				</div>
				
                <div class="inputbox">
                    <label>Asset Location:</label>
                    <select id="assetloc" name="assetloc"  >
					  <option value="" style='disabled'>Choose location</option>
				      <option value="HYD">HYD</option>
				      <option value="VSEZ">VSEZ</option>
				      <option value="MSEZ">MSEZ</option>
				    </select>
                </div>
				
                <div class="inputbox">
					<label>Spares Asset Id: </label>
					<input   type="text"  id="spareassetid" name="spareassetid" placeholder="Spares Asset Id" />
                </div>
				
           
				
               <br><br>
            </div>
			
			<div class="btns">
				<button id="submitentryform" style="background-color:darkblue"> Submit </button>
				<input type="reset" value="clear" id="reset"  style="padding: 10px;  margin: 10px; color: white;border-radius: 5px; width: 100px;background-color:blue" />	
 		</div>
        </div>
          
        
                </form>
        
        <script type="text/javascript">
        
        $("#reset").click(function(){
        	 $("#searchresults").trigger("reset");
        	 $(".results").remove();
        });
        
        function validatesearchform(){
        
        	                let isError = false;
        	              
        	               var assettype =$("#assettype").val();
        	               var memorydetails =    $("#memorydetails").val();
        	               var operatingsystem =$("#operatingsystem").val();
        	               var serialno =$("#serialno").val();
        	               var hardwareassetid =$("#hardwareassetid").val();
        	               var currentstatus =$("#currentstatus").val();
        	               var assignedto =$("#assignedto").val();
        	               var assetloc =$("#assetloc").val();
         	               var spareassetid =$("#spareassetid").val();
         	               
         	               
        	    
        	               if(assettype || memorydetails || operatingsystem || serialno || hardwareassetid || currentstatus || assignedto || assetloc || spareassetid){
        	                   isError=true;
        	                   return true;

        	               }else{
        	            	   isError=false;
      	                  	   alert("Provide Alteast One Search Criteria");
      	                        return false;
      	               }
        	               return isError;
        	               
        	 
        	}
        
        
        </script>
       



           
		
	
				<jsp:include page="/WEB-INF/views/SearchResults.jsp" />     
    </body>
    	

			
 
</html>