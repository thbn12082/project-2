package com.thebinh.service.impl;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thebinh.model.BuildingDTO;
import com.thebinh.repository.BuildingRespository;
import com.thebinh.repository.DistrictRespontory;
import com.thebinh.repository.entity.BuildingEntity;
import com.thebinh.repository.entity.DistrictEntity;
import com.thebinh.service.BuildingService;

@Service

// đây là tầng xử lý dữ liệu theo yêu cầu của client

public class BuildingServiceImpl implements BuildingService{
	@Autowired
    private BuildingRespository buildingRepository;
	
	@Autowired
    private DistrictRespontory districtRepository;
	
	
	@Override
	public ArrayList<BuildingDTO> findAll(Map<String, Object> params, ArrayList<String> typecode) {
		ArrayList<BuildingEntity> buildingEntities = buildingRepository.findAll(params, typecode); 
		ArrayList<BuildingDTO> result = new ArrayList<BuildingDTO>();
		for(BuildingEntity item : buildingEntities) {
			BuildingDTO building = new BuildingDTO();
			building.setName(item.getName());
			DistrictEntity districtEntity = districtRepository.findNameById(item.getDistrictid());
			building.setAddress(item.getStreet() +" " + item.getWard() +" ");
			building.setNumberOfBasement(item.getNumberofbasement());
			result.add(building);
		}
		return result;
	}
}
//+ districtEntity.getName()