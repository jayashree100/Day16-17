package com.bridgelab.algorithm;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomizeMessage {
	String name = "<<name>>";
	String mobileNumber = "xxxxxxxxxx";
	String fullName = "<<full name>>";
	String date = "06/01/2022";

	String message;

	public void firstName(String input) {
		Pattern pattern = Pattern.compile(name);
		Matcher matcher = pattern.matcher(input);
		message = matcher.replaceAll("jayashree");
	}

	public void fullName(String input) {
		Pattern pattern = Pattern.compile(fullName);
		Matcher matcher = pattern.matcher(message);
		message = matcher.replaceAll("Jayashree Metre");
	}

	public void mobileNumber(String input) {
		Pattern pattern = Pattern.compile(mobileNumber);
		Matcher matcher = pattern.matcher(message);
		message = matcher.replaceAll("9632857888");
	}

	public void date(String input) {
		DateTimeFormatter presentDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDateTime localDate = LocalDateTime.now();

		Pattern pattern = Pattern.compile(date);
		Matcher matcher = pattern.matcher(message);
		message = matcher.replaceAll(presentDate.format(localDate));
	}

	public void displayMessage() {
		System.out.println(message);
	}

	public static void main(String[] args) {
		CustomizeMessage customize = new CustomizeMessage();
		String input = "Hello <<name>>, We have your fullname as <<full name>> in our system. your contact number is 91-xxxxxxxxxx."
				+ "\nPlease,let us know in case of any clarification Thank you BridgeLabz 06/01/2022.";
		customize.firstName(input);
		customize.fullName(input);
		customize.mobileNumber(input);
		customize.date(input);
		customize.displayMessage();
	}
}