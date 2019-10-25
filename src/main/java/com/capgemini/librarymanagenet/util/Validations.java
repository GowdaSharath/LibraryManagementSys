package com.capgemini.librarymanagenet.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validations {

	public static Boolean validateId(String id) {

		Pattern pat = Pattern.compile("^[a-zA-Z0-9]+$");
		Matcher mat = pat.matcher(id);
		if (mat.matches()) {
			return true;
		} else {
			return false;
		}

	}

	public static Boolean validatePassword(String pwd) {

		Pattern pat = Pattern.compile("\\w+\\W+\\w+"); // for alphanumeric passwords
		Matcher mat = pat.matcher("afimf#4df");
		if (mat.matches()) {
			return true;
		} else {
			return false;
		}
	}

	public static Boolean validateEmail(String email) {
		Pattern pat = Pattern.compile("\\w+\\@\\w+\\.\\w+");
		Matcher mat = pat.matcher(email);
		if (mat.matches()) {
			return true;
		} else {
			return false;
		}
	}
	
	/*
	 * public static Boolean validateDate(Date date) { SimpleDateFormat date1=new
	 * SimpleDateFormat("yyyy/mm/dd"); return true; }
	 */
	

	

}
