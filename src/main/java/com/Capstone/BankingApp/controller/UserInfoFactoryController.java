/**
 * 
 */
package com.Capstone.BankingApp.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Capstone.BankingApp.entity.UserInfoFactory;
import com.Capstone.BankingApp.service.UserInfoFactoryService;

/**
 * @author Dekun
 * @Date 23 May 2022	
 *
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/userinfofactory")
public class UserInfoFactoryController {
	UserInfoFactoryService UIFS;
	
	@GetMapping(value = "/showUserInfoFactoryDetails/{userId}")
	public UserInfoFactory showUserInfoFactoryDetails(@PathVariable("userId") int userId) {
		return UIFS.showUserInfoFactoryDetails(userId);
	}

	

}
