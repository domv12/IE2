package com.myliblary.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Book {

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int bookId;
	@Column
	private String title;
	@Column
	private String author;
	@Column
	private String publishingHouse;
	
	@ManyToOne
	@JoinColumn(name="userId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private User user;
	
	public Book(){};
	public Book(int bookId, String title, String author,
			String publishingHouse) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.publishingHouse = publishingHouse;
		//this.userId = userId;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublishingHouse() {
		return publishingHouse;
	}
	public void setPublishingHouse(String publishingHouse) {
		this.publishingHouse = publishingHouse;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	
	
}
