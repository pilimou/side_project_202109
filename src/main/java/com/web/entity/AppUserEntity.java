package com.web.entity;

import javax.persistence.*;


@Entity
@Table(name = "FAMILY_USER")
public class AppUserEntity {
	
	@Id
	@Column(name = "ACCOUNT")
	private String account;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "ROLEID")
	private String roleId;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	
	
}
