package com.Capstone.BankingApp.InputClasses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepositFactory {

	private double amount;
	private long CardNumber;
	private String reference;

}