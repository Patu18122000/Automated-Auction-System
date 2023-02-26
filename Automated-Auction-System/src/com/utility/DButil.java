package com.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DButil {
	public static Connection provideConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String url= "jdbc:mysql://localhost/sb101_c4";
		
		Connection conn=null;
		
		try {
			conn = DriverManager.getConnection(url,"root","1812");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
