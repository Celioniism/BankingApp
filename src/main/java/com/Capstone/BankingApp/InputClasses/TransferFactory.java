package com.Capstone.BankingApp.InputClasses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransferFactory {
	private double amount;
	private long fromCardNumber;
	private long toCardNumber;
	private String memo;

}
