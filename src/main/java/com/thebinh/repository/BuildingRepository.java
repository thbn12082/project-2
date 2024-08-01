package com.thebinh.repository;

import java.util.ArrayList;

import com.thebinh.repository.entity.BuildingEntity;

public interface BuildingRepository {
	ArrayList<BuildingEntity> findAll(String name, Long districtId);
}
