/**
 * 
 */
package com.Capstone.BankingApp.service;

/**
 * @author Dekun
 * @Date 19 May 2022	
 *
 */

public interface TransactionsService {
	
	public String Transfer(long fromCardNo, long toCardNo, double amount, String reference);
	
	
	

}
