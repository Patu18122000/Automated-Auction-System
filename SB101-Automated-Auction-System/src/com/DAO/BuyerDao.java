package com.DAO;

import java.util.List;

import com.Exception.BuyerException;
import com.model.BuyItem;
import com.model.Buyer;
import com.model.Items;

public interface BuyerDao {

	public String RegisterBuyer(Buyer buyer) throws BuyerException;
	
	public String LonginBuyer(String email, String password) throws BuyerException;
	
	public List<Items> ShowItemstoBuyer() throws BuyerException;
	
	public String BuyItems(int bid, int sid) throws BuyerException;
	
	public List<BuyItem> ShowBuyItems(int bid) throws BuyerException;
}
