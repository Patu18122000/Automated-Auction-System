package com.usecases;

import java.util.Scanner;

import com.masai.dao.ProductDAO;
import com.masai.dao.ProductDAOimplement;
import com.masai.exception.ProductException;
import com.masai.model.Product;

public class ProductByName {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		ProductDAO p= new ProductDAOimplement();
		
		System.out.println("Enter Product Name");
		String productName= sc.next();
		
		try {
			
			Product product = p.getProductByProductName(productName);
			
			System.out.println(product);
			
		} catch (ProductException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			
		}
		
		sc.close();
	}
}
