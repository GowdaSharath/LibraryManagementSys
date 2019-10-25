package com.capgemini.librarymanagement.service;

import java.util.Date;
import java.util.List;

import com.capgemini.librarymanagement.beans.Books;
import com.capgemini.librarymanagement.beans.User;

public interface StudentService {
	public List<Books> getAllBooks();
	public Boolean updateStudent( User student)  ;
	public Boolean requestBook(String userId,String bookId,Date date);
	public Boolean returnBook(String transactionid, Date returnDate);
	public Boolean cancelRequest(Books bookId) ;
	

}
