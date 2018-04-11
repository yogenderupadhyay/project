package com.project.frontend.controller;

import java.util.List;

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

	@GetMapping("/validate")
	public ModelAndView validate(@RequestParam("uname") String username, @RequestParam("psw") String password)

	{
		System.out.println(username);
		ModelAndView mv = new ModelAndView("index");
		user = userDAO.validate(username, password);
		if (user == null) {
			mv.addObject("errorMessage", "Invalid credentials..please try again.");

		} else {
			 
			httpSession.setAttribute("welcomeMessage", user.getName());
			httpSession.setAttribute("loggedInUserID", user.getEmailID());
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
}
