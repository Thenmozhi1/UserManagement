package com.userManagementexample.demoOnUserManagement.controller;

import java.util.Comparator;

import com.userManagementexample.demoOnUserManagement.DTO.UserDTO;

public class RoleComparator implements Comparator<UserDTO> {

	
	@Override
	public int compare(UserDTO o1, UserDTO o2) {
		return  o1.getRole().compareTo(o2.getRole());  

	}

}
