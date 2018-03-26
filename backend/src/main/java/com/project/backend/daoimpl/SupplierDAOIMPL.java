package com.project.backend.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.backend.DAO.SupplierDAO;
import com.project.backend.domain.Supplier;

@Transactional
@Repository("supplierDAO")
public class SupplierDAOIMPL implements SupplierDAO {
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private Supplier supplier;
	public boolean save(Supplier supplier) {
		try {
			System.out.println("1");
			sessionFactory.getCurrentSession().save(supplier);
			System.out.println("2");
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean update(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().update(supplier);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public Supplier get(String emailID) {
		return sessionFactory.getCurrentSession().get(Supplier.class, emailID);
	}
	public boolean delete(String emailID) {
		try {
			supplier = get(emailID);
			if (supplier == null) {
				return false;
			}
			sessionFactory.getCurrentSession().delete(supplier);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}
	public List<Supplier> list() {
		return sessionFactory.getCurrentSession().createQuery("from Supplier").list();
		}
}
