package com.UseCases;

import java.util.Scanner;

import com.DAO.BuyerDao;
import com.DAO.BuyerrDaoImpl;
import com.Main.Main;

public class LoginBuyer {
	public static String main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Login Buyer");
		System.out.println("Enter your Email here");
		String email = sc.next();
		
		System.out.println("Enter Your Password");
		String password= sc.next();
		
		BuyerDao dao= new BuyerrDaoImpl();
		
		String Result= "Login Failed !..";
		try {
			
			Result= dao.LonginBuyer(email, password);
//			System.out.println(Result);
		} catch (Exception e) {
			e.printStackTrace();
			
			Main.main(args);
		}
		
		return Result;
	}
}
