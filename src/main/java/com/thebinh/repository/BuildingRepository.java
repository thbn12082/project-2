package com.thebinh.repository;

import java.util.List;
import java.util.Map;

import com.thebinh.builder.BuildingSearchBuilder;
import com.thebinh.repository.entity.BuildingEntity;

public interface BuildingRepository {
	List<BuildingEntity> findAll(BuildingSearchBuilder buildingSearchBuilder);

}
