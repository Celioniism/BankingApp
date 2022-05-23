/**
 * 
 */
package com.Capstone.BankingApp.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
	public double Withdraw(double amount, long fromCardNo) {
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
	public double Deposit(double amount, long toCardNo) {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String CurrentDate = formatter.format(date);

		Cards toCard = CR.findCardByNumber(toCardNo);
		double tcb;
		tcb = toCard.getBalance();
		tcb = tcb + amount;
		toCard.setBalance(tcb);
		CR.save(toCard);

		Transactions totr = new Transactions();
		totr.setAmount(amount);
		totr.setReference("");
		totr.setDate_and_time(CurrentDate);
		totr.setTransactionDeposit();
		totr.setCard(toCard);
		TRR.save(totr);

		double deposited = amount;
		return deposited;
	}
}
