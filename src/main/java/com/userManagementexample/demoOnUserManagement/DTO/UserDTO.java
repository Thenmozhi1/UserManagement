package com.userManagementexample.demoOnUserManagement.DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.userManagementexample.demoOnUserManagement.model.UserEntitlements;
import com.userManagementexample.demoOnUserManagement.model.WorkFlow;

public class UserDTO implements Serializable{
	
	private int userId;
	private String userName;
	private int adentId;
	private String location;
	private String organization;
	private String role;
	private List<WorkFlowDTO> workFlowdto = new ArrayList<>();
	private UserEntitlementsDTO userEntitlementsdto;

	
	public UserDTO() {

	}

	public UserDTO(String userName, int adentId, String location, String organization, String role) {
		super();
		this.userName = userName;
		this.adentId = adentId;
		this.location = location;
		this.organization = organization;
		this.role = role;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getAdentId() {
		return adentId;
	}

	public void setAdentId(int adentId) {
		this.adentId = adentId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<WorkFlowDTO> getWorkFlowdto() {
		return workFlowdto;
	}

	public void setWorkFlowdto(List<WorkFlowDTO> workFlowdto) {
		this.workFlowdto = workFlowdto;
	}

	public UserEntitlementsDTO getUserEntitlementsdto() {
		return userEntitlementsdto;
	}

	public void setUserEntitlementsdto(UserEntitlementsDTO userEntitlementsdto) {
		this.userEntitlementsdto = userEntitlementsdto;
	}

	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", userName=" + userName + ", adentId=" + adentId + ", location="
				+ location + ", organization=" + organization + ", role=" + role + ", workFlowdto=" + workFlowdto
				+ ", userEntitlementsdto=" + userEntitlementsdto + "]";
	}

	
}
