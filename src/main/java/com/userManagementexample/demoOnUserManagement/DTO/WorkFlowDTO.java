package com.userManagementexample.demoOnUserManagement.DTO;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.List;


import com.userManagementexample.demoOnUserManagement.model.User;
import com.userManagementexample.demoOnUserManagement.model.WorkRequestType;

public class WorkFlowDTO implements Serializable{
	private static final long serialVersionUID = 3L;

	private int workFlowId;
	private String workFlowtypes;
	private List<WorkRequestTypeDTO> workRequestTypeListdto = new ArrayList<>();	
	private User user;
	
	public WorkFlowDTO() {
	}

	public WorkFlowDTO(String workFlowtypes) {
		super();
		this.workFlowtypes = workFlowtypes;
	}

	public int getWorkFlowId() {
		return workFlowId;
	}

	public void setWorkFlowId(int workFlowId) {
		this.workFlowId = workFlowId;
	}

	public String getWorkFlowtypes() {
		return workFlowtypes;
	}

	public void setWorkFlowtypes(String workFlowtypes) {
		this.workFlowtypes = workFlowtypes;
	}

	public List<WorkRequestTypeDTO> getWorkRequestTypeListdto() {
		return workRequestTypeListdto;
	}

	public void setWorkRequestTypeListdto(List<WorkRequestTypeDTO> workRequestTypeListdto) {
		this.workRequestTypeListdto = workRequestTypeListdto;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "WorkFlowDTO [workFlowId=" + workFlowId + ", workFlowtypes=" + workFlowtypes
				+ ", workRequestTypeListdto=" + workRequestTypeListdto + ", user=" + user + "]";
	}

	

	
}
