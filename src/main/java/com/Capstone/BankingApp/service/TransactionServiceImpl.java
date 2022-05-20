/**
 * 
 */
package com.Capstone.BankingApp.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.Capstone.BankingApp.entity.Cards;
import com.Capstone.BankingApp.entity.Transactions;
import com.Capstone.BankingApp.repository.CardNumberRepo;
import com.Capstone.BankingApp.repository.TransactionsRepo;

/**
 * @author Dekun
 * @Date 19 May 2022
 *
 */
public class TransactionServiceImpl implements TransactionsService {

	@Autowired
	CardNumberRepo CNR;
	@Autowired
	TransactionsRepo TRR;

	@Override
	public String Transfer(long fromCardNo, long toCardNo, double amount, String refrence) {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String CurrentDate = formatter.format(date);
		
		try {
			Cards fromCard = CNR.getById(fromCardNo);
			Cards toCard = CNR.getById(fromCardNo);
			double fcb, tcb;
			fcb = fromCard.getBalance();
			tcb = toCard.getBalance();

			if (fcb >= amount) {
				fcb = fcb - amount;
				tcb = tcb + amount;
				fromCard.setBalance(fcb);
				toCard.setBalance(tcb);
				CNR.save(fromCard);
				CNR.save(toCard);

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
}