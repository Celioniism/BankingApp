package com.Capstone.BankingApp.service;

import java.util.List;

import com.Capstone.BankingApp.entity.Administrator;
import com.Capstone.BankingApp.entity.GeneralStaff;

public interface AdminService {
    public Administrator showAdminInfo(int adminId);
    public void editAdminUsername(int adminId, Administrator administrator);
    public void editAdminPassword(int adminId, Administrator administrator);
    public void editAdminFullName(int adminId, Administrator administrator);
    
    
    public boolean validateAdmin(String username, String password);
    
    public void registerGeneralStaff(GeneralStaff staff);
    
    public List<GeneralStaff> getAllStaff();
    
    public void EnableStaff(int staffId);

    public void DisableStaff(int staffId);
    
}
