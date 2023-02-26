package com.usecases;

import java.util.Scanner;

import com.masai.dao.ProductDAO;
import com.masai.dao.ProductDAOimplement;
import com.masai.exception.ProductException;

public class addQuantity {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		ProductDAO p= new ProductDAOimplement();
		
		System.out.println("Enter ProductID");
		int productId= sc.nextInt();
		System.out.println("Enter Product Quantity");
		int quantity= sc.nextInt();
		
		try {
			
			String str= p.addProductQuantity(productId, quantity);
			
			System.out.println(str);
			
		} catch (ProductException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			
		}
		
		sc.close();
	}
}
