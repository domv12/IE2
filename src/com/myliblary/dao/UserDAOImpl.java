package com.myliblary.dao;

import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;


import com.myliblary.model.User;

public class UserDAOImpl implements UserDAO {

	private SessionFactory sessionFactory;
	
	 public UserDAOImpl(SessionFactory sessionFactory) {
          this.sessionFactory = sessionFactory;
      }
	
	@Override
	public List<User> list() {
		Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<User> items = null;
        try {
            System.out.println("IN LIST");
            items = (List<User>)session.createQuery("from User").list();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.getTransaction().commit();
        return items;
	}

	@Override
	public void add(User item) {
		 Session session = sessionFactory.getCurrentSession();
	        try {
	            session.beginTransaction();
	            session.save(item);
	          } catch (HibernateException e) {
	              e.printStackTrace();
	              session.getTransaction().rollback();
	        }
	            session.getTransaction().commit();
	}

	@Override
	public void update(User item) {
		 Session session = sessionFactory.getCurrentSession();
	        try {
	            System.out.println("IN Update");
	            session.beginTransaction();
	            session.saveOrUpdate(item);
	            } catch (HibernateException e) {
	                e.printStackTrace();
	                session.getTransaction().rollback();
	            }
	        session.getTransaction().commit();

	}

	@Override
	public User getItem(Long id) {
		 Session session = sessionFactory.getCurrentSession();
	        User item=null;
	        try {
	            System.out.println("IN GetIteam");
	            session.beginTransaction();
	            item = (User) session.get(User.class, id);
	        } catch (HibernateException e) {
	            e.printStackTrace();
	            session.getTransaction().rollback();
	        }
	        session.getTransaction().commit();
	        return item;
	}

	@Override
	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        User item = (User) session.get(User.class, id);
        if(null != item) {
            session.delete(item);
        }
        session.getTransaction().commit();
        //return item;
	}

}
