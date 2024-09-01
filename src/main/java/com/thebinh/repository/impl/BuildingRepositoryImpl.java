package com.thebinh.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.thebinh.builder.BuildingSearchBuilder;
import com.thebinh.repository.BuildingRepository;
import com.thebinh.repository.entity.BuildingEntity;

@Repository
@Primary
public class BuildingRepositoryImpl implements BuildingRepository{
	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public List<BuildingEntity> findAll(BuildingSearchBuilder buildingSearchBuilder) {
		//JPQL :JPA Query Language
		String sql = "FROM BuildingEntity b WHERE b.name like '%building%' ";
		Query query = entityManager.createQuery(sql,BuildingEntity.class);
		return query.getResultList();
		
		
		// SQLNative: dùng chính là cái này
		
		
	}
}
