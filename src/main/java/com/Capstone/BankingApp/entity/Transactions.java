package com.Capstone.BankingApp.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Transactions {

	@Id
	private Long transactionsNumber;
    private Date date; 
    private String reference; 
    private double amount; 
   //transaction type: enum 
    
	private enum transactionType {
		  WITHDRAW,
		  TRANSFER,
		  DEPOSIT
		};
	@ManyToOne
	private Cards card;
}
