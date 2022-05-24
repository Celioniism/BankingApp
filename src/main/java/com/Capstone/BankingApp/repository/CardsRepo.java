package com.Capstone.BankingApp.repository;

import com.Capstone.BankingApp.entity.Cards;
import com.Capstone.BankingApp.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardsRepo extends JpaRepository<Cards, Integer> {
	@Query(value = "SELECT * FROM Cards WHERE CardNumber = ?1", nativeQuery = true)
	  Cards findCardByNumber(Long CardNumber);
	@Query(value = "SELECT * FROM Cards WHERE associatedId = ?1", nativeQuery = true)
	List<Cards> findAllUserCards(int associatedId);
}
