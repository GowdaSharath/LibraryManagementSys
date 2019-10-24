package com.capgemini.librarymanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.librarymanagement.service.AdminService;

public class AdminRestController {
	@Autowired
	private AdminService service;
	
	@PostMapping("/AdminLogin")
	public UserResponse login(Integer id, String password) {
		 UserResponse response=new UserResponse();
		Users admin=service.adminLogin(id, password);
		if(admin!=null) {
			response.setStatusCode(201);
			response.setMessage("success");
			
		}else {
			response.setStatusCode(404);
			response.setMessage("failed");
			
		}	return response;	
	}


	

}
