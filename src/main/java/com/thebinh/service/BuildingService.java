package com.thebinh.service;

import java.util.ArrayList;

import com.thebinh.model.BuildingDTO;

public interface BuildingService{
	ArrayList<BuildingDTO> findAll(String name, Long districtId);
}
