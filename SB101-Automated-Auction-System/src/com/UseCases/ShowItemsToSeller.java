package com.UseCases;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.DAO.SellerDao;
import com.DAO.SellerDaoImpl;
import com.Main.Main;
import com.model.Items;

public class ShowItemsToSeller {
	public static List<Items> main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		SellerDao dao= new SellerDaoImpl();
		
		List<Items> list = new ArrayList<>();
		
		try {
			
			list= dao.ShowItemToSeller();
			
//			list.forEach(s->System.out.println(s));
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Main.main(args);
		}
		
		return list;
	}
}
