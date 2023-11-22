package com.Capstone.BankingApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Capstone.BankingApp.InputClasses.UserStats;
import com.Capstone.BankingApp.entity.AccountInfo;
import com.Capstone.BankingApp.service.AccountInfoService;

@CrossOrigin(origins="*",maxAge = 3600)
@RestController
@RequestMapping("/api/accountInfo")
public class AccountInfoController {

	@Autowired
	AccountInfoService AIS;

	@PutMapping("/editSecurityQuestion/{accountNo}")
	public String editSecurityQuestion(@PathVariable(name = "accountNo") long accountNo,
			@RequestBody AccountInfo accountInfo) {
		AIS.editSecurityQuestion(accountNo, accountInfo);
		return "Security Question edited";
	}

	@PutMapping("/editSecurityAnswer/{accountNo}")
	public String editSecurityAnswer(@PathVariable(name = "accountNo") long accountNo,
			@RequestBody AccountInfo accountInfo) {
		AIS.editSecurityAnswer(accountNo, accountInfo);
		return "Security Answer updated";
	}

	@GetMapping("/validateCustomer/{userName}/{password}")
	public boolean validateCustomer(@PathVariable(name = "userName") String userName,
			@PathVariable(name = "password") String password) {
		return AIS.validateCustomer(userName, password);
	}

	@GetMapping("/getAllAccounts")
	public List<AccountInfo> getAllAccounts() {
		return AIS.getAllAccounts();
	}

	@GetMapping("/getAccountByAcctNo/{accountNo}")
	public AccountInfo getAccountByAcctNo(@PathVariable(name = "accountNo") long accountNo) {
		return AIS.getAccountByAcctNo(accountNo);
	}

	@PostMapping("/createAccount")
	public String createAccount( @RequestBody AccountInfo accountInfo) {
		AIS.createAccount(accountInfo);
		return "Account Created";
	}
	
	@GetMapping("/Analytics/{userId}")
	public List<UserStats> viewStats(@PathVariable(name = "userId") int userId) {
		return AIS.getStats(userId);
	}
}
