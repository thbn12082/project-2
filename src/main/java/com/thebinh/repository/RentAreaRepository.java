package com.thebinh.repository;

import java.util.ArrayList;

import com.thebinh.repository.entity.RentAreaEntity;

public interface RentAreaRepository {
	ArrayList<RentAreaEntity> getValueByBuildingId(Long id);
}
