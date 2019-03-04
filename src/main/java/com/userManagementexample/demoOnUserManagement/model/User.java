package com.userManagementexample.demoOnUserManagement.model;

import java.util.ArrayList;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "User")
public class User {
	@Id
	private int userId;
	private String userName;
	private int adentId;
	private String location;
	private String organization;
	private String role;
	private String supervisor;

	
	 @OneToOne(mappedBy="user") 
	 private UserEntitlements userEntitlements;
	 

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	private List<WorkFlow> workFlow = new ArrayList<>();

	public User() {

	}

	public User(String userName, int adentId, String location, String organization, String role) {
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

	/*
	 * public Set<WorkFlow> getWorkFlow() { return workFlow; }
	 */

	public void addWorkFlow(WorkFlow workFlows) {
		if (workFlow == null) {
			workFlow = new ArrayList<WorkFlow>();
		}
		if (!workFlow.contains(workFlows)) {
			workFlow.add(workFlows);
		}
	}

	public void setWorkFlow(List<WorkFlow> workFlow) {
		this.workFlow = workFlow;
	}
	
	

	public UserEntitlements getUserEntitlements() {
		return userEntitlements;
	}

	public void setUserEntitlements(UserEntitlements userEntitlements) {
		this.userEntitlements = userEntitlements;
	}

	public List<WorkFlow> getWorkFlow() {
		return workFlow;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", adentId=" + adentId + ", location=" + location
				+ ", organization=" + organization + ", role=" + role + ", userEntitlements=" + userEntitlements
				+ ", workFlow=" + workFlow + "]";
	}

	

}
