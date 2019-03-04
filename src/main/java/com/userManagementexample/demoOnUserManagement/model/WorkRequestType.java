package com.userManagementexample.demoOnUserManagement.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
public class WorkRequestType {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="workreq_seq")
	@SequenceGenerator(name="workreq_seq",sequenceName="workreq_seq",allocationSize=1)

	private int workRequestTypeId;
	private String workRequestTypes;
	private boolean qrAccess;
	private int qrPercentage;
	private boolean processorAccess;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="Flow_Req_Mapping_id")
	private  WorkFlow workFlow;

	public WorkRequestType() {
		
	}

	public WorkRequestType(String workRequestTypes, boolean qrAccess, int qrPercentage, boolean processorAccess) {
		super();
		this.workRequestTypes = workRequestTypes;
		this.qrAccess = qrAccess;
		this.qrPercentage = qrPercentage;
		this.processorAccess = processorAccess;
	}

	public int getWorkRequestTypeId() {
		return workRequestTypeId;
	}

	public void setWorkRequestTypeId(int workRequestTypeId) {
		this.workRequestTypeId = workRequestTypeId;
	}

	public String getWorkRequestTypes() {
		return workRequestTypes;
	}

	public void setWorkRequestTypes(String workRequestTypes) {
		this.workRequestTypes = workRequestTypes;
	}

	public boolean isQrAccess() {
		return qrAccess;
	}

	public void setQrAccess(boolean qrAccess) {
		this.qrAccess = qrAccess;
	}

	public int getQrPercentage() {
		return qrPercentage;
	}

	public void setQrPercentage(int qrPercentage) {
		this.qrPercentage = qrPercentage;
	}

	public boolean isProcessorAccess() {
		return processorAccess;
	}

	public void setProcessorAccess(boolean processorAccess) {
		this.processorAccess = processorAccess;
	}

	/*public Set<WorkFlow> getWorkFlow() {
		return workFlow;
	}*/
	

	

	public WorkFlow getWorkFlow() {
		return workFlow;
	}

	public void setWorkFlow(WorkFlow workFlow) {
		this.workFlow = workFlow;
	}

	@Override
	public String toString() {
		return "WorkRequestType [workRequestTypeId=" + workRequestTypeId + ", workRequestTypes=" + workRequestTypes
				+ ", qrAccess=" + qrAccess + ", qrPercentage=" + qrPercentage + ", processorAccess=" + processorAccess
				+ ", workFlow=" + workFlow + "]";
	}	
	
	
	
}
