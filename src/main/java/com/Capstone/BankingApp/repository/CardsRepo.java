package com.Capstone.BankingApp.repository;

import com.Capstone.BankingApp.entity.Cards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardsRepo extends JpaRepository<Cards, Integer> {
	
}
