package com.Capstone.BankingApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Capstone.BankingApp.entity.Cards;

@Repository
public interface CardsRepo extends JpaRepository<Cards, Integer> {
	@Query(value = "SELECT * FROM Cards WHERE card_number = ?1", nativeQuery = true)
	  Cards findCardByNumber(Long CardNumber);
	@Query(value="SELECT * FROM Cards WHERE associated_id = ?1", nativeQuery=true)
	  List<Cards> findAllUserCards(int associatedId);
}
