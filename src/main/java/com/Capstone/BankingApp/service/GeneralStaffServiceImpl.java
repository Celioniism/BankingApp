package com.Capstone.BankingApp.service;

import com.Capstone.BankingApp.entity.GeneralStaff;
import com.Capstone.BankingApp.repository.GeneralStaffRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneralStaffServiceImpl implements GeneralStaffService{

    @Autowired
    GeneralStaffRepo generalStaffRepo;


    @Override
    public GeneralStaff showStaffInfo(int staffId) {
        return null;
    }

    @Override
    public void editStaffUsername(int staffId, GeneralStaff generalStaff) {

    }

    @Override
    public void editStaffPassword(int staffId, GeneralStaff generalStaff) {

    }

    @Override
    public void editStaffFullName(int staffId, GeneralStaff generalStaff) {

    }

	@Override
	public void approveUser() {
		// TODO Auto-generated method stub
		
	}
}
