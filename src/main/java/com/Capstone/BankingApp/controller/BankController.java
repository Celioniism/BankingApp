package com.Capstone.BankingApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.Capstone.BankingApp.entity.User;
import com.Capstone.BankingApp.entity.UserInfoFactory;
import com.Capstone.BankingApp.repository.UserRepo;
import com.Capstone.BankingApp.service.UserInfoFactoryService;

@Controller
public class BankController {

	@Autowired
	UserInfoFactoryService UIFS;

	@Autowired
	UserRepo Urepo;

	@GetMapping({ "/ ", "/index" })
	public String getIndex() {
		return "index";
	}

	@GetMapping({ "/login" })
	public String loginPage() {
		return "login";
	}

	@GetMapping({ "/views/userprofile" })
	public String userProfile(Model model) {

		return "views/userprofile";
	}

	@GetMapping({ "/signup" })
	public String getSignup() {
		return "getSignup";
	}

	@PostMapping({ "/signup" })
	public String postSignup(@RequestBody UserInfoFactory uif) {
		System.out.println(uif);
		UIFS.signup(uif);
		return "postSignup";
	}

	@GetMapping({ "/viewUsers" })
	public String viewall(Model model) {
		List<User> users = Urepo.findAll();
		model.addAttribute("users", users);
		return "viewUsers";

	}

}