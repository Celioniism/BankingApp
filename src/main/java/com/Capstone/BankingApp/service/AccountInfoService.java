package com.Capstone.BankingApp.service;

import java.util.List;

import com.Capstone.BankingApp.entity.AccountInfo;
import com.Capstone.BankingApp.entity.User;

public interface AccountInfoService {
    
    public void editSecurityQuestion(int accountNo, AccountInfo accountInfo);
    public void editSecurityAnswer(int accountNo, AccountInfo accountInfo);
    
    public boolean validateCustomer(String userName, String password);
    
    public List<AccountInfo>getAllAccounts();
    
    public AccountInfo getAccountByAcctNo(int accountNo);

    public void createAccount(AccountInfo accountInfo);
    
}


