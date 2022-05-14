package com.Capstone.BankingApp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoFactory {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int UserId;
	private String UserName;
	private String Password;
	private String FullName;
	private Long AccountNumber;

	private int BeneficiaryId;

	private String SecurityQuestion;

	private String SecurityAnswer;

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

	public Long getAccountNumber() {
		return AccountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
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
