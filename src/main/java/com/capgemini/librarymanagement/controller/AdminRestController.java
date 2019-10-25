package com.capgemini.librarymanagement.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.librarymanagement.beans.User;
import com.capgemini.librarymanagement.service.AdminService;
import com.capgemini.librarymanagement.utility.UserResponse;

@RestController
public class AdminRestController {
	
	@Autowired
	private AdminService service;
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		CustomDateEditor dateEditor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),true);
		binder.registerCustomEditor(Date.class, dateEditor);
	}
	
	
	
	
	@DeleteMapping("/deletestudent/{id}")
	public UserResponse deleteStudent(@PathVariable(name = "id") String userId) {
		UserResponse response = new UserResponse();
		if (service.deleteStudent(userId)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("student deleted successfully..");
		} else {
			response.setStatusCode(401);
			response.setMessage("failed");
			response.setDescription("unable to delete student!");
		}
		return response;
	}
	
	@DeleteMapping("/deletelibrarian/{id}")
	public UserResponse deleteLibrarian(@PathVariable(name = "id") String LibrarianId) {
		UserResponse response = new UserResponse();
		if (service.deleteLibrarian(LibrarianId)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("librarian deleted successfully..");
		} else {
			response.setStatusCode(401);
			response.setMessage("failed");
			response.setDescription("unable to delete librarian!");
		}
		return response;
	}
	
	@PostMapping(path = "/registerstudent", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public UserResponse registerStudent(@RequestBody User student) {
		UserResponse response = new UserResponse();
		if (service.registerStudent(student)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("student registered successfully..");
		} else {
			response.setStatusCode(401);
			response.setMessage("failed");
			response.setDescription("unable to register employee!");
		}
		return response;
	}
	
	@PostMapping(path = "/registerlibrarian", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public UserResponse registerLibrarian(@RequestBody User librarian) {
		UserResponse response = new UserResponse();
		if (service.registerLibrarian(librarian)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("librarian registered successfully..");
		} else {
			response.setStatusCode(401);
			response.setMessage("failed");
			response.setDescription("unable to register librarian!");
		}
		return response;
	}
	
	@GetMapping("/getstudent")
	public User getStudent(String userId) {
		return service.searchStudent(userId);
	}
	
	@GetMapping("/getlibrarian")
	public User getLibrarian(String LibrarianId) {
		return service.searchLibrarian(LibrarianId);
	}
	
	@GetMapping(path = "/getAllLibrarian", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public UserResponse getAllLibrarian() {
		List<User> beans = service.getAllLibrarian();
		UserResponse response = new UserResponse();
		if (beans != null) {
			response.setStatusCode(201);
			response.setMessage("Successfull");
			response.setDescription("librarian data found successfully");

		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("librarian data not found");
		}
		return response;
	}
	
	@GetMapping(path = "/getAllStudent", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public UserResponse getAllStudent() {
		List<User> beans = service.getAllStudent();
		UserResponse response = new UserResponse();
		if (beans != null) {
			response.setStatusCode(201);
			response.setMessage("Successfull");
			response.setDescription("student data found successfully");

		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("student data not found");
		}
		return response;
	}
	
	

}
