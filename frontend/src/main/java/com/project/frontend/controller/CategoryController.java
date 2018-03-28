package com.project.frontend.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.backend.DAO.CategoryDAO;
import com.project.backend.domain.Category;

@Controller
public class CategoryController {

	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private Category category;
	@Autowired 
	HttpSession httpSession;
	@RequestMapping(name = "/category/get/{id}", method = RequestMethod.GET)
	public ModelAndView getCategory(@RequestParam("id") String id) {
		category = categoryDAO.get(id);
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("category", category);
		return mv;
	}
	@RequestMapping("/category/save/")
	public ModelAndView saveCategory(@RequestParam("id") String id, @RequestParam("name") String name, @RequestParam("description") String description) 
	{
		ModelAndView mv = new ModelAndView("redirect:/managecategories");
		category.setId(id);
		category.setName(name);
		category.setDescription(description);
		if(categoryDAO.save(category))
		{
			mv.addObject("categorySuccessMessage", "The category created successfully");
    	}
		else
		{
			mv.addObject("categoryErrorMessage", "Coulc not able to create category.  please contact admin");
		}
		return mv;
	}
	@PutMapping("/category/update/")
	public ModelAndView updateCategory(@ModelAttribute Category category) {
		ModelAndView mv = new ModelAndView("index");
		if (categoryDAO.update(category) == true) {
			mv.addObject("successMessage", "The category updated successfully");
		} 
		else {
			mv.addObject("errorMessage", "Could not update the category.");
		}
		return mv;
	}
	@RequestMapping("/category/delete")
	public ModelAndView deleteCategory(@RequestParam String id) {
		System.out.println("going to delete category : " + id);
		ModelAndView mv = new ModelAndView("redirect:/managecategories");
		if (categoryDAO.delete(id) == true) {
			mv.addObject("SuppliersuccessMessage", "The category deleted successfully");
		} else {
			mv.addObject("SuppliererrorMessage", "Could not delete the category.");
		}
		return mv;
	}
	@GetMapping("/categories")
	public ModelAndView getAllCategories() {
		ModelAndView mv = new ModelAndView("index");
		List<Category> categories = categoryDAO.list();
		mv.addObject("categories", categories);
		return mv;
	}
	@RequestMapping("/category/edit")
	public ModelAndView editCategory(@RequestParam String id)
	{
		ModelAndView mv = new ModelAndView("redirect:/managecategories");
		category = categoryDAO.get(id);
		httpSession.setAttribute("selectedCategory", category);
		return mv;

		

	}



}
