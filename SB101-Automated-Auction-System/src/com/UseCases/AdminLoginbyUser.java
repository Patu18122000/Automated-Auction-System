package com.UseCases;

import java.util.Scanner;

import com.DAO.AdministratorDao;
import com.DAO.AdministratorDaoImpl;
import com.Main.Main;
import com.custome.ConsoleColour;

public class AdminLoginbyUser {
	public static String main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		AdministratorDao dao = new AdministratorDaoImpl();
		
		System.out.println(ConsoleColour.BLUE+"Welcome to admin Login"+ConsoleColour.RESET);
		
		System.out.println("Enter your username");
		String username= sc.next();
		
		System.out.println("Enter your password");
		String password= sc.next();
		
		String msg= "Login Failed !..";
		
		try {
			
			msg = dao.AdminLogin(username, password);
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Main.main(args);
		}
		return msg;
	}
}
