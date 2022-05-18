package com.Capstone.BankingApp.service;

import com.Capstone.BankingApp.entity.User;
import com.Capstone.BankingApp.entity.UserInfoFactory;

public interface UserService {
    public User showRegularUserInfo(int userId);
    public void editUsername(int userId, User user);
    public void editUserPassword(int userId, User user);
    public void editFullName(int userId, User user);
    public void saveUser(User user);
    public void authenticateUser(User user);
    public User getUser(int userId);
}
