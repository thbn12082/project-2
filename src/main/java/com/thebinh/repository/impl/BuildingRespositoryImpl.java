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
		String staffid = params.get("staffid").toString();
		if(StringUtil.checkString((staffid))) {
			sql.append(" INNER JOIN assignmentbuilding "
					+ "ON id = assignmentbuilding.buildingid ");
		}
		
		if(typecode != null && typecode.size() != 0) {
			sql.append(" INNER JOIN buildingrenttype "
					+   "ON id = buildingrenttype.buildingid ");
			sql.append(" INNER JOIN renttype "
					+   "ON renttype.id = buildingrenttype.renttypeid ");
		}
		
		String rentareafrom = params.get("areafrom").toString();
		String rentareato = params.get("areato").toString();
		if(StringUtil.checkString(rentareafrom) == true || StringUtil.checkString(rentareato) == true) {
			sql.append(" INNER JOIN rentarea "
					+  " ON id = rentarea.buildingid");
		}
	}
    
        
    
    public static void queryNormal(Map<String, Object> params, StringBuilder where) {
		for(Map.Entry<String, Object> it : params.entrySet()) {
			if(!it.getKey().equals("staffid") && !it.getKey().equals("typecode") && !it.getKey().startsWith("area") && !it.getKey().startsWith("rentprice")) {
				String value = it.getValue().toString();
				if(StringUtil.checkString(value)) {
					if(NumberUtil.checkNumber(value)) {
						where.append(" AND " + it.getKey() +" = " + value +" ");
					}
					else {
						where.append(" AND " + it.getKey() +" like '%" + value  +"%' ");
					}
				}
			}
		}
	}
    
    
    public static void querySpecial(Map<String, Object> params, ArrayList<String> typecode, StringBuilder where) {
		String StaffId = (String)params.get("staffid");
		if(StringUtil.checkString(StaffId)) {
			where.append(" AND assignmentbuiding.staffid = " + StaffId +" ");
		}
		
		if(typecode != null && typecode.size() != 0) {
			for(String it : typecode) {
				where.append(" AND renttype.code IN (" + String.join(" , ", typecode) + ") ");
			}
		}
		
		String rentareafrom = params.get("areafrom").toString();
		String rentareato = params.get("areato").toString();
		if(StringUtil.checkString(rentareafrom) == true ) {
			Long from = Long.parseLong(rentareafrom);
			where.append(" AND rentarea.value >= " + from +" " );
		}
		
		if(StringUtil.checkString(rentareato) == true ) {
			Long to = Long.parseLong(rentareato);
			where.append(" AND rentarea.value <= " + to +" " );
		}		
		
		String rentpricefrom = params.get("pricefrom").toString();
		String rentpriceto = params.get("priceto").toString();
		if(StringUtil.checkString(rentpricefrom) == true ) {
			Long rfrom = Long.parseLong(rentpricefrom);
			where.append(" AND rentprice >= " + rfrom +" " );
		}
		
		if(StringUtil.checkString(rentpriceto) == true ) {
			Long rto = Long.parseLong(rentpriceto);
			where.append(" AND rentprice <= " + rto +" " );
		}		
		
	}
    
	@Override

	public ArrayList<BuildingEntity> findAll(Map<String, Object> params, ArrayList<String> typecode) {
		StringBuilder sql = new StringBuilder("SELECT id, name, districtid, street, districtid, numberofbasement, floorarea, rentprice, managername, managerphonenumber, "
				+ "servicefee,brokeragefee FROM building ");
		
		StringBuilder where = new StringBuilder(" WHERE 1 = 1 ");
		
		joinTable(params, typecode, sql);
		queryNormal(params, where);
		querySpecial(params, typecode, where);
		where.append(" GROUP BY id;");
		sql.append(where);
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