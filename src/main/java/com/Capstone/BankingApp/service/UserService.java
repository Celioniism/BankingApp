package com.Capstone.BankingApp.service;

import com.Capstone.BankingApp.entity.User;

public interface UserService {
   
    public void editUsername(int userId, User user);
    public void editUserPassword(int userId, User user);
    public void editFullName(int userId, User user);
    
    
    public void saveUser(User user);
    
    public boolean authenticateUser(String userName,String password );//login
    
    public User getUserById(int userId);
    
    public boolean updateUser(int userId, User user);
    
    public void deleteBeneficiary(int beneficiaryId, int benefactorId);
    
    public void addBeneficiary(int beneficiaryId,int benefactorId);
    
    
  
    
    
    
    
    
}
