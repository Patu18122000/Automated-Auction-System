package com.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.DButil.Dbutil;
import com.Exception.BuyerException;
import com.custome.ConsoleColour;
import com.model.BuyItem;
import com.model.Buyer;
import com.model.Items;

public class BuyerrDaoImpl implements BuyerDao {

	@Override
	public String RegisterBuyer(Buyer buyer) throws BuyerException {
		String msg= "Regestered failed !";
		
		try (Connection conn= Dbutil.ProvideConection()){
			
			PreparedStatement ps = conn.prepareStatement("insert into Buyer(bname,bemail,bpassword) values(?,?,?)");
			
			ps.setString(1, buyer.getBname());
			ps.setString(2, buyer.getBemail());
			ps.setString(3, buyer.getBpassWord());
			
			int result = ps.executeUpdate();
			
			if(result >0) {
				msg = "Buyer Registered Sucessfully";
			}
			
		} catch (Exception e) {		
			System.out.println(e.getMessage());
		}
		
		return msg;
	}

	@Override
	public String LonginBuyer(String email, String password) throws BuyerException {
		String msg= "Login failed !";
		
		try (Connection conn= Dbutil.ProvideConection()){
			
			PreparedStatement ps1 = conn.prepareStatement("select bid from buyer where bemail = ? and bpassword = ?");
			ps1.setString(1, email);
			ps1.setString(2, password);
			
//			System.out.println("set STring pass ==================================");
			
			int bid= 0;
			
			ResultSet rs2= ps1.executeQuery();
			
//			System.out.println("Result set pass ==================================");
			
			while(rs2.next()) {
				bid= rs2.getInt("bid");
			}
			
//			System.out.println("while loop pass ==================================");
			
			PreparedStatement ps = conn.prepareStatement("select * from buyer where bemail = ? and bpassword = ?");
			
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				msg= "Login Successfull ...";
			}
			
			if(msg.equalsIgnoreCase("Login Successfull ...")) {
				System.out.println(ConsoleColour.CYAN+"Your Buyer id is : "+ bid+ConsoleColour.RESET);
			}
			
		} catch (Exception e) {		
			System.out.println(e.getMessage());
		}
		
		return msg;
	}

	@Override
	public List<Items> ShowItemstoBuyer() throws BuyerException {
		
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

	@Override
	public String BuyItems(int bid, int iid) throws BuyerException {
		
		String msg= "Something went Wrong !";
		
		try (Connection conn= Dbutil.ProvideConection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from items");
			
			String biname = null;
			int biprice =0;
			int biquantity=0;
			Date bidate = null;
			int sid=0;
			
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				biname= rs.getString("iname");
				biprice = rs.getInt("iprice");
				biquantity = rs.getInt("iquantity");
				bidate = rs.getDate("idate");
				sid= rs.getInt("sid");
			}
			
			
			
			PreparedStatement ps1= conn.prepareStatement("select bname from buyer where bid=?");
			ps1.setInt(1, bid);
			
			ResultSet rs2= ps1.executeQuery();
			
			String bibname= null;
			while(rs2.next()) {
				bibname= rs2.getString("Bname");				
			}
			
			PreparedStatement ps2= conn.prepareStatement("insert into Buyitem(biname,biprice,biquantity,bibname,bidate,iid,bid) values(?,?,?,?,?,?,?)");
			
			ps2.setString(1, biname);
			ps2.setInt(2, biprice);
			ps2.setInt(3, biquantity);
			ps2.setString(4, bibname);
			ps2.setDate(5, bidate);
			ps2.setInt(6, iid);
			ps2.setInt(7, bid);
			
			int result = ps2.executeUpdate();
			
			if(result >0) {
				msg = "Item Buyed Sucessfully";
			}
			
//			System.out.println(biname+" "+biprice+" "+biquantity+" "+bibname+" "+bidate+" "+iid);
			
		} catch (Exception e) {		
			System.out.println(e.getMessage());
		}
		
		
		return msg;
		
	}

	@Override
	public List<BuyItem> ShowBuyItems(int bid) throws BuyerException {
		
		List<BuyItem> list= new ArrayList<>(); 
		
		
		try (Connection conn= Dbutil.ProvideConection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from buyitem where bid=?");
			ps.setInt(1, bid);
			
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				int biid = rs.getInt("biid");
				String name= rs.getString("biname");
				int price = rs.getInt("biprice");
				int quantity = rs.getInt("biquantity");
				String bname= rs.getString("bibname");
				Date date= rs.getDate("bidate");
				int iid = rs.getInt("iid");
				int buyerid= rs.getInt("bid");
				
				BuyItem items = new BuyItem();
			
				items.setBiName(name);
				items.setBiPrice(price);
				items.setBiQuantity(quantity);
				items.setBibName(bname);
				items.setDate(date);
				items.setIid(iid);
				items.setBid(buyerid);
				list.add(items);
				
			}
			
			
		} catch (Exception e) {		
			System.out.println(e.getMessage());
		}
		
		return list;
	}

}
