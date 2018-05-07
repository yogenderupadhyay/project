package com.project.niit.controller;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.backend.DAO.CategoryDAO;
import com.project.backend.DAO.ProductDAO;
import com.project.backend.domain.Category;
import com.project.backend.domain.Product;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

@Controller
public class IndexController {
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private HttpSession httpSession;
	/*public static final String imageDirectory="F:\\images\\";*/
	public static final String imageDirectory="src\\main\\webapp\\Resources\\images\\uploads\\";

	@RequestMapping("/")
	public ModelAndView index(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("index");
		List<Category> categories = categoryDAO.list();
		httpSession.setAttribute("categories", categories);
		httpSession.setAttribute("imageDirectory", imageDirectory);

		String root =request.getContextPath();

	    String imageFolder =  root + File.separator +"src" + File.separator + 
	    		"main" +File.separator +
	    		"webapp"+File.separator +
	    		"resources"+File.separator +
	    		"images"+File.separator ;	

	    httpSession.setAttribute("imageFolder", imageFolder);
	    List<Product> products = productDAO.list();
		mv.addObject("products", products);
		mv.addObject("isUserClickedHome", true);
		return mv;
		
	}
	
	@RequestMapping("/login")
	public ModelAndView  login()
	{
		
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("isUserClickedLogin", true);
		return mv;
		
	}
	
	@RequestMapping("/home")
	public ModelAndView  home()
	{
		
		ModelAndView mv = new ModelAndView("index");
		List<Product> products = productDAO.list();
		mv.addObject("products", products);
		mv.addObject("isUserClickedHome", true);
		return mv;
		
	}
	
	@RequestMapping("/signUp")
	public ModelAndView  registration()
	{
		
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("isUserClickedRegister", true);
		return mv;
		
	}

}