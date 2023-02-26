package com.usecases;

import java.util.List;
import java.util.Scanner;

import com.masai.dao.ProductDAO;
import com.masai.dao.ProductDAOimplement;
import com.masai.exception.ProductException;
import com.masai.model.Product;

public class getProductsByQuantity {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		ProductDAO p= new ProductDAOimplement();
		
		System.out.println("Enter Product Quantity");
		int quantity= sc.nextInt();
		
		try {
			List<Product> list = p.getAllProductQuantityLessThan(quantity);
			
			list.forEach(s -> System.out.println(s));
		} catch (ProductException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		sc.close();
	}
}
