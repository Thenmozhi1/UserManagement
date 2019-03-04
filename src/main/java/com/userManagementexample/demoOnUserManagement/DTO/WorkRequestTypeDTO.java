package com.userManagementexample.demoOnUserManagement.DTO;


import java.io.Serializable;

import com.userManagementexample.demoOnUserManagement.model.WorkFlow;

public class WorkRequestTypeDTO implements Serializable{
	private static final long serialVersionUID = 5L;

	private int workRequestTypeId;
	private String workRequestTypes;
	private boolean qrAccess;
	private int qrPercentage;
	private boolean processorAccess;
	private WorkFlowDTO workFlowDTO;
	
	public WorkRequestTypeDTO() {
		
	}

	public WorkRequestTypeDTO(String workRequestTypes, boolean qrAccess, int qrPercentage, boolean processorAccess) {
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

	public WorkFlowDTO getWorkFlowDTO() {
		return workFlowDTO;
	}

	public void setWorkFlowDTO(WorkFlowDTO workFlowDTO) {
		this.workFlowDTO = workFlowDTO;
	}

	@Override
	public String toString() {
		return "WorkRequestTypeDTO [workRequestTypeId=" + workRequestTypeId + ", workRequestTypes=" + workRequestTypes
				+ ", qrAccess=" + qrAccess + ", qrPercentage=" + qrPercentage + ", processorAccess=" + processorAccess
				+ ", workFlowDTO=" + workFlowDTO + "]";
	}
	
	
}
