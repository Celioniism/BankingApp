package com.Capstone.BankingApp.service;

import java.util.List;

import com.Capstone.BankingApp.entity.AccountInfo;
import com.Capstone.BankingApp.entity.GeneralStaff;
import com.Capstone.BankingApp.entity.Transactions;
import com.Capstone.BankingApp.entity.User;

public interface GeneralStaffService {
    public GeneralStaff showStaffInfo(int staffId);
    public void editStaffUsername(int staffId, GeneralStaff generalStaff);
    public void editStaffPassword(int staffId, GeneralStaff generalStaff);
    public void editStaffFullName(int staffId, GeneralStaff generalStaff);
    
   
    public boolean authenticateStaff(String username,String password);
    
    public List<Transactions> getTransactions(long acctId);
    
    public List<User> BeneficiaryToBeApproved();
    
    public void approveBeneficiary(int userId);
    
    
    public List<AccountInfo> accountsToBeApproved();
    
    
    public void approveCustAccounts(long[] accountNumber);
    
    public  List<User> getAllUsers();
    
    public void EnableUser(int userId);
    
    public User GetUserById(int userId);
    
    
    
    
    
}
