package com.Capstone.BankingApp.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int UserId;
	private String UserName;
	private String Password;
	private String FullName;
	
	@OneToOne(cascade = CascadeType.ALL)
	private AccountInfo accountinfo;
	@ManyToMany(fetch=FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	private Set<GeneralStaff> generalStaff;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int userId, String userName, String password, String fullName) {
		super();
		UserId = userId;
		UserName = userName;
		Password = password;
		FullName = fullName;
	}
	public User(String userName, String password, String fullName) {
		super();
		UserName = userName;
		Password = password;
		FullName = fullName;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
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
	public AccountInfo getAccountinfo() {
		return accountinfo;
	}
	public void setAccountinfo(AccountInfo accountinfo) {
		this.accountinfo = accountinfo;
	}
	public Set<GeneralStaff> getGeneralStaff() {
		return generalStaff;
	}
	public void setGeneralStaff(Set<GeneralStaff> generalStaff) {
		this.generalStaff = generalStaff;
	}
	
	
	
}
