package com.Capstone.BankingApp.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Entity
@Setter
@AllArgsConstructor
@ToString
public class Cards {
	
	@Id
	private long CardNumber;
	private int AssociatedId;
	
	private String Exp;
	
	private int Cvv;
	
	private double Balance;
	private String CardType;
	
	private enum cardType  {
		  DEBIT,
		  CREDIT
		};
		public void setCardDebit() {
			cardType t1 = cardType.DEBIT;
			String tr = String.valueOf(t1);
			this.CardType = tr;
		}

		public void setCardCredit() {
			cardType t1 = cardType.CREDIT;
			String tr = String.valueOf(t1);
			this.CardType = tr;
		}	
		
		
		
		
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Transactions> transaction;
	
	@ManyToOne
	private AccountInfo acountInfo;

	public Cards() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cards(int associatedId, long cardNumber, String exp, int cvv, double balance) {
		super();
		AssociatedId = associatedId;
		CardNumber = cardNumber;
		Exp = exp;
		Cvv = cvv;
		Balance = balance;
	}

	public Cards(long cardNumber, String exp, int cvv, double balance) {
		super();
		CardNumber = cardNumber;
		Exp = exp;
		Cvv = cvv;
		Balance = balance;
	}

	public int getAssociatedId() {
		return AssociatedId;
	}

	public void setAssociatedId(int associatedId) {
		AssociatedId = associatedId;
	}

	public long getCardNumber() {
		return CardNumber;
	}

	public void setCardNumber(long cardNumber) {
		CardNumber = cardNumber;
	}

	public String getExp() {
		return Exp;
	}

	public void setExp(String exp) {
		Exp = exp;
	}

	public int getCvv() {
		return Cvv;
	}

	public void setCvv(int cvv) {
		Cvv = cvv;
	}

	public double getBalance() {
		return Balance;
	}

	public void setBalance(double balance) {
		Balance = balance;
	}

	public AccountInfo getAcountInfo() {
		return acountInfo;
	}

	public void setAcountInfo(AccountInfo acountInfo) {
		this.acountInfo = acountInfo;
	}
	
	

}
