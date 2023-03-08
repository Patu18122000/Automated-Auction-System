package com.model;

public class Buyer {
	private int bid;
	private String bname;
	private String bemail;
	private String bpassWord;
	
	public Buyer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Buyer(int bid, String bname, String bemail, String bpassWord) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.bemail = bemail;
		this.bpassWord = bpassWord;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getBemail() {
		return bemail;
	}

	public void setBemail(String bemail) {
		this.bemail = bemail;
	}

	public String getBpassWord() {
		return bpassWord;
	}

	public void setBpassWord(String bpassWord) {
		this.bpassWord = bpassWord;
	}

	@Override
	public String toString() {
		return "Buyer [bid=" + bid + ", bname=" + bname + ", bemail=" + bemail + ", bpassWord=" + bpassWord + "]";
	}

	
	
	
}
