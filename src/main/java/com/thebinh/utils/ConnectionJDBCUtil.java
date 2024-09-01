package com.thebinh.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;


@PropertySource("classpath:application-uat.properties")
public class ConnectionJDBCUtil {
	@Value("${spring.datasource.url}")
	    static String url;
	
	
	@Value("${spring.datasource.username}")
		static String username;
	
	@Value("${spring.datasource.password}")
		static String password ;
		
		
		
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
