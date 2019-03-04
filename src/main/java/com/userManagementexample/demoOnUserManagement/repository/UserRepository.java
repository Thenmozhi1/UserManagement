package com.userManagementexample.demoOnUserManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.userManagementexample.demoOnUserManagement.model.User;

public interface UserRepository extends JpaRepository<User,Integer>{

}
