package com.Capstone.BankingApp.service;

import com.Capstone.BankingApp.entity.User;
import com.Capstone.BankingApp.repository.AccountInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountInfoServiceImpl implements AccountInfoService {

    @Autowired
    AccountInfoRepo accountInfoRepo;


    @Override
    public User showAccountInfo(int userId) {
        return null;
    }

    @Override
    public void editSecurityQuestion(int userId, User user) {

    }

    @Override
    public void editSecurityAnswer(int userId, User user) {

    }
}
