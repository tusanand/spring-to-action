package edu.asu.diging.springaction.core.model.impl;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import edu.asu.diging.simpleusers.core.model.IUser;
import edu.asu.diging.simpleusers.core.model.impl.User;

@Entity
public class BookImpl implements Book {

    @Id
    @GeneratedValue
    private Long id;
    
    private String title;
    private String author;

    private boolean available;
    
    @ManyToOne(targetEntity = User.class)
    private IUser borrower;
    
    public IUser getBorrower() {
		return borrower;
	}
	public void setBorrower(IUser borrower) {
		this.borrower = borrower;
	}
	@Override
	public Long getId() {
        return id;
    }
    @Override
	public void setId(Long id) {
        this.id = id;
    }
    @Override
	public String getTitle() {
        return title;
    }
    @Override
	public void setTitle(String title) {
        this.title = title;
    }
    @Override
	public String getAuthor() {
        return author;
    }
    @Override
	public void setAuthor(String author) {
        this.author = author;
    }
    @Override
	public boolean isAvailable() {
        return available;
    }
    @Override
	public void setAvailable(boolean available) {
        this.available = available;
    }
}