package com.project.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.backend.DAO.UserDAO;

@Controller
public class UserController {
	@Autowired
	private UserDAO userDAO;

	@RequestMapping("/validate")
	public ModelAndView validate(@RequestParam("uname") String username, @RequestParam("psw") String password)
	
	{
		System.out.println(username);
		ModelAndView mv = new ModelAndView("index");
		if(userDAO.validate(username,password)==null)
		{
			System.out.println("2");
			mv.addObject("errorMessage", "Invalid credentials..please try again.");
			
		}
		else
		{
			System.out.println("1");
			mv.addObject("welcomeMessage" , "Welcome Mr. "+username);
		}
		return mv;
		
	}
}
