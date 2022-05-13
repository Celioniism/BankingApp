package com.Capstone.BankingApp.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class GeneralStaff {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int StaffId;
	private String UserName;
	private String Password;
	private String FullName;
	
	@ManyToOne
	private Administrator admin;
	@ManyToMany(fetch=FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	private Set<AccountInfo> accountInfo;
	
	@ManyToMany(fetch=FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	private Set<User> user;
	public GeneralStaff() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GeneralStaff(int staffId, String userName, String password, String fullName) {
		super();
		StaffId = staffId;
		UserName = userName;
		Password = password;
		FullName = fullName;
	}
	public GeneralStaff(String userName, String password, String fullName) {
		super();
		UserName = userName;
		Password = password;
		FullName = fullName;
	}
	public int getStaffId() {
		return StaffId;
	}
	public void setStaffId(int staffId) {
		StaffId = staffId;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getFullName() {
		return FullName;
	}
	public void setFullName(String fullName) {
		FullName = fullName;
	}
	public Administrator getAdmin() {
		return admin;
	}
	public void setAdmin(Administrator admin) {
		this.admin = admin;
	}
	public Set<AccountInfo> getAccountInfo() {
		return accountInfo;
	}
	public void setAccountInfo(Set<AccountInfo> accountInfo) {
		this.accountInfo = accountInfo;
	}
	public Set<User> getUser() {
		return user;
	}
	public void setUser(Set<User> user) {
		this.user = user;
	}

}
