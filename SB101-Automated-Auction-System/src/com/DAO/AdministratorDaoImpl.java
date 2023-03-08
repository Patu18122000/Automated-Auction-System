package com.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.DButil.Dbutil;
import com.Exception.AdminException;
import com.model.BuyItem;
import com.model.Buyer;
import com.model.Seller;

public class AdministratorDaoImpl implements AdministratorDao {

	@Override
	public List<Buyer> viewBuyerList() throws AdminException {
		List<Buyer> list= new ArrayList<>();
		
		try (Connection conn= Dbutil.ProvideConection()){
			PreparedStatement ps = conn.prepareStatement("Select * from Buyer");
			
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				int bid = rs.getInt("bid");
				String bname = rs.getString("bname");
				String bemail = rs.getString("bemail");
				String bpassWord = rs.getString("bpassword");
				
				Buyer buyer= new Buyer(bid,bname,bemail,bpassWord);
				list.add(buyer);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return list;
	}

	@Override
	public List<Seller> viewSellerList() throws AdminException {
		List<Seller> list= new ArrayList<>();
		
		try (Connection conn= Dbutil.ProvideConection()){
			PreparedStatement ps = conn.prepareStatement("Select * from Seller");
			
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				int Sid = rs.getInt("Sid");
				String sName = rs.getString("sName");
				String sEmail = rs.getString("sEmail");
				String sPassWord = rs.getString("sPassWord");
				
				Seller Seller= new Seller(Sid,sName,sEmail,sPassWord);
				list.add(Seller);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return list;
	}

	@Override
	public List<BuyItem> viewDailySelling() throws AdminException {
		
		List<BuyItem> list = new ArrayList<>();
		
		try (Connection conn= Dbutil.ProvideConection()){
			PreparedStatement ps = conn.prepareStatement("select * from buyitem where bidate = curdate()");
			
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				int biid = rs.getInt("biid");
				String name= rs.getString("biname");
				int price = rs.getInt("biprice");
				int quantity = rs.getInt("biquantity");
				String bname= rs.getString("bibname");
				Date date= rs.getDate("bidate");
				int iid = rs.getInt("iid");
				int bid = rs.getInt("bid");
				
				BuyItem items = new BuyItem();
			
				items.setBiName(name);
				items.setBiPrice(price);
				items.setBiQuantity(quantity);
				items.setBibName(bname);
				items.setDate(date);
				items.setIid(iid);
				items.setBid(bid);
				
				list.add(items);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return list;
		
	}

	@Override
	public String AdminLogin(String username, String password) throws AdminException {
		
		String msg = "Admin Login Failed !..";
		
		try (Connection conn= Dbutil.ProvideConection()){
			PreparedStatement ps = conn.prepareStatement("select * from Admin where username = ? and password = ?");
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				msg= "Login Succesfull";
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return msg;
	}

}
