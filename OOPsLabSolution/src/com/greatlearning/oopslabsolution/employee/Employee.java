package com.greatlearning.oopslabsolution.employee;

import com.greatlearning.oopslabsolution.credentialsprovider.CredentialService;

public class Employee {

	public static final String COMPANY_NAME = "Great Learning";

	private String firstName;
	private String lastName;
	private String departmentName;
	private CredentialService credentialsProvider;

	// public parameterized Constructor
	public Employee(String firstName, String lastName) {
		super();
		if (nameValidityCheck(firstName) && nameValidityCheck(lastName)) {
			this.firstName = firstName;
			this.lastName = lastName;
		} else {
			throw new IllegalArgumentException("Name:" + firstName + " " + lastName + " should contain only letters");
		}
	}

	// Method

	// This method is mainly to check whether a given string contains only letters
	// or not
	private boolean nameValidityCheck(String name) {

		for (char ch : name.toCharArray()) {
			if (!Character.isLetter(ch)) {
				return false;
			}
		}
		return true;
	}

	// Getters and setters
	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setDepartmentName(String departmentName) {
		if (departmentName.length() > 0) {
			this.departmentName = departmentName;
		} else {
			throw new IllegalArgumentException("Department name cannot be blank or null");
		}
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setCredentialsProvider(CredentialService credentialsProvider) {
		this.credentialsProvider = credentialsProvider;
	}

	public CredentialService getCredentialsProvider() {
		return credentialsProvider;
	}

}
