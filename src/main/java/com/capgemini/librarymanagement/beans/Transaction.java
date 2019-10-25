package com.capgemini.librarymanagement.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="books_transaction")
public class Transaction  {
	@Id
	@Column(name="transaction_id")
	private String transactionid;
	@Column(name="registration_id")
	private String registrationid;
	@Column(name="issue_date")
	private Date issuedate;
	@Column(name="return_date")
	private Date returndate;
	@Column
	private Double fine;
	public String getTransactionid() {
		return transactionid;
	}
	public void setTransactionid(String transactionid) {
		this.transactionid = transactionid;
	}
	public String getRegistrationid() {
		return registrationid;
	}
	public void setRegistrationid(String registrationid) {
		this.registrationid = registrationid;
	}
	public Date getIssuedate() {
		return issuedate;
	}
	public void setIssuedate(Date issuedate) {
		this.issuedate = issuedate;
	}
	public Date getReturndate() {
		return returndate;
	}
	public void setReturndate(Date returndate) {
		this.returndate = returndate;
	}
	public Double getFine() {
		return fine;
	}
	public void setFine(Double fine) {
		this.fine = fine;
	}
	@Override
	public String toString() {
		return "Transaction [transactionid=" + transactionid + ", registrationid=" + registrationid + ", issuedate="
				+ issuedate + ", returndate=" + returndate + ", fine=" + fine + "]";
	}
	
	
	
	

}
