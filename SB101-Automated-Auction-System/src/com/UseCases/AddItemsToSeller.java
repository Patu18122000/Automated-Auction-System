package com.UseCases;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Scanner;

import com.DAO.SellerDao;
import com.DAO.SellerDaoImpl;
import com.Main.Main;
import com.model.Items;

public class AddItemsToSeller {
	public static String main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		String msg="Item Not Registered";
		
		SellerDao dao = new SellerDaoImpl();
		
		System.out.println("Enter Item Name");
		String name = sc.next();
		
		System.out.println("Enter Item Price");
		int price = sc.nextInt();
		
		System.out.println("Enter Item Quantity");
		int quantity= sc.nextInt();
		
		Date date = Date.valueOf(LocalDate.now());
		
		System.out.println("Enter your Sid");
		int sid = sc.nextInt();
		
		Items items= new Items();
		items.setiName(name);
		items.setiPrice(price);
		items.setiQuantity(quantity);
		items.setiDate(date);
		items.setSid(sid);
		
		try {
			msg = dao.AddItemToSeller(items);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Main.main(args);
		}
		
		return msg;
	}
}
