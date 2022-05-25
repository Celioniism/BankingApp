/**
 * 
 */
package com.Capstone.BankingApp.service;

import java.util.List;

import com.Capstone.BankingApp.InputClasses.WithdrawalFactory;
import com.Capstone.BankingApp.InputClasses.DepositFactory;
import com.Capstone.BankingApp.entity.Transactions;

/**
 * @author Dekun
 * @Date 19 May 2022	
 *
 */

public interface TransactionsService {
	
	public String Transfer(long fromCardNo, long toCardNo, double amount, String reference);
	
	public double Withdraw(WithdrawalFactory WF);
	public double Deposit(DepositFactory df);
	
	public List<Transactions> userTransactions(int userId);

}
