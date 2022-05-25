/**
 * 
 */
package com.Capstone.BankingApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Capstone.BankingApp.entity.User;
import com.Capstone.BankingApp.service.UserService;

/**
 * @author Dekun
 * @Date 23 May 2022	
 *
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService us;
	
	
	@PutMapping(value = "/editUsername/{userId}")
	public void editUsername(@PathVariable("userId") int userId,@RequestBody User user) {
		us.editUsername(userId, user);
	}
	
	@PutMapping(value = "/editUserPassword/{userId}")
	public void editUserPassword(@PathVariable("userId") int userId,@RequestBody User user) {
		us.editUserPassword(userId, user);
	}
	
	@PutMapping(value = "/editFullName/{userId}")
	public void editFullName(@PathVariable("userId") int userId,@RequestBody User user) {
		us.editFullName(userId, user);
	}
	
	@PostMapping(value = "/saveUser")
	public void saveUser(@RequestBody User user) {
		us.saveUser(user);
	}
	
	@GetMapping(value = "/authenticateUser/{userName}/{password}")
	public boolean authenticateUser(@PathVariable("userName") String userName,@PathVariable("password") String password ) {
		return us.authenticateUser(userName, password);
	}
	@GetMapping(value = "/getUserById/{userId}")
	public User getUserById(@PathVariable("userId") int userId) {
		return us.getUserById(userId);
	}
	
	@PutMapping(value = "/updateUser/{userId}")
	public boolean updateUser(@PathVariable("userId") int userId, @RequestBody User user) {
		return us.updateUser(userId, user);
	}
	
	@DeleteMapping(value="/deleteBeneficiary/{beneficiaryId}/{benefactorId}")
	public void deleteBeneficiary(@PathVariable("beneficiaryId") int beneficiaryId, @PathVariable("benefactorId") int benefactorId) {
		us.deleteBeneficiary(beneficiaryId, benefactorId);
	}
	
	@PostMapping(value="/addBeneficiary/{beneficiaryId}/{benefactorId}")
	public void addBeneficiary(@PathVariable("beneficiaryId") int beneficiaryId, @PathVariable("benefactorId") int benefactorId) {
		us.addBeneficiary(beneficiaryId, benefactorId);
	}
}
