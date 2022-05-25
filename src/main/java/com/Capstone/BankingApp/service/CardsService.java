package com.Capstone.BankingApp.service;

import java.util.List;

import com.Capstone.BankingApp.entity.Cards;

public interface CardsService {
    
    public void registerCard(Cards card);
    
    public void deleteCard(long cardnumber);
    
    public void generateCard(int associatedId, String Type);

    public List<Cards> showUserCardDetails(int associatedId);

	public List<Cards> showAllCards();
	
	public double userTotalBalance(int userId);
}
