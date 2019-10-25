package com.capgemini.librarymanagement.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="books_inventory")
public class Books {
	@Id
	@Column(name="book_id")
	private String bookid;
	@Column(name="book_name")
	private String title;
	@Column
	private String firstauthorname;
	@Column
	private String secondauthorname;
	@Column
	private String publisher;
	@Column(name="yop")
	private String yearofpublication;
	public String getBookid() {
		return bookid;
	}
	public void setBookid(String bookid) {
		this.bookid = bookid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFirstauthorname() {
		return firstauthorname;
	}
	public void setFirstauthorname(String firstauthorname) {
		this.firstauthorname = firstauthorname;
	}
	public String getSecondauthorname() {
		return secondauthorname;
	}
	public void setSecondauthorname(String secondauthorname) {
		this.secondauthorname = secondauthorname;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getYearofpublication() {
		return yearofpublication;
	}
	public void setYearofpublication(String yearofpublication) {
		this.yearofpublication = yearofpublication;
	}
	@Override
	public String toString() {
		return "Books [bookid=" + bookid + ", title=" + title + ", firstauthorname=" + firstauthorname
				+ ", secondauthorname=" + secondauthorname + ", publisher=" + publisher + ", yearofpublication="
				+ yearofpublication + "]";
	}
	
    


}
