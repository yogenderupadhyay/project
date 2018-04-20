package com.project.backend;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.project.backend.DAO.ProductDAO;
import com.project.backend.domain.Product;

public class ProductTestCase {
private static AnnotationConfigApplicationContext context;
	@Autowired
	private static ProductDAO productDAO;
	@Autowired
	private static Product product;
	@BeforeClass
	public static void init()
	{

		context = new AnnotationConfigApplicationContext();
		context.scan("com.project");
		context.refresh();
		productDAO = (ProductDAO)context.getBean("productDAO");
		product = (Product)context.getBean("product");
	}
	/*@Test
	public void saveProductTestCase()
	{
		product = new Product();
		product.setId("Lenevo-002");
		product.setName("Lenevo -- prodcut");
		product.setDescription("This is Lenevo product");
		product.setCategoryId("MolbileCategory001");
	  boolean status = 	productDAO.save(product);
	  assertEquals("save product test case", true, status);
	}*/
	/*@Test
	public void updateProductTestCase()
	{
		product.setId("Lenevo-002");
		product.setName("Lenevo -- prodcut");
		product.setDescription("This is not Lenevo product");
		boolean status = productDAO.update(product);
		assertEquals("update test case", true,status );
	}*/
	@Test
	public void getProductSuccessTestCase()
	{
	product= productDAO.get("C_000-mobile");
	assertNotNull("get product test case", product.getName());
	}
	/*@Test
	public void getProductFailureTestCase()
	}
	product= productDAO.get("Lenevo-001");
	assertNull("get product test case", product);
	}*/
	/*@Test
	public void deleteProductSuccessTestCase()
	{
	boolean status =	productDAO.delete("Lenevo-002");
	assertEquals("delete product succss test case" , true, status);
	}*/
	/*@Test
	public void deleteProductFailureTestCase()
	{
	boolean status =	productDAO.delete("Lenevo-001");
	assertEquals("delete product failure test case" , false, status);
	}*/
	/*@Test
	public void getAllProductsTestCase()
	{
	List<Product>	products = productDAO.list();
	assertEquals("get all products " , 3, products.size() );
	}*/

}
