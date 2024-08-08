package com.thebinh.repository;

import java.util.ArrayList;

import com.thebinh.repository.entity.DistrictEntity;

public interface DistrictRespontory {
	DistrictEntity findNameById(Long districtId);
}
