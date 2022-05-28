package com.Capstone.BankingApp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Capstone.BankingApp.entity.AccountInfo;
import com.Capstone.BankingApp.entity.Cards;
import com.Capstone.BankingApp.entity.User;
import com.Capstone.BankingApp.entity.UserInfoFactory;
import com.Capstone.BankingApp.repository.AccountInfoRepo;
import com.Capstone.BankingApp.repository.CardsRepo;
import com.Capstone.BankingApp.repository.UserInfoFactoryRepo;
import com.Capstone.BankingApp.repository.UserRepo;

@Service
public class UserInfoFactoryServiceImpl implements UserInfoFactoryService {

	@Autowired
	AccountInfoRepo AIRepo;
	@Autowired
	CardsService CS;
	@Autowired
	CardsRepo CR;
	@Autowired
	UserRepo URepo;
	@Autowired
	UserInfoFactoryRepo UIRepo;

	@Autowired
	AccountInfoService AIS;

	@Override
	public UserInfoFactory showUserInfoFactoryDetails(int userId) {

		return UIRepo.findById(userId).get();

	}

	@Override
	public boolean signup(UserInfoFactory userIF, String type) {
		User nu = new User();
		AccountInfo AI = new AccountInfo();
		Cards card = new Cards();
		System.out.println(userIF);
		nu.setUserName(userIF.getUserName());
		nu.setFullName(userIF.getFullName());
		nu.setPassword(userIF.getPassword());

		AI = AIS.registerFactory(AI);

		AI.setSecurityAnswer(userIF.getSecurityAnswer());
		AI.setSecurityQuestion(userIF.getSecurityQuestion());

		AI.setUser(nu);

		List<AccountInfo> LAI = new ArrayList<AccountInfo>();
		LAI.add(AI);

		URepo.save(nu);
		User userfound = (URepo.findByUserName(nu.getUserName()));
		card = CS.generateCardReturn(userfound.getUserId(), type);
		CR.save(card);
		AI.setUserId(userfound.getUserId());
		String fullname = userfound.getFullName();
		 String[] arrOffname = fullname.split(" ", 2);
		 String fname = arrOffname[0], lname = arrOffname[1];
		 AI.setFistName(fname);
		 AI.setLastName(lname);
		AIRepo.save(AI);
		return true;
	}
}
