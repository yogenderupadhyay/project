package com.project.backend.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.backend.DAO.CartDAO;
import com.project.backend.domain.Cart;
import com.project.backend.domain.Category;

@Transactional
@Repository("cartDAO")
public class CartDAOIMPL implements CartDAO {
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private Cart cart;

	Logger log = LoggerFactory.getLogger(CartDAOIMPL.class);

	public boolean save(Cart cart) {
		try {
			sessionFactory.getCurrentSession().save(cart);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(Cart cart) {
		try {
			sessionFactory.getCurrentSession().update(cart);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public Cart get(int id) {
		return sessionFactory.getCurrentSession().get(Cart.class, id);
	}
	public boolean delete(int id) {
		try {
			cart = get(id);
			System.out.println(cart);

			if (cart == null) {
				System.out.println("delete f");
				return false;
			}
			System.out.println("delete");
			sessionFactory.getCurrentSession().delete(cart);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			System.out.println("delete f");
			return false;
		}
	}

	public List<Cart> list(String emailID, char status) {
		return sessionFactory.getCurrentSession().createCriteria(Cart.class)
				.add(Restrictions.eq("emailID", emailID))
				.add(Restrictions.eq("status", status))
				.list();
	}
	public List<Cart> list(String emailID) {
		return sessionFactory.getCurrentSession().createCriteria(Cart.class)
				.add(Restrictions.eq("emailID", emailID))
				.list();
	}
	public boolean update(String productID, int qty) {
		log.debug("Starting of the method update");
		String hql = "update Cart set quantity = '"+qty+"' where productID='" + productID + "'";
		try {
			sessionFactory.getCurrentSession().createQuery(hql).executeUpdate();
			log.debug("Ending of the method update");
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean update(String emailID) {
		log.debug("Starting of the method update");
		log.debug("Going to place order of " + emailID);
		String hql = "update Cart set status = 'O' where emailid='" + emailID + "'";
		try {
			sessionFactory.getCurrentSession().createQuery(hql).executeUpdate();
			log.debug("Ending of the method update");
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
