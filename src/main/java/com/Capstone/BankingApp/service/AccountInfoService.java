package com.Capstone.BankingApp.service;

import java.util.List;

import com.Capstone.BankingApp.entity.AccountInfo;
import com.Capstone.BankingApp.entity.User;

public interface AccountInfoService {
    
    public void editSecurityQuestion(int accountNo);
    public void editSecurityAnswer(int accountNo);
    
    public boolean approveCustomer(int accountNo);
    
    public List<AccountInfo>getAllAccounts(int userID, List<AccountInfo> Accountinfo);
    
    public AccountInfo getAccountByAcctNo(int accountNo);
    
    
    public void createAccount(int userID, AccountInfo accountinfo);
    
}


