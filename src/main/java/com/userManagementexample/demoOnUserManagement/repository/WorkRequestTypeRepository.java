package com.userManagementexample.demoOnUserManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.userManagementexample.demoOnUserManagement.model.WorkRequestType;


public interface WorkRequestTypeRepository extends JpaRepository<WorkRequestType,Integer>{
	@Query("select u from WorkRequestType u where u.workFlow.workFlowId=?1")
	List<WorkRequestType> findByWorkFlowId(int workFlowId);

}
