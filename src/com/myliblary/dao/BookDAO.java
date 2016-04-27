package com.myliblary.dao;

import java.util.List;

import com.myliblary.model.Book;

public interface BookDAO {

    public List<Book> list();
    public void add(Book book);
    public void  update(Book book);
    public Book  getBook(Long id);
    public void  deleteBook(int id);
	
}
