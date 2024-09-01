package com.thebinh.convertor;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.thebinh.model.BuildingDTO;
import com.thebinh.repository.entity.BuildingEntity;
import com.thebinh.repository.entity.DistrictEntity;
import com.thebinh.repository.entity.RentAreaEntity;

@Component
public class BuildingDTOConvertor {

	@Autowired
	private ModelMapper modelMapper;

	public BuildingDTO toBuildingDTO(BuildingEntity item) {
		BuildingDTO building = modelMapper.map(item, BuildingDTO.class);
		DistrictEntity districtEntity = item.getDistrict();
		building.setAddress(item.getStreet() + " " + item.getWard() + " " + item.getDistrict().getName());
		building.setNumberOfBasement(item.getNumberofbasement());
		List<RentAreaEntity> rentArea = item.getItems();
		String areaResult = rentArea.stream().map(it -> it.getValue().toString()).collect(Collectors.joining(","));
		building.setRentArea(areaResult);
		return building;
	}
}
