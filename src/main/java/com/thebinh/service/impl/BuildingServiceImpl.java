package com.thebinh.service.impl;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thebinh.builder.BuildingSearchBuilder;
import com.thebinh.convertor.BuildingDTOConvertor;
import com.thebinh.convertor.BuildingSearchBuilderConvertor;
import com.thebinh.model.BuildingDTO;
import com.thebinh.repository.BuildingRespository;
import com.thebinh.repository.DistrictRespontory;
import com.thebinh.repository.RentAreaRepository;
import com.thebinh.repository.entity.BuildingEntity;
import com.thebinh.repository.entity.DistrictEntity;
import com.thebinh.repository.entity.RentAreaEntity;
import com.thebinh.service.BuildingService;

@Service

// đây là tầng xử lý dữ liệu theo yêu cầu của client

public class BuildingServiceImpl implements BuildingService{
	@Autowired
    private BuildingRespository buildingRepository;
	@Autowired
	private BuildingDTOConvertor buildingDTOConvertor;
	@Autowired
	private BuildingSearchBuilderConvertor buildingSearchBuilderConvertor;
	@Override
	public ArrayList<BuildingDTO> findAll(Map<String, Object> params, ArrayList<String> typecode) {
		BuildingSearchBuilder buildingSearchBuilder = buildingSearchBuilderConvertor.toBuildingSearchBuilder(params, typecode);
		ArrayList<BuildingEntity> buildingEntities = buildingRepository.findAll(buildingSearchBuilder); 
		ArrayList<BuildingDTO> result = new ArrayList<BuildingDTO>();
		for(BuildingEntity item : buildingEntities) {
			result.add(buildingDTOConvertor.toBuildingDTO(item));
		}
		return result;
	}
}
//