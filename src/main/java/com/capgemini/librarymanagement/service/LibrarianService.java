package com.capgemini.librarymanagement.service;

import java.util.Date;
import java.util.List;

import com.capgemini.librarymanagement.beans.Books;
import com.capgemini.librarymanagement.beans.Transaction;

public interface LibrarianService {
	public Boolean add(Books book);
	public Boolean update(Books bookId);
	public List<Books> findAll();
	public Books findBookById(String bookId);
	public Transaction acceptRequest(String registrationid);
	public Transaction generateFine(String registrationid,Date returndate );
	


}
