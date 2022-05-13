package com.Capstone.BankingApp.service;

import com.Capstone.BankingApp.entity.User;

public interface AccountInfoService {
    public User showAccountInfo(int userId);
    public void editSecurityQuestion(int userId, User user);
    public void editSecurityAnswer(int userId, User user);
}


