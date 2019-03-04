package com.userManagementexample.demoOnUserManagement.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserComposite implements Serializable {


	private static final long serialVersionUID = 1L;

	@Column(name = "user_id", nullable = false)
    private int userId;

    @Column(name = "proxy_name", nullable = false)
    private int proxyName;

	public UserComposite() {
		
	}

	public UserComposite(int userId, int proxyName) {
		super();
		this.userId = userId;
		this.proxyName = proxyName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getProxyName() {
		return proxyName;
	}

	public void setProxyName(int proxyName) {
		this.proxyName = proxyName;
	}

	@Override
	public String toString() {
		return "UserComposite [userId=" + userId + ", proxyName=" + proxyName + "]";
	}
    
    
}
