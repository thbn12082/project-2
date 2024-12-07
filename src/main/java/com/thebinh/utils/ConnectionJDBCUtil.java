package com.thebinh.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJDBCUtil {
	    static final String url = "jdbc:mysql://localhost:3306/estatebasic?autoRecconect=true&useSSL=false";
		static final String username = "root";
		static final String password = "0281";
		
		
		
		public static Connection getConnect() {
			Connection conn;
			 try{
			     conn = DriverManager.getConnection(url, username, password);
			     return conn;
			 }
			 catch(SQLException e) {
				 e.printStackTrace();
				 return null;
			 }
		}
}
