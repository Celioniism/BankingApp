package com.Capstone.BankingApp.repository;

import com.Capstone.BankingApp.entity.AccountInfo;
import com.Capstone.BankingApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountInfoRepo extends JpaRepository<AccountInfo, Integer> {
    //User findByUsername(String userName);

}
