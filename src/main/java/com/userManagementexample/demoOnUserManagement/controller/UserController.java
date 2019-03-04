//https://www.baeldung.com/entity-to-and-from-dto-for-a-java-spring-application
package com.userManagementexample.demoOnUserManagement.controller;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.userManagementexample.demoOnUserManagement.DTO.UserDTO;
import com.userManagementexample.demoOnUserManagement.DTO.UserEntitlementsDTO;
import com.userManagementexample.demoOnUserManagement.DTO.WorkFlowDTO;
import com.userManagementexample.demoOnUserManagement.DTO.WorkRequestTypeDTO;
import com.userManagementexample.demoOnUserManagement.configuration.UserConfiguration;
import com.userManagementexample.demoOnUserManagement.model.User;
import com.userManagementexample.demoOnUserManagement.model.UserEntitlements;
import com.userManagementexample.demoOnUserManagement.model.WorkFlow;
import com.userManagementexample.demoOnUserManagement.model.WorkRequestType;
import com.userManagementexample.demoOnUserManagement.repository.UserEntitlementsRepository;
import com.userManagementexample.demoOnUserManagement.repository.UserRepository;
import com.userManagementexample.demoOnUserManagement.repository.WorkFlowRepository;
import com.userManagementexample.demoOnUserManagement.repository.WorkRequestTypeRepository;

@RestController
public class UserController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserEntitlementsRepository userEntitlementsRepository;
	@Autowired
	private WorkFlowRepository workFlowRepository;
	@Autowired
	private WorkRequestTypeRepository workRequestTypeRepository;
	@Autowired
	private UserConfiguration userConfiguration;

	@PostMapping("/users/new")
	public String saveUser(@RequestBody UserDTO userDto) {
		if (userEntitlementsRepository.existsById(userDto.getUserId())) {
			return "User: " + userDto.getUserName() + " is already added";
		}
		String msg = convertToEntity(userDto);
		return msg;

	}

	private String convertToEntity(UserDTO userDto) {
		UserEntitlements userEntitlementsRepo = userEntitlementsRepository.findByUser(userDto.getUserId());
		List<WorkFlow> workFlowsRepo = workFlowRepository.findByUser(userDto.getUserId());
		User user = userConfiguration.modelMapper().map(userDto, User.class);

		UserEntitlements userEntitlements = userConfiguration.modelMapper().map(userDto.getUserEntitlementsdto(),
				UserEntitlements.class);
		if (userEntitlementsRepo != null) {
			System.out.println("inside for updation");
			userEntitlements.setId(userEntitlementsRepo.getId());
		}
		userEntitlements.setUser(user);
		System.out.println(user.toString());
		System.out.println(userEntitlements.toString());

		userEntitlementsRepository.save(userEntitlements);

		for (WorkFlowDTO workFlw : userDto.getWorkFlowdto()) {

			WorkFlow workFlow = userConfiguration.modelMapper().map(workFlw, WorkFlow.class);
			if (workFlowsRepo != null) {
				for (WorkFlow wFlow : workFlowsRepo)
					workFlow.setWorkFlowId(wFlow.getWorkFlowId());
			}
			workFlow.setUser(user);
			workFlowRepository.save(workFlow);
			System.out.println("WorkFlow  toString() :: " + workFlw.toString());

			List<WorkRequestType> workRequestTypesRepo = workRequestTypeRepository
					.findByWorkFlowId(workFlow.getWorkFlowId());
			for (WorkRequestTypeDTO workReq : workFlw.getWorkRequestTypeListdto()) {
				System.out.println("wor Req string :: " + workReq.toString());

				WorkRequestType workRequestType = userConfiguration.modelMapper().map(workReq, WorkRequestType.class);
				if (workRequestTypesRepo != null) {
					for (WorkRequestType wRequest : workRequestTypesRepo) {
						workRequestType.setWorkRequestTypeId(wRequest.getWorkRequestTypeId());
					}
				}
				workRequestType.setWorkFlow(workFlow);
				if(workReq.isQrAccess()==true){
					if(workReq.isProcessorAccess()==false){
						return "please select processor access to true!";
					}
					
				}
				workRequestTypeRepository.save(workRequestType);

			}
		}

		return "User: " + userDto.getUserName() + " added successfully!";
	}

	@GetMapping("/users")
	public List<User> getAllUsers() {
		System.out.println("INSIDE GET USER");
		return userRepository.findAll();
	}

	@PutMapping("/users/update")
	public String updateUser(@RequestBody UserDTO userDto) {

		if (!userRepository.existsById(userDto.getUserId())) {
			return "user not found";
		}
		String msg = convertToEntity(userDto);
		return "Updated succesfully for user " + userDto.getUserName();

	}

	@PutMapping("/users/bulkupdate")
	public String updateBulkUsers(@RequestBody List<UserDTO> usersDTO) {
		System.out.println("inside update Bulk Users ");
		String msg=null;

		String role = null;

		for (UserDTO userDto : usersDTO) {

			if (userRepository.existsById(userDto.getUserId())) {
				return "User: " + userDto.getUserName() + " is already added to CDM. Bulk update cannot be done";
			}

			if (role == null) {
				role = userDto.getRole();
				System.out.println("inside role" + userDto.getRole() + "::" + userDto.getUserName());
			} else {
				int roleCompare = role.compareTo(userDto.getRole());
				if (roleCompare != 0) {
					System.out.println("role" + userDto.getRole() + "::" + userDto.getUserName());
					return "Roles should be same for selected users";
				}

			}

		}
		for (UserDTO userDto : usersDTO) {
			msg = convertToEntity(userDto);
		}
		return "Succesfully ADDED all users";

	}

}
