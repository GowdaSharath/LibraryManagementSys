package com.capgemini.librarymanagement.service;

import com.capgemini.librarymanagement.beans.User;

public interface CommonOperationService {
	public User adminLogin(String adminId,String password);
	public User studentLogin(String studentid,String password);
	public User librarianLogin(String librarianid,String password);
	

}
