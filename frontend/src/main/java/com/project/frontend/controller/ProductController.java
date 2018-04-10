package com.project.frontend.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.backend.DAO.CategoryDAO;
import com.project.backend.DAO.ProductDAO;
import com.project.backend.DAO.SupplierDAO;
import com.project.backend.domain.Product;
import com.project.frontend.util.FileUtil;

@Controller
public class ProductController {
	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private SupplierDAO supplierDAO;

	@Autowired
	private Product product;

	@Autowired
	HttpSession httpSession;

	@Autowired
	FileUtil fileUtil;
	
	Logger log = LoggerFactory.getLogger(ProductController.class);

	@GetMapping("/product/get/{id}")

	public ModelAndView getSelectedProduct(@PathVariable("id") String id, RedirectAttributes redirectAttributes) {
		ModelAndView mv = new ModelAndView("redirect:/");
		redirectAttributes.addFlashAttribute("selectedProduct", productDAO.get(id));
		redirectAttributes.addFlashAttribute("isUserSelectedProduct", true);
		return mv;
	}

	@RequestMapping("/product/save/")
	public ModelAndView saveProduct(@RequestParam("id") String id, @RequestParam("name") String name,
			@RequestParam("description") String description, @RequestParam("price") String price,
			@RequestParam("categoryID") String categoryID, @RequestParam("supplierID") String supplierID,
			@RequestParam("file") MultipartFile file) {
		ModelAndView mv = new ModelAndView("redirect:/manageproducts");
		product.setId(id);
		product.setName(name);
		product.setDescription(description);
		price = price.replace(",", "");
		product.setPrice(Integer.parseInt(price));
		product.setCategoryId(categoryID);
		product.setSupplierId(supplierID);
		if (productDAO.save(product)) {
			mv.addObject("productSuccessMessage", "The product created successfully");
			if (FileUtil.copyFileNIO(file, id + ".PNG")) {
				mv.addObject("uploadMessage", "product image successfully updated");
			} else {
				mv.addObject("uploadMessage", "Coulod not upload image");
			}
		} else {
			mv.addObject("productErrorMessage", "Coulc not able to create product.  please contact admin");
		}
		return mv;
	}

	@PutMapping("/product/update/")
	public ModelAndView updateProduct(@ModelAttribute Product product) {
		ModelAndView mv = new ModelAndView("home");
		if (productDAO.update(product) == true) {
			mv.addObject("successMessage", "The product updated successfully");
		} else {
			mv.addObject("errorMessage", "Could not update the product.");
		}
		return mv;
	}

	@GetMapping("/product/delete")
	public ModelAndView deleteProduct(@RequestParam String id) {
		System.out.println("going to delete product : " + id);
		ModelAndView mv = new ModelAndView("redirect:/manageproducts");
		if (productDAO.delete(id) == true) {
			mv.addObject("successMessage", "The product deleted successfully");
		} else {
			mv.addObject("errorMessage", "Could not delete the product.");
		}
		return mv;
	}

	@GetMapping("/product/edit")
	public ModelAndView editProduct(@RequestParam String id) {
		ModelAndView mv = new ModelAndView("redirect:/manageproducts");
		product = productDAO.get(id);
		httpSession.setAttribute("selectedProduct", product);
		return mv;
	}

	@GetMapping("/products")
	public ModelAndView getAllCategories() {
		ModelAndView mv = new ModelAndView("home");
		List<Product> categories = productDAO.list();
		mv.addObject("products", categories);
		return mv;
	}
	@GetMapping("search")
	public ModelAndView searchProduct(@RequestParam("searchString") String searchString)
	{
		ModelAndView mv = new ModelAndView("index");
		List<Product> products =  productDAO.search(searchString);
		mv.addObject("products", products);
		mv.addObject("isUserSelectedProduct", true);
		log.info("Number of products with search string " +searchString +  " is/are : " + products.size());
		return mv;
	}
}
