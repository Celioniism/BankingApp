package com.Capstone.BankingApp.InputClasses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WithdrawalFactory {
	private double amount;
	private long CardNumber;
}
