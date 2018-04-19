package com.project.backend.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.backend.DAO.CategoryDAO;
import com.project.backend.domain.Category;

@Transactional
@Repository("categoryDAO")
public class CategoryDAOIMPL implements CategoryDAO {
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private Category category;
	@Autowired
	private Category categoryDAO;
	
	
	public boolean save(Category category) {
		try {
			List<Category> categories = sessionFactory.getCurrentSession().createQuery("from Category").list();
			int count = categories.size();
			String str="C_00"+ count +"-"+ category.getId();
			category.setId(str);
			sessionFactory.getCurrentSession().saveOrUpdate(category);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean update(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}
	public Category get(String id) {
		return sessionFactory.getCurrentSession().get(Category.class, id);
	}
	public boolean delete(String id) {
		try {
			category = get(id);
			
			if (category == null) {
				System.out.println("delete f");
				return false;
			}
			System.out.println("delete");
			sessionFactory.getCurrentSession().delete(category);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			System.out.println("delete f");
			return false;
		}
	}
	public List<Category> list() {
		return sessionFactory.getCurrentSession().createQuery("from Category").list();
				/*.createCriteria(Category.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();*/
	}
}
