package com.Capstone.BankingApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Capstone.BankingApp.entity.Cards;

public interface CardNumberRepo extends JpaRepository<Cards, Long> {

}
