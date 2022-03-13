package com.greatlearning.oopslabsolution.credentialsprovider;

import com.greatlearning.oopslabsolution.employee.Employee;
import java.util.Random;

public class CredentialService {

	private String email;
	private String password;

	// Parameterized constructor
	public CredentialService(Employee e) {
		if (e != null) {
			this.email = generateEmailAddress(e);
			this.password = generatePassword();
		} else {
			throw new RuntimeException("Employee details cannot be null");
		}
	}

	/* Making it private so that no external user can access directly to this api
	* basically the developer is enforcing the users to use showCredentials()
	* method
	*/
	private String generateEmailAddress(Employee e) {
		if (e != null) {
			return e.getFirstName().toLowerCase() + e.getLastName().toLowerCase() + "@" + e.getDepartmentName() + "."
					+ Employee.COMPANY_NAME.toLowerCase().trim().replace(" ", "") + ".com";
		} else {
			throw new RuntimeException("Employee details cannot be null");
		}
	}

	/* Making it private so that no external user can access directly to this api
	* basically the developer is enforcing the users to use showCredentials()
	* method
	*/
	private String generatePassword() {

		Random r = new Random();
		String password = "";
		char upper = ' ', lower = ' ', digit = ' ', symbol = ' ';
		boolean hasUpper = false, hasLower = false, hasDigit = false, hasSymbol = false;
		String symbols = "~`!@#$%^&*()- _+=|\\}]{[:;\"\'?/>.<,";
		int len = 8;// r.nextInt(8,9);//length of the password, if we want we can make it dynamic as
					// well
		int value = -1;

		for (int i = 1; i <= len; i++) {
			value = r.nextInt(0, 4);// upper(value=0) lower(value=1) digit(value=2) symbol(value=3)
			if (value == 0) {
				// upper
				hasUpper = true;
				upper = (char) r.nextInt(65, 90 + 1);// selecting random character between A and Z
				password += upper;
			} else if (value == 1) {
				// lower
				hasLower = true;
				lower = (char) r.nextInt(97, 122 + 1);// selecting random character between a and z
				password += lower;
			} else if (value == 2) {
				// digit
				hasDigit = true;
				digit = (char) r.nextInt(48, 57 + 1);// selecting random character between 0 and 9
				password += digit;
			} else if (value == 3) {
				// symbols
				hasSymbol = true;
				symbol = symbols.charAt(r.nextInt(0, symbols.length()));// selecting random character for special characters
				password += symbol;
			}
			if (i == len / 2) {
				if (!hasUpper) {
					hasUpper = true;
					upper = (char) r.nextInt(65, 90 + 1);
					password += upper;
					i++;
				}
				if (!hasLower) {
					hasLower = true;
					lower = (char) r.nextInt(97, 122 + 1);
					password += lower;
					i++;
				}
				if (!hasDigit) {
					hasDigit = true;
					digit = (char) r.nextInt(48, 57 + 1);
					password += digit;
					i++;
				}
				if (!hasSymbol) {
					hasSymbol = true;
					symbol = symbols.charAt(r.nextInt(0, symbols.length()));
					password += symbol;
					i++;
				}
			}

		}
		return password;
	}

	public void showCredentials() {
		System.out.println("Email    ---> " + email);
		System.out.println("Password ---> " + password);
	}
}
