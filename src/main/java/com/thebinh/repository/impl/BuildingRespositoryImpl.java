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
import com.thebinh.utils.NumberUtil;
import com.thebinh.utils.StringUtil;
@Repository
public class BuildingRespositoryImpl implements BuildingRespository{
	private static String url = "jdbc:mysql://localhost:3306/estatebasic?autoRecconect=true&useSSL=false";
    static final String username = "root";
    static final String password = "0281";
    
    public static void joinTable(Map<String, Object> params, ArrayList<String> typecode, StringBuilder sql) {
		String staffid = (String)params.get("staffid");
		if(StringUtil.checkString((staffid))) {
			sql.append(" INNER JOIN assignmentbuilding ON b.id = assignmentbuilding.buildingid ");
		}
		
		if(typecode != null && typecode.size() != 0) {
			sql.append(" INNER JOIN buildingrenttype ON b.id = buildingrenttype.buildingid ");
			sql.append(" INNER JOIN renttype ON renttype.id = buildingrenttype.renttypeid ");
		}
		
		String rentareafrom = (String)params.get("areafrom");
		String rentareato = (String)params.get("areato");
		if(StringUtil.checkString(rentareafrom) == true || StringUtil.checkString(rentareato) == true) {
			sql.append(" INNER JOIN rentarea ON b.id = rentarea.buildingid ");
		}
	}
    
        
    
    public static void queryNormal(Map<String, Object> params, StringBuilder where) {
		for(Map.Entry<String, Object> it : params.entrySet()) {
			if(!it.getKey().equals("staffid") && !it.getKey().equals("typecode") && !it.getKey().startsWith("area") && !it.getKey().startsWith("rentprice")) {
				String value = (String)it.getValue();
				if(StringUtil.checkString(value)) {
					if(NumberUtil.checkNumber(value)) {
						where.append(" AND b." + it.getKey() +" = " + value +" ");
					}
					else {
						where.append(" AND b." + it.getKey() +" like '%" + value  +"%' ");
					}
				}
			}
		}
	}
    
    
    public static void querySpecial(Map<String, Object> params, ArrayList<String> typecode, StringBuilder where) {
		String StaffId = (String)params.get("staffid");
		if(StringUtil.checkString(StaffId)) {
			where.append(" AND assignmentbuilding.staffid = " + StaffId +" ");
		}
		
		
		//java 7 
		if(typecode != null && typecode.size() != 0) {
			ArrayList<String> code = new ArrayList<>();
			for(String it : typecode) {
				code.add("'" + it + "'");
			}
			where.append(" AND renttype.code IN (" + String.join(" , ", code) + ") ");
		}
		
		String rentareafrom = (String)params.get("areafrom");
		String rentareato = (String)params.get("areato");
		if(StringUtil.checkString(rentareafrom) == true ) {
			//Long from = Long.parseLong(rentareafrom);
			where.append(" AND rentarea.value >= " + rentareafrom +" " );
		}
		
		if(StringUtil.checkString(rentareato) == true ) {
			//Long to = Long.parseLong(rentareato);
			where.append(" AND rentarea.value <= " + rentareato +" " );
		}		
		
		String rentpricefrom = (String)params.get("pricefrom");
		String rentpriceto =  (String)params.get("priceto");
		if(StringUtil.checkString(rentpricefrom) == true ) {
			//Long rfrom = Long.parseLong(rentpricefrom);
			where.append(" AND rentprice >= " + rentpricefrom +" " );
		}
		
		if(StringUtil.checkString(rentpriceto) == true ) {
			//Long rto = Long.parseLong(rentpriceto);
			where.append(" AND rentprice <= " + rentpriceto +" " );
		}		
		
	}
    
	@Override
//b.id, b.name, b.districtid, b.street, b.districtid, b.numberofbasement, b.floorarea, b.rentprice, b.managername, b.managerphonenumber,b.servicefee,b.brokeragefee
	public ArrayList<BuildingEntity> findAll(Map<String, Object> params, ArrayList<String> typecode) {
		StringBuilder sql = new StringBuilder("SELECT * FROM building b");
		joinTable(params, typecode, sql);
		StringBuilder where = new StringBuilder(" WHERE 1 = 1 ");
		queryNormal(params, where);
		querySpecial(params, typecode, where);
		where.append(" GROUP BY b.id;");
		sql.append(where);
		ArrayList<BuildingEntity> arr = new ArrayList<>();		
		try(Connection conn = DriverManager.getConnection(url, username, password);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql.toString());){
			while(rs.next()) {
				BuildingEntity y = new BuildingEntity();
				y.setId(rs.getLong("b.id"));
				y.setName(rs.getString("b.name"));
				y.setWard(rs.getString("b.ward"));
				y.setDistrictid(rs.getLong("b.districtid"));
				y.setStreet(rs.getString("b.street"));
				y.setFloorarea(rs.getInt("b.floorarea"));
				y.setRentprice(rs.getInt("b.rentprice"));
				y.setServicefee(rs.getString("b.servicefee"));
				y.setBrokeragefee(rs.getLong("b.brokeragefee"));
				y.setManagername(rs.getString("b.managername"));
				y.setManagerphonenumber(rs.getString("b.managerphonenumber"));
				
				arr.add(y);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return arr;
	}
}