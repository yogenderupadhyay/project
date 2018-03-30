package com.project.frontend.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.backend.DAO.UserDAO;
import com.project.backend.daoimpl.UserDAOIMPL;
import com.project.backend.domain.User;

@Controller
public class UserController {
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private User user;
	@Autowired
	HttpSession httpSession;

	@RequestMapping("/validate")
	public ModelAndView validate(@RequestParam("uname") String username, @RequestParam("psw") String password)
	
	{
		System.out.println(username);
		ModelAndView mv = new ModelAndView("index");
		user=userDAO.validate(username, password);
		if (user==null)
		{
			mv.addObject("errorMessage", "Invalid credentials..please try again.");
			
		}
		else
		{
			/*if(user.getRole()=='A')

			{
				mv.addObject("isAdmin", true);
			}*/
			httpSession.setAttribute("welcomeMessage" , user.getName());
			httpSession.setAttribute("loggedInUserID", user.getEmailID());
			if(user.getRole()=='A')

			{
				httpSession.setAttribute("isAdmin", true);
			}
		}
		return mv;
		
	}
	@RequestMapping("/logout")
	public ModelAndView  logout()
	{
		
		ModelAndView mv = new ModelAndView("index");
		/*mv.addObject("isUserClickedLogin", true);*/
		mv.addObject("welcomeMessage" , null);
		httpSession.invalidate();
		mv.addObject("logoutMessage", "Successfully logout");
		return mv;
		
	}
}
