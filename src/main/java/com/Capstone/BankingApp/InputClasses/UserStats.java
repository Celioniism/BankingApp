package com.Capstone.BankingApp.InputClasses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserStats {
	private int epercents;
	private int dpercents;
	private int expenses;
	private int deposits;
	private double moneyIn;
	private double moneyOut;
	@Override
	public String toString() {
		return "UserStats [epercents=" + epercents + ", dpercents=" + dpercents + ", expenses=" + expenses
				+ ", deposits=" + deposits + ", moneyIn=" + moneyIn + ", moneyOut=" + moneyOut + "] \n";
	}
}