package com.Capstone.BankingApp.service;

import com.Capstone.BankingApp.entity.AccountInfo;
import com.Capstone.BankingApp.entity.User;
import com.Capstone.BankingApp.repository.AccountInfoRepo;

import java.util.List;

import com.Capstone.BankingApp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountInfoServiceImpl implements AccountInfoService {

    @Autowired
    AccountInfoRepo accountInfoRepo;

	@Autowired
	UserRepo userRepo;


	@Override
	public void editSecurityQuestion(int accountNo, AccountInfo accountInfo) {
		// get accountNo
		accountInfoRepo.getById(accountNo);
		// update securityQuestion and securityAnswer
		accountInfo.setSecurityQuestion(accountInfo.getSecurityQuestion());
		accountInfo.setSecurityAnswer(accountInfo.getSecurityAnswer());
		// save updated securityQuestion
		accountInfoRepo.save(accountInfo);
	}

	@Override
	public void editSecurityAnswer(int accountNo, AccountInfo accountInfo) {
		// get accountNo
		accountInfoRepo.getById(accountNo);
		// update securityAnswer
		accountInfo.setSecurityAnswer(accountInfo.getSecurityAnswer());;
		// save updated securityAnswer
		accountInfoRepo.save(accountInfo);
	}

	@Override
	public boolean validateCustomer(String userName, String password) {
		User temp = userRepo.findByUserName(userName);
		if(temp.getUserName()==userName && temp.getPassword()==password)
			return true;
		else
			return false;
	}


	@Override
	public List<AccountInfo> getAllAccounts() {
		return accountInfoRepo.findAll();
	}


	@Override
	public AccountInfo getAccountByAcctNo(int accountNo) {
		return accountInfoRepo.getById(accountNo);
	}

	@Override
	public void createAccount(AccountInfo accountInfo) {
		User user = new User();

		user.setUserName(user.getUserName());
		user.setPassword(user.getPassword());
		user.setFullName(user.getFullName());

		accountInfo.setSecurityQuestion(accountInfo.getSecurityQuestion());
		accountInfo.setSecurityAnswer(accountInfo.getSecurityAnswer());
		accountInfo.setCard(accountInfo.getCard());

		userRepo.save(user);
		accountInfoRepo.save(accountInfo);
		
	}
}
