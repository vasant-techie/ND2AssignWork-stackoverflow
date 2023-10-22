package com.nd2.assignwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nd2.assignwork.entity.PermissionEntity;

public interface PermissionRepository extends JpaRepository<PermissionEntity, Integer> {

	PermissionEntity findOneByPermissionName(String permissionName);
}
