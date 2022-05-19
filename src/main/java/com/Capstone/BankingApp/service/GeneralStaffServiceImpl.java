package com.Capstone.BankingApp.service;

import com.Capstone.BankingApp.entity.AccountInfo;
import com.Capstone.BankingApp.entity.Benefactor;
import com.Capstone.BankingApp.entity.GeneralStaff;
import com.Capstone.BankingApp.entity.Transactions;
import com.Capstone.BankingApp.entity.User;
import com.Capstone.BankingApp.repository.GeneralStaffRepo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneralStaffServiceImpl implements GeneralStaffService{

    @Autowired
    GeneralStaffRepo generalStaffRepo;


    @Override
    public GeneralStaff showStaffInfo(int staffId) {
        return null;
    }

    @Override
    public void editStaffUsername(int staffId, GeneralStaff generalStaff) {

    }

    @Override
    public void editStaffPassword(int staffId, GeneralStaff generalStaff) {

    }

    @Override
    public void editStaffFullName(int staffId, GeneralStaff generalStaff) {

    }

	@Override
	public boolean authenticateStaff(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Transactions> getTransactions(int acctId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Benefactor> BeneficiaryToBeApproved() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void approveBeneficiary(int userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<AccountInfo> accountsToBeApproved() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void approveCustAccounts(long[] accountNumber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void EnableUser(int userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User GetUserById(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
