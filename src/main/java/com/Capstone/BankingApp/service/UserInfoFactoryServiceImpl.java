package com.Capstone.BankingApp.service;

import java.util.HashSet;
import java.util.Set;

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
		Set<AccountInfo> AI = new HashSet<AccountInfo>();
		nu.setUserName(userIF.getUserName());
		nu.setFullName(userIF.getFullName());
		nu.setPassword(userIF.getPassword());

		((AccountInfo) AI).setAccountNumber(userIF.getAccountNumber());
		((AccountInfo) AI).setBeneficiaryId(userIF.getBeneficiaryId());
		((AccountInfo) AI).setSecurityAnswer(userIF.getSecurityAnswer());
		((AccountInfo) AI).setSecurityQuestion(userIF.getSecurityQuestion());
		nu.setAccountinfo(AI);

		URepo.save(nu);
		AIRepo.saveAll(AI);
	}
}
