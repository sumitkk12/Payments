package com.capstone.payments.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "logged_in_user")
public class LoggedInUser {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	@Column(name = "login_id")
	private String loginId;
	@Column(name = "role_id")
	private String roleId;

	@Override
	public String toString() {
		return loginId + " " + roleId;
	}

	public LoggedInUser(String loginId, String roleId) {
		super();
		this.loginId = loginId;
		this.roleId = roleId;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

}
