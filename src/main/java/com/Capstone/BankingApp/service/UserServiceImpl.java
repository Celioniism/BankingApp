package com.Capstone.BankingApp.service;

import com.Capstone.BankingApp.entity.User;
import com.Capstone.BankingApp.entity.UserInfoFactory;
import com.Capstone.BankingApp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepo userRepo;


    @Override
    public User showRegularUserInfo(int userId) {
        return null;
    }

    @Override
    public void editUsername(int userId, User user) {

    }

    @Override
    public void editUserPassword(int userId, User user) {

    }

    @Override
    public void editFullName(int userId, User user) {

    }
}
