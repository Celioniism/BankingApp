package com.Capstone.BankingApp.repository;

import com.Capstone.BankingApp.entity.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface AdministratorRepo extends JpaRepository<Administrator, Integer> {
    @Query(value = "SELECT * FROM user WHERE user_name = ?1", nativeQuery = true)
    Administrator findByUsername(String UserName);

}
