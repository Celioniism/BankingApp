package com.Capstone.BankingApp.service;

import com.Capstone.BankingApp.entity.Administrator;
import com.Capstone.BankingApp.repository.AdministratorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    AdministratorRepo administratorRepo;

    @Override
    public Administrator showAdminInfo(int adminId) {
    return administratorRepo.getById(adminId);
    }

    @Override
    public void editAdminUsername(int adminId, Administrator administrator) {
        // get adminId
        administratorRepo.getById(adminId);
        // admin details
        administrator.setAdminId(administrator.getAdminId());
        administrator.setUserPassword(administrator.getUserPassword());
        administrator.setFullName(administrator.getFullName());
        // update adminUsername
        administrator.setUserName(administrator.getUserName());
        // save updated adminUsername
        administratorRepo.save(administrator);
    }

    @Override
    public void editAdminPassword(int adminId, Administrator administrator) {
        // get adminId
        administratorRepo.getById(adminId);
        // admin details
        administrator.setAdminId(administrator.getAdminId());
        administrator.setUserName(administrator.getUserName());
        administrator.setFullName(administrator.getFullName());
        // update adminPassword
        administrator.setUserPassword(administrator.getUserPassword());
        // save updated adminPassword
        administratorRepo.save(administrator);
    }

    @Override
    public void editAdminFullName(int adminId, Administrator administrator) {
        // get adminId
        administratorRepo.getById(adminId);
        // admin details
        administrator.setAdminId(administrator.getAdminId());
        administrator.setUserName(administrator.getUserName());
        administrator.setUserPassword(administrator.getUserPassword());
        // update adminFullName
        administrator.setFullName(administrator.getFullName());
        // save updated adminFullName
        administratorRepo.save(administrator);
    }
}
