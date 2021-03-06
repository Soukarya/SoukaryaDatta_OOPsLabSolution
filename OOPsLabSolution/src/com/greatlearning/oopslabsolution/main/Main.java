/*
 * 
 * Author: Soukarya Datta
 * JDK: 17 (C:\Program Files\Java\jdk-17.0.2\bin)
 * JRE: C:\Users\Soukarya Datta\eclipse\java-2021-12\plugins\org.eclipse.justj.openjdk.hotspot.jre.full.win32.x86_64_17.0.1.v20211116-1657\jre
 * Eclipse version: 2021-12
 * Date : March 13, 2022
 * Version : 1.0.4
 * 
 * While importing from Git, please configure the appropriate JRE build path
 * 
 * 1> Right click on the project
 * 2> Build Path
 * 3> Configure Build Path
 * 4> Click on Java Build Path from the left window
 * 5> Select 'Order and Export' tab
 * 6> Select appropriate JRE
 * 7> Click on 'Apply and Close'
 * 
 */

package com.greatlearning.oopslabsolution.main;

import java.util.Scanner;

import com.greatlearning.oopslabsolution.credentialsprovider.CredentialService;
import com.greatlearning.oopslabsolution.employee.Employee;

public class Main {

	// To get title case of a string
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
		String departmentName = "", firstName = "";
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
			}
			if (emp != null) {
				firstName = Main.getTitleCase(emp.getFirstName().toLowerCase());

				try {
					departmentName = switch (choice) {
					case 1:
						validEmployeeExist = true;
						yield "tech";
					case 2:
						validEmployeeExist = true;
						yield "adm";
					case 3:
						validEmployeeExist = true;
						yield "hr";
					case 4:
						validEmployeeExist = true;
						yield "lgl";
					default:
						throw new IllegalArgumentException("Please enter a number between 1 and 4 inclusive\n");
					};
				} catch (IllegalArgumentException e) {
					System.err.println(e.getMessage());
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

		// Closing all the necessary resources
		emp = null;
		cp = null;
		if (sc != null)
			sc.close();
	}

}
