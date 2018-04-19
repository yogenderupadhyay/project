package com.project.backend.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.backend.DAO.SupplierDAO;
import com.project.backend.domain.Category;
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
			List<Supplier> suppliers = sessionFactory.getCurrentSession().createQuery("from Supplier").list();
			int count = suppliers.size();
			String str="S_00"+ count +"-"+ supplier.getId();
			supplier.setId(str);
			sessionFactory.getCurrentSession().saveOrUpdate(supplier);
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
	public Supplier get(String id) {
		return sessionFactory.getCurrentSession().get(Supplier.class, id);
	}
	public boolean delete(String id) {
		try {
			supplier = get(id);
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
