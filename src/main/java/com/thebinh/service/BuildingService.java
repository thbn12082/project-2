package com.thebinh.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.thebinh.model.BuildingDTO;

public interface BuildingService{
	List<BuildingDTO> findAll(Map<String, Object> params, ArrayList<String> typecode);
}
