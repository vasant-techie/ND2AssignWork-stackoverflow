package com.nd2.assignwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nd2.assignwork.entity.PositionEntity;

public interface PositionRepository extends JpaRepository<PositionEntity, Integer> {

	// Find single Position by Position_Name
	PositionEntity findOneByPositionName(String positionName);
}
