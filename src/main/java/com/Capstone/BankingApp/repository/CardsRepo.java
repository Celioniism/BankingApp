package com.Capstone.BankingApp.repository;

import com.Capstone.BankingApp.entity.Cards;
import com.Capstone.BankingApp.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CardsRepo extends JpaRepository<Cards, Integer> {
	@Query(value = "SELECT * FROM Cards WHERE CardNumber = ?1", nativeQuery = true)
	  Cards findCardByNumber(Long CardNumber);
}
