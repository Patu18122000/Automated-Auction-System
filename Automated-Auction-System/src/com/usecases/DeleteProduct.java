package com.usecases;

import java.util.Scanner;
import com.masai.dao.ProductDAO;
import com.masai.dao.ProductDAOimplement;
import com.masai.exception.ProductException;
public class DeleteProduct {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		ProductDAO p= new ProductDAOimplement();
		
		System.out.println("Enter Product Name");
		String productName= sc.next();
		
		try {
			
			String str= p.deleteProductByProductName(productName);
			
			System.out.println(str);
			
		} catch (ProductException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			
		}
		
		sc.close();
	}
}
