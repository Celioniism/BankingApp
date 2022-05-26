package com.Capstone.BankingApp.service;

import com.Capstone.BankingApp.entity.AccountInfo;
import com.Capstone.BankingApp.entity.User;
import com.Capstone.BankingApp.repository.AccountInfoRepo;

import java.util.List;
import java.util.Set;

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
	public void editSecurityQuestion(long accountNo, AccountInfo accountInfo) {
		// get accountNo
		AccountInfo ai ;  //must be found and retrieved as an object to assign values and update <==
		ai = accountInfoRepo.findById(accountNo).get();
		// update securityQuestion and securityAnswer
		ai.setSecurityQuestion(accountInfo.getSecurityQuestion());
		ai.setSecurityAnswer(accountInfo.getSecurityAnswer()); // the newly found object can have properties changed <== 
		// save updated securityQuestion
		accountInfoRepo.save(ai); // the object is passed and the database uses the new data to update tables<==
	}

	@Override
	public void editSecurityAnswer(long accountNo, AccountInfo accountInfo) {
		// get accountNo
		accountInfoRepo.findById(accountNo);
		// update securityAnswer
		accountInfo.setSecurityAnswer(accountInfo.getSecurityAnswer());
		;
		// save updated securityAnswer
		accountInfoRepo.save(accountInfo);
	}

	@Override
	public boolean validateCustomer(String userName, String password) {
		User temp = userRepo.findByUserName(userName);
		if (temp.getUserName() == userName && temp.getPassword() == password)
			return true;
		else
			return false;
	}

	@Override
	public List<AccountInfo> getAllAccounts() {
		return accountInfoRepo.findAll();
	}

	

	public AccountInfo getAccountByAcctNo(int accountNo) {
		Long a = new Long((long)accountNo);
		return accountInfoRepo.findById(a).get();
	}
	@Override
	public void createAccount(AccountInfo accountInfo) {
		int lock = 0;
		int min = 000000;
		int max = 999999;
		int random1 = (int) Math.floor(Math.random() * (max - min + 1) + min);
		String random2 = String.valueOf(random1);
		long acnum = Long.parseLong(random2);
		while (lock == 0) {
			if (accountInfoRepo.findById(acnum) != null) {
				acnum += 1;
			} else {
				lock = 0;
				accountInfo.setAccountNumber(acnum);
			}
		}
		if (accountInfo.getSecurityQuestion() != null && accountInfo.getSecurityAnswer() != null
				&& accountInfo.getFistName() != null && accountInfo.getLastName() != null) {
			accountInfoRepo.save(accountInfo);
			User u = userRepo.findById(accountInfo.getUserId()).get();
			if (u != null) {
				u.setAccountinfo((Set<AccountInfo>) accountInfo);
				userRepo.save(u);
			}
		} else
			System.out.println("error creating user, null fields exist");
	}

}
