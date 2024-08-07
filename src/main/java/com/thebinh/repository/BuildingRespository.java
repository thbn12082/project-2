package com.thebinh.repository;

import java.util.ArrayList;
import java.util.Map;

import com.thebinh.repository.entity.BuildingEntity;

public interface BuildingRespository {
	ArrayList<BuildingEntity> findAll(Map<String, Object> params, ArrayList<String> typecode);

}
