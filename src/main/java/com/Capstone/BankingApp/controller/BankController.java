package com.Capstone.BankingApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Capstone.BankingApp.InputClasses.WithdrawalFactory;
import com.Capstone.BankingApp.InputClasses.DepositFactory;
import com.Capstone.BankingApp.entity.Cards;
import com.Capstone.BankingApp.entity.Transactions;
import com.Capstone.BankingApp.entity.User;
import com.Capstone.BankingApp.entity.UserInfoFactory;
import com.Capstone.BankingApp.repository.UserRepo;
import com.Capstone.BankingApp.service.CardsService;
import com.Capstone.BankingApp.service.TransactionsService;
import com.Capstone.BankingApp.service.UserInfoFactoryService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class BankController {

	@Autowired
	TransactionsService TS;

	@Autowired
	UserInfoFactoryService UIFS;

	@Autowired
	CardsService CardsS;

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

	@GetMapping({ "/getAllCards" })
	public List<Cards> getAllCards(Model model) {
		List<Cards> cards = CardsS.showAllCards();
		return cards;
	}

	@GetMapping({ "/getUserCards/{userId}" })
	public List<Cards> getUserCards(@PathVariable("userId") int userId) {
		List<Cards> cards = CardsS.showUserCardDetails(userId);
		return cards;
	}

	@PostMapping({ "/generateNewCard/{userId}" })
	public String generateNewCard(@PathVariable("userId") int userId, @RequestBody String Type) {
		CardsS.generateCard(userId, Type);
		return "added successfuly!";
	}

	@GetMapping({ "/getUserTransactions/{userId}" })
	public List<Transactions> getUserTransactions(@PathVariable("userId") int userId) {
		List<Transactions> Tlist = TS.userTransactions(userId);
		return Tlist;
	}

	@GetMapping({ "/userTotalBalance/{userId}" })
	public double userTotalBal(@PathVariable("userId") int userId) {
		double bal = (CardsS.userTotalBalance(userId));
		return bal;
	}

	@PostMapping({ "/Deposit" })
	public void userDeposit(@RequestBody DepositFactory df) {

		TS.Deposit(df);
	}

	@PostMapping({ "/Withdraw" })
	public String userWithdraw(@RequestBody WithdrawalFactory WF) {
		double result = TS.Withdraw(WF);
		if(result>0) {
			return result + " dollars successfully withdrawn";
		}else {
			return "unable to withdraw";
		}
	}
	
	@PostMapping({ "/Transfer" })
	public String userTransfer(@RequestBody  long tocard, @RequestBody  long fromcard, @RequestBody  String amount, @RequestBody String mmemo) {
		return "successfuly transfered";
	}

}
