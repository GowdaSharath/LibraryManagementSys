package com.capgemini.librarymanagement.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.librarymanagement.beans.Books;
import com.capgemini.librarymanagement.beans.User;
import com.capgemini.librarymanagement.dao.StudentDao;
@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDao dao;

	@Override
	public List<Books> getAllBooks() {
		return dao.getAllBooks();
	}

	@Override
	public Boolean updateStudent(User student) {
		return dao.updateStudent(student);
	}

	@Override
	public Boolean requestBook(String userId, String bookId, Date date) {
		return dao.requestBook(userId, bookId, date);
	}

	@Override
	public Boolean returnBook(String transactionid, Date returnDate) {
		return dao.returnBook(transactionid, returnDate);
	}

	@Override
	public Boolean cancelRequest(Books bookId) {
		return dao.cancelRequest(bookId);
	}
	
	

}
