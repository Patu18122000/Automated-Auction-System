package com.model;

import java.sql.Date;

public class BuyItem {
	
	private String biName;
	private int biPrice;
	private int biQuantity;
	private String bibName;
	private Date Date;
	private int iid;
	private int bid;
	
	public BuyItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BuyItem(String biName, int biPrice, int biQuantity, String bibName, java.sql.Date date, int iid, int bid) {
		super();
		this.biName = biName;
		this.biPrice = biPrice;
		this.biQuantity = biQuantity;
		this.bibName = bibName;
		Date = date;
		this.iid = iid;
		this.bid = bid;
	}

	public String getBiName() {
		return biName;
	}

	public void setBiName(String biName) {
		this.biName = biName;
	}

	public int getBiPrice() {
		return biPrice;
	}

	public void setBiPrice(int biPrice) {
		this.biPrice = biPrice;
	}

	public int getBiQuantity() {
		return biQuantity;
	}

	public void setBiQuantity(int biQuantity) {
		this.biQuantity = biQuantity;
	}

	public String getBibName() {
		return bibName;
	}

	public void setBibName(String bibName) {
		this.bibName = bibName;
	}

	public Date getDate() {
		return Date;
	}

	public void setDate(Date date) {
		Date = date;
	}

	public int getIid() {
		return iid;
	}

	public void setIid(int iid) {
		this.iid = iid;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	@Override
	public String toString() {
		return "BuyItem [biName=" + biName + ", biPrice=" + biPrice + ", biQuantity=" + biQuantity + ", bibName="
				+ bibName + ", Date=" + Date + ", iid=" + iid + ", bid=" + bid + "]";
	}

	
	
}
