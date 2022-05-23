package com.Capstone.BankingApp.service;

import java.util.List;

import com.Capstone.BankingApp.entity.Cards;

public interface CardsService {
    
    public void registerCard(Cards card);
    
    public void deleteCard(long cardnumber);
    
    public Long generateCard();

    public List<Cards> showUserCardDetails(int associatedId);

	List<Cards> showAllCards();
}
