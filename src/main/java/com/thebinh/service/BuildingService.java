package com.thebinh.service;

import java.awt.List;
import java.util.ArrayList;
import java.util.Map;

import com.thebinh.model.BuildingDTO;

public interface BuildingService{
	ArrayList<BuildingDTO> findAll(Map<String, Object> params);
}
