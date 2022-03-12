package com.greatlearning.oopslabsolution.credentialsprovider;

import com.greatlearning.oopslabsolution.employee.Employee;
import java.util.Random;

public class CredentialsProvider {

	private String email;
	private String password;
	
	public CredentialsProvider(Employee e) {
		if(e != null) {
			this.email = e.getFirstName().toLowerCase()+e.getLastName().toLowerCase()+"@"+e.getDepartmentName()+"."+Employee.COMPANY_NAME.toLowerCase()+".com";
			this.password = this.generatePassword();
		}else {
			throw new RuntimeException("Employee details cannot be null");
		}
	}
	
	public String generateEmailAddress() {
			return email;
	}
	
	public String generatePassword() {
		
		Random r = new Random();
		String password = "";
		char upper =' ', lower = ' ', digit = ' ', symbol = ' ';
		String symbols = "~`!@#$%^&*()- _+=|\\}]{[:;\"\'?/>.<,";
		int len = r.nextInt(8,9);
		for(int i=0;i<len;i++) {
			int value = r.nextInt(0,4);
			if(value == 0) {
				//upper
				upper = (char)r.nextInt(65, 90);
				password += upper;
			}else if(value==1) {
				//lower
				lower = (char)r.nextInt(97, 122);
				password += lower;
			}else if(value == 2) {
				//digit
				digit = (char)r.nextInt(48, 57);
				password += digit;
			}else if(value == 3) {
				//symbols
				symbol = symbols.charAt(r.nextInt(0,symbols.length()));
				password += symbol;
			}
		}
		return password;
	}
	
	public void showCredentials() {
		System.out.println(generateEmailAddress());
		System.out.println(password);
	}
}
