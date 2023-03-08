package com.DButil;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dbutil {

	public static Connection ProvideConection() {
		Connection conn= null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String url= "jdbc:mysql://localhost/SB101_Project_AAS";
		String userName="root";
		String password="1812";
		
		try {
			conn= DriverManager.getConnection(url, userName, password);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
}
