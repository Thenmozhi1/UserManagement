package com.userManagementexample.demoOnUserManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.userManagementexample.demoOnUserManagement.model.WorkFlow;


public interface WorkFlowRepository extends JpaRepository<WorkFlow,Integer>{
	@Query("select u from WorkFlow u where u.user.userId=?1")
	List<WorkFlow> findByUser(int userId);
	
}
