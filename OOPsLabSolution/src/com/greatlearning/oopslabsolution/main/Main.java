package com.greatlearning.oopslabsolution.main;

import java.util.Scanner;

import com.greatlearning.oopslabsolution.credentialsprovider.CredentialsProvider;
import com.greatlearning.oopslabsolution.employee.Employee;

public class Main {

	private static String getTitleCase(String s) {
		return ((char) (s.charAt(0) - 32)) + s.substring(1);
	}

	public static void main(String[] args) {

		int choice=0;
		String departmentName = "", firstName="", lastName = "";
		Employee emp = null;
		CredentialsProvider cp = null;
		boolean validEmployeeExist = false;
		Scanner sc = new Scanner(System.in);
		

		do {
			System.out.println("Please enter the department from the following");
			System.out.println("1. Technical");
			System.out.println("2. Admin");
			System.out.println("3. Human Resource");
			System.out.println("4. Legal");
			choice = sc.nextInt();
			//Creating employee object
			emp = new Employee("Soukarya", "Datta");

			if (emp != null) {
				firstName = Main.getTitleCase(emp.getFirstName().toLowerCase());
				//lastName = Main.getTitleCase(emp.getLastName().toLowerCase());
				
				switch (choice) {
				case 1:
					departmentName = "tech";
					validEmployeeExist = true;
					break;
				case 2:
					departmentName = "admin";
					validEmployeeExist = true;
					break;
				case 3:
					departmentName = "hr";
					validEmployeeExist = true;
					break;
				case 4:
					departmentName = "legal";
					validEmployeeExist = true;
					break;
				default:
					System.err.println("Please enter a number between 1 and 4 inclusive\n");
				}
			}
		} while (!(choice >= 1 && choice <= 4));
		
		if (validEmployeeExist) {
			emp.setDepartmentName(departmentName);
			cp = new CredentialsProvider(emp);
			if (cp != null) {
				//emp.setCredentialsProvider(cp);
				System.out.println("Dear " + firstName + " your generated credentials are as follows");
				cp.showCredentials();
			}
		}
		if(sc!=null)
			sc.close();

	}

}
