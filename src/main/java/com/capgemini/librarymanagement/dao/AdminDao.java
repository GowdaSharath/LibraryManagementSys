package com.capgemini.librarymanagement.dao;

import java.util.List;

import com.capgemini.librarymanagement.beans.User;

public interface AdminDao {
	public Boolean registerLibrarian(User librarian);
	
	public User login(String id,String password);

	public Boolean registerStudent(User student);

	public Boolean deleteStudent(String userId);

	public User searchStudent(String userId);

	public User searchLibrarian(String LibrarianId);

	public Boolean deleteLibrarian(String LibrarianId);

	public List<User> getAllLibrarian();

	public List<User> getAllStudent();

}
