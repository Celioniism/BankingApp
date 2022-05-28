package com.Capstone.BankingApp.service;

import java.util.List;

import com.Capstone.BankingApp.InputClasses.UserSD;
import com.Capstone.BankingApp.InputClasses.UserStats;
import com.Capstone.BankingApp.entity.AccountInfo;

public interface AccountInfoService {

	void editSecurityQuestion(long accountNo, AccountInfo accountInfo);

	void editSecurityAnswer(long accountNo, AccountInfo accountInfo);

	boolean validateCustomer(String userName, String password);

	List<AccountInfo> getAllAccounts();

	AccountInfo getAccountByAcctNo(long accountNo);

	void createAccount(AccountInfo accountInfo);
    
	List<UserStats> getStats(int userId);   
	
	AccountInfo registerFactory(AccountInfo AI);
	
	UserSD returnUserdata(String userid, String password);
}