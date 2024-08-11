package com.thebinh.convertor;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.thebinh.model.BuildingDTO;
import com.thebinh.repository.DistrictRespontory;
import com.thebinh.repository.RentAreaRepository;
import com.thebinh.repository.entity.BuildingEntity;
import com.thebinh.repository.entity.DistrictEntity;
import com.thebinh.repository.entity.RentAreaEntity;

@Component
public class BuildingDTOConvertor {
	@Autowired
	private DistrictRespontory districtRepository;

	@Autowired
	private RentAreaRepository rentAreaRepository;

	@Autowired
	private ModelMapper modelMapper;

	public BuildingDTO toBuildingDTO(BuildingEntity item) {
		BuildingDTO building = modelMapper.map(item, BuildingDTO.class);
		DistrictEntity districtEntity = districtRepository.findNameById(item.getDistrictid());
		building.setAddress(item.getStreet() + " " + item.getWard() + " " + districtEntity.getName());
		building.setNumberOfBasement(item.getNumberofbasement());
		ArrayList<RentAreaEntity> rentArea = rentAreaRepository.getValueByBuildingId(item.getId());
		String areaResult = rentArea.stream().map(it -> it.getValue().toString()).collect(Collectors.joining(","));
		building.setRentArea(areaResult);
		return building;
	}
}
