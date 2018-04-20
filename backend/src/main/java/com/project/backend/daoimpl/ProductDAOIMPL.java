package com.project.backend.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.backend.DAO.ProductDAO;
import com.project.backend.domain.Category;
import com.project.backend.domain.Product;

@Transactional
@Repository("productDAO")
public class ProductDAOIMPL implements ProductDAO {
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private Product product;

	public boolean save(Product product) {

		try {
			List<Product> products = sessionFactory.getCurrentSession().createQuery("from Product").list();
			int count = products.size();
			String str="P_00"+ count +"-"+ product.getId();
			product.setId(str);
			sessionFactory.getCurrentSession().save(product);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public Product get(String id) {
		return sessionFactory.getCurrentSession().get(Product.class, id);
		
	}

	public boolean delete(String id) {
		try {
			product = get(id);
			if (product == null) {
				System.out.println("1");
				return false;
			}

			sessionFactory.getCurrentSession().delete(product);
			System.out.println("delete");
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Product> list() {
		return sessionFactory.getCurrentSession().createQuery("from Product").list();
	}

	public List<Product> search(String searchString) {

		String hql = "from Product where DESCRIPTION like '%" + searchString + "%'" +"or name like '%"+searchString+"%'";
		return sessionFactory.getCurrentSession().createQuery(hql).list();
	}

	public List<Product> search(String searchString, int maxPrice) {

		String hql = "from Product where description like '%" + searchString + "%'  and price < " + maxPrice;
		return sessionFactory.getCurrentSession().createQuery(hql).list();

	}

	public List<Product> search(String searchString, int minPrice, int maxPrice) {
		return null;
	}

}
