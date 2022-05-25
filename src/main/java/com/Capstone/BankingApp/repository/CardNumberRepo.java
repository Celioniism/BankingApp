package com.Capstone.BankingApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Capstone.BankingApp.entity.Cards;

@Repository
public interface CardNumberRepo extends JpaRepository<Cards, Long> {

}
