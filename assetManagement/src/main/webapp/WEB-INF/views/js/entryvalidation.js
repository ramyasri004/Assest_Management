     
        
        function validateentryform(){
        
        	                let isError = true;
        	                
        	                $("#assettype").removeAttr("style");
        	                $("#makeandmodel").removeAttr("style");
         	                $("#serialno").removeAttr("style");
         	                $("#invoiceno").removeAttr("style");
         	                $("#hardwareassetid").removeAttr("style");
         	                $("#invoicedate").removeAttr("style");
         	                $("#currentstatus").removeAttr("style");
         	                $("#assetloc").removeAttr("style");
     
        	                
        	                
        	               var assetType =$("#assettype").val();
        	               var model =    $("#makeandmodel").val();
        	               var serialnumber =$("#serialno").val();
        	               var invoicenumber =$("#invoiceno").val();
        	               var hardwareAssetId =$("#hardwareassetid").val();
        	               var invoicedate =$("#invoicedate").val();
        	               var currentStatus =$("#currentstatus").val();
        	               var assetlocation =$("#assetloc").val();
        	    
        	               if(!assetType){
        	                   isError=false;
        	                     $("#assettype").css("border-color","red");
        	                     $(this).next("span").remove();
        	     				 $(this).after('<span class="errors">*'+name+' Required.</span>');
        	                    return false;
        	               }
        	               if(!model){
        	                   isError=false;
        	                   $("#makeandmodel").css("border-color","red");
        	                   return false;
        	               }
        	               if(!serialnumber){
        	                   isError=false;
        	                     $("#serialno").css("border-color","red");
        	                     return false;
        	               }
        	               if(!invoicenumber){
        	                   isError=false;
        	                     $("#invoiceno").css("border-color","red");
        	                     return false;
        	               }
        	               if(!invoicedate){
        	                   isError=false;
        	                     $("#invoicedate").css("border-color","red");
        	                     return false;
        	               }
        	               if(!hardwareAssetId){
        	                   isError=false;
        	                     $("#hardwareassetid").css("border-color","red");
        	                     return false;
        	               }
        	            
        	               if(!currentStatus){
        	                   isError=false;
        	                     $("#currentstatus").css("border-color","red");
        	                     return false;
        	               }
        	               if(!assetlocation){
        	                   isError=false;
        	                     $("#assetloc").css("border-color","red");
        	                     return false;
        	               }
        	               
        	        
        	    if(!isError){
        	        $("span.response").html("");
        	        $("span.response").html("Please enter required values");
        	    }
        	    alert("isError  "+isError);
        	    return isError;
        	}
        