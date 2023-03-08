package com.UseCases;

import java.util.Scanner;

import com.DAO.SellerDao;
import com.DAO.SellerDaoImpl;
import com.Main.Main;
import com.model.Seller;

public class SellerRegistration {
	public static String main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Welcome ");
		System.out.println("Enter Your Name");
		String name = sc.next();
		
		System.out.println("Enter Your Email");
		String email = sc.next();
		
		System.out.println("Enter Your Password");
		String password = sc.next();
		
		Seller seller= new Seller();
		
		seller.setsName(name);
		seller.setsEmail(email);
		seller.setsPassword(password);
		
		String result = "Registration Failed !...";
		
		SellerDao dao= new SellerDaoImpl();
		
		try {
			result = dao.RegisterSeller(seller);
			
//			System.out.println(result);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Main.main(args);
		}
		
		return result;
	
	}
}
