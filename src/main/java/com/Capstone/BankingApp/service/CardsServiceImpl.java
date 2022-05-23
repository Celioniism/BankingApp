package com.Capstone.BankingApp.service;

import java.util.List;
import java.util.Optional;

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
	public Long generateCard() {
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
		System.out.println(CardNum);
		return CardNum;
	}

	@Override
	public List<Cards> showAllCards() {
		List<Cards> cards = cardsRepo.findAll();
		return cards;
	}


}
