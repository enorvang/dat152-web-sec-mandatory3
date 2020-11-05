package no.hvl.dat152.obl4.util;

import org.apache.commons.text.StringEscapeUtils;

public class Validator {

	public static String validString(String parameter) {
		return parameter != null ? StringEscapeUtils.escapeHtml4(parameter) : "null";
	}

	public static boolean validPassword(String password){
		return password.length() >= 8;
	}
}
