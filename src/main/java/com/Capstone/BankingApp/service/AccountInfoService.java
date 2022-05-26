package com.Capstone.BankingApp.service;

import java.util.List;

import com.Capstone.BankingApp.entity.AccountInfo;
import com.Capstone.BankingApp.entity.User;

public interface AccountInfoService {

	void editSecurityQuestion(long accountNo, AccountInfo accountInfo);

	void editSecurityAnswer(long accountNo, AccountInfo accountInfo);

	boolean validateCustomer(String userName, String password);

	List<AccountInfo> getAllAccounts();

	AccountInfo getAccountByAcctNo(long accountNo);

	void createAccount(AccountInfo accountInfo);
    
 
    
}


