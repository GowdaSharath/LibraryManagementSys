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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.librarymanagement.beans.Books;
import com.capgemini.librarymanagement.beans.User;
import com.capgemini.librarymanagement.service.AdminService;
import com.capgemini.librarymanagement.service.StudentService;
import com.capgemini.librarymanagement.utility.UserResponse;

@RestController
public class StudentRestController {
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		CustomDateEditor dateEditor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),true);
		binder.registerCustomEditor(Date.class, dateEditor);
	}
	
	@Autowired
	private StudentService service;
	@GetMapping(path = "/showAllbooks", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public UserResponse getAllBooks() {
		List<Books> beans = service.getAllBooks();
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
	
	@PutMapping(path = "/updatestudent", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public UserResponse updateStudent(@RequestBody User student) {
		UserResponse response = new UserResponse();
		if (service.updateStudent(student)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("student updated successfully..");
		} else {
			response.setStatusCode(401);
			response.setMessage("failed");
			response.setDescription("unable to update student!");
		}
		return response;
	}
	@PutMapping(path = "/requestbook", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public UserResponse requestBook(@RequestBody String userId,String bookId,Date date) {
		UserResponse response = new UserResponse();
		if (service.requestBook(userId, bookId, date)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("requested successfully..");
		} else {
			response.setStatusCode(401);
			response.setMessage("failed");
			response.setDescription("failed!");
		}
		return response;
	}
	@DeleteMapping("/returnbook")
	public UserResponse deleteLibrarian(String transactionid, Date returnDate) {
		UserResponse response = new UserResponse();
		if (service.returnBook(transactionid, returnDate)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("returned successfully..");
		} else {
			response.setStatusCode(401);
			response.setMessage("failed");
			response.setDescription("unable to return!");
		}
		return response;
	}
	
	@DeleteMapping("/cancelbook")
	public UserResponse cancelrequest(Books bookId) {
		UserResponse response = new UserResponse();
		if (service.cancelRequest(bookId)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("canceled successfully..");
		} else {
			response.setStatusCode(401);
			response.setMessage("failed");
			response.setDescription("unable to cancel!");
		}
		return response;
	}


}
