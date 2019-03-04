package com.userManagementexample.demoOnUserManagement.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class UserEntitlements {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userentitlements_seq")
	@SequenceGenerator(name = "userentitlements_seq", sequenceName = "userentitlements_seq", allocationSize = 1)
	private int id;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	private boolean isBankerOutreach;

	public UserEntitlements() {

	}

	public UserEntitlements(boolean isBankerOutreach) {
		super();
		this.isBankerOutreach = isBankerOutreach;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isBankerOutreach() {
		return isBankerOutreach;
	}

	public void setBankerOutreach(boolean isBankerOutreach) {
		this.isBankerOutreach = isBankerOutreach;
	}

	@Override
	public String toString() {
		return "UserEntitlements [id=" + id + ", user=" + user + ", isBankerOutreach=" + isBankerOutreach + "]";
	}

}
