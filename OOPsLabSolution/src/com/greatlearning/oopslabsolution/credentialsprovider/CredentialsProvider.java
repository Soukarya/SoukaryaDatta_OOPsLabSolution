package com.greatlearning.oopslabsolution.credentialsprovider;

import com.greatlearning.oopslabsolution.employee.Employee;
import java.util.Random;

public class CredentialsProvider {
	

	private String email;
	private String password;
	
	public CredentialsProvider(Employee e) {
		if(e != null) {
			this.email = generateEmailAddress(e);
			this.password = generatePassword();
		}else {
			throw new RuntimeException("Employee details cannot be null");
		}
	}
	
	private String generateEmailAddress(Employee e) {
		return e.getFirstName().toLowerCase()+e.getLastName().toLowerCase()+"@"+e.getDepartmentName()+"."+Employee.COMPANY_NAME.toLowerCase()+".com";
	}
	
	private String generatePassword() {
		
		Random r = new Random();
		String password = "";
		char upper =' ', lower = ' ', digit = ' ', symbol = ' ';
		boolean hasUpper = false, hasLower = false, hasDigit = false, hasSymbol = false;
		String symbols = "~`!@#$%^&*()- _+=|\\}]{[:;\"\'?/>.<,";
		int len = r.nextInt(8,9);
		int value = -1;
		for(int i=1;i<=len;i++) {
			value = r.nextInt(0,4);
			if(value == 0) {
				//upper
				hasUpper = true;
				upper = (char)r.nextInt(65, 90+1);
				password += upper;
			}else if(value==1) {
				//lower
				hasLower = true;
				lower = (char)r.nextInt(97, 122+1);
				password += lower;
			}else if(value == 2) {
				//digit
				hasDigit = true;
				digit = (char)r.nextInt(48, 57+1);
				password += digit;
			}else if(value == 3) {
				//symbols
				hasSymbol = true;
				symbol = symbols.charAt(r.nextInt(0,symbols.length()));
				password += symbol;
			}
			if(i == len/2) {
				//System.out.println("Entering i==len/2 "+i);
				if(!hasUpper) {
					//System.out.println("A");
					hasUpper = true;
					upper = (char)r.nextInt(65, 90+1);
					password += upper;
					i++;
				}
				if(!hasLower) {
					//System.out.println("a");
					hasLower = true;
					lower = (char)r.nextInt(97, 122+1);
					password += lower;
					i++;
				}
				if(!hasDigit) {
					//System.out.println("9");
					hasDigit = true;
					digit = (char)r.nextInt(48, 57+1);
					password += digit;
					i++;
				}
				if(!hasSymbol) {
					//System.out.println("#");
					hasSymbol = true;
					symbol = symbols.charAt(r.nextInt(0,symbols.length()));
					password += symbol;
					i++;
				}
			}
			
		}
		return password;
	}
	
	public void showCredentials() {
		System.out.println(email);
		System.out.println(password);
	}
}
