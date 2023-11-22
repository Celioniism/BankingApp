package com.Capstone.BankingApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.Capstone.BankingApp.entity.AccountInfo;
import com.Capstone.BankingApp.entity.GeneralStaff;
import com.Capstone.BankingApp.entity.Transactions;
import com.Capstone.BankingApp.entity.User;
import com.Capstone.BankingApp.service.GeneralStaffService;

@CrossOrigin(origins="*",maxAge = 3600)
@RestController
@RequestMapping("/api/staff")
public class GeneralStaffController {

	@Autowired
	GeneralStaffService GeneralSS;
	
	@GetMapping("/showStaffInfo/{id}")
	public GeneralStaff showStaffInfo(@PathVariable(name = "id") int staffId) {
		return GeneralSS.showStaffInfo(staffId);
	}
	
	@PutMapping("/updateStaffUserName/{id}")
	public String updateStaffUserName(@PathVariable(name = "id") int staffId, @RequestBody GeneralStaff staff) {
		GeneralSS.editStaffUsername(staffId, staff);
		return "Staff username updated";
	}
	
	@PutMapping("/updateStaffPassword/{id}")
	public String updateStaffPassword(@PathVariable(name = "id") int staffId, @RequestBody GeneralStaff staff) {
		GeneralSS.editStaffPassword(staffId, staff);
		return "Staff password updated";
	}
	
	@PutMapping("/updateStaffFullName/{id}")
	public String updateStaffFullName(@PathVariable(name = "id") int staffId, @RequestBody GeneralStaff staff) {
		GeneralSS.editStaffFullName(staffId, staff);
		return "Staff fullName updated";
	}
	
	@GetMapping("/authenticateStaff/{userName}/{password}")
	public boolean authenticateStaff(@PathVariable(name = "userName") String username, @PathVariable(name = "password") String password) {
		
		return GeneralSS.authenticateStaff(username, password);
	}

	@GetMapping("/getTransactions/{id}")
	public List<Transactions> getTransactions(@PathVariable(name = "id") int acctId) {
		return GeneralSS.getTransactions(acctId);
	}
	
	@GetMapping("/getBeneficiaries")
	public List<User> BeneficiaryToBeApproved() {
		return GeneralSS.BeneficiaryToBeApproved();
	}

	@PutMapping("/approveBeneficiary/{id}")
	public String approveBeneficiary(@PathVariable(name = "id") int userId) {
		GeneralSS.approveBeneficiary(userId);
		return "Beneficiary approved";
	}
	
	@GetMapping("/accountsToBeApproved")
	public List<AccountInfo> accountsToBeApproved() {
		return GeneralSS.accountsToBeApproved();
	}

	@PutMapping("/approveCustAccounts")
	public String approveCustAccounts(@RequestBody long... accountNumber) {
		GeneralSS.approveCustAccounts(accountNumber);
		return "accounts approved";
	}

	@GetMapping("/getAllUsers")
	public List<User> getAllUsers() {
		return GeneralSS.getAllUsers();
	}
	
	@PutMapping("/enableUser/{id}")
	public void enableUser(@PathVariable(name = "id") int userId) {
		GeneralSS.EnableUser(userId);
		
	}
	
	@GetMapping("/getUserById/{id}")
	public User getUserById(@PathVariable(name = "id") int userId) {
		return GeneralSS.GetUserById(userId);
	}
}
