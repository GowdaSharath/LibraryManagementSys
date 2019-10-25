package com.capgemini.librarymanagement.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.librarymanagement.beans.Books;
import com.capgemini.librarymanagement.beans.User;
import com.capgemini.librarymanagement.service.AdminService;
import com.capgemini.librarymanagement.service.LibrarianService;
import com.capgemini.librarymanagement.utility.UserResponse;

@RestController
public class LibrarianRestController {
	

	@Autowired
	private LibrarianService service;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		CustomDateEditor dateEditor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),true);
		binder.registerCustomEditor(Date.class, dateEditor);
	}
	
	
	@PostMapping(path = "/addbooks", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public UserResponse addBooks(@RequestBody Books books) {
		UserResponse response = new UserResponse();
		if (service.add(books)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("books added successfully..");
		} else {
			response.setStatusCode(401);
			response.setMessage("failed");
			response.setDescription("unable to add books!");
		}
		return response;
	}
	
	@PutMapping(path = "/updatebook", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public UserResponse updateBook(@RequestBody Books book) {
		UserResponse response = new UserResponse();
		if (service.update(book)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("book updated successfully..");
		} else {
			response.setStatusCode(401);
			response.setMessage("failed");
			response.setDescription("unable to update employee!");
		}
		return response;
	}

	@GetMapping(path = "/checkallbooks", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public UserResponse findAllBooks() {
		List<Books> beans = service.findAll();
		UserResponse response = new UserResponse();
		if (beans != null) {
			response.setStatusCode(201);
			response.setMessage("Successfull");
			response.setDescription("books data found successfully");

		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("books data not found");
		}
		return response;
	}
	@GetMapping("/getbook")
	public Books getStudent(String bookId) {
		return service.findBookById(bookId);
	}	
	
	@PostMapping(path = "/acceptrequest", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public UserResponse acceptRequest(@RequestBody String registrationid) {
		UserResponse response = new UserResponse();
		if (service.acceptRequest(registrationid) != null) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("request accepted successfully..");
		} else {
			response.setStatusCode(401);
			response.setMessage("failed");
			response.setDescription("request not accepted !");
		}
		return response;
	}
	@PostMapping(path = "/fine", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public UserResponse generateFine(@RequestBody String registrationid,Date returndate) {
		UserResponse response = new UserResponse();
		if (service.generateFine(registrationid, returndate) != null) {
			response.setStatusCode(201);
			response.setMessage("success");
		} else {
			response.setStatusCode(401);
			response.setMessage("failed");
		}
		return response;
	}
	
	
}
