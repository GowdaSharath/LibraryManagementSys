package com.capgemini.librarymanagement.utility;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.capgemini.librarymanagement.beans.User;
import com.fasterxml.jackson.annotation.JsonInclude;

@XmlRootElement(name = "user-response")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponse {
	@XmlElement(name = "status-code")
	private int statusCode;

	@XmlElement
	private String message;

	@XmlElement
	private String description;

	private User user;
	private List<User> userlist;

}
