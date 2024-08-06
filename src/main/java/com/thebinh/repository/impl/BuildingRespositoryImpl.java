package com.thebinh.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.stereotype.Repository;
import com.thebinh.repository.BuildingRespository;
import com.thebinh.repository.entity.BuildingEntity;
@Repository
public class BuildingRespositoryImpl implements BuildingRespository{
	private static String url = "jdbc:mysql://localhost:3306/estatebasic?autoRecconect=true&useSSL=false";
    static final String username = "root";
    static final String password = "0281";
    
    
	@Override

	public ArrayList<BuildingEntity> findAll(Map<String, Object> params) {
		StringBuilder sql = new StringBuilder("SELECT * FROM building WHERE 1 = 1 ");
		
		
		ArrayList<BuildingEntity> arr = new ArrayList<>();
		
	
		try(Connection conn = DriverManager.getConnection(url, username, password);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql.toString());){
			while(rs.next()) {
				BuildingEntity y = new BuildingEntity();
				y.setName(rs.getString("name"));
				y.setFloorarea(rs.getInt("floorarea"));
				y.setWard(rs.getString("ward"));
				y.setStreet(rs.getString("street"));
				y.setNumberofbasement(rs.getInt("numberofbasement"));
				y.setDirection(rs.getString("direction"));
				y.setLevel(rs.getString("level"));
				y.setRentprice(rs.getInt("rentprice"));
				y.setManagername(rs.getString("managername"));
				y.setManagerphonenumber(rs.getString("managerphonenumber"));
				arr.add(y);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return arr;
	}
}