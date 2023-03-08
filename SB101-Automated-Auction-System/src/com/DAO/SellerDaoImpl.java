package com.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.DButil.Dbutil;
import com.Exception.ItemsException;
import com.Exception.SellerException;
import com.custome.ConsoleColour;
import com.model.BuyItem;
import com.model.Items;
import com.model.Seller;

public class SellerDaoImpl implements SellerDao {

	@Override
	public String RegisterSeller(Seller seller) throws SellerException {
		String msg= "Regestered failed !";
		
		try (Connection conn= Dbutil.ProvideConection()){
			
			PreparedStatement ps = conn.prepareStatement("insert into Seller(sname,semail,spassword) values(?,?,?)");
			
			ps.setString(1, seller.getsName());
			ps.setString(2, seller.getsEmail());
			ps.setString(3, seller.getsPassword());
			
			int result = ps.executeUpdate();
			
			if(result >0) {
				msg = "Seller Registered Sucessfully";
			}
			
		} catch (Exception e) {		
			System.out.println(e.getMessage());
		}
		
		return msg;
	}

	@Override
	public String LoginSeller(String email, String password) throws SellerException {
		String msg= "Login failed !";
		
		try (Connection conn= Dbutil.ProvideConection()){
			
			PreparedStatement ps1 = conn.prepareStatement("select sid from Seller where Semail = ? and Spassword = ?");
			ps1.setString(1, email);
			ps1.setString(2, password);
			
//			System.out.println("set STring pass ==================================");
			
			int sid= 0;
			
			ResultSet rs2= ps1.executeQuery();
			
//			System.out.println("Result set pass ==================================");
			
			while(rs2.next()) {
				sid= rs2.getInt("sid");
			}
			
			PreparedStatement ps = conn.prepareStatement("Select * from Seller where Semail = ? and Spassword = ?");
			
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				msg= "Login Successfull ...";
			}
			
			if(msg.equalsIgnoreCase("Login Successfull ...")) {
				System.out.println(ConsoleColour.CYAN+"Your Seller id is : "+ sid+ConsoleColour.RESET);
			}
			
		} catch (Exception e) {		
			System.out.println(e.getMessage());
		}
		
		return msg;	
	}

	@Override
	public String AddItemToSeller(Items items) throws SellerException, ItemsException {
		
		String msg = "Adding failed ! Something went Wrong ";
		
		try (Connection conn= Dbutil.ProvideConection()){
			
			PreparedStatement ps = conn.prepareStatement("insert into items (iname,iquantity,iprice,idate,sid) values (?,?,?,?,?)");
			
			ps.setString(1, items.getiName());
			ps.setInt(2, items.getiQuantity());
			ps.setInt(3, items.getiPrice());
			ps.setDate(4, items.getiDate());
			ps.setInt(5, items.getSid());
			
			int result = ps.executeUpdate();
			
			if(result >0) {
				msg = "Item Added Successfully";
			}
			
		} catch (Exception e) {		
			System.out.println(e.getMessage());
		}
		
		return msg;	
		
	}

	@Override
	public String UpdateItem(int price, int quantity, int iid) throws SellerException, ItemsException {
		String msg ="Updation Failed !";
		
		try (Connection conn= Dbutil.ProvideConection()){
			
			PreparedStatement ps = conn.prepareStatement("update items set iprice = ?,iquantity = ? where iid = ?");
			
			ps.setInt(1, price);
			ps.setInt(2, quantity);
			ps.setInt(3, iid);
			
			int result = ps.executeUpdate();
			
			if(result > 0) {
				msg = "Item Updated Successfully";
			}
			
		} catch (Exception e) {		
			System.out.println(e.getMessage());
		}
		
		return msg;	
		
	}

	@Override
	public String RemoveItemSeller(int iid) throws SellerException, ItemsException {
		String msg = "Failed to Remove !";
		
		try (Connection conn= Dbutil.ProvideConection()){
			
			PreparedStatement ps = conn.prepareStatement("delete from items where iid = ?");
			
			ps.setInt(1, iid);
			
			int result = ps.executeUpdate();
			
			if(result >0) {
				msg = "Item Removed Successfully";
			}
			
		} catch (Exception e) {		
			System.out.println(e.getMessage());
		}
		
		return msg;	
		
	}

	@Override
	public List<Items> ShowItemToSeller() throws SellerException {
		
		List<Items> list= new ArrayList<>();
		
		try (Connection conn= Dbutil.ProvideConection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from items");
			
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				int id= rs.getInt("iid");
				String name= rs.getString("iname");
				int price= rs.getInt("iprice");
				int quantity= rs.getInt("iquantity");
				Date idate= rs.getDate("idate");
				int sid= rs.getInt("sid");
				
				Items items = new Items(id, name, quantity, price, idate, sid);
				
				list.add(items);
			}
			
		} catch (Exception e) {		
			System.out.println(e.getMessage());
		}
		
		return list;
	}

}
