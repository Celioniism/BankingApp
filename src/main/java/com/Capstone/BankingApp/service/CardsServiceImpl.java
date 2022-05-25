package com.Capstone.BankingApp.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Capstone.BankingApp.entity.Cards;
import com.Capstone.BankingApp.repository.CardNumberRepo;
import com.Capstone.BankingApp.repository.CardsRepo;

@Service
public class CardsServiceImpl implements CardsService {
	@Autowired
	CardsRepo cardsRepo;

	@Autowired
	CardNumberRepo CNR;

	@Override
	public List<Cards> showUserCardDetails(int associatedId) {
		List<Cards> card = cardsRepo.findAllUserCards(associatedId);
		return card;
	}

	@Override
	public void registerCard(Cards card) {
		cardsRepo.save(card);
	}

	@Override
	public void deleteCard(long cardnumber) {
		Cards card = CNR.findById(cardnumber).get();
		CNR.delete(card);
	}

	@Override
	public void generateCard(int associatedId, String Type) {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/yy");
		String CurrentDate = formatter.format(date);
		String[] datechanges = CurrentDate.split("/", 2);
		int[] dateint = new int[2];
		int i = 0;
		for (String dates : datechanges) {
			dateint[i] = Integer.parseInt(dates);
			i++;
		}
		dateint[1] = dateint[1] + 5;
		String exp = "" + dateint[0] + "/" + dateint[1];
		Cards newcard = new Cards();
		int lock = 0;
		int cvvmax = 999, cvvmin = 111;
		int cvv = (int) Math.floor(Math.random() * (cvvmax - cvvmin + 1) + cvvmin);
		int min = 123456;
		int max = 999999;
		int random1 = (int) Math.floor(Math.random() * (max - min + 1) + min);
		int random2 = (int) Math.floor(Math.random() * (max - min + 1) + min);
		long p1 = Long.valueOf(random1);
		long p2 = Long.valueOf(random2);
		long l1 = 4205;
		String s1 = Long.toString(l1);
		String s2 = Long.toString(p1);
		String s3 = Long.toString(p2);
		String s4 = s1 + s2 + s3;
		long CardNum = Long.valueOf(s4).longValue();
		newcard.setAssociatedId(associatedId);
		newcard.setBalance(0);

		while (lock == 0) {
			if (cardsRepo.findCardByNumber(CardNum) != null) {
				CardNum += 1;
			} else {
				lock = 1;
				newcard.setCardNumber(CardNum);
			}
			CardNum -= 3;
		}

		newcard.setCvv(cvv);
		newcard.setExp(exp);
		if (Type.equalsIgnoreCase("credit")) {
			newcard.setCardCredit();
		} else if (Type.equalsIgnoreCase("debit")) {
			newcard.setCardDebit();
		}

		cardsRepo.save(newcard);

	}

	@Override
	public List<Cards> showAllCards() {
		List<Cards> cards = cardsRepo.findAll();
		return cards;
	}

	@Override
	public double userTotalBalance(int userId) {
		List<Cards> card = cardsRepo.findAllUserCards(userId);
		double totalBal = 0;
		for (Cards c : card) {
			if (c.getCardType() != null) {
				if (c.getCardType().equals("credit")) {
					totalBal = totalBal - c.getBalance();
				} else if (c.getCardType().equals("debit")) {
					totalBal = totalBal + c.getBalance();
				} else {
					totalBal = totalBal + c.getBalance();
				}
			}else {
				totalBal = totalBal + c.getBalance();
			}
		}
		return totalBal;
	}

}