package com.Capstone.BankingApp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserInfoFactory {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int UserId;
	private String UserName;
	private String Password;
	private String FullName;
	private int AccountNumber;
	
	private int BeneficiaryId;
	
	private String SecurityQuestion;
	
	private String SecurityAnswer;

	public UserInfoFactory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserInfoFactory(int userId, String userName, String password, String fullName, int accountNumber,
			int beneficiaryId, String securityQuestion, String securityAnswer) {
		super();
		UserId = userId;
		UserName = userName;
		Password = password;
		FullName = fullName;
		AccountNumber = accountNumber;
		BeneficiaryId = beneficiaryId;
		SecurityQuestion = securityQuestion;
		SecurityAnswer = securityAnswer;
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

	public int getAccountNumber() {
		return AccountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		AccountNumber = accountNumber;
	}

	public int getBeneficiaryId() {
		return BeneficiaryId;
	}

	public void setBeneficiaryId(int beneficiaryId) {
		BeneficiaryId = beneficiaryId;
	}

	public String getSecurityQuestion() {
		return SecurityQuestion;
	}

	public void setSecurityQuestion(String securityQuestion) {
		SecurityQuestion = securityQuestion;
	}

	public String getSecurityAnswer() {
		return SecurityAnswer;
	}

	public void setSecurityAnswer(String securityAnswer) {
		SecurityAnswer = securityAnswer;
	}
	
	
	

}
