// Validation for input type
    $("#p1").hide();
    var passReg = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,20}$/;
	 var emailReg = /^([a-zA-Z0-9\.]+)@([a-zA-Z0-9\.]+)(\.com)$/;
	 
//This code invokes the validate() method on register page to validate on--click submit-button. 
	 $("#registerButton").click(function(){
		var registerError = validate();
		if(registerError){
			 $("#form").attr({onsubmit:"return true", action:"registerProcess"});
		 }else{
			 $("#form").attr("onsubmit","return false");
		 }
	 });

//This code invokes the validate() method on login page to validate on--click submit-button. 
	 $("#loginButton").click(function(){
		 var loginError = validate();
		 if(loginError){
			 $("#form").attr("onsubmit","return true");
		 }else{
			 $("#form").attr("onsubmit","return false");
		 }
	 });
    
	 $("#changepass").click(function(){
			var registerError = validate();
			if(registerError){
				 $("#form").attr("onsubmit","return true");
			 }else{
				 $("#form").attr("onsubmit","return false");
			 }
		 });
 //This is to give error message when the field is left empty on the event of on-blur.
    $('input,textarea').blur(function(){   
            let value = $(this).val();
			let name = $(this).prev("span").text();
			let isRequired = $(this).attr("required");
			let minLength = $(this).attr("minlength");
			let maxLength = $(this).attr("maxlength");
			let precision = $(this).attr("precision");
            //console.log(value);
		if(isRequired=='required'){
            if(value.length<1){
                $(this).css("border-color","red");
				$(this).next("span").remove();
				$(this).after('<span class="errors">*'+name+' Required.</span>');
            }else if(value.length<minLength){
            	 $(this).css("border-color","red");
 				 $(this).next("span").remove();
 				 $(this).after('<span class="errors">*'+name+' should contain minimum '+minLength+' characters and maximum '+maxLength+' charaters.</span>');
            }else if(value.length>maxLength){
            	 $(this).css("border-color","red");
 				 $(this).next("span").remove();
 				 $(this).after('<span class="errors">*'+name+' should not exceed '+maxLength+' characters.</span>');
            }else if(precision!=undefined && precision != null && precision.trim() !=""){
            	var decimalValue = Number(value).toFixed(precision);
            	$(this).val(decimalValue);
            	$(this).css("border-color","#9b59b6");
				$(this).next("span").remove();
            }else{
			       $(this).css("border-color","#9b59b6");
				   $(this).next("span").remove();
			}
		 }
  });
 
 //This is to give error message when the field is left empty on the event of on-blur.
    $("select").on("blur",function(){
		let value = $(this).find("option:selected").val();
		let name = $(this).prev("span").text();
		if($(this).attr("required")) {
			if(value.length == 0){
		    	$(this).css("border-color","red");
		    	$(this).next("span").remove();
				$(this).after('<span class="errors">*'+name+' Required.</span>');
		    }else{
		    	$(this).css("border-color","#9b59b6");
		    	$(this).next("span").remove();
			}
		}
	});


  //code to check the whether the confirmPassword is same a password on the event of Key-up.
    $("#confirmpass").keyup(function(){
	    let pass = $("#password").val();
		let cnpass = $("#confirmpass").val();
	    if(cnpass!==pass){
		   $("#confirmpass").css("border-color","red");
		}else{
		      $(this).css("border-color","#9b59b6");
		      
		}
	});
	
    //code to check the whether the confirmPassword is same a password on the event of on-blur.
	$("#confirmpass").blur(function(){
	    let pass = $("#password").val();
		let cnpass = $("#confirmpass").val();
	    if(cnpass!==pass){
		   $(this).css("border-color","red");
		   $(this).next("span").remove();
		   $(this).after('<span class="errors">*Check Password.</span>');
		}else{
		      $(this).css("border-color","#9b59b6");
			  $("#confirmpass").next("span").remove();
		}
	});

   // code to verify whether provided password meets the required specification.
	$("#password").keyup(function(){
	     let checkPass = $("#password").val();
         if(!passReg.test(checkPass)) {
         $("#p1").show();
		 $("#password").css("border-color","red");
		}else{
		      $(this).css("border-color","#9b59b6");
			  $("#p1").hide();
		}
	});

    //code to verify the provided email is valid or not on the event of on-blur.
	$("#email").blur(function(){
	     let email = $("#email").val();
         if(!emailReg.test(email)) {
		 $(this).next("span").remove();
         $(this).after('<span class="errors">*Invalid Email Format.</span>');
		 $("#email").css("border-color","red");
		}else{
		      $(this).css("border-color","#9b59b6");
			  $(this).next("span").remove();
		}
	});
	
    
 
// code to validate form whether the provided details match the required specifications before submitting the form.
		function validate(){
			let isError = true;
		$("#form").find("input,select,textarea").each(function(){
		
			let currentTagName = $(this).prop("tagName");
			 if(currentTagName!=undefined && currentTagName != null && currentTagName.trim() != ""){
				 currentTagName = currentTagName.toLowerCase();
			 }
		 
		    let currentElementType = $(this).attr("type");
			 if(currentElementType!=undefined && currentElementType!=null && currentElementType.trim() != ""){
				 currentElementType = currentElementType.toLowerCase();
			 }
		 
		 let currentId = $(this).attr("id");
		 let currentVal = $(this).val();
		 let currentElemRequired = $(this).attr("required");
		 let currentElementMinLength = $(this).attr("minlength");
		 let currentElementMaxLength = $(this).attr("maxlength");
		console.log(currentElementType + " " + currentId + " " + currentVal + " " + currentElemRequired);
		if(currentTagName == "input") {
		if(currentElemRequired!=undefined && currentElemRequired!=null && currentElemRequired.trim()!=""){
		if(currentVal.trim()==""){
		    isError=false;
		 $("#"+currentId).css("border-color","red"); 
		}else if(currentElementType=="password"){
		if(currentVal.length<8){
			isError=false;
			 $("#"+currentId).css("border-color","red");
		}
		if(!passReg.test(currentVal)){
			isError = false;
			 $("#"+currentId).css("border-color","red");
			}
		}else if(currentElementType=="email"){
		
			if(!emailReg.test(currentVal)){
				isError = false;
				 $("#"+currentId).css("border-color","red");
				}
			
		}else if(currentElementType=="radio"||currentElementType=="checkbox"){
			if($("input[type="+currentElementType+"]:checked").length==0){
					isError = false;
				}
		}else{
			if(currentVal.length<currentElementMinLength){
				isError = false;
				 $("#"+currentId).css("border-color","red");
		    	}
		    }
		}else if(currentElementType=="password"){
		if(currentVal.length<8){
			isError=false;
			 $("#"+currentId).css("border-color","red");
		}
		if(!passReg.test(currentVal)){
			isError = false;
			 $("#"+currentId).css("border-color","red");
			}
		}else if(currentElementType=="email"){
		
		if(!emailReg.test(currentVal)){
			isError = false;
			 $("#"+currentId).css("border-color","red");
		    	}
		    }
		}else{
			if(currentTagName=="textarea"){
		if(currentElemRequired!=undefined && currentElemRequired!=null && currentElemRequired.trim()!=""){
		if(currentVal===""){
		isError=false;
		 $("#"+currentId).css("border-color","red");
			
		}else if(currentVal.length>currentElementMaxLength){
			isError = false;
			 $("#"+currentId).css("border-color","red");
			}
			
		}else if(currentVal.length>currentElementMaxLength){
			isError = false;
			 $("#"+currentId).css("border-color","red");
			}
			
		}else{
			if(currentElemRequired=="required" && $("#"+currentId).find("option:selected").val()==""){
				         isError=false;
				        $("#"+currentId).css("border-color","red");
		          	}
		    	}    	
		    }
		    
		});
	if(!isError){
		$("span .response").html("");
		$("span .response").html("Please enter required values");
	}
	return isError;
  }
	



