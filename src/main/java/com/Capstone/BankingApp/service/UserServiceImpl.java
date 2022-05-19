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
    public void editUsername(int userId, User user) {

    }

    @Override
    public void editUserPassword(int userId, User user) {

    }

    @Override
    public void editFullName(int userId, User user) {

    }

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean authenticateUser(String userName, String password) {
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateUser(int userId, User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void deleteBeneficiary(int beneficiaryId, int benefactorId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addBeneficiary(int beneficiaryId, int benefactorId) {
		// TODO Auto-generated method stub
		
	}
}
