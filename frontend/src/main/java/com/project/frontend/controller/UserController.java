package com.project.frontend.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.backend.DAO.CartDAO;
import com.project.backend.DAO.UserDAO;
import com.project.backend.domain.Cart;
import com.project.backend.domain.User;

@Controller
public class UserController {
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private User user;
	@Autowired
	private Cart cart;
	@Autowired
	private CartDAO cartDAO;
	@Autowired
	HttpSession httpSession;
	@Autowired
	HttpServletResponse httpServletResponse;
	@Autowired
	HttpServletRequest httpServletRequest;

	@GetMapping("/validate")
	public ModelAndView validate(@RequestParam("uname") String username, @RequestParam("psw") String password, @RequestParam ("remember") String rem)

	{
		/*boolean remb= false;
		 try{
		 	Cookie[] allcookies=httpServletRequest.getCookies();
		 	for(int i = 0; i<allcookies.length;i++)
		 	{
		 		if(allcookies[i].getName().equals("usename")){
		 			remb=true;
		 		}
		 	}
		 }catch(NullPointerException ne){}*/
		 
		ModelAndView mv = new ModelAndView("index");
		user = userDAO.validate(username, password);
		if (user == null) {
			mv.addObject("errorMessage", "Invalid credentials..please try again.");

		} else {
			if(rem=="on"){
				Cookie ck =new Cookie(username, password);
				httpServletResponse.addCookie(ck);
			}
			 
			 
			 
			httpSession.setAttribute("welcomeMessage", user.getName());
			httpSession.setAttribute("loggedInUserID", user.getEmailID());
			System.out.println("Session 2: "+user.getEmailID());
			httpSession.setAttribute("isLoggedIn", true);
			List<Cart> carts = cartDAO.list(user.getEmailID());
			httpSession.setAttribute("size", carts.size());
			httpSession.setAttribute("carts", carts);
			if (user.getRole() == 'A')

			{
				httpSession.setAttribute("isAdmin", true);
			}
		}
		return mv;

	}

	@RequestMapping("/logout")
	public ModelAndView logout() {

		ModelAndView mv = new ModelAndView("index");
		/* mv.addObject("isUserClickedLogin", true); */
		mv.addObject("welcomeMessage", null);
		httpSession.invalidate();
		mv.addObject("logoutMessage", "Successfully logout");
		return mv;

	}
	@RequestMapping("/register")
	public ModelAndView register(@RequestParam("fName") String fName, 
			@RequestParam("LName") String LName, 
			@RequestParam("uname") String username, 
			@RequestParam("psw") String password,
			@RequestParam("gender") String gender,
			@RequestParam("mobile") String mobile,
			@RequestParam("dob") String dOB) {

		ModelAndView mv = new ModelAndView("redirect:/register");
		user.setName(fName);
		user.setLastName(LName);
		user.setEmailID(username);
		user.setPassword(password);
		user.setdOB(dOB);
		user.setMobile(mobile);
		user.setGender(gender);
		System.out.println("qwerty");
		if(userDAO.save(user)) {
			
			mv.addObject("registrationSuccessMessage", "The category created successfully");
    	}
		else
		{
			mv.addObject("registrationErrorMessage", "Coulc not able to create category.  please contact admin");
		}
		return mv;
	}
	@RequestMapping("/userHome")
	public ModelAndView loginUserHome()
	{
	 ModelAndView mv=new ModelAndView("index");
	 System.out.println(user.getRole());
	 if (user.getRole() == 'A')

		{
			httpSession.setAttribute("isAdmin", true);
			httpSession.setAttribute("isUserSelectedProduct",  false);
		}
	 return mv;
	}
}
