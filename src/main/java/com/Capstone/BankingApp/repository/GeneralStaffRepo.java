package com.Capstone.BankingApp.repository;

import com.Capstone.BankingApp.entity.GeneralStaff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneralStaffRepo extends JpaRepository<GeneralStaff, Integer> {
  @Query(value = "SELECT * FROM user WHERE user_name = ?1", nativeQuery = true)
    GeneralStaff findByUsername(String UserName);
}
