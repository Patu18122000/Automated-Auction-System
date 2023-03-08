package com.UseCases;

import java.util.Scanner;

import com.DAO.SellerDao;
import com.DAO.SellerDaoImpl;

public class RemoveItembySId {
	public static String main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		SellerDao dao = new SellerDaoImpl();
				
		System.out.println("Enter your Iid");
		int Iid = sc.nextInt();
		
		String msg= "Remove Items Failed !.."; 
		
		try {
			msg = dao.RemoveItemSeller(Iid);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return msg;
	}
}
