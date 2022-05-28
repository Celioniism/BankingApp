package com.Capstone.BankingApp.service;

import com.Capstone.BankingApp.entity.User;

import com.Capstone.BankingApp.entity.UserInfoFactory;
import com.Capstone.BankingApp.repository.UserRepo;

import antlr.collections.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo userRepo;

	@Override
	public void editUsername(int userId, User user) {
		User temp = userRepo.getById(userId);
		temp.setUserName(user.getUserName());
		userRepo.save(temp);
	}

	@Override
	public void editUserPassword(int userId, User user) {
		User temp = userRepo.getById(userId);
		temp.setPassword(user.getPassword());
		userRepo.save(temp);
	}

	@Override
	public void editFullName(int userId, User user) {
		User temp = userRepo.getById(userId);
		temp.setFullName(user.getFullName());
		userRepo.save(temp);
	}

	@Override
	public void saveUser(User user) {
		userRepo.save(user);

	}

	@Override
	public String authenticateUser(String userName, String password) {
		User temp = userRepo.findByUserName(userName);
		if (temp.getPassword().equals(password)) {
			return "true";
		} else {
			return "false";
		}
	}

	@Override
	public User getUserById(int userId) {
		return userRepo.findById(userId).get();
	}

	@Override
	public boolean updateUser(int userId, User user) {
		if (userRepo.getById(userId) != null) {
			User temp = userRepo.getById(userId);

			temp.setFullName(user.getFullName());
			temp.setPassword(user.getPassword());
			temp.setUserName(user.getUserName());

			userRepo.save(temp);
			return true;
		} else {
			return false;
		}

	}

	@Override
	public void deleteBeneficiary(int beneficiaryId, int benefactorId) {
		User beneficiary = userRepo.getById(beneficiaryId);
		java.util.List<Integer> tempbi = beneficiary.getBenefactorList();
		tempbi.remove(benefactorId);
		beneficiary.setBenefactorList(tempbi);
		userRepo.save(beneficiary);

		User benefactor = userRepo.getById(benefactorId);
		java.util.List<Integer> tempbe = benefactor.getBeneficiaryList();
		tempbe.remove(beneficiaryId);
		benefactor.setBeneficiaryList(tempbe);
		userRepo.save(benefactor);

	}

	@Override
	public void addBeneficiary(int beneficiaryId, int benefactorId) {

		User beneficiary = userRepo.getById(beneficiaryId);
		java.util.List<Integer> tempbi = beneficiary.getBenefactorList();
		tempbi.add(benefactorId);
		beneficiary.setBenefactorList(tempbi);
		userRepo.save(beneficiary);

		User benefactor = userRepo.getById(benefactorId);
		java.util.List<Integer> tempbe = benefactor.getBeneficiaryList();
		tempbe.add(beneficiaryId);
		benefactor.setBeneficiaryList(tempbe);
		userRepo.save(benefactor);

	}

	@Override
	public int returnUserId(String username, String password) {
		User foundUser = userRepo.findByUsernPw(username, password);
		return foundUser.getUserId();

	}
}
