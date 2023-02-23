package com.usecases;

import java.util.Scanner;

import com.masai.dao.EmployeeDaoInt;
import com.masai.exception.EmployeeException;
import com.masai.model.Employee;

public class RegisterEmp {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome");
		System.out.println("Enter Employee Details");
		
		EmployeeDaoInt dao= new EmployeeDaoInt();
		
		while(true) {
			System.out.println("Enter Name");
			String name= sc.nextLine();
			
			System.out.println("Enter address");
			String address= sc.nextLine();
			
			System.out.println("Enter email");
			String email= sc.nextLine();
			
			System.out.println("Enter password");
			String password= sc.nextLine();
			
			System.out.println("Enter salary");
			int salary= sc.nextInt();
			
			System.out.println("Enter depId");
			int depId= sc.nextInt();
			
			Employee emp= new Employee();
			
			emp.setEname(name);
			emp.setAddress(address);
			emp.setEmail(email);
			emp.setPassword(password);
			emp.setSalary(salary);
			emp.setDepId(depId);
			
			try {
				System.out.println(dao.registerEmployee(emp));
			} catch (EmployeeException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			
			System.out.println("Regestration Done");
			sc.close();
		}
		

	}

}
