package com.thebinh.repository;

import java.util.ArrayList;
import java.util.Map;

import com.thebinh.builder.BuildingSearchBuilder;
import com.thebinh.repository.entity.BuildingEntity;

public interface BuildingRespository {
	ArrayList<BuildingEntity> findAll(BuildingSearchBuilder buildingSearchBuilder);

}
