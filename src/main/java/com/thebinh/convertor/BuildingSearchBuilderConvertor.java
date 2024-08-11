package com.thebinh.convertor;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.thebinh.builder.BuildingSearchBuilder;
import com.thebinh.utils.MapUtil;


@Component

public class BuildingSearchBuilderConvertor {
	public BuildingSearchBuilder toBuildingSearchBuilder(Map<String, Object> params, ArrayList<String> typecode) {
		BuildingSearchBuilder buildingSearchBuilder = new BuildingSearchBuilder.Builder()
																						 .setName(MapUtil.getObject(params,"name" , String.class))
																						 .setFloorArea(MapUtil.getObject(params, "floorarea", Long.class))
																						 .setWard(MapUtil.getObject(params, "ward", String.class))
																						 .setStreet(MapUtil.getObject(params,"street" ,String.class))
																						 .setDistrictcode(MapUtil.getObject(params, "districtid", Long.class))
																						 .setNumberOfBasement(MapUtil.getObject(params, "numberOfBasement", Integer.class))
																						 .setManagerName(MapUtil.getObject(params,"managerName" , String.class))
																						 .setManagerPhoneNumber(MapUtil.getObject(params, "managerPhoneNumber", String.class))
																						 .setRentPriceFrom(MapUtil.getObject(params, "priceFrom", Long.class))
																						 .setRentPriceTo(MapUtil.getObject(params, "priceTo", Long.class))
																						 .setAreaFrom(MapUtil.getObject(params, "areafrom", Long.class))
																						 .setAreaTo(MapUtil.getObject(params, "areato", Long.class))
																						 .setStaffId(MapUtil.getObject(params, "staffid",Long.class))
																						 .setTypeCode(typecode)
																						 .build();
		/// nguyễn thế bình
		return buildingSearchBuilder;
	}
}