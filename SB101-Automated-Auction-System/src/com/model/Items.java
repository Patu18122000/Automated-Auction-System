

package com.model;

import java.sql.Date;

public class Items {
	private int iid;
	private String iName;
	private int iPrice;
	private int iQuantity;
	private Date iDate;
	private int sid;
	
	public Items() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Items(int iid, String iName, int iQuantity, int iPrice, Date iDate, int sid) {
		super();
		this.iid = iid;
		this.iName = iName;
		this.iQuantity = iQuantity;
		this.iPrice = iPrice;
		this.iDate = iDate;
		this.sid = sid;
	}

	public int getIid() {
		return iid;
	}

	public void setIid(int iid) {
		this.iid = iid;
	}

	public String getiName() {
		return iName;
	}

	public void setiName(String iName) {
		this.iName = iName;
	}

	public int getiQuantity() {
		return iQuantity;
	}

	public void setiQuantity(int iQuantity) {
		this.iQuantity = iQuantity;
	}

	public int getiPrice() {
		return iPrice;
	}

	public void setiPrice(int iPrice) {
		this.iPrice = iPrice;
	}

	public Date getiDate() {
		return iDate;
	}

	public void setiDate(Date iDate) {
		this.iDate = iDate;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	@Override
	public String toString() {
		return "Items [iid=" + iid + ", iName=" + iName + ", iPrice=" + iPrice + ", iQuantity=" + iQuantity + ", iDate="
				+ iDate + ", sid=" + sid + "]";
	}

	
	
	
	
}
