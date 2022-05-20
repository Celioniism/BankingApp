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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountInfo {

	
	
	@Id
	private Long AccountNumber;
	private int UserId;
	private int BeneficiaryId;

	private String SecurityQuestion;

	private String SecurityAnswer;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })

	private Set<GeneralStaff> staff;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "accountInfo_cards_jointb", joinColumns = @JoinColumn(name = "userId"))
	private Set<Cards> card;

	@ManyToOne
	private User user;



	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
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
