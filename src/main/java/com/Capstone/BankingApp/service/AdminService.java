package com.Capstone.BankingApp.service;

import com.Capstone.BankingApp.entity.Administrator;

public interface AdminService {
    public Administrator showAdminInfo(int adminId);
    public void editAdminUsername(int adminId, Administrator administrator);
    public void editAdminPassword(int adminId, Administrator administrator);
    public void editAdminFullName(int adminId, Administrator administrator);
}
