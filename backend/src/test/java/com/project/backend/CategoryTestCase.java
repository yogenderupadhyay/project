package com.project.backend;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.project.backend.DAO.CategoryDAO;
import com.project.backend.domain.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;
	@Autowired
	private static CategoryDAO categoryDAO;
	@Autowired
	private static Category category;
	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.project");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
		category = (Category) context.getBean("category");
	}
	@Test
	public void saveCategoryTestCase()
	{
		category = new Category();
		category.setId("MolbileCategory");
		category.setName("Mobile");
		category.setDescription("This is Mobile category");
		boolean status = categoryDAO.save(category);
		assertEquals("save category test case", true, status);
	}
	/*@Test
	public void updateCategoryTestCase()
	{
		category.setId("WoMenCategory");
		category.setName("Mobile");
		category.setDescription("This is new mobile category");
		boolean status = categoryDAO.update(category);
		assertEquals("update test case", true, status);
	}*/
	/*@Test
	public void getCategorySuccessTestCase()
	{
		category = categoryDAO.get("WoMenCategory001");
		assertNotNull("get category test case", category);
	}*/
	@Test
	public void getCategoryFailureTestCase()
	{
		category = categoryDAO.get("abc");
		assertNull("get category test case", category);
	}
	/*@Test
	public void deleteCategorySuccessTestCase()
	{
		boolean status = categoryDAO.delete("Category001");
		assertEquals("delete category succss test case", true, status);
	}*/
	@Test
	public void deleteCategoryFailureTestCase()
	{
		boolean status = categoryDAO.delete("deletefailure");
		assertEquals("delete category failure test case", false, status);
	}
	/*@Test
	public void getAllCategorysTestCase()
	{
		List<Category> categories = categoryDAO.list();
		assertEquals("get all usres ", 3, categories.size());
	}*/
}
