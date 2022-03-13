package com.greatlearning.oopslabsolution.employee;

import com.greatlearning.oopslabsolution.credentialsprovider.CredentialService;

public class Employee {

	//COMPANY_NAME is constant within an organization
	public static final String COMPANY_NAME = "Great Learning";

	private String firstName;
	private String lastName;
	private String departmentName;
	private CredentialService credentialsProvider;

	// public parameterized Constructor
	public Employee(String firstName, String lastName) {
		super();
		if(firstName.length()>0 && lastName.length()>0) {
			if (nameValidityCheck(firstName) && nameValidityCheck(lastName)) {
				this.firstName = firstName;
				this.lastName = lastName;
			} else {
				throw new IllegalArgumentException("Name:" + firstName + " " + lastName + " should contain only letters");
			}
		} else {
			throw new IllegalArgumentException("Name cannot be an empty string");
		}
	}

	// This method is mainly to check whether a given string contains only letters
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
		if (departmentName!= null && departmentName.length() > 0) {
			this.departmentName = departmentName;
		} else {
			throw new IllegalArgumentException("Department name cannot be an empty string or null");
		}
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setCredentialsProvider(CredentialService credentialsProvider) {
		if(credentialsProvider != null) {
			this.credentialsProvider = credentialsProvider;
		}
	}

	public CredentialService getCredentialsProvider() {
		return credentialsProvider;
	}

}
