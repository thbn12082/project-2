package com.thebinh.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

//import org.springframework.beans.factory.annotation.Autowired;
import com.thebinh.repository.BuildingRepository;
import com.thebinh.repository.entity.BuildingEntity;
@Repository
public class BuildingRepositoryImpl implements BuildingRepository{
	//@Autowired
	private static String url = "jdbc:mysql://localhost:3306/estatebasic?autoRecconect=true&useSSL=false";
    static final String username = "root";
    static final String password = "0281";
	@Override
	public ArrayList<BuildingEntity> findAll(String name) {
		String sql = "SELECT * FROM building WHERE name like '%" + name + "%'"; 
		ArrayList<BuildingEntity> arr = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(url, username, password);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);		
				){
			while(rs.next()){
				BuildingEntity y = new BuildingEntity();
					y.setName(rs.getString("name"));
					y.setStreet(rs.getString("street"));
					y.setWard(rs.getString("ward"));
					y.setNumberOfBasement(rs.getInt("numberOfBasement"));
					arr.add(y);
			}
		}catch(SQLException e) {
			e.printStackTrace();;
		}
		return arr;
	}

}
