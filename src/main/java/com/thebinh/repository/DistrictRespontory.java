package com.thebinh.repository;

import com.thebinh.repository.entity.DistrictEntity;

public interface DistrictRespontory {
	DistrictEntity findNameById(Long districtId);
}
