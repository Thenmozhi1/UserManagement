package com.userManagementexample.demoOnUserManagement.model;

import java.util.ArrayList;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class WorkFlow {
	@Id	
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="workflow_seq")
	@SequenceGenerator(name="workflow_seq",sequenceName="workflow_seq",allocationSize=1)
	private int workFlowId;
	private String WorkFlowtypes;
	
	@OneToMany(mappedBy="workFlow",fetch=FetchType.LAZY,orphanRemoval=true)
	private List<WorkRequestType> workRequestTypeList=new ArrayList<>();
	

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
	public WorkFlow() {
		
	}

	public WorkFlow(int workFlowId, String workFlowtypes) {
		super();
		this.workFlowId = workFlowId;
		WorkFlowtypes = workFlowtypes;
	}

	public int getWorkFlowId() {
		return workFlowId;
	}

	public void setWorkFlowId(int workFlowId) {
		this.workFlowId = workFlowId;
	}

	public String getWorkFlowtypes() {
		return WorkFlowtypes;
	}

	public void setWorkFlowtypes(String workFlowtypes) {
		WorkFlowtypes = workFlowtypes;
	}

	/*public Set<WorkRequestType> getWorkRequestType() {
		return workRequestType;
	}*/
	
	public void addWorkRequestType(WorkRequestType workRequestTypes) {
		workRequestTypes.setWorkFlow(this);
       this.getWorkRequestTypeList().add(workRequestTypes);
    }

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "WorkFlow [workFlowId=" + workFlowId + ", WorkFlowtypes=" + WorkFlowtypes +/* ", workRequestType="
				+ workRequestType + */", user=" + user + "]";
	}

	public List<WorkRequestType> getWorkRequestTypeList() {
		return workRequestTypeList;
	}

	protected void setWorkRequestTypeList(List<WorkRequestType> workRequestTypeList) {
		this.workRequestTypeList = workRequestTypeList;
	}
	

}
