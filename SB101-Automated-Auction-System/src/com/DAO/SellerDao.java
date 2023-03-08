package com.DAO;

import java.util.List;

import com.Exception.ItemsException;
import com.Exception.SellerException;
import com.model.BuyItem;
import com.model.Items;
import com.model.Seller;

public interface SellerDao {

	public String RegisterSeller(Seller seller) throws SellerException;

	public String LoginSeller (String email, String password) throws SellerException;
	
	public String AddItemToSeller(Items items)throws SellerException,ItemsException;
	
	public String UpdateItem(int price, int quantity, int iid)throws SellerException,ItemsException;
	
	public String RemoveItemSeller(int iid) throws SellerException,ItemsException;
	
	public List<Items> ShowItemToSeller() throws SellerException;
	
}
