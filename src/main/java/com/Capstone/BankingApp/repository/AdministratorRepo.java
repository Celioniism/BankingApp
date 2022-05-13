package com.Capstone.BankingApp.repository;

import com.Capstone.BankingApp.entity.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministratorRepo extends JpaRepository<Administrator, Integer> {
}
