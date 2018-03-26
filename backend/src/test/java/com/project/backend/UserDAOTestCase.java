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
	}
	/*@Test
	public void saveUserTestCase()
	{
		System.out.println("2");
		user.setEmailID("yatin@gmail.com");
		user.setMobile("95847621");
		user.setName("yatin upadhyay");
		user.setPassword("yatin");
		
	  boolean status = 	userDAO.save(user);
	  
	  assertEquals("save user test case", true, status);
	}*/
	/*@Test
	public void updateUserTestCase()
	{
		user.setEmailID("niashant@gmail.com");
		user.setName("nishant sharma");
		boolean status = userDAO.update(user);
		assertEquals("update test case", true,status );
	}*/
	
	@Test
	public void getUserSuccessTestCase()
	{
		
	user= userDAO.get("yogender@gmail.com");
	
	assertNotNull("get user test case", user);
	}
	
	@Test
	public void getUserFailureTestCase()
	{
		
	user= userDAO.get("abc@gmail.com");
	
	assertNull("get user test case", user);
	}
	
	/*@Test
	public void deleteUserSuccessTestCase()
	{
	boolean status =	userDAO.delete("amit1@gmail.com");
	assertEquals("delete user succss test case" , true, status);
	
	}
	*/
	@Test
	public void deleteUserFailureTestCase()
	{
	boolean status =	userDAO.delete("abct@gmail.com");
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
