package com.thebinh.repository.impl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

//import com.mysql.cj.Query;
import com.thebinh.builder.BuildingSearchBuilder;
import com.thebinh.repository.BuildingRepository;
import com.thebinh.repository.entity.BuildingEntity;

@Repository
//@Transactional
public class JDBCBuildingRespositoryImpl implements BuildingRepository {
	@PersistenceContext
	private EntityManager entityManager;
	
	/*@Value("${spring.datasource.url}")
	private  String url;

	@Value("${spring.datasource.username}")
	private  String username;

	@Value("${spring.datasource.password}")
	private  String password;*/

	public static void joinTable(BuildingSearchBuilder buildingSearchBuilder, StringBuilder sql) {
		Long staffid = buildingSearchBuilder.getStaffId();
		if (staffid != null) {
			sql.append(" INNER JOIN assignmentbuilding ON b.id = assignmentbuilding.buildingid ");
		}
		ArrayList<String> typecode = buildingSearchBuilder.getTypeCode();
		if (typecode != null && typecode.size() != 0) {
			sql.append(" INNER JOIN buildingrenttype ON b.id = buildingrenttype.buildingid ");
			sql.append(" INNER JOIN renttype ON renttype.id = buildingrenttype.renttypeid ");
		}

		Long rentareafrom = buildingSearchBuilder.getAreaFrom();
		Long rentareato = buildingSearchBuilder.getAreaTo();

		if (rentareafrom != null || rentareato != null) {
			sql.append(" INNER JOIN rentarea ON b.id = rentarea.buildingid ");
		}
	}

	public static void queryNormal(BuildingSearchBuilder buildingSearchBuilder, StringBuilder where) {
		try {
			Field[] fields = BuildingSearchBuilder.class.getDeclaredFields();
			for (Field item : fields) {
				item.setAccessible(true);
				String fieldName = item.getName();
				if (!fieldName.equals("staffid") && !fieldName.equals("typecode") && !fieldName.startsWith("area")
						&& !fieldName.startsWith("rentprice")) {
					Object value = item.get(buildingSearchBuilder);
					if (value != null) {

						if (item.getType().getName().equals("java.lang.Long")) {
							where.append(" AND b." + fieldName + " = " + value + " ");
						} else if (item.getType().getName().equals("java.Lang.String")) {
							where.append(" AND b." + fieldName + " like '%" + value + "%' ");
						}
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void querySpecial(BuildingSearchBuilder buildingSearchBuilder, StringBuilder where) {
		Long staffid = Long.valueOf(buildingSearchBuilder.getStaffId());
		if (staffid != null) {
			where.append(" AND assignmentbuilding.staffid = " + staffid + " ");
		}

		// java 7
		if (buildingSearchBuilder.getTypeCode() != null && buildingSearchBuilder.getTypeCode().size() != 0) {
			List<String> code = new ArrayList<>();
			List<String> typecode = buildingSearchBuilder.getTypeCode();
			for (String it : typecode) {
				code.add("'" + it + "'");
			}
			where.append(" AND renttype.code IN (" + String.join(" , ", code) + ") ");
		}

		// (String)params.get("areafrom")
		Long rentareafrom = buildingSearchBuilder.getAreaFrom();
		Long rentareato = buildingSearchBuilder.getAreaTo();
		// (String)params.get("areato")

		if (rentareafrom != null) {
			// Long from = Long.parseLong(rentareafrom);
			where.append(" AND rentarea.value >= " + rentareafrom + " ");
		}

		if (rentareato != null) {
			// Long to = Long.parseLong(rentareato);
			where.append(" AND rentarea.value <= " + rentareato + " ");
		}

		// (String)params.get("pricefrom")
		// (String)params.get("priceto")

		Long rentpricefrom = buildingSearchBuilder.getRentPriceFrom();
		Long rentpriceto = buildingSearchBuilder.getRentPriceTo();
		if (rentpricefrom != null) {
			// Long rfrom = Long.parseLong(rentpricefrom);
			where.append(" AND rentprice >= " + rentpricefrom + " ");
		}

		if (rentpriceto != null) {
			// Long rto = Long.parseLong(rentpriceto);
			where.append(" AND rentprice <= " + rentpriceto + " ");
		}

	}

	@Override
//b.id, b.name, b.districtid, b.street, b.districtid, b.numberofbasement, b.floorarea, b.rentprice, b.managername, b.managerphonenumber,b.servicefee,b.brokeragefee
	public List<BuildingEntity> findAll(BuildingSearchBuilder buildingSearchBuilder) {
		StringBuilder sql = new StringBuilder("SELECT * FROM building b");
		joinTable(buildingSearchBuilder, sql);
		StringBuilder where = new StringBuilder(" WHERE 1 = 1 ");
		queryNormal(buildingSearchBuilder, where);
		querySpecial(buildingSearchBuilder, where);
		where.append(" GROUP BY b.id;");
		sql.append(where);
		/*List<BuildingEntity> arr = new ArrayList<>();
		try (Connection conn = ConnectionJDBCUtil.getConnect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql.toString());) {
			while (rs.next()) {
				BuildingEntity y = new BuildingEntity();
				y.setId(rs.getLong("b.id"));
				y.setName(rs.getString("b.name"));
				y.setWard(rs.getString("b.ward"));
				//y.setDistrictid(rs.getLong("b.districtid"));
				y.setStreet(rs.getString("b.street"));
				y.setFloorarea(rs.getLong("b.floorarea"));
				y.setRentprice(rs.getLong("b.rentprice"));
				y.setServicefee(rs.getString("b.servicefee"));
				y.setBrokeragefee(rs.getLong("b.brokeragefee"));
				y.setManagername(rs.getString("b.managername"));
				y.setManagerphonenumber(rs.getString("b.managerphonenumber"));

				arr.add(y);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		Query query = entityManager.createNativeQuery(sql.toString(), BuildingEntity.class);
		return query.getResultList();
	}
	
	
	
	
	
}