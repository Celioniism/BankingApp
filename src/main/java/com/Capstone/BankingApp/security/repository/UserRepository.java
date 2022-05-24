package com.Capstone.BankingApp.security.repository;

import com.Capstone.BankingApp.security.models.UserSecurity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserSecurity, Long> {
	Optional<UserSecurity> findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
}
