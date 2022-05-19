package com.Capstone.BankingApp.service;

import com.Capstone.BankingApp.entity.Administrator;
import com.Capstone.BankingApp.entity.GeneralStaff;
import com.Capstone.BankingApp.repository.AdministratorRepo;

import java.util.List;

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

	@Override
	public boolean validateAdmin(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void registerGeneralStaff(GeneralStaff staff) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<GeneralStaff> getAllStaff() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void EnableStaff() {
		// TODO Auto-generated method stub
		
	}
}
