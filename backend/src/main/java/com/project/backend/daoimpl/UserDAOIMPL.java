package com.project.backend.daoimpl;

import java.sql.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.backend.DAO.UserDAO;
import com.project.backend.domain.User;


@Transactional
@Repository("userDAO")
public class UserDAOIMPL implements UserDAO {
	private static final Logger log= LoggerFactory.getLogger(UserDAOIMPL.class);
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private User user;
	
	public boolean save(User user) {
		try {
			user.setRole('C');
			user.setRegisteredDate(new Date(System.currentTimeMillis()) + "");
			String str=user.getEmailID()+"@sb.com";
			user.setEmailID(str);
			sessionFactory.getCurrentSession().save(user);
			System.out.println("save");
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public boolean update(User user) {
		try {
			sessionFactory.getCurrentSession().update(user);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public User get(String emailID) {
		return sessionFactory.getCurrentSession().get(User.class, emailID);
	}

	public boolean delete(String emailID) {
		try {
			user = get(emailID);
			if (user == null) {
				return false;
			}

			sessionFactory.getCurrentSession().delete(user);

			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}

	}

	public List<User> list() {
		return	sessionFactory.getCurrentSession().createQuery("from User").list();
	}

	public User validate(String emailID, String password) {
		return (User)sessionFactory.getCurrentSession().
				createCriteria(User.class).
				add(Restrictions.eq("emailID", emailID))
				.add(Restrictions.eq("password",password)).uniqueResult();
				}

}
