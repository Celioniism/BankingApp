package com.Capstone.BankingApp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Transactions {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long transactionsNumber;
	private String date_and_time;
	private String reference;
	private double amount;
	private String TransactionType;

	public enum transactionType {
		WITHDRAW, TRANSFER, DEPOSIT
	};

	@ManyToOne
	private Cards card;

	public void setTransactionWithdraw() {
		transactionType t1 = transactionType.WITHDRAW;
		String tr = String.valueOf(t1);
		this.TransactionType = tr;
	}

	public void setTransactionTransfer() {
		transactionType t1 = transactionType.TRANSFER;
		String tr = String.valueOf(t1);
		this.TransactionType = tr;
	}

	public void setTransactionDeposit() {
		transactionType t1 = transactionType.DEPOSIT;
		String tr = String.valueOf(t1);
		this.TransactionType = tr;
	}
	
	public String getTransactionType() {
		return this.TransactionType;
	}
}