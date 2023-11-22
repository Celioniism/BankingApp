package com.Capstone.BankingApp.service;

import java.util.ArrayList;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Capstone.BankingApp.entity.AccountInfo;
import com.Capstone.BankingApp.entity.Cards;
import com.Capstone.BankingApp.entity.GeneralStaff;
import com.Capstone.BankingApp.entity.Transactions;
import com.Capstone.BankingApp.entity.User;
import com.Capstone.BankingApp.repository.AccountInfoRepo;
import com.Capstone.BankingApp.repository.GeneralStaffRepo;
import com.Capstone.BankingApp.repository.TransactionsRepo;
import com.Capstone.BankingApp.repository.UserRepo;

@Service
public class GeneralStaffServiceImpl implements GeneralStaffService{

    @Autowired
    GeneralStaffRepo generalStaffRepo;
    
    @Autowired
    UserRepo URepo;
    
    @Autowired
    AccountInfoRepo AcctRepo;
    
    @Autowired
    TransactionsRepo transRepo;


    @Override
    public GeneralStaff showStaffInfo(int staffId) {
    	GeneralStaff StaffFromDB = generalStaffRepo.findById(staffId).get();
        return StaffFromDB;
    }

    @Override
    public void editStaffUsername(int staffId, GeneralStaff generalStaff) {
    	
    	GeneralStaff StaffFromDB = generalStaffRepo.getById(staffId);
    	if(StaffFromDB != null) {
    		StaffFromDB.setUserName(generalStaff.getUserName());
    		generalStaffRepo.save(StaffFromDB);
    	}else {
    		 System.out.println("Staff Does not Exist");
    	}

    }

    @Override
    public void editStaffPassword(int staffId, GeneralStaff generalStaff) {

    	GeneralStaff StaffFromDB = generalStaffRepo.getById(staffId);
    	if(StaffFromDB != null) {
    		StaffFromDB.setPassword(generalStaff.getPassword());
    		generalStaffRepo.save(StaffFromDB);

    	}else {
    		 System.out.println("Staff Does not Exist");
    	}
    }

    @Override
    public void editStaffFullName(int staffId, GeneralStaff generalStaff) {

    	GeneralStaff StaffFromDB = generalStaffRepo.getById(staffId);
    	if(StaffFromDB != null) {
    		StaffFromDB.setFullName(generalStaff.getFullName());
    		generalStaffRepo.save(StaffFromDB);
    	}else {
    		 System.out.println("Staff Does not Exist");
    	}
    }


	@Override
	public boolean authenticateStaff(String username, String password) {
		// TODO Auto-generated method stub
		GeneralStaff tempStaff = generalStaffRepo.findByUsername(username);
		
		if(tempStaff.getUserName().equals(username) && tempStaff.getPassword().equals(password)) {
			return true;
		}
		return false;
	}

	@Override
	public List<Transactions> getTransactions(long acctId) {
		// TODO Auto-generated method stub
		AccountInfo TransAcct = AcctRepo.getById(acctId);
		Set<Cards> card = TransAcct.getCard();
		List<Transactions> statement = new ArrayList<>();
		//Iterator<Cards> cardIterator = card.iterator();
		
		for(Cards cards: card) {
			statement.addAll(cards.getTransaction());
		}
		
		return statement;
	}

	@Override
	public List<User> BeneficiaryToBeApproved() {
		// TODO Auto-generated method stub
		
		//Get a list of all users 
		//itreate through the list of users to retrieve the list of beneficiaries from each user object
		//iterate through list of beneficiaries and check if approved is equal to no
		// cast the list of beneficiaries to type User?
		
		List <User> users = URepo.findAll();
		List<Integer> beneficaryId = new ArrayList<>();
		List<User> unapprovedBenef = new ArrayList<>();

		for(User user: users) {
			beneficaryId.addAll(user.getBeneficiaryList());
		}
		for(Integer beneficiary: beneficaryId) {
			User unapproved = URepo.getById(beneficiary);
			if(unapproved.getApprovedAsBeneficiary().equalsIgnoreCase("no")) {
				unapprovedBenef.add(unapproved);
			}
		}
		
		return  unapprovedBenef;
	}

	@Override
	public void approveBeneficiary(int userId) {
		// TODO Auto-generated method stub
		User user = URepo.getById(userId);
		List<Integer> unapprovedbenef = user.getBeneficiaryList();
		
		for(Integer id: unapprovedbenef) {
			User beneficiary = URepo.getById(id);
			if(beneficiary.getApprovedAsBeneficiary().equalsIgnoreCase("no")) {
				beneficiary.setApprovedAsBeneficiary("yes");
			}
			URepo.save(beneficiary);
		}
	}

	@Override
	public List<AccountInfo> accountsToBeApproved() {
		// TODO Auto-generated method stub
		List<AccountInfo> accts = AcctRepo.findAll();
		List<AccountInfo> unApprovedAccts = new ArrayList<AccountInfo>();
		
		for(AccountInfo acct: accts) {
			if(acct.getApproved().equalsIgnoreCase("no")) {
				unApprovedAccts.add(acct);
			}
		}
		
		return unApprovedAccts;
	}

	@Override
	public void approveCustAccounts(long... accountNumber) {
		// TODO Auto-generated method stub
		List<AccountInfo> unApprovedaccts = accountsToBeApproved();
		
		for(AccountInfo accts: unApprovedaccts) {
			for(int i = 0; i <= accountNumber.length - 1; i++) {
				if(accts.getAccountNumber() == accountNumber[i] ) {
					accts.setApproved("yes");
				}
				AcctRepo.save(accts);
			}
		}
	}

	@Override 
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return URepo.findAll();
	}

	@Override
	public void EnableUser(int userId) {
		// TODO Auto-generated method stub
		User userFromDb = URepo.getById(userId);
		
		if(userFromDb.getStatus().equals(User.Status.DISABLE.toString())) {
			userFromDb.setEnable();
			URepo.save(userFromDb);
		}else if(userFromDb.getStatus().equals(User.Status.ENABLE.toString())) {
			userFromDb.setDisable();
			URepo.save(userFromDb);
		}
	}

	@Override
	public User GetUserById(int userId) {
		// TODO Auto-generated method stub
		User UserFromDB = URepo.findById(userId).get();
		
		return UserFromDB;
	}

}
