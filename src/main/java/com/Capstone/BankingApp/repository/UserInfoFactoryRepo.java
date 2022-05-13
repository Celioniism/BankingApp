package com.Capstone.BankingApp.repository;

import com.Capstone.BankingApp.entity.UserInfoFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoFactoryRepo extends JpaRepository<UserInfoFactory, Integer> {
}
