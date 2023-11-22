/**
 * 
 */
package com.Capstone.BankingApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Capstone.BankingApp.InputClasses.DepositFactory;
import com.Capstone.BankingApp.InputClasses.TransferFactory;
import com.Capstone.BankingApp.InputClasses.WithdrawalFactory;
import com.Capstone.BankingApp.entity.Transactions;
import com.Capstone.BankingApp.service.CardsService;
import com.Capstone.BankingApp.service.TransactionsService;

/**
 * @author Dekun
 * @Date 23 May 2022
 *
 */
@CrossOrigin(origins="*",maxAge = 3600)
@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
	@Autowired
	TransactionsService TS;

	@Autowired
	CardsService CS;

	@GetMapping({ "/getUserTransactions/{userId}" })
	public List<Transactions> getUserTransactions(@PathVariable("userId") int userId) {
		List<Transactions> Tlist = TS.userTransactions(userId);
		return Tlist;
	}

	@GetMapping({ "/userTotalBalance/{userId}" })
	public double userTotalBal(@PathVariable("userId") int userId) {
		double bal = (CS.userTotalBalance(userId));
		return bal;
	}

	@PostMapping({ "/Deposit" })
	public void userDeposit(@RequestBody DepositFactory df) {

		TS.Deposit(df);
	}

	@PostMapping({ "/Withdraw" })
	public void userWithdraw(@RequestBody WithdrawalFactory WF) {
		TS.Withdraw(WF);
	}

	@PostMapping({ "/Transfer" })
	public String userTransfer(@RequestBody TransferFactory TF) {

		TS.Transfer(TF);
		return "successfuly transfered";
	}

}
