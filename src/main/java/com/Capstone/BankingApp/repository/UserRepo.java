package com.Capstone.BankingApp.repository;
import org.springframework.data.jpa.repository.Query;
import com.Capstone.BankingApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
  @Query(value = "SELECT * FROM user WHERE user_name = ?1", nativeQuery = true)
	  User findByUserName(String userName);
}
