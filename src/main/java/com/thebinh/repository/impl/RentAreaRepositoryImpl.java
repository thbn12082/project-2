package com.thebinh.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.thebinh.repository.RentAreaRepository;
import com.thebinh.repository.entity.RentAreaEntity;
import com.thebinh.utils.ConnectionJDBCUtil;
@Repository	
public class RentAreaRepositoryImpl implements RentAreaRepository{
	
	@Override
	
	public ArrayList<RentAreaEntity> getValueByBuildingId(Long id) {
		String sql = "SELECT * FROM rentarea WHERE rentarea.buildingid = " + id +" ";
		ArrayList<RentAreaEntity> rentAreas = new ArrayList<>();
		try( Connection conn = ConnectionJDBCUtil.getConnect();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql)) {
			
			while(rs.next()) {
				RentAreaEntity areaEntity = new RentAreaEntity();
				areaEntity.setValue(rs.getString("value"));
				rentAreas.add(areaEntity);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return rentAreas;
	}

}
