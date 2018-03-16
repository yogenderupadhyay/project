package com.project.backend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.project.backend.daoimpl.UserDAOIMPL;
import com.project.backend.domain.User;

public class UserDAOTestCase {
	private static AnnotationConfigApplicationContext context;
	@Autowired
	private static UserDAOIMPL userDAO;
	@Autowired
	private static User user;
	@BeforeClass
	public static void initialize() {
		context= new AnnotationConfigApplicationContext();
		context.scan("com.project.backend");
		context.refresh();
		userDAO=(UserDAOIMPL)context.getBean("UserDAOIMPL");
		user= (User)context.getBean("user");
		System.out.println("1");
	}
	@Test
	public void saveUserTestCase()
	{
		System.out.println("2");
		user.setEmailID("yogender@gmail.com");
		user.setMobile("95847621");
		user.setName("yogender upadhyay");
		user.setPassword("yogender");
		
	  boolean status = 	userDAO.save(user);
	  
	  assertEquals("save user test case", true, status);
	}
}
