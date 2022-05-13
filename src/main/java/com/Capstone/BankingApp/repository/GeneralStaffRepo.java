package com.Capstone.BankingApp.repository;

import com.Capstone.BankingApp.entity.GeneralStaff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneralStaffRepo extends JpaRepository<GeneralStaff, Integer> {
}
