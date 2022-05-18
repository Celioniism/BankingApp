package com.Capstone.BankingApp.service;

import java.util.List;

import com.Capstone.BankingApp.entity.AccountInfo;
import com.Capstone.BankingApp.entity.User;

public interface AccountInfoService {
    public User showAccountInfo(int userId);
    public void editSecurityQuestion(int userId, User user);
    public void editSecurityAnswer(int userId, User user);
    public List<AccountInfo> getAllAccounts(int cusId);
    public void getAccountInfo();
}


