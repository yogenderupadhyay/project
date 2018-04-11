package com.project.frontend.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.backend.DAO.CartDAO;
import com.project.backend.DAO.ProductDAO;
import com.project.backend.domain.Cart;
import com.project.backend.domain.Product;

@Controller
public class CartController {
	Logger log = LoggerFactory.getLogger(CartController.class);
	@Autowired
	private CartDAO cartDAO;
	@Autowired  
	private Cart cart;
	@Autowired
	private ProductDAO productDAO;
	@Autowired 
	private Product product;
	@Autowired 
	private HttpSession httpSession;
	
	@GetMapping("/Buy")
	public ModelAndView order()
	{
		ModelAndView mv = new ModelAndView("home");
		String loggedInUserID =(String) httpSession.getAttribute("loggedInUserID");
		if (cartDAO.update(loggedInUserID))
		{
			mv.addObject("successMessage", "Your order placed successfully...");
		}
		else
		{
			mv.addObject("errorMessage", "Your order could placed.   please try after some time.");
		}
		
		return mv;
	}
	@GetMapping("/cart/add/{productID}")
	public ModelAndView addToCart(
			@PathVariable String productID	)
	{
		ModelAndView mv = new ModelAndView("index");
		String loggedInUserID = (String) httpSession.getAttribute("loggedInUserID");
		System.out.println("Session : "+loggedInUserID);
		if(loggedInUserID=="null" || loggedInUserID==null)
		{
			mv.addObject("errorMessage", "Please login to add any product to cart");
			return mv;
		}
		product = productDAO.get(productID);		
		cart.setEmailID(loggedInUserID);

		cart.setPrice(product.getPrice());
		cart.setProductID(productID);
		cart.setProductName(product.getName());
		cart.setQuantity(1);
		cart.setId();
		if(cartDAO.save(cart))
		{
			mv.addObject("successMessage", "The product add to cart successfully");
		}
		else
		{
			mv.addObject("errorMessage", "Could not add the product to cart..please try after some time");
		}
		return mv;
	}
	@RequestMapping("/mycart")
	public ModelAndView  getMyCartDetails()
	{
		log.debug("Starting of the method getMyCartDetails");
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("isUserClickedMyCart", true);
		String loggedInUserID = (String)httpSession.getAttribute("loggedInUserID");
		log.info("Logged in user id : " + loggedInUserID);
		if(loggedInUserID==null)
		{
		  mv.addObject("errorMessage", "Please login to see your cart details");
		  return mv;
		}
		 List<Cart> cartList = cartDAO.list(loggedInUserID);
		 mv.addObject("cartList", cartList);
		 log.debug("not of products in cart " + cartList.size());
		 log.debug("Ending of the method getMyCartDetails");
		 return mv;
	}
}
