package com.Capstone.BankingApp.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Transactions {

	@Id
	private Long AccountNumber;
    private Date date; 
    private String reference; 
    private double amount; 
   //transaction type: enum 
	
	
}
