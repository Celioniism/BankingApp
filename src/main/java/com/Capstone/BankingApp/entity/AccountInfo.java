package com.Capstone.BankingApp.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class AccountInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int UserId;
	
	private int AcountNumber;
	
	private int BeneficiaryId;
	
	private String SecurityQuestion;
	
	private String SercurityAnswer;
	
	@ManyToMany(fetch=FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	
	private Set<GeneralStaff> staff;
	
	
	

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name="accountInfo_cards_jointb", joinColumns = @JoinColumn(name="userId"))
	private Set<Cards> card;
	
	@OneToOne
	private User user;

	public AccountInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccountInfo(int userId, int acountNumber, int beneficiaryId, String securityQuestion,
			String sercurityAnswer) {
		super();
		UserId = userId;
		AcountNumber = acountNumber;
		BeneficiaryId = beneficiaryId;
		SecurityQuestion = securityQuestion;
		SercurityAnswer = sercurityAnswer;
	}

	public AccountInfo(int acountNumber, int beneficiaryId) {
		super();
		AcountNumber = acountNumber;
		BeneficiaryId = beneficiaryId;
	}

	public AccountInfo(int acountNumber, int beneficiaryId, String securityQuestion, String sercurityAnswer) {
		super();
		AcountNumber = acountNumber;
		BeneficiaryId = beneficiaryId;
		SecurityQuestion = securityQuestion;
		SercurityAnswer = sercurityAnswer;
	}

	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

	public int getAcountNumber() {
		return AcountNumber;
	}

	public void setAcountNumber(int acountNumber) {
		AcountNumber = acountNumber;
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

	public String getSercurityAnswer() {
		return SercurityAnswer;
	}

	public void setSercurityAnswer(String sercurityAnswer) {
		SercurityAnswer = sercurityAnswer;
	}

	public Set<GeneralStaff> getStaff() {
		return staff;
	}

	public void setStaff(Set<GeneralStaff> staff) {
		this.staff = staff;
	}

	public Set<Cards> getCard() {
		return card;
	}

	public void setCard(Set<Cards> card) {
		this.card = card;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
	

}
