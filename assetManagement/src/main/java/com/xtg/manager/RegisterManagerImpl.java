package com.xtg.manager;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.client.RestTemplate;

import com.xtg.helper.CryptoUtil;
import com.xtg.model.UserInfo;
import com.xtg.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class RegisterManagerImpl implements RegisterManager {
	
	@Autowired
	private CryptoUtil cryptoUtil;	
	@Autowired
	private UserService userService;
	
	private String secretkey = "kjl^*&hkjh2323";
	

	

	public String createUser(UserInfo user, Model model,HttpServletRequest request) {
		Long valid = null;
		String registerOutMsg = null;
		//Here we will verify and validate the fact that the user has goven all his details
		String validateRegisterResponse = validateRegister(user);

		try {
			//If the user has given all the details then the compiler will execute the following block of code
			if (validateRegisterResponse == null) {
				// Here we are encrypting the password that the user has entered before sending it to the database.
				String encriptedpass = cryptoUtil.encrypt(secretkey, user.getPassword());
				user.setPassword(encriptedpass);
			//Here we invoke the register message in Userservice class.
				Map<String, Object> registerPrceResponse = userService.register(user);
				//valid = Long.parseLong((registerPrceResponse.get("POV_EXIST").toString()));
				registerOutMsg = registerPrceResponse.get("POV_RESPONSE").toString();
				model.addAttribute("registerResponse", registerOutMsg);
			} else {
				model.addAttribute("registerResponse", validateRegisterResponse);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
//Here if the user has entered accurate details then we redirect them to Login page.
//If the user has entered wrong details then the user will be shown the register page with an error message.
		if (valid == null) {
			return "Register";
		} else if (valid == 0) {
			return "Login";
		} else {
			return "Register";
		}

	}

	// This method verifies the existence of nulls in inputs that is submitted
	// and returns message else return null;

	// This method verifies the existence of nulls in inputs that is submitted
	// and returns message else return null;
	public String validateRegister(UserInfo user) {
		try {
			if (user.getFullname() == null || ("").equals(user.getFullname().trim())) {
				return "FullName required";
			} else if (user.getUsername() == null || ("").equals(user.getUsername().trim())) {
				return "UserName required";
			} else if (user.getEmail().trim() == null || ("").equals(user.getEmail().trim())) {
				return "Email required";
			} else if (user.getPassword() == null || ("").equals(user.getPassword().trim())) {
				return "Password required";
			} else if (user.getGender() == null || ("").equals(user.getGender().trim())) {
				return "Gender required";
			} else
				return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Exception occured";
	}
	 public String verifyUser(String username, String password, Model model) {
	        String userActive = null;
	        String loginMsg = null;
	        try {
	        	
	        	//we are validation whether username and password is empty or not
	            String validateLoginResponse = validateLogin(username, password);
  
	            //If there no vaidations , we are encrypt the password using secertkey
	            //We are validating the user-enterd (username and encrypted password ) details against DB 
	            //If the validation is sucessful and user is active ,then we are naviagating to Entry Form otherwise naviages to same page.
	           if (validateLoginResponse == null) {
	                String encriptedpass = cryptoUtil.encrypt(secretkey, password);

                   //Storing UserName and encrypted password details in the Map
	               Map<String, Object> loginInputs = new HashMap<String, Object>();
	                loginInputs.put("PIV_USER_NAME", username);
	                loginInputs.put("PIV_PASSWORD", encriptedpass);

	               //Invoke UserService.loginService method
	                Map<String, Object> loginPrcResponse = userService.loginService(loginInputs);
	                ///Get UserActive Flag from the Database
	                //userActive = loginPrcResponse.get("POV_IS_ACTIVE").toString();
	                loginMsg = loginPrcResponse.get("pov_user_response").toString();
	                //Stores the LoginResponse in the model
	                model.addAttribute("loginResponse", loginMsg);
	            } else {
	                model.addAttribute("loginResponse", validateLoginResponse);
	            }

	        //we are validating the whether valid user is Active or not
	        /*if (userActive != null && ("Y").equals(userActive)) {
	            return "Entryform";
	        } else {
	            return "Login";
	        }*/
	           
	        if("login Success".equals(loginMsg)){
	        	return "Entryform";
	        } else {
	        	return "Login";
	        }
	        
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        
	        return null;
	    }
	// This method verifies the existence of nulls in inputs that is submitted
		// and returns message else return null;

		// This method verifies the existence of nulls in inputs that is submitted
		// and returns message else return null;
	    public String validateLogin(String username, String password) {
	        try {
	            if (Objects.isNull(username) || ("").equals(username.trim())) {
	                return "Enter username";
	            } else if (Objects.isNull(password) || ("").equals(password.trim())) {
	                return "Enter password";
	            } else {
	                return null;
	            }
	        } catch (Exception e) {
	e.printStackTrace();        }
	        return "Exception occured";
	    }
}
