package com.capgemini.librarymanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.librarymanagement.beans.User;
import com.capgemini.librarymanagement.dao.AdminDao;
import com.capgemini.librarymanagement.dao.AdminDaoImpl;
@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	 AdminDao dao=new AdminDaoImpl();
	@Override
	public Boolean registerLibrarian(User librarian) {
		return dao.registerLibrarian(librarian);
	}

	@Override
	public Boolean registerStudent(User student) {
		return dao.registerStudent(student);
	}

	@Override
	public Boolean deleteStudent(String userId) {
		return dao.deleteStudent(userId);
	}

	@Override
	public User searchStudent(String userId) {
		return dao.searchStudent(userId);
	}

	@Override
	public User searchLibrarian(String LibrarianId) {
		return dao.searchLibrarian(LibrarianId);
	}

	@Override
	public Boolean deleteLibrarian(String LibrarianId) {
		return dao.deleteLibrarian(LibrarianId);
	}

	@Override
	public List<User> getAllLibrarian() {
		return dao.getAllLibrarian();
	}

	@Override
	public List<User> getAllStudent() {
		return dao.getAllStudent();
	}

	@Override
	public User login(String id, String password) {
		return dao.login(id, password);
	}
	

}
