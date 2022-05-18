package com.Capstone.BankingApp.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Administrator {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int AdminId;
	
	private String UserName;
	
	private String UserPassword;
	
	private String FullName;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name="admin_staff_jointb", joinColumns = @JoinColumn(name="adminId"))
	private Set<GeneralStaff> generalStaff;

	public Administrator() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Administrator(int adminId, String userName, String userPassword, String fullName) {
		super();
		AdminId = adminId;
		UserName = userName;
		UserPassword = userPassword;
		FullName = fullName;
	}

	public Administrator(String userName, String userPassword, String fullName) {
		super();
		UserName = userName;
		UserPassword = userPassword;
		FullName = fullName;
	}

	public int getAdminId() {
		return AdminId;
	}

	public void setAdminId(int adminId) {
		AdminId = adminId;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getUserPassword() {
		return UserPassword;
	}

	public void setUserPassword(String userPassword) {
		UserPassword = userPassword;
	}

	public String getFullName() {
		return FullName;
	}

	public void setFullName(String fullName) {
		FullName = fullName;
	}

	public Set<GeneralStaff> getGeneralStaff() {
		return generalStaff;
	}

	public void setGeneralStaff(Set<GeneralStaff> generalStaff) {
		this.generalStaff = generalStaff;
	}
	
	
	
}
