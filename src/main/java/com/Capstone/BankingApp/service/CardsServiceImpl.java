package com.Capstone.BankingApp.service;

import com.Capstone.BankingApp.entity.Cards;
import com.Capstone.BankingApp.repository.CardsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardsServiceImpl implements CardsService{
    @Autowired
    CardsRepo cardsRepo;


    @Override
    public Cards showCardDetails(int associatedId) {
        return null;
    }
}
