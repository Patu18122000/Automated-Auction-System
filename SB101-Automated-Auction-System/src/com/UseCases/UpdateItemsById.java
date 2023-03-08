package com.UseCases;

import java.util.Scanner;

import com.DAO.SellerDao;
import com.DAO.SellerDaoImpl;
import com.Main.Main;
import com.model.Items;

public class UpdateItemsById {
	public static String main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		SellerDao dao = new SellerDaoImpl();
		
		System.out.println("Enter Item Price");
		int price = sc.nextInt();
		
		System.out.println("Enter Item Quantity");
		int quantity= sc.nextInt();
				
		System.out.println("Enter your Iid");
		int Iid = sc.nextInt();
		
		String msg= "Updation Failed !..";
		
		try {
			msg = dao.UpdateItem(price,quantity,Iid);
			
//			System.out.println(msg);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Main.main(args);
		}
		
		return msg;
	}
}
