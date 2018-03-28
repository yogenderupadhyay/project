package com.project.frontend.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

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
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private SupplierDAO supplierDAO;
	@Autowired
	private ProductDAO productDAO;
	@Autowired 
	HttpSession httpSession;
	@GetMapping("/managecategories")
	public ModelAndView admincClickedCategories() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("isAdminClickedManageCategories", true);
		List<Category> categories = categoryDAO.list();
		httpSession.setAttribute("categories", categories);
		return mv;
	}
	@GetMapping("/managesuppliers")
	public ModelAndView admincClickedSupplier()
	{
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("isAdminClickedManageSuppliers", true);
		List<Supplier> supplier = supplierDAO.list();
		httpSession.setAttribute("supplier", supplier);
		return mv;
	}
	@GetMapping("/manageproducts")
	public ModelAndView admincClickedProducts()
	{
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("isAdminClickedManageProducts", true);
		 List<Category> categories = categoryDAO.list();
		 List<Supplier> suppliers = supplierDAO.list();
		 List<Product> products = productDAO.list();
		 httpSession.setAttribute("categories", categories);
		 httpSession.setAttribute("suppliers", suppliers);
		 httpSession.setAttribute("products", products);
		return mv;
	}
}
