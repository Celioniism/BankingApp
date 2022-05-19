package com.Capstone.BankingApp.service;

import com.Capstone.BankingApp.entity.AccountInfo;
import com.Capstone.BankingApp.entity.User;
import com.Capstone.BankingApp.repository.AccountInfoRepo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountInfoServiceImpl implements AccountInfoService {

    @Autowired
    AccountInfoRepo accountInfoRepo;


    

	@Override
	public boolean approveCustomer(int accountNo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<AccountInfo> getAllAccounts(int userID, List<AccountInfo> Accountinfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void editSecurityQuestion(int accountNo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editSecurityAnswer(int accountNo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AccountInfo getAccountByAcctNo(int accountNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createAccount(int userID, AccountInfo accountinfo) {
		// TODO Auto-generated method stub
		
	}
}
