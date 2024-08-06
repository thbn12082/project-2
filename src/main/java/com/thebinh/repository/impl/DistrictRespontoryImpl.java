package com.thebinh.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;
import com.thebinh.repository.BuildingRespository;
import com.thebinh.repository.DistrictRespontory;
import com.thebinh.repository.entity.DistrictEntity;

@Repository
public class DistrictRespontoryImpl implements DistrictRespontory{
	
	private static String url = "jdbc:mysql://localhost:3306/estatebasic?autoRecconect=true&useSSL=false";
	final static String username = "root";
	final static String password = "0281";
	
	
	@Autowired
	private BuildingRespository building;
	
	@Override

	public DistrictEntity findNameById(Long id)  {
		String sql ="SELECT name FROM district WHERE id = " + id +";";
		DistrictEntity district = new DistrictEntity();
		try(Connection conn = DriverManager.getConnection(url, username, password);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql)){
			
			while(rs.next()) {
				district.setName(rs.getString("name"));
			}
				
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return district;
	}
}
