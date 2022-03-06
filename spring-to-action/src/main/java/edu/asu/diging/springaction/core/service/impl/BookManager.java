package edu.asu.diging.springaction.core.service.impl;

import java.util.List;

import edu.asu.diging.simpleusers.core.model.IUser;
import edu.asu.diging.springaction.core.model.impl.Book;

public interface BookManager {

	List<Book> all();

	Book store(String author, String title);
	
	Book get(Long id);
	
	void borrow(IUser user, Book book);
	
	void returnBook(IUser user, Book book);
	
	List<Book> findByUser(IUser user);

}