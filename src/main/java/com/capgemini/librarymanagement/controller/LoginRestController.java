package com.capgemini.librarymanagement.controller;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.librarymanagement.beans.User;
import com.capgemini.librarymanagement.service.AdminService;
import com.capgemini.librarymanagement.utility.UserResponse;

@RestController
public class LoginRestController {
	
	
	@Autowired
	private AdminService cservice;
	
	@PostMapping("/adminlogin")
	public UserResponse login( String id, String password) {
		 UserResponse response=new UserResponse();
		User admin=cservice.login(id, password);
		if(admin!=null) {
			response.setStatusCode(201);
			response.setMessage("success");
		}else {
			response.setStatusCode(404);
			response.setMessage("failed");
		}	return response;	
	}
	
	/*
	 * @PostMapping("/studentlogin") public UserResponse studentLogin(String id,
	 * String password) { UserResponse response=new UserResponse(); User
	 * student=cservice.studentLogin(id, password); if(student!=null) {
	 * response.setStatusCode(201); response.setMessage("success"); }else {
	 * response.setStatusCode(404); response.setMessage("failed"); } return
	 * response; }
	 * 
	 * @PostMapping("/librarianlogin") public UserResponse librarianLogin(String id,
	 * String password) { UserResponse response=new UserResponse(); User
	 * librarian=cservice.librarianLogin(id, password); if(librarian!=null) {
	 * response.setStatusCode(201); response.setMessage("success"); }else {
	 * response.setStatusCode(404); response.setMessage("failed"); } return
	 * response; }
	 * 
	 */


	

}
