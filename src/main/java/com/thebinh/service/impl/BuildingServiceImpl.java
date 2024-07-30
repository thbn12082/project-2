package com.thebinh.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thebinh.model.BuildingDTO;
import com.thebinh.repository.BuildingRepository;
import com.thebinh.repository.entity.BuildingEntity;
import com.thebinh.service.BuildingService;

@Service
public class BuildingServiceImpl implements BuildingService{
	@Autowired
    private BuildingRepository buildingRepository;
	@Override
	public ArrayList<BuildingDTO> findAll(String name) {
		ArrayList<BuildingEntity> buildingEntities = buildingRepository.findAll(name); 
		ArrayList<BuildingDTO> result = new ArrayList<BuildingDTO>();
		for(BuildingEntity item : buildingEntities) {
			BuildingDTO building = new BuildingDTO();
			building.setName(item.getName());
			building.setAddress(item.getStreet() +" " + item.getWard());
			building.setNumberOfBasement(item.getNumberOfBasement());
			result.add(building);
		}
		return result;
	}
}