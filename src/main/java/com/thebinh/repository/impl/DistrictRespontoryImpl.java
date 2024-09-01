package com.thebinh.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;
import com.thebinh.repository.BuildingRepository;
import com.thebinh.repository.DistrictRepontory;
import com.thebinh.repository.entity.DistrictEntity;
import com.thebinh.utils.ConnectionJDBCUtil;

@Repository
public class DistrictRespontoryImpl implements DistrictRepontory{
	@Autowired
	private BuildingRepository building;
	
	@Override

	public DistrictEntity findNameById(Long id)  {
		String sql ="SELECT name FROM district WHERE id = " + id +";";
		DistrictEntity district = new DistrictEntity();
		try(Connection conn = ConnectionJDBCUtil.getConnect();
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
