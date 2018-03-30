package com.project.frontend.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	@Autowired
	private HttpSession httpSession;
	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("index");
		return mv;
		
	}
	
	@RequestMapping("/login")
	public ModelAndView  login()
	{
		
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("isUserClickedLogin", true);
		return mv;
		
	}
	
	
	@RequestMapping("/register")
	public ModelAndView  registration()
	{
		
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("isUserClickedRegister", true);
		return mv;
		
	}

}