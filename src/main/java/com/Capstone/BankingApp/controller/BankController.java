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

import com.Capstone.BankingApp.InputClasses.UserSD;
import com.Capstone.BankingApp.entity.Cards;
import com.Capstone.BankingApp.entity.User;
import com.Capstone.BankingApp.entity.UserInfoFactory;
import com.Capstone.BankingApp.repository.UserRepo;
import com.Capstone.BankingApp.service.AccountInfoService;
import com.Capstone.BankingApp.service.CardsService;
import com.Capstone.BankingApp.service.TransactionsService;
import com.Capstone.BankingApp.service.UserInfoFactoryService;
import com.Capstone.BankingApp.service.UserService;

@CrossOrigin(origins="*",maxAge = 3600)
@RestController
@RequestMapping("/api")
public class BankController {

	@Autowired
	TransactionsService TS;

	@Autowired
	UserInfoFactoryService UIFS;

	@Autowired
	AccountInfoService AIS;
	@Autowired
	CardsService CardsS;

	@Autowired
	UserRepo Urepo;

	@Autowired
	UserService US;

	@PostMapping({ "/login" })
	public String loginPage(@RequestBody User user) {
		return US.authenticateUser(user.getUserName(), user.getPassword());
	}

	@PostMapping({ "/signup/{type}" })
	public boolean postSignup(@RequestBody UserInfoFactory uif, @PathVariable("type") String type) {
		return UIFS.signup(uif, type);
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

	@PostMapping({ "/getUserSD" })
	public UserSD getUserSD(@RequestBody User user) {
		return AIS.returnUserdata(user.getUserName(), user.getPassword());
	}
	
	@GetMapping({ "/getUserSD/{userId}" })
	public UserSD getUserSD(@PathVariable("userId") int userId) {
		return AIS.returnUserdataId(userId);
	}
	
	@PostMapping({ "/getUserId" })
	public int getUserId(@RequestBody User user) {
		return US.returnUserId(user.getUserName(), user.getPassword());
	}

}