package com.Capstone.BankingApp.service;

import com.Capstone.BankingApp.entity.GeneralStaff;

public interface GeneralStaffService {
    public GeneralStaff showStaffInfo(int staffId);
    public void editStaffUsername(int staffId, GeneralStaff generalStaff);
    public void editStaffPassword(int staffId, GeneralStaff generalStaff);
    public void editStaffFullName(int staffId, GeneralStaff generalStaff);
}
