package com.Capstone.BankingApp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Beneficiary {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int beneficiaryId;
	private int beneficiaryAcctNo;
	private String accountType;
	private String approved;
	private String beneficiaryName;
	private String active;
	
	public Beneficiary() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Beneficiary(int beneficiaryId, int beneficiaryAcctNo, String accountType, String approved,
			String beneficiaryName, String active) {
		super();
		this.beneficiaryId = beneficiaryId;
		this.beneficiaryAcctNo = beneficiaryAcctNo;
		this.accountType = accountType;
		this.approved = approved;
		this.beneficiaryName = beneficiaryName;
		this.active = active;
	}

	public Beneficiary(int beneficiaryAcctNo, String accountType, String approved, String beneficiaryName,
			String active) {
		super();
		this.beneficiaryAcctNo = beneficiaryAcctNo;
		this.accountType = accountType;
		this.approved = approved;
		this.beneficiaryName = beneficiaryName;
		this.active = active;
	}


	public int getBeneficiaryId() {
		return beneficiaryId;
	}
	public void setBeneficiaryId(int beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}
	public int getBeneficiaryAcctNo() {
		return beneficiaryAcctNo;
	}
	public void setBeneficiaryAcctNo(int beneficiaryAcctNo) {
		this.beneficiaryAcctNo = beneficiaryAcctNo;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getApproved() {
		return approved;
	}
	public void setApproved(String approved) {
		this.approved = approved;
	}
	public String getBeneficiaryName() {
		return beneficiaryName;
	}
	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	
	
}
