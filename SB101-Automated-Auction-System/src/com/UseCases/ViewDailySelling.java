package com.UseCases;

import java.util.List;
import java.util.Scanner;

import com.DAO.AdministratorDao;
import com.DAO.AdministratorDaoImpl;
import com.model.BuyItem;

public class ViewDailySelling {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		AdministratorDao dao = new AdministratorDaoImpl();
		
		try {
			
			List<BuyItem> list = dao.viewDailySelling();
			
			list.forEach(s -> System.out.println(s));
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		sc.close();
	}
}
