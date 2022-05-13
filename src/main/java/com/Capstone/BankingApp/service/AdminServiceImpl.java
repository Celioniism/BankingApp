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
        return null;
    }

    @Override
    public void editAdminUsername(int adminId, Administrator administrator) {

    }

    @Override
    public void editAdminPassword(int adminId, Administrator administrator) {

    }

    @Override
    public void editAdminFullName(int adminId, Administrator administrator) {

    }
}
