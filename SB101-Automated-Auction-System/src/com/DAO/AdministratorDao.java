package com.DAO;

import java.util.List;

import com.Exception.AdminException;
import com.model.BuyItem;
import com.model.Buyer;
import com.model.Seller;

public interface AdministratorDao {
	public String AdminLogin(String username, String password) throws AdminException;
	
	public List<Buyer> viewBuyerList() throws AdminException;
	
	public List<Seller> viewSellerList() throws AdminException;
	
	public List<BuyItem> viewDailySelling() throws AdminException;
	
}
