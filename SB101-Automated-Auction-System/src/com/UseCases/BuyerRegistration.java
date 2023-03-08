package com.UseCases;

import java.util.Scanner;

import com.DAO.BuyerDao;
import com.DAO.BuyerrDaoImpl;
import com.Main.Main;
import com.model.Buyer;

public class BuyerRegistration {
	public static String main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Welcome ");
		System.out.println("Enter Your Name");
		String name = sc.next();
		
		System.out.println("Enter Your Email");
		String email = sc.next();
		
		System.out.println("Enter Your Password");
		String password = sc.next();
		
		Buyer buyer= new Buyer();
		
		buyer.setBname(name);
		buyer.setBemail(email);
		buyer.setBpassWord(password);
		
		BuyerDao dao= new BuyerrDaoImpl();
		
		String result="Regestered failed !";
		
		try {
			result = dao.RegisterBuyer(buyer);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Main.main(args);
		}
		
		return result;
	}
	
}
