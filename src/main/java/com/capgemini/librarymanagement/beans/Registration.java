package com.capgemini.librarymanagement.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="books_registration")
public class Registration {
	@GeneratedValue
	@Id
	@Column(name="registration_id")
	private String registrationid;
	@Column(name="book_id")
	private String bookid;
	@Column(name="user_id")
	private String id;
	@Column(name="registration_date")
	private Date registrationdate;
	public String getRegistrationid() {
		return registrationid;
	}
	public void setRegistrationid(String registrationid) {
		this.registrationid = registrationid;
	}
	public String getBookid() {
		return bookid;
	}
	public void setBookid(String bookid) {
		this.bookid = bookid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getRegistrationdate() {
		return registrationdate;
	}
	public void setRegistrationdate(Date registrationdate) {
		this.registrationdate = registrationdate;
	}
	@Override
	public String toString() {
		return "Registration [registrationid=" + registrationid + ", bookid=" + bookid + ", id=" + id
				+ ", registrationdate=" + registrationdate + "]";
	}
	

}
