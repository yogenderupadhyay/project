package com.project.backend;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.project.backend.DAO.SupplierDAO;
import com.project.backend.domain.Supplier;

public class SupplierTestCase {
private static AnnotationConfigApplicationContext context;
	@Autowired
	private static SupplierDAO supplierDAO;
	@Autowired
	private static Supplier supplier;
	@BeforeClass
	public static void init()

	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.project"); 
		context.refresh();
		supplierDAO = (SupplierDAO)context.getBean("supplierDAO");
		supplier = (Supplier)context.getBean("supplier");
	}
	/*@Test
	public void saveSupplierTestCase()
	{
		supplier = new Supplier();
		supplier.setId("SUP-002");
		supplier.setName("suvidha store");
		supplier.setAddress("kigsway cmp, delhi");
	  boolean status = 	supplierDAO.save(supplier);
	  assertEquals("save supplier test case", true, status);
	}*/
/*	@Test
	public void updateSupplierTestCase()

	{
		supplier.setId("SUP-002");
		supplier.setName("maruti");
		supplier.setAddress("new delhi");
		boolean status = supplierDAO.update(supplier);
		assertEquals("update test case", true,status );
	}*/
	@Test
	public void getSupplierSuccessTestCase()
	{
	supplier= supplierDAO.get("SUP-001");
	assertNotNull("get supplier test case", supplier);
	}
	@Test
	public void getSupplierFailureTestCase()
	{
	supplier= supplierDAO.get("SUP-004");
	assertNull("get supplier test case", supplier);
	}
	/*@Test
	public void deleteSupplierSuccessTestCase()
	{
	boolean status =	supplierDAO.delete("SUP-002");
	assertEquals("delete supplier succss test case" , true, status);
	}*/
	@Test
	public void deleteSupplierFailureTestCase()
	{
	boolean status =	supplierDAO.delete("SUP-004");
	assertEquals("delete supplier failure test case" , false, status);
	}
	@Test
	public void getAllSuppliersTestCase()
	{
	List<Supplier>	suppliers = supplierDAO.list();
	assertEquals("get all usres " , 2, suppliers.size() );
	}
}
