package com.project.frontend.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.backend.DAO.CategoryDAO;
import com.project.backend.DAO.ProductDAO;
import com.project.backend.DAO.SupplierDAO;
import com.project.backend.domain.Category;
import com.project.backend.domain.Product;
import com.project.backend.domain.Supplier;

@Controller
public class AdminController {
	private static Logger log = LoggerFactory.getLogger(AdminController.class);
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private SupplierDAO supplierDAO;
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private Category category;
	@Autowired
	private Supplier supplier;
	@Autowired
	private Product product;
	@Autowired 
	HttpSession httpSession;
	@GetMapping("/managecategories")
	public ModelAndView admincClickedCategories() {
		ModelAndView mv = new ModelAndView("index");
		String loggedInUserID= (String)httpSession.getAttribute("loggedInUserID");

		if(loggedInUserID==null)
		{
			mv.addObject("errorMessage", "Please login to do this operation");
			return mv;
		}
		Boolean isAdmin =(Boolean)  httpSession.getAttribute("isAdmin");
	 if(isAdmin ==null  || isAdmin==false)
	 {
		 mv.addObject("errorMessage", "You are not autheroized to do this operations.");
		 return mv;
	 }
	 log.debug("starting of the method admincClickedCategories");
		mv.addObject("isAdminClickedManageCategories", true);
		List<Category> categories = categoryDAO.list();
		httpSession.setAttribute("categories", categories);
		log.debug("ending of the method admincClickedCategories");
		return mv;
	}
	@GetMapping("/managesuppliers")
	public ModelAndView admincClickedSupplier()
	{
		log.debug("starting of the method admincClickedSupplier");
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("isAdminClickedManageSuppliers", true);
		List<Supplier> suppliers =  supplierDAO.list();
		httpSession.setAttribute("suppliers", suppliers);
		log.debug("ending of the method admincClickedSupplier");
		return mv;
	}
	@GetMapping("/manageproducts")
	public ModelAndView admincClickedProducts()
	{
		log.debug("starting of the method admincClickedProducts");
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("isAdminClickedManageProducts", true);
		 List<Category> categories = categoryDAO.list();
		 List<Supplier> suppliers = supplierDAO.list();
		 List<Product> products = productDAO.list();
		 httpSession.setAttribute("categories", categories);
		 httpSession.setAttribute("suppliers", suppliers);
		 httpSession.setAttribute("products", products);
		 log.debug("ending of the method admincClickedProducts");
		return mv;
	}
}
