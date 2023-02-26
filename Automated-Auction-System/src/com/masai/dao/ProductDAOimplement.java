package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.masai.exception.ProductException;
import com.masai.model.Product;
import com.utility.DButil;


public class ProductDAOimplement implements ProductDAO{

	@Override
	public String addProduct(Product product) throws ProductException {
		
		String str= "Product Not Added";
		
		try (Connection conn= DButil.provideConnection()){
			
			PreparedStatement statement = conn.prepareStatement("insert into product values(?,?,?,?)");
			
			statement.setInt(1, product.getProductId());
			statement.setString(2, product.getProductName());
			statement.setInt(3, product.getPrice());
			statement.setInt(4, product.getQuantity());
			
			int result = statement.executeUpdate();
			
			if(result>0) {
				str= "Product Added successfully";
			}
			
			return str;
			
		} catch (Exception e) {
			// TODO: handle exception
			str= e.getMessage();
		}
		
		return str;
	}

	@Override
	public List<Product> getAllProducts() throws ProductException {
		List<Product> list = new ArrayList<>();
		
		try (Connection conn= DButil.provideConnection()){
			
			PreparedStatement statement = conn.prepareStatement("select * from product");
			
			ResultSet rs= statement.executeQuery();
			while(rs.next()) {
				int productId = rs.getInt("productId");
				String productName = rs.getString("productName");
				int price = rs.getInt("price");
				int quantity = rs.getInt("quantity");
				
				Product product= new Product(productId,productName,price,quantity);
				
				list.add(product);
			}
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		if(list.size()==0) {
			throw new ProductException("the Product List is Empty");
		}
		
		return list;
		
	}

	@Override
	public List<Product> getAllProductQuantityLessThan(int quantity) throws ProductException {
		List<Product> list = new ArrayList<>();
		
		try (Connection conn= DButil.provideConnection()){
			
			PreparedStatement statement = conn.prepareStatement("select * from product where quantity < ?");
			statement.setInt(1, quantity);
			
			ResultSet rs= statement.executeQuery();
			
			while(rs.next()) {
				int productId = rs.getInt("productId");
				String productName = rs.getString("productName");
				int price = rs.getInt("price");
				int quant = rs.getInt("quantity");
				
				Product product= new Product(productId,productName,price,quant);
				
				list.add(product);
			}
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		if(list.size()==0) {
			throw new ProductException("No Product Found");
		}
		
//		System.out.println(list);
		
		return list;
		
	}

	@Override
	public String addProductQuantity(int productId, int Quantity) throws ProductException {
		
		String str= "Quantity Not Added";
		
		try(Connection conn= DButil.provideConnection()) {
			
			PreparedStatement statement= conn.prepareStatement("select quantity from product where productId=?");
			
			statement.setInt(1, productId);
			
			ResultSet rs = statement.executeQuery();
			
			if(rs.next()) {
				Quantity = Quantity +rs.getInt("quantity");
			}
			
			PreparedStatement statement1= conn.prepareStatement("Update product set quantity=? where productID=?");
			
			statement1.setInt(1, Quantity);
			statement1.setInt(2, productId);
			
			int result = statement1.executeUpdate();
			
			if(result>0) {
				str= "Quantity updated Successfully";
			}else {
				throw new ProductException("No Product found");
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		return str;
	}

	@Override
	public String deleteProductByProductName(String pname) throws ProductException {
		String str= "Product Not Deleted Succefully";
		
		try(Connection conn= DButil.provideConnection()) {
			
			PreparedStatement statement= conn.prepareStatement("delete from product where productName=?");
			
			statement.setString(1, pname);
			
			int result= statement.executeUpdate();
			
			if(result>0) {
				str= "Product Deleted Successfully";
			}else {
				throw new ProductException("No Product found");
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		return str;
		
}

	@Override
	public Product getProductByProductName(String pname) throws ProductException {
		Product product = null;
		
		try(Connection conn= DButil.provideConnection()) {
			
			PreparedStatement statement= conn.prepareStatement("select * from product where productName=?");
			
			statement.setString(1, pname);
			
			ResultSet rs= statement.executeQuery();
			
			if(rs.next()) {
				int productId = rs.getInt("productId");
				String productName = rs.getString("productName");
				int price = rs.getInt("price");
				int quant = rs.getInt("quantity");
				
				product= new Product(productId,productName,price,quant);
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		if(product==null) {
			throw new ProductException("There is no product of this Name");
		}
		
		return product;
		
	}

	@Override
	public String deleteProductWhoseNameStart(String pname) throws ProductException {
		
		String str= "Product Not Deleted Succefully";
		
		try(Connection conn= DButil.provideConnection()) {
			
			PreparedStatement statement= conn.prepareStatement("delete from product where productName=?%");
			
			statement.setString(1, pname);
			
			int result= statement.executeUpdate();
			
			if(result>0) {
				str= "Product Deleted Successfully";
			}else {
				throw new ProductException("No Product found");
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		return str;
	}	
}
