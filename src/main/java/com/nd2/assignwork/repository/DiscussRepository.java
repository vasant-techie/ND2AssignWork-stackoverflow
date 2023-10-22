package com.nd2.assignwork.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nd2.assignwork.entity.DiscussEntity;
import com.nd2.assignwork.entity.DiscussID;

public interface DiscussRepository extends JpaRepository<DiscussEntity, DiscussID> {

	DiscussEntity findOneByDiscussTask(String discussTask);
	
	DiscussEntity findOneByDiscussUser(String discussUser);
	
	DiscussEntity findOneByDiscussTime(Date discussTime);
	
	void deleteByDiscussTime(Date discussTime);
}
