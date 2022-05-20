package com.Capstone.BankingApp.entity;

import java.util.Set;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	private String UserName;
	private String Password;
	private String FullName;

	@OneToMany(cascade = CascadeType.ALL)
	private Set<AccountInfo> accountinfo;
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<GeneralStaff> generalStaff;
	private List<Integer> BenefactorList;
	private List<Integer> BeneficiaryList;
	
	public List<Integer> getBenefactorList() {
		return BenefactorList;
	}

	public void setBenefactorList(List<Integer> benefactorList) {
		BenefactorList = benefactorList;
	}

	public List<Integer> getBeneficiaryList() {
		return BeneficiaryList;
	}

	public void setBeneficiaryList(List<Integer> beneficiaryList) {
		BeneficiaryList = beneficiaryList;
	}

	public User(int userId, String userName, String password, String fullName) {
		super();
		this.userId = userId;
		UserName = userName;
		Password = password;
		FullName = fullName;
	}
public User() {
		// TODO Auto-generated constructor stub
	}
	public User(String userName, String password, String fullName) {
		super();
		UserName = userName;
		Password = password;
		FullName = fullName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public Set<AccountInfo> getAccountinfo() {
		return accountinfo;
	}

	public void setAccountinfo(Set<AccountInfo> accountinfo) {
		this.accountinfo = accountinfo;
	}

	public Set<GeneralStaff> getGeneralStaff() {
		return generalStaff;
	}

	public void setGeneralStaff(Set<GeneralStaff> generalStaff) {
		this.generalStaff = generalStaff;
	}

}
