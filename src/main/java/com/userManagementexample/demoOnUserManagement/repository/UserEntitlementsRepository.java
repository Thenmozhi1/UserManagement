package com.userManagementexample.demoOnUserManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.userManagementexample.demoOnUserManagement.model.User;
import com.userManagementexample.demoOnUserManagement.model.UserEntitlements;

public interface UserEntitlementsRepository extends JpaRepository<UserEntitlements,Integer>{
	@Query("select u from UserEntitlements u where u.user.userId=?1")
	UserEntitlements findByUser(Integer i);

}
