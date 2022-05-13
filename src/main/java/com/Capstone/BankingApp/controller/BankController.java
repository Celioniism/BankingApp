package com.Capstone.BankingApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BankController {

	@GetMapping({ "/ ", "/index" })
	public String getIndex() {
		return "index";
	}

	@GetMapping({ "/login" })
	public String loginPage() {
		return "login";
	}

	@GetMapping({ "/user/userprofile" })
	public String userProfile(Model model) {
		
		return "user/userprofile";
	}
}
