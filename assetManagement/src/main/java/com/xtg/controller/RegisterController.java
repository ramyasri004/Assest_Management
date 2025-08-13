package com.xtg.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.xtg.manager.RegisterManager;
import com.xtg.model.Login;
import com.xtg.model.UserInfo;
import com.xtg.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class RegisterController {
	@Autowired
	private  RegisterManager registerManager;
	@Autowired
	private UserService userService;
	
	@Autowired
	private HttpSession session;
	
	
	 
	 //when the user hits the url that maps  with "/login , the showLoginGet() method will execute
	 //This method will render the Login.jsp page  as we stored view name as "Login"
	 //InternalResourceViewResolver(assetMangment-servlet.xml) will  look Login.jsp inside /WEB-INF/views folder
	 //if it finds the page it will load otherwise render error page.
	  @RequestMapping(value = "/login", method = RequestMethod.GET)
	  public ModelAndView loginHomePage(HttpServletRequest request, HttpServletResponse response) {
		    ModelAndView mav = new ModelAndView("Login"); //Model    javabean   view jsp
		    mav.addObject("Login", new Login());
		    return mav;
	  }

		//When the user gives his details. All of his details are stored in a model Attribute called User.
	  //this will invoke the createUser method in the RegisterManager class.
	 @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
	  public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
	      @ModelAttribute("User") UserInfo user,Model model) throws SQLException {
		 System.out.println("addUser called");
		 System.out.println(user.toString());
		 String view = registerManager.createUser(user,model,request);
		 
	    return new ModelAndView(view, "firstname", user.getUsername());
	  }
	 
	 
	 //when the user hits the url that maps  with "/ , the showLoginGet() method will execute
	 //This method will render the Login.jsp page  as we stored view name as "Login"
	 //InternalResourceViewResolver(assetMangment-servlet.xml) will  look Login.jsp inside /WEB-INF/views folder
	 //if it finds the page it will load otherwise render error page.
	 @RequestMapping(value = "/", method = RequestMethod.GET)
	  public ModelAndView showLoginGet(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView("Login"); //Model    javabean   view jsp
	    mav.addObject("Login", new Login());

	    return mav;
	  }
	 //This is used to invalidate the holding session, so that the user can logout.
	 @RequestMapping(value="/logout",method=RequestMethod.GET)
	  public ModelAndView showLogoutGet(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav= new ModelAndView("Logout");
	 return mav;
}
	 
	 	//When the user enters the login credentials and submit the Login Button,the application captures the username and password 
	    //Invokes the  verifyUser () method by passing argument as username, password, model
	    @RequestMapping(value = "/entryprocess", method = RequestMethod.POST)
	    public String processLogin(@RequestParam("username") String username, @RequestParam("password") String password,
	            Model model, HttpServletRequest request) {
	        String viewReturned = null;
	        HttpSession session;
	        try {
	            viewReturned = registerManager.verifyUser(username, password, model);
	             if (!("/Login").equals(viewReturned)) {
	                System.out.println("::::creating session object::::");
	                session = request.getSession(true);
	                session.setAttribute("sessionId", session.getId());
	                session.setMaxInactiveInterval(2000);
	                session.setAttribute("username", username);
					session.removeAttribute("errorMsg");

	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }



	       return viewReturned;
	    }
	    /*This is used to render the Register page to display to the user.*/
	    @RequestMapping(value="/register", method= RequestMethod.GET)
	    public ModelAndView showRegGet(HttpServletRequest request, HttpServletResponse response){
	    	
	    	ModelAndView mav = new ModelAndView("Register"); //Model    javabean   view jsp
	   	    mav.addObject("User", new UserInfo());

	   	    return mav;
	    	}
	    }
	
	
