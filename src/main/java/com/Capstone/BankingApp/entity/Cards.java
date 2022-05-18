package com.Capstone.BankingApp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Cards {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int AssociatedId;
	
	private long CardNumber;
	
	private int Exp;
	
	private int Cvv;
	
	private double Balance;
	
	@ManyToOne
	private AccountInfo acountInfo;

	public Cards() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cards(int associatedId, long cardNumber, int exp, int cvv, double balance) {
		super();
		AssociatedId = associatedId;
		CardNumber = cardNumber;
		Exp = exp;
		Cvv = cvv;
		Balance = balance;
	}

	public Cards(long cardNumber, int exp, int cvv, double balance) {
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

	public int getExp() {
		return Exp;
	}

	public void setExp(int exp) {
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
