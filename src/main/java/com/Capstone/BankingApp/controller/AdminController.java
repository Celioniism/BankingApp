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

import com.Capstone.BankingApp.entity.Administrator;
import com.Capstone.BankingApp.entity.GeneralStaff;
import com.Capstone.BankingApp.service.AdminService;
import org.springframework.web.bind.annotation.PostMapping;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/admin")
public class AdminController {

	@Autowired
	AdminService AdminService;
	
	@GetMapping("/showAdminInfo/{id}")
    public Administrator showAdminInfo(@PathVariable int adminId) {
		return AdminService.showAdminInfo(adminId);
	}
	
	@PutMapping("/editAdminUsername/{id}")
	public String editAdminUsername(@PathVariable(name = "id") int adminId, @RequestBody Administrator administrator) {
		AdminService.editAdminUsername(adminId, administrator);
		return "Admin username updated";
	}
	
	@PutMapping("/editAdminPassword/{id}")
	public String editAdminPassword(@PathVariable(name = "id") int adminId, @RequestBody Administrator administrator) {
		AdminService.editAdminPassword(adminId, administrator);
		return "Admin Password updated";
	}
	
	@PutMapping("/editAdminFullName/{id}")
	 public String editAdminFullName(@PathVariable(name = "id") int adminId, @RequestBody Administrator administrator) {
		 AdminService.editAdminFullName(adminId, administrator);
		 return "Admin FullName updated";
	 }
	
	@GetMapping("/validateAdmin/{userName}/{password}")
	public boolean validateAdmin(@PathVariable(name = "userName") String username,  @PathVariable(name = "password") String password) {
		return AdminService.validateAdmin(username, password);
	}
	
	@PostMapping("/registerGeneralStaff")
	public String registerGeneralStaff(@RequestBody GeneralStaff staff) {
		AdminService.registerGeneralStaff(staff);
		return "Staff Registered";
	}
	 
	@GetMapping("/getAllStaff")
	 public List<GeneralStaff> getAllStaff(){
		 return AdminService.getAllStaff();
	 }
	
	@PutMapping("/EnableStaff/{staffId}")
	public void EnableStaff(int staffId) {
		AdminService.EnableStaff(staffId);
	}
	 
	@PutMapping("/DisableStaff/{staffId}")
	 public void DisableStaff(int staffId) {
		 AdminService.DisableStaff(staffId);
	 }
}
