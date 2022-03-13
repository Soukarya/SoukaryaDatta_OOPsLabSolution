/*
 * 
 * Author: Soukarya Datta
 * JDK: 17 (C:\Program Files\Java\jdk-17.0.2\bin)
 * JRE: C:\Users\Soukarya Datta\eclipse\java-2021-12\plugins\org.eclipse.justj.openjdk.hotspot.jre.full.win32.x86_64_17.0.1.v20211116-1657\jre
 * Eclipse version: 2021-12
 * Date : March 13, 2022
 * Version : 1.0.4
 * 
 * While importing from git, please configure the JRE build path
 * 
 */

package com.greatlearning.oopslabsolution.main;

import java.util.Scanner;

import com.greatlearning.oopslabsolution.credentialsprovider.CredentialService;
import com.greatlearning.oopslabsolution.employee.Employee;

public class Main {

	//To get title case of a string
	private static String getTitleCase(String s) {
		if (s.length() == 1) {
			return s.toUpperCase();
		} else if (s.length() > 1) {
			return ((char) (s.charAt(0) - 32)) + s.substring(1);
		} else {
			throw new RuntimeException("Please enter a valid name");
		}
	}

	public static void main(String[] args) {

		int choice = 0;
		String departmentName = "", firstName = "", lastName = "";
		Employee emp = null;
		CredentialService cp = null;
		boolean validEmployeeExist = false;
		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("Please enter the department from the following");
			System.out.println("1. Technical");
			System.out.println("2. Admin");
			System.out.println("3. Human Resource");
			System.out.println("4. Legal");
			choice = sc.nextInt();
			System.out.println();
			// Creating employee object
			try {
				emp = new Employee("Soukarya", "Datta");
			} catch (IllegalArgumentException e) {
				System.err.println(e.getMessage());
				sc.close();
			}
			if (emp != null) {
				firstName = Main.getTitleCase(emp.getFirstName().toLowerCase());
				// lastName = Main.getTitleCase(emp.getLastName().toLowerCase());

				switch (choice) {
				case 1:
					departmentName = "tech";
					validEmployeeExist = true;
					break;
				case 2:
					departmentName = "adm";
					validEmployeeExist = true;
					break;
				case 3:
					departmentName = "hr";
					validEmployeeExist = true;
					break;
				case 4:
					departmentName = "lgl";
					validEmployeeExist = true;
					break;
				default:
					System.err.println("Please enter a number between 1 and 4 inclusive\n");
				}
			}
		} while (!(choice >= 1 && choice <= 4));

		if (validEmployeeExist) {
			emp.setDepartmentName(departmentName);
			cp = new CredentialService(emp);
			if (cp != null) {
				emp.setCredentialsProvider(cp);
				System.out.println("Dear " + firstName + " your generated credentials are as follows");
				emp.getCredentialsProvider().showCredentials();
			}
		}
		emp = null;
		cp = null;
		if (sc != null)
			sc.close();

	}

}
