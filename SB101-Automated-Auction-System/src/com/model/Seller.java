package com.model;

public class Seller {
	private int Sid;
	private String sName;
	private String sEmail;
	private String sPassword;
	
	public Seller() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Seller(int Sid,String sName, String sEmail, String sPassword) {
		super();
		this.Sid= Sid;
		this.sName = sName;
		this.sEmail = sEmail;
		this.sPassword = sPassword;
	}

	public int getSid() {
		return Sid;
	}

	public void setSid(int sid) {
		Sid = sid;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsEmail() {
		return sEmail;
	}

	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}

	public String getsPassword() {
		return sPassword;
	}

	public void setsPassword(String sPassword) {
		this.sPassword = sPassword;
	}

	@Override
	public String toString() {
		return "Seller [Sid=" + Sid + ", sName=" + sName + ", sEmail=" + sEmail + ", sPassword=" + sPassword + "]";
	}

	
	
	
	
}
