package com.project.backend;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.project.backend.DAO.CartDAO;
import com.project.backend.DAO.ProductDAO;
import com.project.backend.domain.Cart;

public class CartTestCase {
private static AnnotationConfigApplicationContext context;
	@Autowired
	private static CartDAO cartDAO;
	@Autowired
	private static Cart cart;
	@BeforeClass
	public static void init()
	{

		context = new AnnotationConfigApplicationContext();
		context.scan("com.project");
		context.refresh();
		cartDAO = (CartDAO)context.getBean("productDAO");
		cart = (Cart)context.getBean("cart");
	}
	/*@Test
	public void saveProductTestCase()
	{
		
		cart = new Cart();
		cart.setId();
		cart.setEmailID("aditi@sb.com");
		cart.setPrice(500);
		cart.setProductID("P_003-shirt");
		cart.setProductName("Shirt");
		cart.setQuantity(1);
	  boolean status = 	cartDAO.save(cart);
	  assertEquals("save cart test case", true, status);
	}
	@Test
	public void updateProductTestCase()
	{
		cart.setId("Lenevo-002");
		cart.setName("Lenevo -- prodcut");
		cart.setDescription("This is not Lenevo cart");
		boolean status = productDAO.update(cart);
		assertEquals("update test case", true,status );
	}
	@Test
	public void getProductSuccessTestCase()
	{
	cart= productDAO.get("Lenevo-001");
	assertNotNull("get cart test case", cart.getName());
	}*/
	/*@Test
	public void getProductFailureTestCase()
	}
	cart= productDAO.get("Lenevo-001");
	assertNull("get cart test case", cart);
	}*/
	/*@Test
	public void deleteProductSuccessTestCase()
	{
	boolean status =	productDAO.delete("Lenevo-002");
	assertEquals("delete cart succss test case" , true, status);
	}*/
	/*@Test
	public void deleteProductFailureTestCase()
	{
	boolean status =	productDAO.delete("Lenevo-001");
	assertEquals("delete cart failure test case" , false, status);
	}*/
	/*@Test
	public void getAllProductsTestCase()
	{
	List<Cart>	products = cartDAO.list("aditi@sb.com");
	assertEquals("get all products " , 2, products.size() );
	}*/

}
