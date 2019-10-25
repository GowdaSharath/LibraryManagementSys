package com.capgemini.librarymanagement.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.librarymanagement.beans.Books;
import com.capgemini.librarymanagement.beans.Transaction;
import com.capgemini.librarymanagement.dao.LibrarianDao;

@Service
public class LibrarianServiceImpl implements LibrarianService {
	private LibrarianDao dao;

	@Override
	public Boolean add(Books book) {
		return dao.add(book);
	}

	@Override
	public Boolean update(Books bookId) {
		return dao.update(bookId);
	}

	@Override
	public List<Books> findAll() {
		return dao.findAll();
	}

	@Override
	public Books findBookById(String bookId) {
		return dao.findBookById(bookId);
	}

	@Override
	public Transaction acceptRequest(String registrationid) {
		return dao.acceptRequest(registrationid);
	}

	@Override
	public Transaction generateFine(String registrationid, Date returndate) {
		return dao.generateFine(registrationid, returndate);
	}

	
	

}
