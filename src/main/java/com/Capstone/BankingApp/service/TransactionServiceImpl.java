/**
 * 
 */
package com.Capstone.BankingApp.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Capstone.BankingApp.InputClasses.WithdrawalFactory;
import com.Capstone.BankingApp.InputClasses.DepositFactory;
import com.Capstone.BankingApp.entity.Cards;
import com.Capstone.BankingApp.entity.Transactions;
import com.Capstone.BankingApp.repository.CardsRepo;
import com.Capstone.BankingApp.repository.TransactionsRepo;

/**
 * @author Dekun
 * @Date 19 May 2022
 *
 */
@Service
public class TransactionServiceImpl implements TransactionsService {

	@Autowired
	CardsRepo CR;

	@Autowired
	TransactionsRepo TRR;

	@Override
	public String Transfer(long fromCardNo, long toCardNo, double amount, String refrence) {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String CurrentDate = formatter.format(date);

		try {

			Cards fromCard = CR.findCardByNumber(fromCardNo);
			Cards toCard = CR.findCardByNumber(toCardNo);
			double fcb, tcb;
			fcb = fromCard.getBalance();
			tcb = toCard.getBalance();

			if (fcb >= amount) {
				fcb = fcb - amount;
				tcb = tcb + amount;
				fromCard.setBalance(fcb);
				toCard.setBalance(tcb);
				CR.save(fromCard);
				CR.save(toCard);

				Transactions fromtr = new Transactions();
				fromtr.setAmount(0 - amount);
				fromtr.setReference(refrence);
				fromtr.setDate_and_time(CurrentDate);
				fromtr.setTransactionTransfer();
				fromtr.setCard(fromCard);
				TRR.save(fromtr);

				Transactions totr = new Transactions();
				totr.setAmount(amount);
				totr.setReference(refrence);
				totr.setDate_and_time(CurrentDate);
				totr.setTransactionTransfer();
				totr.setCard(toCard);
				TRR.save(totr);
				return "transfer success";
			} else {
				return "not enough funds";
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "card error";
		}
	}

	@Override
	public double Withdraw(WithdrawalFactory WF) {
		long fromCardNo = WF.getCardNumber();
		double amount = WF.getAmount();
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String CurrentDate = formatter.format(date);

		Cards fromCard = CR.findCardByNumber(fromCardNo);
		double fcb;
		fcb = fromCard.getBalance();
		if (fcb >= amount) {
			fcb = fcb - amount;
			fromCard.setBalance(fcb);
			CR.save(fromCard);

			Transactions fromtr = new Transactions();
			fromtr.setAmount(0 - amount);
			fromtr.setReference("");
			fromtr.setDate_and_time(CurrentDate);
			fromtr.setTransactionWithdraw();
			fromtr.setCard(fromCard);
			TRR.save(fromtr);

			double withdrawn = amount;
			return withdrawn;
		} else {
			return 0;
		}
	}

	@Override
	public double Deposit(DepositFactory df) {
		long toCardNo = df.getCardNumber();
		String memo = df.getMemo();
		double amount = df.getAmount();
		System.out.println("working");
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String CurrentDate = formatter.format(date);
		Cards toCard = CR.findCardByNumber(toCardNo);
		double tcb;
		tcb = toCard.getBalance();
		if (toCard.getCardType() != null) {
			if (toCard.getCardType().equalsIgnoreCase("debit")) {
				tcb = tcb + amount;
				toCard.setBalance(tcb);
				CR.save(toCard);
			} else if (toCard.getCardType().equalsIgnoreCase("credit")) {
				if (amount <= tcb) {
					tcb = tcb - amount;
					toCard.setBalance(tcb);
				} else {
					tcb = 0;
					double temp = tcb - amount;
					amount = amount + temp;
					toCard.setBalance(tcb);
				}
			}
		}else {
			tcb = tcb + amount;
			toCard.setBalance(tcb);
		}
		Transactions totr = new Transactions();
		totr.setAmount(amount);
		totr.setReference(memo);
		totr.setDate_and_time(CurrentDate);
		totr.setTransactionDeposit();
		totr.setCard(toCard);
		TRR.save(totr);
		double deposited = amount;
		return deposited;
	}

	@Override
	public List<Transactions> userTransactions(int userId) {
		List<Cards> usercards = CR.findAllUserCards(userId);
		List<Transactions> Tlist = TRR.findAll();
		List<Transactions> userTransactions = new ArrayList<Transactions>();
		for (Cards c : usercards) {
			for (Transactions t : Tlist) {
				if (c.equals(t.getCard())) {
					userTransactions.add(t);
				}
			}
		}
		return userTransactions;
	}
}