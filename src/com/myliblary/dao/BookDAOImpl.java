package com.myliblary.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;





import com.myliblary.model.Book;
import com.myliblary.model.User;

public class BookDAOImpl implements BookDAO{

	private SessionFactory sessionFactory;
	
	 public BookDAOImpl(SessionFactory sessionFactory) {
         this.sessionFactory = sessionFactory;
     }
	
	
	@Override
	public List<Book> list() {
		Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Book> books = null;
        try {
            System.out.println("IN BOOK LIST");
            books = (List<Book>)session.createQuery("from Book").list();
 
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.getTransaction().commit();
        return books;
	}

	@Override
	public void add(Book book) {
		 Session session = sessionFactory.getCurrentSession();
	        try {
	            session.beginTransaction();
	            session.save(book);
	          } catch (HibernateException e) {
	              e.printStackTrace();
	              session.getTransaction().rollback();
	        }
	            session.getTransaction().commit();
	}

	@Override
	public void update(Book book) {
		Session session = sessionFactory.getCurrentSession();
        try {
            System.out.println("IN Book Update");
            session.beginTransaction();
            session.saveOrUpdate(book);
            } catch (HibernateException e) {
                e.printStackTrace();
                session.getTransaction().rollback();
            }
        session.getTransaction().commit();
	}

	@Override
	public Book getBook(Long id) {
		Session session = sessionFactory.getCurrentSession();
        Book book=null;
        try {
            System.out.println("IN GetBook");
            session.beginTransaction();
            book = (Book) session.get(Book.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.getTransaction().commit();
        return book;
	}

	@Override
	public void deleteBook(int id) {
		Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Book book = (Book) session.get(Book.class, id);
        if(null != book) {
            session.delete(book);
        }
        session.getTransaction().commit();
	}

}
