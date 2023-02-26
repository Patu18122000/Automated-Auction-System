package com.usecases;

import java.util.Scanner;

import com.masai.dao.ProductDAO;
import com.masai.dao.ProductDAOimplement;
import com.masai.exception.ProductException;
import com.masai.model.Product;


public class AddProduct {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		ProductDAO p= new ProductDAOimplement();
		
		System.out.println("Add Product Details");
		System.out.println("Enter ProductID");
		int productId= sc.nextInt();
		System.out.println("Enter Product Name");
		String productName= sc.next();
		System.out.println("Enter Product  Price");
		int price= sc.nextInt();
		System.out.println("Enter Product Quantity");
		int quantity= sc.nextInt();
		
		Product product= new Product(productId,productName,price,quantity);
		
//		System.out.println(product);
		
		try {
			
			String str= p.addProduct(product);
			
			System.out.println(str);
			
		} catch (ProductException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			
		}
		
		sc.close();
	}
	
}
