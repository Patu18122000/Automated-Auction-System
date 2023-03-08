package com.UseCases;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.DAO.BuyerDao;
import com.DAO.BuyerrDaoImpl;
import com.Main.Main;
import com.model.BuyItem;

public class ShowBuyItemsByID {
	public static List<BuyItem> main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		BuyerDao dao= new BuyerrDaoImpl();
		
		System.out.println("Enter your Buyer Id (bid)");
		int bid= sc.nextInt();
		
		List<BuyItem> list = new ArrayList<>();
		
		try {
			list = dao.ShowBuyItems(bid);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Main.main(args);
		}
		
		return list;
	}
}
