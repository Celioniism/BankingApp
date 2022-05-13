package com.Capstone.BankingApp.service;

import com.Capstone.BankingApp.entity.UserInfoFactory;
import com.Capstone.BankingApp.repository.UserInfoFactoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoFactoryServiceImpl implements UserInfoFactoryService{

    @Autowired
    UserInfoFactoryRepo userInfoFactoryRepo;

    @Override
    public UserInfoFactory showUserInfoFactoryDetails(int userId) {
        return null;
    }
}
