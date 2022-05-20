package com.Capstone.BankingApp.service;

import com.Capstone.BankingApp.entity.Administrator;
import com.Capstone.BankingApp.entity.GeneralStaff;
import com.Capstone.BankingApp.repository.AdministratorRepo;
import com.Capstone.BankingApp.repository.GeneralStaffRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    AdministratorRepo administratorRepo;

    @Autowired
    GeneralStaffRepo generalStaffRepo;


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

	@Override
	public boolean validateAdmin(String username, String password) {
        Administrator temp = administratorRepo.findByUsername(username);
        if(temp.getUserName()==username && temp.getUserPassword()==password)
            return true;
        else
		    return false;
	}

	@Override
	public void registerGeneralStaff(GeneralStaff staff) {
		administratorRepo.getById(staff.getStaffId());

        staff.setFullName(staff.getFullName());
        staff.setUserName(staff.getUserName());
        staff.setPassword(staff.getPassword());

        generalStaffRepo.save(staff);
		
	}

	@Override
	public List<GeneralStaff> getAllStaff() {
		administratorRepo.findAll();
		return null;
	}

	@Override
	public void EnableStaff(int staffId) {
		GeneralStaff generalStaff = generalStaffRepo.getById(staffId);
        generalStaff.setEnableStaff();
        generalStaffRepo.save(generalStaff);
	}

    public void DisableStaff(int staffId) {
        GeneralStaff generalStaff = generalStaffRepo.getById(staffId);
        generalStaff.setDisableStaff();
        generalStaffRepo.save(generalStaff);
    }



}
