package com.Capstone.BankingApp.repository;

import com.Capstone.BankingApp.entity.AccountInfo;
import com.Capstone.BankingApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
@Repository
public interface AccountInfoRepo extends JpaRepository<AccountInfo, Long> {
     @Query(value = "SELECT * FROM user WHERE user_name = ?1", nativeQuery = true)
    User findByUsername(String userName);
     @Query(value = "SELECT * FROM account_info WHERE user_id = ?1", nativeQuery = true)
     AccountInfo findByUserId(int userId);
}
