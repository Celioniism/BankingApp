package com.Capstone.BankingApp.service;

import com.Capstone.BankingApp.entity.UserInfoFactory;

public interface UserInfoFactoryService {
	public UserInfoFactory showUserInfoFactoryDetails(int userId);

	public boolean signup(UserInfoFactory userIF, String Type);
}
