package com.greatlearning.oopslabsolution.employee;

import com.greatlearning.oopslabsolution.credentialsprovider.CredentialsProvider;

public class Employee {

	public static final String COMPANY_NAME = "Abc";
	
	private String firstName;
	private String lastName;
	private String departmentName;
	private CredentialsProvider credentialsProvider;
	
	
	public Employee(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.credentialsProvider = new CredentialsProvider(this);
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	public String getDepartmentName() {
		return departmentName;
	}
	
	//public void setCredentialsProvider(CredentialsProvider credentialsProvider) {
	//	this.credentialsProvider = credentialsProvider;
	//}
	
	public CredentialsProvider getCredentialsProvider() {
		return credentialsProvider;
	}

}
