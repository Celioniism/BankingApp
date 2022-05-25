package com.Capstone.BankingApp.service;

import java.util.List;

import com.Capstone.BankingApp.entity.AccountInfo;
import com.Capstone.BankingApp.entity.User;

public interface AccountInfoService {

	void editSecurityQuestion(int accountNo, AccountInfo accountInfo);

	void editSecurityAnswer(int accountNo, AccountInfo accountInfo);

	boolean validateCustomer(String userName, String password);

	List<AccountInfo> getAllAccounts();

	AccountInfo getAccountByAcctNo(int accountNo);

	void createAccount(AccountInfo accountInfo);
    
 
    
}


