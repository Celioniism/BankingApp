package com.Capstone.BankingApp.service;

import com.Capstone.BankingApp.entity.Cards;

public interface CardsService {
    public Cards showCardDetails(int associatedId);
    
    public void registerCard(Cards card);
    
    public void deleteCard(long cardnumber);
    
    public Long generateCard();
}
