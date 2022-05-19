package com.Capstone.BankingApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Capstone.BankingApp.entity.AccountInfo;
import com.Capstone.BankingApp.entity.User;
import com.Capstone.BankingApp.entity.UserInfoFactory;
import com.Capstone.BankingApp.repository.AccountInfoRepo;
import com.Capstone.BankingApp.repository.UserRepo;

@Service
public class UserInfoFactoryServiceImpl implements UserInfoFactoryService {

	@Autowired
	AccountInfoRepo AIRepo;

	@Autowired
	UserRepo URepo;
	@Autowired
	UserInfoFactoryRepo UIRepo;
	@Override
	public UserInfoFactory showUserInfoFactoryDetails(int userId) {
		return UIRepo.getById(userId);
	}

	@Override
	public void signup(UserInfoFactory userIF) {
		User nu = new User();
		AccountInfo AI = new AccountInfo();
		nu.setUserName(userIF.getUserName());
		nu.setFullName(userIF.getFullName());
		nu.setPassword(userIF.getPassword());

		AI.setAccountNumber(userIF.getAccountNumber());
		AI.setBeneficiaryId(userIF.getBeneficiaryId());
		AI.setSecurityAnswer(userIF.getSecurityAnswer());
		AI.setSecurityQuestion(userIF.getSecurityQuestion());
		nu.setAccountinfo(AI);

		URepo.save(nu);
		AIRepo.save(AI);

	}

}
