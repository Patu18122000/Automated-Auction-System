package com.UseCases;

import java.util.Scanner;

import com.DAO.BuyerDao;
import com.DAO.BuyerrDaoImpl;
import com.Main.Main;

public class BuyItemsUC {
	public static String main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Welcome");
		System.out.println("Enter Bid");
		int bid = sc.nextInt();
		
		System.out.println("Enter iid");
		int iid = sc.nextInt();
		
		BuyerDao dao= new BuyerrDaoImpl();
		
		String result = "Something went wrong";
		
		try {
			result = dao.BuyItems(bid, iid);
			
//			System.out.println(result);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Main.main(args);
		}
		
		return result;
	}
}
