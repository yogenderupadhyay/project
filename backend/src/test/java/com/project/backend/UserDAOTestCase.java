package com.project.backend;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.project.backend.DAO.UserDAO;
import com.project.backend.domain.User;

public class UserDAOTestCase {
	private static AnnotationConfigApplicationContext context;
	@Autowired
	private static UserDAO userDAO;
	@Autowired
	private static User user;
	@BeforeClass
	public static void init() {
		context= new AnnotationConfigApplicationContext();
		context.scan("com.project.backend.*");
		context.refresh();
		userDAO=(UserDAO)context.getBean("userDAO");
		user= (User)context.getBean("user");
		System.out.println("1");
	}
	@Test
	public void saveUserTestCase()
	{
		System.out.println("2");
		user.setEmailID("amit@gmail.com");
		user.setMobile("95847621");
		user.setName("amit upadhyay");
		user.setPassword("amit");
		
	  boolean status = 	userDAO.save(user);
	  
	  assertEquals("save user test case", true, status);
	}
	@Test
	public void updateUserTestCase()
	{
		user.setEmailID("yogender@gmail.com");
		user.setMobile("888888888");
		boolean status = userDAO.update(user);
		assertEquals("update test case", true,status );
	}
	
	@Test
	public void getUserSuccessTestCase()
	{
		
	user= userDAO.get("yogender@gmail.com");
	
	assertNotNull("get user test case", user);
	}
	
	@Test
	public void getUserFailureTestCase()
	{
		
	user= userDAO.get("yatin@gmail.com");
	
	assertNull("get user test case", user);
	}
	
	@Test
	public void deleteUserSuccessTestCase()
	{
	boolean status =	userDAO.delete("yogender");
	assertEquals("delete user succss test case" , true, status);
	
	}
	
	@Test
	public void deleteUserFailureTestCase()
	{
	boolean status =	userDAO.delete("abc@gmail.com");
	assertEquals("delete user failure test case" , false, status);
	
	}
	
	
	@Test
	public void getAllUsersTestCase()
	{
	List<User>	users = userDAO.list();
	
	assertEquals("get all usres " , 3, users.size() );
	
	}
	@Test
	public void validateCredentailsTestCase()
	{
	user = 	userDAO.validate("yogender@gmail.com", "yogender");
	assertNotNull("Validate test case",user );
	}
}
