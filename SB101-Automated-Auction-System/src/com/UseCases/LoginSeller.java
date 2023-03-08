package com.UseCases;

import java.util.Scanner;

import com.DAO.SellerDao;
import com.DAO.SellerDaoImpl;
import com.Main.Main;

public class LoginSeller {
	public static String main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Login Buyer");
		System.out.println("Enter your Email here");
		String email = sc.next();
		
		System.out.println("Enter Your Password");
		String password= sc.next();
		
		SellerDao dao= new SellerDaoImpl();
		
		String Result= "Login Failed !...";
		
		try {
			
			Result= dao.LoginSeller(email, password);
			
//			System.out.println(Result);
			
		} catch (Exception e) {
			e.printStackTrace();
			Main.main(args);
		}
		
		return Result;
//		sc.close();
	}
	
}
